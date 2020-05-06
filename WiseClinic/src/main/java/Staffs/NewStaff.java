package Staffs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewStaff {
	
	public NewStaff(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"continue_btn\"]")
	private WebElement continue_button;
	
	public void new_staff() {
		
		continue_button.click();
	}

}
