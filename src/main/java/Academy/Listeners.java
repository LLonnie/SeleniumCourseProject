package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends TestBase implements ITestListener {

	ExtentReports extentReports = ExtentReporter.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String testName = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(driver, testName), testName + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		extentTest.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
