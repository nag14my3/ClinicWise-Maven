package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefinition {

	WebDriver driver;

	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Aadhya\\eclipse-workspace\\WiseClinic\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://sandbox.clinicwise.net/sign_in");

	}

	@When("^Title of the Login Page is Wise Clicnic$")
	public void title_of_the_Login_Page_is_Wise_Clicnic() {

		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);

		Assert.assertEquals("Wise Clinic", actualtitle);

	}
	
	@Then("User enters the \"(.*)\" and \"(.*)\"")
	public void user_enters_the_Username_and_Password(String log,String pwd) {
	 
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
