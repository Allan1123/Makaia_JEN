package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class ViewLead extends WebDriverServiceImpl {
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleVerFirstName;
	
	@FindBy(linkText="Edit")
	WebElement eleEditBtn;
	
	@FindBy(id="viewLead_companyName_sp")
	WebElement eleCompanyName;
	
	@FindBy(linkText="Delete")
	WebElement eleDeleteBtn;
	
	@FindBy(xpath="//a[text()='Duplicate Lead']")
	WebElement eleDuplicateBtn;
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstNameVer;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeadLink;
	
	
	
	public ViewLead() {
//		this.driver=driver;
//		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	public ViewLead VerifyFirstName(String name) {
		verifyExactText(eleVerFirstName, name);
		return this;	
	}
	@When("Verify Company Name (.*)")
	public ViewLead VerifyCompanyName(String cName) {
		verifyPartialText(eleCompanyName, cName);
		return this;	
	}
	@And("ClickOnEditLead")
	public EditLead ClickOnEdit() {
		click(eleEditBtn);
		return new EditLead();	
	}
	
	public MyLeads clickOnDeleteBtn() {
		click(eleDeleteBtn);
		return new MyLeads();	

	}	
	
	public DuplicateLead clickOnDuplicateBtn() {
		click(eleDuplicateBtn);
		return new DuplicateLead();	

	}
	
	public ViewLead sleep() {
		waitMan();
		return this;	
	}
	
	public ViewLead verifyFirstName() {
		verifyExactText(eleFirstNameVer, name);
		return this;
	}
	
	public FindLeads clickOnFindLeadsLink() throws InterruptedException {
		click(eleFindLeadLink);
		Thread.sleep(3000);
		return new FindLeads();

	}

}
