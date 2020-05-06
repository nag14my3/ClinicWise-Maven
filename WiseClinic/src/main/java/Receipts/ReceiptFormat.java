package Receipts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReceiptFormat {
	
	public ReceiptFormat(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"receipt_template_002\"]")
	private WebElement receipt_format;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"continue_btn\"]")
	private WebElement continue_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page_content\"]/div/div/form/fieldset/div[2]/div/a")
	private WebElement skip_button;
	
public void receipt_Format() {
	
	if(receipt_format.isSelected()) {
		
		continue_button.submit();		
	}else {
		
		receipt_format.click();
		continue_button.submit();
		
	}
	
}
}
