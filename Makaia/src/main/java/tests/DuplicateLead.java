package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class DuplicateLead extends PreAndPost{
	@BeforeTest
	public void setValue() {
		testCaseName="Duplicate Lead";
		testDesc="Duplicate lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="DuplicateLead";
	}
	@Test(dataProvider="UAT")
	
	public void duplicateLead (String eMail) throws InterruptedException {
		// Duplicate lead
//		
//		WebElement eleUserName = locateElement("id", "username");
//		type(eleUserName, "DemoSalesManager");
//		
//		WebElement elePassword = locateElement("id", "password");
//		type(elePassword, "crmsfa");
		
//		WebElement eleLogin = locateElement("class", "decorativeSubmit");
//		click(eleLogin);
//		
//		WebElement eleCRM = locateElement("link", "CRM/SFA");
//		click(eleCRM);
		
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		Thread.sleep(4000);
		
		WebElement eleEmail = locateElement("xpath", "//span[text()='Email']");
		click(eleEmail);
		
		Thread.sleep(3000);
		
		WebElement eleEmailAdd = locateElement("xpath", "//input[@name='emailAddress']");
		type(eleEmailAdd, eMail);
		
		WebElement eleFindLeadsBtn = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn);
		
		WebElement eleFirstName = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
		String firstName = eleFirstName.getText();
		
		WebElement eleFirstElement = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		click(eleFirstElement);
		
		WebElement eleDuplicateBtn = locateElement("xpath", "//a[text()='Duplicate Lead']");
		click(eleDuplicateBtn);
		
		String title = driver.getTitle();
		verifyExactTitle(title);
		
		WebElement eleCreateLead = locateElement("xpath", "//input[@name='submitButton']");
		click(eleCreateLead);
		
		WebElement eleCapFirstNam = locateElement("id", "viewLead_firstName_sp");
		String CapFirstName = eleCapFirstNam.getText();
	
		verifyExactText(eleCapFirstNam, CapFirstName);

		
		
	}
//	@DataProvider(name="UAT")
//	public String[][] getdata() {
//		String[][] data=new String[1][1];
//		data[0][0]="allandavid35@gmail.com";
//		return data;
//		
//	}

}
