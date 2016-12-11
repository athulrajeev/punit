package punit.framework.api;

public interface TestScenario {

	/**
	 * Function to test the test suite against the provided thread count. The function will throw an assertion error
	 * even if one tread returns an assertion error
	 * 
	 * @param threadCount
	 *            the number of thread to be tested against
	 */
	public void testForNThreads();

	/**
	 * Function to test a particular test scenario against all possible non functional scenarios
	 */
	public void test();
}
