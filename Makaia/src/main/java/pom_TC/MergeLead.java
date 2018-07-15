package pom_TC;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome;

public class MergeLead extends PreAndPost  {
	@BeforeTest
	public void setValue() {
		testCaseName="Merge Lead";
		testDesc="Merge lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="MergeLeadPOM";
	}
	@Test(dataProvider="UAT")

	public void MergeLeads(String fname) throws InterruptedException {
		
		new MyHome()
		.clickLeads()
		.clickMergeLeads()
		.clickOnFromLead()
		.typeFirstName(fname)
		.clickOnFindLeads()
		.captureLeadID()
		.clickFirstRecord()
		.clickOnToLead()
		.typeFirstName(fname)
		.clickOnFindLeads()
		.clickOnSecondRecord()
		.clickMergeLeadBtn().clickAlertAccept().clickOnFindLeadsLink()
		.typeLeadID()
		.clickOnFindLeads().verifyNoRecords();
	}
	


}
