package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
//@Test(enabled=false)

public class MergeLead extends PreAndPost  {
	@BeforeTest
	public void setValue() {
		testCaseName="Merge Lead";
		testDesc="Merge lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="MergeLead";
	}
	@Test(dataProvider="UAT")
	//@Test(groups= {"Sanity"})
	public void MergeLeads(String fname) throws InterruptedException {
		//Merge Lead
		System.out.println("Merge Lead");
//		WebElement eleUserName = locateElement("id", "username");
//		type(eleUserName, "DemoSalesManager");
//		
//		WebElement elePassword = locateElement("id", "password");
//		type(elePassword, "crmsfa");
		
		//WebElement eleLogin = locateElement("class", "decorativeSubmit");
		//click(eleLogin);
		
		//WebElement eleCRM = locateElement("link", "CRM/SFA");
		//click(eleCRM);
		
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Merge Leads");
		click(eleFindLeads);
		
		
		
		WebElement eleFromLeadBtn = locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[1]");
		click(eleFromLeadBtn);
		
		Thread.sleep(2000);
		switchToWindow(1);
		
		Thread.sleep(2000);
		
		WebElement eleLeadIdWin = locateElement("xpath", "//input[@name='firstName']");
		type(eleLeadIdWin, "Allan");
		
		WebElement eleFindLeadBtnWin = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadBtnWin);
		
		Thread.sleep(3000);
		
		WebElement eleWin2Element = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String LeadId = eleWin2Element.getText();
		click(eleWin2Element);
		
		Thread.sleep(3000);
		
		switchToWindow(0);
	
		
		WebElement eleFromLeadBtn1 = locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]");
		click(eleFromLeadBtn1);
		
		Thread.sleep(3000);
		switchToWindow(1);
		
		Thread.sleep(3000);
		
		WebElement eleLeadIdWin1 = locateElement("xpath", "//input[@name='firstName']");
		type(eleLeadIdWin1, fname);
		
		WebElement eleFindLeadBtnWin1 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadBtnWin1);
		
		Thread.sleep(3000);
		
		WebElement eleWin2Element1 = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		click(eleWin2Element1);
		
		Thread.sleep(3000);
		switchToWindow(0);
		
		WebElement eleMergeBtn = locateElement("class", "buttonDangerous");
		click(eleMergeBtn);
		
		acceptAlert();
		
		WebElement eleFindLeads2 = locateElement("link", "Find Leads");
		click(eleFindLeads2);
		
		Thread.sleep(3000);
		
		WebElement eleLeadid = locateElement("name", "id");
		type(eleLeadid, LeadId);
		
		WebElement eleFindLeadsBtn1 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn1);
		
		WebElement eleNorecords = locateElement("xpath", "//div[text()='No records to display']");
		
		verifyExactText(eleNorecords, "No records to display");	
		
	}
	
//	@DataProvider(name="UAT")
//	public String[][] getdata() {
//		String[][] data=new String[1][1];
//		data[0][0]="Allan";
//		return data;
//	}

}
