package org.punit.framework.domain;

import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.punit.impl.sample.testcase.SampleTestCase3;
import org.punit.impl.sample.testcase.SampleTestCase4;
import org.punit.impl.sample.testcase.SampleTestCase5;

import punit.framework.domain.PunitTestForNThreads;

public class PunitTestForNThreadsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testForNThreads_given_100Thread_when_success_then_pass() {

		// Assert
		ExpectedException.none();

		// Arrange
		final SampleTestCase3 sampleTestCase = new SampleTestCase3();
		final Method method = sampleTestCase.getClass().getMethods()[0];
		final int threadCount = 100;

		PunitTestForNThreads subject = new PunitTestForNThreads(threadCount, method, sampleTestCase);

		// Act
		subject.testForNThreads();
	}

	@Test
	public void testForNThreads_given_100Thread_when_onefails_then_fail() {

		// Assert
		thrown.expect(AssertionError.class);

		// Arrange
		final SampleTestCase4 sampleTestCase = new SampleTestCase4();
		final Method method = sampleTestCase.getClass().getMethods()[0];
		final int threadCount = 100;

		PunitTestForNThreads subject = new PunitTestForNThreads(threadCount, method, sampleTestCase);

		// Act
		subject.testForNThreads();
	}

	@Test
	public void testForNThreads_given_100Thread_when_oneNonAssertionError_then_fail() {

		// Assert
		thrown.expect(RuntimeException.class);

		// Arrange
		final SampleTestCase5 sampleTestCase = new SampleTestCase5();
		final Method method = sampleTestCase.getClass().getMethods()[0];
		final int threadCount = 100;

		PunitTestForNThreads subject = new PunitTestForNThreads(threadCount, method, sampleTestCase);

		// Act
		subject.testForNThreads();
	}
}
