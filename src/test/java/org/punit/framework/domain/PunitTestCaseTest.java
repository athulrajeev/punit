package org.punit.framework.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.punit.impl.sample.testcase.SampleTestCase6;

import punit.framework.domain.PunitTestCase;

public class PunitTestCaseTest {

	@Test
	public void test_loadTestScenarios_given_junit_test_case_object_then_success() {

		// Arrange
		final SampleTestCase6 junitTestCase = new SampleTestCase6();
		final int threadCount = 100;

		// Act
		PunitTestCase testCase = new PunitTestCase(junitTestCase, threadCount);

		// Assert
		assertEquals("The number of junit test case should be as expected", 2, testCase.getTestScenarioList().size());
		assertEquals("The test case should be as expected", junitTestCase, testCase.getTestCase());
		assertEquals("The thread count should be as expected", threadCount, testCase.getThreadCount());
	}

}
