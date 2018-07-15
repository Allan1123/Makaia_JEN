package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class CreateLead extends WebDriverServiceImpl {
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;
	
	@FindBy(className="smallSubmit")
	WebElement eleCreateBtn;
	
	@FindBy(id="createLeadForm_primaryPhoneNumber")
	WebElement elePhoneNumber;
	
	@FindBy(id="createLeadForm_primaryEmail")
	WebElement eleEmail;
	
	
	public CreateLead() {
//		this.driver=driver;
//		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@And("type companny name (.*)")
	public CreateLead typeCompany(String companyName) {
		type(eleCompanyName, companyName);
		return this;
	}
	@And("type first name (.*)")
	public CreateLead typeFirstName(String firstName) {
		type(eleFirstName, firstName);
		return this;
	}
	@And("type last name (.*)")
	public CreateLead typeLastName(String lastName) {
		type(eleLastName, lastName);
		return this;
	}
	
	public CreateLead typePhoneNumber(String phoneNum) {
		type(elePhoneNumber, phoneNum);
		return this;
	}
	
	public CreateLead typeEmail(String eMail) {
		type(eleEmail, eMail);
		return this;
	}
	@When("Create Lead")
	public ViewLead clicnBtnCreateLead() {
		click(eleCreateBtn);
		return new ViewLead();
	}
		
	}
	


