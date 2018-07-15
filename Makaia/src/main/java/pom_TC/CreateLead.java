package pom_TC;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome;

public class CreateLead extends PreAndPost{
	
	@BeforeTest
	public void setValue() {
		testCaseName="Create Lead POM";
		testDesc="Create lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="CreateLeadPOM";
	}
	
	@Test(dataProvider="UAT")
	//@Test(invocationCount=2,timeOut=30000)
	public void createLead(String CName,String fName, String lName, String phone, String eMial) {
		new MyHome().clickLeads().clickCreateLeads().typeCompany(CName).typeFirstName(fName).typeLastName(lName).typePhoneNumber(phone).typeEmail(eMial).clicnBtnCreateLead().VerifyFirstName(fName);
		
		
	}
}




