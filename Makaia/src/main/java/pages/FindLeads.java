package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class FindLeads extends WebDriverServiceImpl {



	@FindBy(xpath="(//div/input[@name='firstName'])[3]")
	WebElement eleFindFirstName;

	@FindBy(xpath="//li//span[text()='Phone']")
	WebElement eleFindPhoneTab;


	@FindBy(xpath="//div/table/tbody/tr//button[text()='Find Leads']")
	WebElement eleFindLeadsBtn;


	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleFirstRecord;

	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement elePhoneNumber;
	
	@FindBy(xpath="//div/input[@name='id']")
	WebElement eleLeadId;
	
	@FindBy(xpath="//div[@class='x-paging-info']")
	WebElement eleNoRecords;
	
	@FindBy(xpath="//span[text()='Email']")
	WebElement eleEmailTab;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	WebElement eleEmailAdd;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")
	WebElement eleFirstName;
	
	
	
	

	public FindLeads() {
//		this.driver=driver;
//		this.test=test;

		PageFactory.initElements(driver, this);	
	}
	@And("typeFirstName (.*)")
	public FindLeads typeFirstName(String sName) {
		type(eleFindFirstName, sName);
		return this;	
	}
	@And("Click on Find leads")
	public FindLeads clickOnFindLeads() {
		click(eleFindLeadsBtn);
		return this;
	}
	@And("ClickFirstRecord")
	public ViewLead clickOnFirstRecord() {
		click(eleFirstRecord);
		return new ViewLead();	
	}

	public FindLeads clickOnFindPhoneTab() {
		click(eleFindPhoneTab);
		return this;	
	}

	public FindLeads typePhoneNumber(String phone) {
		type(elePhoneNumber, phone);
		return this;	
	}

	public FindLeads getLeadID() {
		leadID = getText(eleFirstRecord);
		return this;	
	}
	
	public FindLeads typeLeadID() {
		type(eleLeadId, leadID);
		return this;	
	}
	
	public FindLeads verifyNoRecords() {
		verifyPartialText(eleNoRecords, "No records");
		return this;	
	}
	
	public FindLeads sleep() {
		waitMan();
		return this;	
	}
	
	public FindLeads clickEmailTab() {
		click(eleEmailTab);
		return this;	
	}
	
	public FindLeads typeEmailAdd(String email) {
		type(eleEmailAdd, email);
		return this;	
	}
	
	public FindLeads captureFirstName() {
		name = getText(eleFirstName);
		return this;	
	}
	
//	public FindLeads typeLeadIDFromMerge() {
//		MergeLeads ml=new MergeLeads(driver, test);
//		type(eleLeadId, ml.mergeleadID);
//		return this;	
//	}
	

}