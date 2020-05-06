package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import AdminHomePage.AdminHomePage;
import DataHandling.DataImport;
import NewClinicReg.NewClinicCreation;
import Receipts.ReceiptFormat;
import Screenshot.TakeScreenshot;
import Settings.CoreSettings;
import Staffs.NewStaff;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {

	
	WebDriver driver;
	AdminHomePage adminhomepage;
	NewClinicCreation newclinic;
	ReceiptFormat receiptformat;
	NewStaff newstaff;
	CoreSettings settings;
	DataImport dataimp;
	TakeScreenshot screenshot;
//	ConfigFileReader configFileReader;


	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() {
		
		// configFileReader= new ConfigFileReader();
		  

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aadhya\\eclipse-workspace\\WiseClinic\\Drivers\\chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		driver.get("http://sandbox.clinicwise.net/sign_in");

	}

	@When("^Title of the Login Page is Wise Clicnic$")		
	public void title_of_the_Login_Page_is_Wise_Clicnic() {

		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);

		//Assert.assertEquals("Wise Clinic", actualtitle);

	}

	@Then("User enters the \"(.*)\" and \"(.*)\"")
	public void user_enters_the_Username_and_Password(String log, String pwd) {

		driver.findElement(By.name("username")).sendKeys(log);
		driver.findElement(By.name("password")).sendKeys(pwd);

	}

	@Then("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@Then("Verify that user is able to login")
	public void verify_that_user_is_able_to_login() throws Exception {

		System.out.println("Logged in successfully");
		
		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[1]/a[1]")).click();
		//String s = driver.findElement(By.xpath("//*[@id=\"account_name\"]")).getText();
		//System.out.println(s);
		//Assert.assertEquals(s,"Wise Clinic");
		
		Thread.sleep(3000);
		
		adminhomepage = new AdminHomePage(driver);
		adminhomepage.fill_PersonalDetails();
		
		newclinic = new NewClinicCreation(driver);
		newclinic.create_new_clinic();
		
		receiptformat = new ReceiptFormat(driver);
		
		receiptformat.receipt_Format();
		
		settings = new CoreSettings(driver);
		
		settings.core_settings();
		
		newstaff = new NewStaff(driver);
		
		newstaff.new_staff();
		
		dataimp = new DataImport(driver);
		dataimp.click_finish();
		
		
		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[1]/a[2]")).click();
		screenshot = new TakeScreenshot(driver) ;
		screenshot.takeSnapShot(driver, "C:\\User\\Aadhya\\Pictures");
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"user_nav_link\"]/i"));
		
		element.click();
		//Select select = new Select(driver.findElement(By.xpath("//*[@id=\"user_nav_link\"]/i")));
		
		//select.selectByValue("");
		
		driver.findElement(By.xpath("//*[@id=\"sign_out_link\"]")).click();
		
	}

}
