package Runner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.gherkin.model.Feature;

import Base.ExtentReportUtils;

import static Base.BaseUtils.features;

public class ListenerTest implements ITestListener {
	
	ExtentReportUtils extentReport = new ExtentReportUtils();

	@Override
	public void onFinish(ITestContext iTestContext) {
		
		System.out.println("Test on Finish");

	}

	@Override
	public void onStart(ITestContext iTestContext2) {
		
		System.out.println("Test on Start");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestContext3) {
		System.out.println("Test on fail but within Success Percentage");
		
		try {
			extentReport.ExtentReportScreenshot();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestContext4) {
		System.out.println("Test on Failure");
	}

	@Override
	public void onTestSkipped(ITestResult iTestContext5) {
		System.out.println("Test on Skipped");
	}

	@Override
	public void onTestStart(ITestResult iTestContext6) {
		System.out.println("Test on Start");
		
		extentReport.ExtentReort();
		features = extentReport.extent.createTest(Feature.class, "Login Feature");
		
	}

	@Override
	public void onTestSuccess(ITestResult iTestContext7) {
		
		System.out.println("Test on Success");

	}

}
