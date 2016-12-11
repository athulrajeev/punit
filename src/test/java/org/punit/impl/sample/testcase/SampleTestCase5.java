package org.punit.impl.sample.testcase;

import org.junit.Assert;
import org.junit.Test;

public class SampleTestCase5 {

	@Test
	public void test() {

		if (Thread.currentThread().getName().contains("60")) {
			int a=5/0;
		} else {
			Assert.assertTrue(true);
		}

	}
}
