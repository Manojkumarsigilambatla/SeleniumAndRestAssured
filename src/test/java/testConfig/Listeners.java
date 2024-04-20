package testConfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import reporting.ExtentReporting;

public class Listeners  extends ExtentReporting implements ITestListener {

	
	public WebDriver driver;
	
	public String testName;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		testName = result.getMethod().getMethodName()+" "+result.getParameters()[0].toString();
		
		extentTest = extent.createTest(testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS,"Successfully placed the order");
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		
		File file =takeScreenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"//screenshots//"+testName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"//screenshots//"+testName+".png");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	

	@Override
	public void onStart(ITestContext context) {
		
		instantiateReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

	
}
