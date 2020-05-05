package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\Aadhya\\eclipse-workspace\\CucumberDemoProject\\src\\main\\java\\Features\\Example.feature"},
		glue = {"StepDefinitions"}
		)

public class RunnerClass {

}






