package punit.framework.domain;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import punit.framework.api.TestCase;
import punit.framework.api.TestScenario;

public class PunitTestCase implements TestCase {

	private List<TestScenario> testScenarioList;
	private final Object testCase;
	private final int threadCount;

	public PunitTestCase(Object testCase, int threadCount) {
		this.testCase = testCase;
		this.threadCount = threadCount;
		this.loadTestScenarios();
	}

	private void loadTestScenarios() {
		testScenarioList = Arrays
			.asList(testCase.getClass().getMethods())
				.stream()
				.filter(isAnnotatedWithTest())
				.map(buildTestScenario())
				.collect(Collectors.toList());
	}

	private Predicate<? super Method> isAnnotatedWithTest() {
		return method -> method.isAnnotationPresent(org.junit.Test.class);
	}

	private Function<Method, TestScenario> buildTestScenario() {
		return method -> {
			return new PunitTestScenario(method, this.testCase, this.threadCount);
		};
	}

	@Override
	public void executeTestScenarios() {

	}

	public List<TestScenario> getTestScenarioList() {
		return testScenarioList;
	}

	public void setTestScenarioList(List<TestScenario> testScenarioList) {
		this.testScenarioList = testScenarioList;
	}

	public Object getTestCase() {
		return testCase;
	}

	public int getThreadCount() {
		return threadCount;
	}
}
