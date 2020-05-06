package AdminHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExportData {

	public ExportData(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page_content\"]/div/div/form/div[1]/div/input")
	private WebElement admin_password;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page_content\"]/div/div/form/div[2]/div/select")
	private WebElement data_dropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page_content\"]/div/div/form/div[3]/div/input[2]")
	private WebElement file_Format;

	@FindBy(how = How.XPATH, using = "//*[@id=\"export_button\"]")
	private WebElement export_button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page_content\"]/div/div/form/div[4]/div/a")
	private WebElement cancel_button;

	public void admin_pass(String passadmin) {

		admin_password.sendKeys(passadmin);

	}

	public void selectdata() {

		Select select = new Select(data_dropdown);
		select.selectByValue("clients");

	}

	public void selectfileformat() {

		if (file_Format.isSelected()) {

			export_button.click();

		} else {

			file_Format.click();
			export_button.submit();

		}

	}
	
	public void dataexport() {
		
		admin_pass("test");
		selectdata();
		selectfileformat();
		
	}

}
