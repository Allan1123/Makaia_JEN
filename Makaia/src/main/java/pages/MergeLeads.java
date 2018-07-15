package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.selenium.WebDriverServiceImpl;

public class MergeLeads extends WebDriverServiceImpl{
	
	static String mergeleadID;
	
	@FindBy(xpath="(//img[@src='/images/fieldlookup.gif'])[1]")
	WebElement eleFromLead;
	
	@FindBy(xpath="(//input[@name='firstName'])[3]")
	WebElement eleFirstName;
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsBtn;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleFirstRecord;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")
	WebElement eleSecondRecord;
	
	@FindBy(xpath="(//img[@src='/images/fieldlookup.gif'])[2]")
	WebElement eleToLead;

	@FindBy(className="buttonDangerous")
	WebElement eleMergeLeadBtn;
	
	
	
	public MergeLeads() {
//		this.driver=driver;
//		this.test=test;

		PageFactory.initElements(driver, this);	
	}
	
	public FindLeadsPopUp clickOnFromLead() throws InterruptedException {
		click(eleFromLead);
		Thread.sleep(3000);
		switchToWindow(1);
		return new FindLeadsPopUp();	
	}
	
//	public MergeLeads switchWindow() {
//		switchToWindow(1);
//		return this;	
//	}
	
	public MergeLeads typeFirstName(String sname) {
		type(eleFirstName, sname);
		return this;	
	}
	
	public MergeLeads clickFindLeadBtn() {
		click(eleFindLeadsBtn);
		return this;	
	}
	
	public MergeLeads clickFirstRecord() {
		click(eleFirstRecord);
		switchToWindow(0);
		return this;	
	}
	
	public MergeLeads captureLeadId() {
		mergeleadID = getText(eleFirstRecord);
		return this;	
	}
	
	public FindLeadsPopUp clickOnToLead() throws InterruptedException {
		click(eleToLead);
		Thread.sleep(3000);
		switchToWindow(1);
		//add
		return new FindLeadsPopUp();	
	}
	
	public MergeLeads clickSecondRecord() {
		click(eleSecondRecord);
		switchToWindow(0);
		return this;	
	}
	
	public MergeLeads clickMergeLeadBtn() {
		click(eleMergeLeadBtn);
		return this;
	}
	
	public ViewLead clickAlertAccept() {
		acceptAlert();
		return new ViewLead();	
			
	}
	
	public MergeLeads sleep() {
		waitMan();
		return this;	
	}

}
