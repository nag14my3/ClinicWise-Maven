package Base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentReportUtils extends BaseUtils{
	
	String fileName = reportlocation + "extentreport.html";
	
	public void ExtentReort() {
		
		extent = new ExtentReports();
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Test Report for Wise Clinic");
		htmlReporter.config().setEncoding("uft-8");
		htmlReporter.config().setReportName("Test Report");
		extent.attachReporter(htmlReporter);
		
	}
	
	public void ExtentReportScreenshot() throws IOException{
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		File scr = scrShot.getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File(reportlocation+"screenshot.png"));
	}
	
	public void FlushReport() {
		
		extent.flush();
	}

}
