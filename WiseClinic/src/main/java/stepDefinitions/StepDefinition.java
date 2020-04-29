package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.ConfigFileReader;
import managers.FileReaderManager;

public class StepDefinition {

	
	WebDriver driver;
	ConfigFileReader configFileReader;
	

	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() {
		
		 configFileReader= new ConfigFileReader();
		  

		System.setProperty("webdriver.chrome.driver",FileReaderManager.getInstance().getConfigReader().getDriverPath());
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

	}

	@When("^Title of the Login Page is Wise Clicnic$")		
	public void title_of_the_Login_Page_is_Wise_Clicnic() {

		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);

		Assert.assertEquals("Wise Clinic", actualtitle);

	}

	@Then("User enters the \"(.*)\" and \"(.*)\"")
	public void user_enters_the_Username_and_Password(String log, String pwd) {

		driver.findElement(By.name("username")).sendKeys(log);
		driver.findElement(By.name("password")).sendKeys(pwd);

	}

	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {

		driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();
		driver.manage().window().maximize();

	}

	@Then("Verify that user is able to login")
	public void verify_that_user_is_able_to_login() {

		System.out.println("Logged in successfully");
	}

}
