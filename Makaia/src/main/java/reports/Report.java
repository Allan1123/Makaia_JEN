package reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {

	public static void main(String[] args) throws IOException {
	ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.htm");
	html.setAppendExisting(false);
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(html);
	
	
	ExtentTest test = extent.createTest("TC_001","Create lead");
	test.assignAuthor("Allan");
	test.assignCategory("Smoke");
	test.pass("The test case is passed",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
	extent.flush();

	}

}
