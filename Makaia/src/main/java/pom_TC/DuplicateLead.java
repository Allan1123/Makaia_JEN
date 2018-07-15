package pom_TC;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome;

public class DuplicateLead extends PreAndPost{
	@BeforeTest
	public void setValue() {
		testCaseName="Duplicate Lead";
		testDesc="Duplicate lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="DuplicateLeadPOM";
	}
	@Test(dataProvider="UAT")
	
	public void duplicateLead (String eMail) throws InterruptedException {
		System.out.println("Duplicate Lead");	
		
		
		new MyHome().clickLeads().clickFindLeads().clickEmailTab().typeEmailAdd(eMail).clickOnFindLeads().sleep().captureFirstName().clickOnFirstRecord().clickOnDuplicateBtn().verifyTitleName().clickOnCreateLeadBtn().sleep().verifyFirstName();
		
	}

}
