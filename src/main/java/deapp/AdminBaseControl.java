package deapp;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdminBaseControl {

	public static ExtentReports reports;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest mainTest;
	public static ExtentTest secondTest;
	public static ExtentTest logTest;

	public static void createTestName(String testName, String Authorname) throws Exception {

		mainTest = reports.createTest(testName).assignAuthor(Authorname);

	}

	public static void assignTestCategories(String pageName) {

		// To get category tag names
		mainTest.assignCategory(pageName);

	}

	@BeforeSuite
	public void extentReportSetUp() throws Exception

	{

		String ReportPath = "./DigitalExpert1.5_18N_Reports/DE_1.5_I18N_TestReport.html";

		reports = new ExtentReports();
		htmlReporter = new ExtentSparkReporter(ReportPath);

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("DigitalExpert1.5_I18N_TestReport");
		htmlReporter.config().setTimelineEnabled(true);

		reports.attachReporter(htmlReporter);
	}

	@AfterMethod
	public void PostConditionTestStatus(ITestResult result) throws Exception {

		ITestNGMethod m = result.getMethod();
		String name = m.getMethodName();

		String description = result.getMethod().getDescription();

		if (result.getStatus() == ITestResult.SUCCESS) {

			secondTest = mainTest.createNode(description);
			secondTest.pass(MarkupHelper.createLabel(name + " \"Language comparision  is passed\"", ExtentColor.GREEN));

			AdminBaseControl
					.assignTestCategories("Feature" + result.getTestClass().getRealClass().getName().substring(5));

		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			secondTest = mainTest.createNode(description);

			AdminBaseControl
					.assignTestCategories("Feature" + result.getTestClass().getRealClass().getName().substring(5));

			try {

				// to capture status,name of testmethod in Tests node
				secondTest.log(Status.FAIL, name + " \"Language comparision failed \"");

				// To get Bug icon and exceptions of Defects and info
				secondTest.info(result.getThrowable());

			}

			catch (Exception e) {

				// To get Bug icon and exceptions of Defects and info
				secondTest.log(Status.FAIL, e.getMessage());

				System.out.println("error message" + e.getMessage());

			}
		}
		reports.flush();
	}

	@AfterClass
	public void addToReport() {
		reports.flush();

	}

}
