package punit.framework.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import punit.framework.api.TestForNThreads;

/**
 * This class will encapsulate the logic for testing a scenario against N threads.
 */
public class PunitTestForNThreads implements TestForNThreads {

	private final int threadCount;

	private final Method method;

	private final Object testCase;

	public PunitTestForNThreads(int threadCount, Method method, Object testCase) {
		super();
		this.threadCount = threadCount;
		this.method = method;
		this.testCase = testCase;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public Method getMethod() {
		return method;
	}

	@Override
	public void testForNThreads() {
		mapMethodToRunnable().andThen(executeRunnableAgainstNThreads()).apply(method);
	}

	private Function<? super Method, ? extends Runnable> mapMethodToRunnable() {
		return method -> {
			return () -> {
				try {
					method.invoke(testCase);
				} catch (IllegalAccessException | IllegalArgumentException e) {
					throw new java.lang.AssertionError(e);
				} catch (InvocationTargetException e) {
					try {
						AssertionError assertionError = (AssertionError) e.getTargetException();
						throw assertionError;
					} catch (ClassCastException e2) {
						throw new RuntimeException(e);
					}
				}
			};
		};
	}

	private Function<? super Runnable, Void> executeRunnableAgainstNThreads() {
		return runnable -> {
			ExecutorService executor = Executors.newFixedThreadPool(threadCount);

			@SuppressWarnings("unchecked")
			CompletableFuture<Void>[] cfArray = IntStream.range(0, threadCount).mapToObj(index -> {
				return CompletableFuture.runAsync(runnable, executor);
			}).collect(Collectors.toList()).toArray(new CompletableFuture[0]);

			CompletableFuture<Void> completableFuture = CompletableFuture.allOf(cfArray);
			try {
				completableFuture.get();
			} catch (InterruptedException | ExecutionException e) {
				try {
					AssertionError assertionError = (AssertionError) e.getCause();
					throw assertionError;
				} catch (ClassCastException e2) {
					throw new RuntimeException(e);
				}
			}
			return null;
		};
	}
}
