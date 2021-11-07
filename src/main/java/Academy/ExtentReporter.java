package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReports extentReports;

	public static ExtentReports getReportObject() {

		String reportingPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportingPath);
		extentSparkReporter.config().setReportName("Web Automation Results");
		extentSparkReporter.config().setDocumentTitle("Test Results");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Lonnie");

		return extentReports;
	}
}
