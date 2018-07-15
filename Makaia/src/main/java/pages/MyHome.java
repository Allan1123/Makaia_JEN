package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class MyHome extends WebDriverServiceImpl {
	
	@FindBy(linkText="Leads")
	WebElement eleLeads;
	
	
	public MyHome() {
//		this.driver=driver;
//		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@And("Click lead link")
	public MyLeads clickLeads() {
		click(eleLeads);
		return new MyLeads();
		
	}
	

}
