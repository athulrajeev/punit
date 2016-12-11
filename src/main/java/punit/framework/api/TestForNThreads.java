package punit.framework.api;

/**
 * This interface will provide functionality for a TestScenario to test for N threads
 */
public interface TestForNThreads {

	/**
	 * This will test if a scenario returns the same function when tested against N threads
	 */
	public void testForNThreads();

}
