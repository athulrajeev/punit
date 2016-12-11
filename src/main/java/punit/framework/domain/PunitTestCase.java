package punit.framework.domain;

import java.util.List;

import punit.framework.api.TestCase;
import punit.framework.api.TestScenario;

public class PunitTestCase implements TestCase {
	
	private List<TestScenario> testScenarioList;

	@Override
	public void loadTestScenarios() {
		
	}

	@Override
	public void executeTestScenarios() {
		
	}
}
