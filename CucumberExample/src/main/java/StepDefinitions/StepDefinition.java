package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	@Given("^User should be able to write code$")
	public void user_should_be_able_to_write_code(){
	    System.out.println("Writing code");
	}

	@When("^User should be able to print statement$")
	public void user_should_be_able_to_print_statement() {
		System.out.println("printing statement");
	}

	@Then("^Verify theoutput$")
	public void verify_theoutput() throws Throwable {
		System.out.println("verified");
	}

}
