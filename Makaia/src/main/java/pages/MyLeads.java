package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class MyLeads extends WebDriverServiceImpl {
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLeads;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	
	@FindBy(linkText="Merge Leads")
	WebElement eleMergeLeads;
	
	
	public MyLeads() {
//		this.driver=driver;
//		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@And("Click Create Lead link")
	public pages.CreateLead clickCreateLeads() {
		click(eleCreateLeads);
		return new pages.CreateLead();
		
	}
	@And("Click Find Lead link")
	public FindLeads clickFindLeads() {
		click(eleFindLeads);
		return new FindLeads();
		
	}
	
	public MergeLeads clickMergeLeads() {
		click(eleMergeLeads);
		return new MergeLeads();
		
	}

}
