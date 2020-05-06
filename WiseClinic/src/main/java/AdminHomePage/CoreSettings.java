package AdminHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CoreSettings {
	
	public CoreSettings(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"continue_btn\"]")
	private WebElement continue_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page_content\"]/div/div/form/fieldset/div[4]/div/a")
	private WebElement skip_button;
	
	public void core_settings() {
		
		skip_button.click();
	}
	
}
