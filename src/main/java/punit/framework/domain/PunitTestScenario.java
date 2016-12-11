package punit.framework.domain;

import java.lang.reflect.Method;

import punit.framework.api.TestForNThreads;
import punit.framework.api.TestScenario;

public class PunitTestScenario implements TestScenario, TestForNThreads {

	private final Method testScenario;
	private final int threadCount;
	private final TestForNThreads testForNThreads;
	private final Object testCase;

	public PunitTestScenario(Method testScenario, Object testCase, int threadCount) {
		super();
		this.testScenario = testScenario;
		this.threadCount = threadCount;
		this.testCase = testCase;
		testForNThreads = new PunitTestForNThreads(threadCount, testScenario, testCase);
	}

	@Override
	public void testForNThreads() {
		testForNThreads.testForNThreads();
	}

	@Override
	public void test() {
		this.testForNThreads();
	}

	public Method getTestScenario() {
		return testScenario;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public TestForNThreads getTestForNThreads() {
		return testForNThreads;
	}

	public Object getTestCase() {
		return testCase;
	}
}
