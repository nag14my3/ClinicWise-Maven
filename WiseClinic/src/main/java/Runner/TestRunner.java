package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "C:\\Users\\Aadhya\\git\\ClinicWise-Maven\\WiseClinic\\src\\main\\java\\Features\\Login.feature" ,
		glue = {"stepDefinitions"},
		plugin = {"pretty", "html:target/cucumber-reports"}
		
			
		)

public class TestRunner {
	
}
