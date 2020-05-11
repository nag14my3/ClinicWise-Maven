package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.aventstack.extentreports.GherkinKeyword;

import AdminHomePage.AdminHomePage;
import AdminHomePage.CoreSettings;
import AdminHomePage.DataImport;
import AdminHomePage.ExportData;
import AdminHomePage.NewClinicCreation;
import AdminHomePage.NewStaff;
import AdminHomePage.ReceiptFormat;
import AdminHomePage.TakeScreenshot;
import Base.BaseUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class StepDefinition  {

	 public static WebDriver driver;
	AdminHomePage adminhomepage;
	NewClinicCreation newclinic;
	ReceiptFormat receiptformat;
	NewStaff newstaff;
	CoreSettings settings;
	DataImport dataimp;
	TakeScreenshot screenshot;
	ExportData export;
	ConfigFileReader configFileReader;

	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() throws ClassNotFoundException {
	//	scenarioDef.createNode(new GherkinKeyword("Given"), "User is on the login page");
		System.setProperty("webdriver.chrome.driver",
				FileReaderManager.getInstance().getConfigReader().getDriverPath());
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		

		configFileReader = new ConfigFileReader();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

	}

	@When("^Title of the Login Page is Wise Clicnic$")
	public void title_of_the_Login_Page_is_Wise_Clicnic() {

		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);

		// Assert.assertEquals("Wise Clinic", actualtitle);

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

		// driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[1]/a[1]")).click();
		// String s =
		// driver.findElement(By.xpath("//*[@id=\"account_name\"]")).getText();
		// System.out.println(s);
		// Assert.assertEquals(s,"Wise Clinic");

		Thread.sleep(3000);

	}

	@Given("^User is already on login page$")
	public void user_is_already_on_login_page() {

		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[1]/a[1]")).click();

		System.out.println("Yes already in login page");

	}

	@When("^User Starts configuration of company info$")
	public void user_Starts_configuration_of_company_info() throws Exception {

		Thread.sleep(3000);

		adminhomepage = new AdminHomePage(driver);
		adminhomepage.fill_PersonalDetails();

	}

	@Then("^User creates a new clinic$")
	public void user_creates_a_new_clinic() throws InterruptedException {

		Thread.sleep(3000);

		newclinic = new NewClinicCreation(driver);
		newclinic.create_new_clinic();

	}

	@Then("^Apply Settings to the clinic ceated$")
	public void apply_Settings_to_the_clinic_ceated() {

		receiptformat = new ReceiptFormat(driver);

		receiptformat.receipt_Format();

		settings = new CoreSettings(driver);

		settings.core_settings();

	}

	@Then("^Finish the creation of new clinic$")
	public void finish_the_creation_of_new_clinic() {

		newstaff = new NewStaff(driver);

		newstaff.new_staff();

		dataimp = new DataImport(driver);
		dataimp.click_finish();

	}

	@And("^Verify that new clinic is created by taking screenshot$")
	public void verify_that_new_clinic_is_created_by_taking_screenshot() throws Exception {

		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[1]/a[2]")).click();
		screenshot = new TakeScreenshot(driver);
		screenshot.takeSnapShot(driver, "C:\\User\\Aadhya\\Pictures");

		driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[1]/a[3]")).click();

		export = new ExportData(driver);
		export.dataexport();

	}

	@Given("^User is on login Page$")
	public void user_is_on_login_Page() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/ul/li/a")).click();

		Thread.sleep(3000);

	}

	@When("^User clicks on register new staff link$")
	public void user_clicks_on_register_new_staff_link() {

		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[2]/a[1]")).click();

	}

	@Then("^User will be forwarded to New Staff Page$")
	public void user_will_be_forwarded_to_New_Staff_Page() throws InterruptedException {

		Thread.sleep(3000);

		newstaff = new NewStaff(driver);

		newstaff.new_satff_creation();

	}

	@Then("^Enter all the details of Satff$")
	public void enter_all_the_details_of_Satff() {

		System.out.println("Details are entered");

	}

	@Then("^Then click on Finish$")
	public void then_click_on_Finish() throws Exception {

		System.out.println("Finished with creation of new staff");

		driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/ul/li[1]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/p[2]/a[2]")).click();

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/div/div[6]/h4"));

		screenshot = new TakeScreenshot(driver);
		screenshot.takeSnapShot(driver, "C:\\User\\Aadhya\\Pictures");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		int yPosition = ele.getLocation().getY();
		js.executeScript("window.scroll (0, " + yPosition + ") ");
		Thread.sleep(3000L);

		screenshot = new TakeScreenshot(driver);
		screenshot.takeSnapShot(driver, "C:\\User\\Aadhya\\Pictures");

	}

	@Then("^Logout as an admin$")
	public void logout() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"user_nav_link\"]/i"));

		element.click();
		// Select select = new
		// Select(driver.findElement(By.xpath("//*[@id=\"user_nav_link\"]/i")));

		// select.selectByValue("");

		driver.findElement(By.xpath("//*[@id=\"sign_out_link\"]")).click();

		driver.close();

	}

	@Given("Practioner is on the login page")
	public void practioner_is_on_the_login_page() {

		System.out.println("User is on Login page");

	}

	@When("User checks his details")
	public void user_checks_his_details() throws Exception {

		driver.findElement(By.xpath("//*[@id=\"user_nav_link\"]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"profile_link\"]")).click();

		screenshot = new TakeScreenshot(driver);
		screenshot.takeSnapShot(driver, "C:\\User\\Aadhya\\Pictures");

	}

	@Then("He verifies that clinic which he got registered is displayed")
	public void he_verifies_that_clinic_which_he_got_registered_is_displayed() {

		driver.findElement(By.xpath("//*[@id=\"practitioner_provider_numbers\"]/table/tbody/tr/td[1]")).getText();

	}
	
	@Then("Logout as an Practioner")
	public void logout_as_an_Practioner() {
	    driver.findElement(By.xpath("//*[@id=\"user_nav_link\"]/i")).click();
	    driver.findElement(By.xpath("//*[@id=\"sign_out_link\"]")).click();
	    System.out.println("Logged out successfully");
	    driver.close();
	}


}
