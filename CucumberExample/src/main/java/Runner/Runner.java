package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\Aadhya\\eclipse-workspace\\CucumberExample\\src\\main\\java\\Features\\Demo.feature"},
		glue = {"StepDefinitions"}
		)

public class Runner {

}
