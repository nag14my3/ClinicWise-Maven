package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeTest;



import Base.BaseUtils;
import cucumber.api.Scenario;
import managers.FileReaderManager;

public class Hooks extends BaseUtils {
	
	private BaseUtils utils;
	
	public Hooks(BaseUtils utils) {
		
		this.utils = utils;
		
	}
	
	@BeforeTest
	public void InitializeTest(Scenario scenario) {
		
		scenarioDef = utils.features.createNode(scenario.getName());
		
		System.setProperty("webdriver.chrome.driver",
				FileReaderManager.getInstance().getConfigReader().getDriverPath());
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		
	}
	

}
