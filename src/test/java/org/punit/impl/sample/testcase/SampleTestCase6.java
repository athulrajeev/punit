package org.punit.impl.sample.testcase;

import org.junit.Assert;
import org.junit.Test;

public class SampleTestCase6 {

	@Test
	public void test1() {
		Assert.assertTrue(true);
	}

	@Test
	public void test2() {
		Assert.assertTrue(true);
	}

	public void test3() {
		System.out.println("I am not a junit test");
	}
}
