package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.reader.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl{
	public String testCaseName,testDesc,nodeName,authorName,category,excelFileName; 
	
	@Parameters({"URL","userName","pass"})
	@BeforeMethod
	public void beforeMethod(String url,String uName,String pwd) {
		//for reports
		startTestModule(nodeName);
		test.assignAuthor(authorName);
		test.assignCategory(category);
		
		
		System.setProperty("webdriver.chrome.driver", ".Makaia/drivers/chromedriver");
		webdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		driver.manage().window().fullscreen();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		type(locateElement("id", "username"), uName);	
		type(locateElement("id", "password"), pwd);
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
	}

	@AfterMethod
	public void afterMethod() {
		closeActiveBrowser();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDesc);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}


	@AfterSuite
	public void afterSuite() {
		endResult();
	}
	
	
	@DataProvider(name="UAT")
	public String[][] getdata() throws IOException{
		ReadExcel excel=new ReadExcel();
		String [][] data=excel.readExcel(excelFileName);
		return data;
	}
	
	
	
	

}
