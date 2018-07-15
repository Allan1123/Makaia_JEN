package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl{
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement eleCreateLead;
	
	public DuplicateLead() {
//		this.driver=driver;
//		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	public ViewLead clickOnCreateLeadBtn() {
		click(eleCreateLead);
		return new ViewLead();	

	}
	
	public DuplicateLead verifyTitleName() {
		verifyExactTitle("Duplicate Lead");
		return this;

	}

}
