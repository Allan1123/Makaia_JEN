package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost {
	@BeforeTest
	public void setValue() {
		testCaseName="Edit Lead";
		testDesc="Edit lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="EditLead";
	}
	
	@Test(dataProvider="UAT")
	//@Test(groups= {"Smoke"})
	//@Test(dependsOnMethods= {"tests.CreateLead.createLead"},description="Edit Lead Test Execution")
	public void Editlead(String fname,String eComp) throws InterruptedException {
		System.out.println("Edit Lead");
//		WebElement eleUserName = locateElement("id", "username");
//		type(eleUserName, "DemoSalesManager");
//		
//		WebElement elePassword = locateElement("id", "password");
//		type(elePassword, "crmsfa");
		
		/*WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		*/
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		Thread.sleep(4000);
		
		WebElement eleFirstName = locateElement("xpath", "(//div/input[@name='firstName'])[3]");
		type(eleFirstName, fname);
		
		WebElement eleFindLeadsBtn = locateElement("xpath", "//div/table/tbody/tr//button[text()='Find Leads']");
		click(eleFindLeadsBtn);
		
		Thread.sleep(3000);
		
		WebElement eleFirstRecord = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		click(eleFirstRecord);
		
		verifyExactTitle("View Lead");
		
		WebElement eleEditBtn = locateElement("link", "Edit");
		click(eleEditBtn);
		
		WebElement eleCompanyName = locateElement("id", "updateLeadForm_companyName");
		cleardata(eleCompanyName);
		Thread.sleep(3000);
		type(eleCompanyName, eComp);
		
		
		WebElement eleUpdateBtn = locateElement("class", "smallSubmit");
		click(eleUpdateBtn);
		
		WebElement eleCompanyNameVerf = locateElement("id", "viewLead_companyName_sp");
		verifyPartialText(eleCompanyNameVerf, "Bally");
		
		//closeAllBrowsers();		
		
	}
	
//	@DataProvider(name="UAT", parallel=true)
//	public String[][] getdata() {
//		String[][] data=new String[1][2];
//		data[0][0]="Allan";
//		data[0][1]="SG";
//		return data;
//	}

}
