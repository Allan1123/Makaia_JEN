package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class CreateLead extends PreAndPost{
	
	@BeforeTest
	public void setValue() {
		testCaseName="Create Lead";
		testDesc="Create lead Test Cases";
		nodeName="Lead";
		authorName="Allan";
		category="Sanity";
		excelFileName="CreateLead";
	}
	
	@Test(dataProvider="UAT")
	//@Test(invocationCount=2,timeOut=30000)
	public void createLead(String CName,String fName, String lName,String eMail, String Phone) {
		System.out.println("Create Lead");

		/*WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);*/
		
		WebElement eleCreateLead = locateElement("link", "Create Lead");
		click(eleCreateLead);
		
		WebElement eleCompanyName = locateElement("id", "createLeadForm_companyName");
		type(eleCompanyName, CName);
		
		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, fName);
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, lName);
		
		WebElement eleEmail = locateElement("id", "createLeadForm_primaryEmail");
		type(eleEmail, eMail);
		
		WebElement elePhoneNumber = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(elePhoneNumber, Phone);
		
		WebElement eleCreateLeadButton = locateElement("class", "smallSubmit");
		click(eleCreateLeadButton);
		
		
		
	}
//	@DataProvider(name="UAT")
//	public String[][] getdata() throws IOException{
//		ReadExcel excel=new ReadExcel();
//		String [][] data=excel.readExcel("CreateLead");
////		String[][] data=new String[1][5];
////		data[0][0]="TestLeaf";
////		data[0][1]="Allan123";
////		data[0][2]="David";
////		data[0][3]="Allandavid35@gmail.com";
////		data[0][4]="9884516877";
//		return data;
//		
//	}
	
}




