package pom_TC;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome;

public class EditLead extends PreAndPost {
	@BeforeTest
	public void setValue() {
		testCaseName="Edit Lead";
		testDesc="Edit lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="EditLeadPOM";
	}

	@Test(dataProvider="UAT")

	public void Editlead(String fname,String eComp) throws InterruptedException {
		System.out.println("Edit Lead");

		new MyHome().clickLeads().clickFindLeads().typeFirstName(fname).clickOnFindLeads().clickOnFirstRecord().ClickOnEdit().clearCompanyName().typeCompanyNameEL(eComp).ClickOnUpdateBtn().VerifyCompanyName(eComp);
	}



}
