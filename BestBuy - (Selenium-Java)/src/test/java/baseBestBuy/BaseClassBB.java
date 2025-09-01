package baseBestBuy;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilsBestBuy.UtilsBB;

import java.io.File;

public class BaseClassBB extends UtilsBB {

	@BeforeSuite
	public void startReport() {
		createReportDirectory();

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public static void createReportDirectory() {
		File reportDir = new File("./reports");

		if (!reportDir.exists()) {
			reportDir.mkdirs();
		}
	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@BeforeMethod
	public void start() throws Exception {
		launchBrowser(readProperty("browser"));
		getApplication(readProperty("url"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getFromExcel() throws Exception {
		return dataReader(sheetName);
	}

	@AfterSuite
	public void endReport() {
		if (extent != null) {
			extent.flush();
		}
	}
}
