package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class EditLead extends WebDriverServiceImpl {
	
	@FindBy(id="updateLeadForm_companyName")
	WebElement eleCompanyNameEL;
	
	@FindBy(className="smallSubmit")
	WebElement eleUpdateBtn;
	
	
	public EditLead() {
//		this.driver=driver;
//		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@And("type Company Name (.*)")
	public EditLead typeCompanyNameEL(String cName) {
		type(eleCompanyNameEL, cName);
		return this;	
	}
	@And("clear Company Name")
	public EditLead clearCompanyName() {
		cleardata(eleCompanyNameEL);
		return this;	
	}
	@And("Click on Update Btn")
	public ViewLead ClickOnUpdateBtn() {
		click(eleUpdateBtn);
		return new ViewLead();	
	}

}
