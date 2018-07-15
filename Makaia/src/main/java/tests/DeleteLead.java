package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class DeleteLead extends PreAndPost {
	@BeforeTest
	public void setValue() {
		testCaseName="Delete Lead";
		testDesc="Delete lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="DeleteLeead";
	}
	@Test(dataProvider="UAT")
	//@Test(groups= {"Sanity"})
	//@Test(dependsOnMethods="tests.CreateLead.createLead",alwaysRun=true)
	
	public void deleteLead(String phone) throws InterruptedException {
		
		System.out.println("Delete Lead");
		
		
//		WebElement eleUserName = locateElement("id", "username");
//		type(eleUserName, "DemoSalesManager");
//		
//		WebElement elePassword = locateElement("id", "password");
//		type(elePassword, "crmsfa");
//		
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
		
		WebElement elePhone = locateElement("xpath", "//li//span[text()='Phone']");
		click(elePhone);
		
		//Use Data Provider
		
		WebElement elePhoneEdit = locateElement("xpath", "//div/input[@name='phoneNumber']");
		type(elePhoneEdit, phone);
		//------------
		
		WebElement eleFindLeadBtn = locateElement("xpath", "//tbody//td//button[text()='Find Leads']");
		click(eleFindLeadBtn);
		
		Thread.sleep(3000);
		
		WebElement eleFirstElement = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String textFirstEle = eleFirstElement.getText();
		click(eleFirstElement);
		
		WebElement eleDelete = locateElement("link", "Delete");
		click(eleDelete);
		
		Thread.sleep(3000);
		


		WebElement eleFindLeadsD = locateElement("link", "Find Leads");
		click(eleFindLeadsD);
		
		
		WebElement eleLeadId = locateElement("xpath", "//div/input[@name='id']");
		type(eleLeadId, textFirstEle);
		
		WebElement eleFindLeadBtnD = locateElement("xpath", "//tbody//td//button[text()='Find Leads']");
		click(eleFindLeadBtnD);
		
		WebElement eleNoRecords = locateElement("xpath", "//div[@class='x-paging-info']");
		String textNoRecords = eleNoRecords.getText();
		verifyPartialText(eleNoRecords, textNoRecords);

	}
	
//	@DataProvider(name="UAT")
//	public String[][] getdata(){
//		String[][] data=new String[1][1];
//		data[0][0]="9884516877";
//		return data;
//	}

}
