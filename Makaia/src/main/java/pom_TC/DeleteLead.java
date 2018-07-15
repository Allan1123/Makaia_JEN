package pom_TC;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome;

public class DeleteLead extends PreAndPost {
	@BeforeTest
	public void setValue() {
		testCaseName="Delete Lead POM";
		testDesc="Delete lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="DeleteLeadPOM";
	}
	@Test(dataProvider="UAT")	
	public void deleteLead(String phone) throws InterruptedException {
		
		System.out.println("Delete Lead");
		
		new MyHome().clickLeads().clickFindLeads().clickOnFindPhoneTab().sleep().typePhoneNumber(phone).clickOnFindLeads().getLeadID().clickOnFirstRecord().clickOnDeleteBtn().clickFindLeads().typeLeadID().clickOnFindLeads().verifyNoRecords();
		
		
	}
	
}
