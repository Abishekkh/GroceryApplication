package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();
	// static instance of ExtentReports to be shared across the application

	public synchronized static ExtentReports createExtentReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

		reporter.config().setReportName("7RMartSupermarketProject");

		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Abishek"); // provides context of the report

		return extentReports;
	}
}
