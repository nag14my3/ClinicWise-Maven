package NewClinicReg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewClinicCreation {

	public NewClinicCreation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_name\"]")
	private WebElement clinic_Name;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_full_address\"]")
	private WebElement full_Address;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_address_line_1\"]")
	private WebElement addressline1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_address_line_2\"]")
	private WebElement addressline2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_phone\"]")
	private WebElement phone;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_email\"]")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_invoice_title\"]")
	private WebElement invoice_Title;

	@FindBy(how = How.XPATH, using = "//*[@id=\"clinic_use_separate_reference_number\"]")
	private WebElement reference_Num;

	@FindBy(how = How.XPATH, using = "")
	private WebElement Appointment_color;

	public void enter_Name(String name) {

		clinic_Name.sendKeys(name);
	}

	public void enter_fulladdress(String fulladd) {

		full_Address.sendKeys(fulladd);
	}

	public void enter_addressline1(String enteraddressline1) {

		addressline1.sendKeys(enteraddressline1);
	}

	public void enter_addressline2(String enteraddressline2) {

		addressline2.sendKeys(enteraddressline2);
	}

	public void enter_email(String enteremail) {

		email.sendKeys(enteremail);
	}

	public void enter_phone(String phonenum) {

		phone.sendKeys(phonenum);
	}
	
	public void check_invoice(String invoice) {
		
		invoice_Title.sendKeys(invoice);
	}

	public void reference(){

		reference_Num.click();

		reference_Num.isSelected();

	}

	public void appointment_color() {

		Appointment_color.findElement(By.xpath("\"//*[@id=\\\"clinic_event_color_green\\\"]\"")).click();

	}
	
	public void create_new_clinic() {
		
		enter_Name("Appollo");
		enter_fulladdress("#600, Los Angelas, USA");
		enter_addressline1("Street2, 1st Main");
		enter_addressline2("USA");
		enter_email("Appollo.clinic@Wiseclinic.com");
		enter_phone("1234567890");
		check_invoice("Happy Message");
		reference();
		appointment_color();
		
		
	}
}
