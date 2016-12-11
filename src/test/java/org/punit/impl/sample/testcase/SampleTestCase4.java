package org.punit.impl.sample.testcase;

import org.junit.Assert;
import org.junit.Test;

public class SampleTestCase4 {

	@Test
	public void test() {

		if (Thread.currentThread().getName().contains("60")) {
			Assert.assertTrue("Test Condition Failed",false);
		} else {
			Assert.assertTrue(true);
		}

	}
}
