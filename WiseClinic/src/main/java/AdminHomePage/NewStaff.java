package AdminHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewStaff {
	
	public NewStaff(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"continue_btn\"]")
	private WebElement continue_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_username\"]")
	private WebElement user_Name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_staff_number\"]")
	private WebElement staff_No;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_password\"]")
	private WebElement user_password;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_password_confirmation\"]")
	private WebElement user_pass_again;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_email\"]")
	private WebElement user_email;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_last_name\"]")
	private WebElement last_name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_first_name\"]")
	private WebElement first_name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"new_user\"]/div[10]/div/div[2]/div[2]/input")
	private WebElement user_Role;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_position\"]")
	private WebElement user_position;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_mobile\"]")
	private WebElement user_mobile_No;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"new_user\"]/div[16]/div/input")
	private WebElement register_button;
	
	
	
	
	public void new_staff() {
		
		continue_button.click();
	}

	
	public void userName(String username) {
		
		user_Name.sendKeys(username);
		
	}
	
	public void staffNumber(String staffnum) {
		
		staff_No.sendKeys(staffnum);
		
	}
	
	public void userpassword(String userpassword) {
		
		user_password.sendKeys(userpassword);
		
		
	}
	
	public void passwordAgain(String passwordagain) {
		
		user_pass_again.sendKeys(passwordagain);
		
	}
	
	public void userEmail(String email2) {
		
		user_email.sendKeys(email2);
		
	}
	
	
	public void lastName(String lastname) {
		
		last_name.sendKeys(lastname);
		
	}
	
	public void firstName(String firstname) {
		
		first_name.sendKeys(firstname);
	}
	
	public void userRole() {
		
		user_Role.click();
	}
	
	public void userPosition() {
		
		Select select = new Select(user_position);
		select.selectByIndex(1);
	}
	
	public void userMobile(String mobilenum) {
		
		user_mobile_No.sendKeys(mobilenum);
	}
	
	public void registerButton() {
		
		register_button.click();
	}
	
	public void new_satff_creation() {
		
		userName("Jhony.S");
		staffNumber("10");
		userpassword("test");
		passwordAgain("test");
		userEmail("jhony.s@wiseclinic.com");
		lastName("S");
		firstName("Jhony");
		userRole();
		userPosition();
		userMobile("9234567892");
		registerButton();
		
	}
	
}
