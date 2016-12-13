package punit.framework.api;

/**
 * The User of this interface has control in loading, executing JUNIT TestCase file and reporting the status of each test scenarios
 * present in the Test Case
 */
public interface TestCase {
	
	/**
	 * This function will execute one scenario at a time. 
	 */
	public void executeTestScenarios();
}
