package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.selenium.WebDriverServiceImpl;

public class FindLeadsPopUp extends WebDriverServiceImpl {


	@FindBy(xpath="//input[@name='firstName']")
	WebElement eleFindFirstName;

	@FindBy(xpath="//div/table/tbody/tr//button[text()='Find Leads']")
	WebElement eleFindLeadsBtn;


	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleFirstRecord;

	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")
	WebElement eleSecontRecord;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleFirstLeadId;	
	
	

	public FindLeadsPopUp() {
//		this.driver=driver;
//		this.test=test;

		PageFactory.initElements(driver, this);	
	}

	public FindLeadsPopUp typeFirstName(String sName) {
		type(eleFindFirstName, sName);
		return this;	
	}

	public FindLeadsPopUp clickOnFindLeads() {
		click(eleFindLeadsBtn);
		return this;
	}

	public MergeLeads clickOnFirstRecord() {
		click(eleFirstRecord);
		return new MergeLeads();	
	}
	public MergeLeads clickOnSecondRecord() {
		click(eleSecontRecord);
		switchToWindow(0);
		return new MergeLeads();	
	}
	//add
	public MergeLeads captureLeadID() {
		leadID = getText(eleFirstLeadId);
		return new MergeLeads();	
	}
	
	
	

}