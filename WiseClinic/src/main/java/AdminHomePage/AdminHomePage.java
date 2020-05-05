package AdminHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminHomePage {

	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_name\"]")
	private WebElement company_Name;

//	@FindBy(how = How.XPATH, using = "//*[@id=\"account_logo\"]")
//	private WebElement Company_Logo;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_time_zone\"]")
	private WebElement time_Zone;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"account_locale\"]")
	private WebElement language;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_address_line_1\"]")
	private WebElement address_line1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_address_line_2\"]")
	private WebElement address_line2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_email\"]")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@id=\"continue_btn\"]")
	private WebElement continue_button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"edit_account_1\"]/div[10]/div/a")
	private WebElement skip_button;

	public void company_Name(String name) {

		String s = company_Name.getText();
		System.out.println(s);

		if (s.equals("Wise Clinic")) {
			System.out.println("company name is same as what you expected");
		} else {
			company_Name.sendKeys(name);
		}

	}

//	//public void upload_logo(String logo) {
//		Company_Logo.sendKeys(logo);
//	}

	public void select_timeZone() {
		Select time = new Select(time_Zone);
		time.selectByIndex(2);
	}
	
	public void select_language() {
		Select lan = new Select(language);
		lan.selectByIndex(2);
		
	}

	public void enter_addressline1(String addressline1) {
		address_line1.sendKeys(addressline1);
	}

	public void enter_addressline2(String addressline2) {
		address_line2.sendKeys(addressline2);
	}

	public void enter_Email(String enteremail) {
		email.sendKeys(enteremail);
	}

	public void click_continue() {
		continue_button.submit();
	}

	public void click_skip() {
		skip_button.click();
	}

	public void fill_PersonalDetails() {
		company_Name("Wise Clinic");
		//upload_logo("Test");
		select_timeZone();
		enter_addressline1("#601, DUKE BLVD");
		enter_addressline2("LosAngels");
		enter_Email("admin@wiseclinic.com");
		click_continue();
		

	}

}
