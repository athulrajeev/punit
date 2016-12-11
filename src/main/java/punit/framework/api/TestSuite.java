package punit.framework.api;

/**
 * The User of this interface has control in loading test suite for a particular project
 */
public interface TestSuite {

	/**
	 * This function when invoked will load test suites present src/test/java folder. Each JUNIT test case will be
	 * become one TesTCase object
	 */
	public void loadTestCases();

}
