package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{
	private Actions builder;
	public static String leadID;	
	public static String name;

	public WebElement locateElement(String locator, String locValue) {

		switch (locator) {
		case "id": return driver.findElement(By.id(locValue));

		case "name": return driver.findElement(By.name(locValue));

		case "class": return driver.findElement(By.className(locValue));

		case "link" : return driver.findElement(By.linkText(locValue));

		case "xpath": return driver.findElement(By.xpath(locValue));

		default:
			break;
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportSteps("The Data "+data+" is Entered Successfully", "pass");
		} catch (Exception e) {
			reportSteps("The Data "+data+" is not Entered Successfully", "fail");
		}		
	}

	public void click(WebElement ele) {
		ele.click();		
	}

	public String getText(WebElement ele) {
		return ele.getText();

	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	public boolean verifyExactTitle(String expectedTitle) {
		if(driver.getTitle().contains(expectedTitle))
		{
			System.out.println("The Title is verified");
			return true;
		}
		else {
			System.out.println("The Title is not verified");
			return false;
		}
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		String text = ele.getText();
		if(text.equals(expectedText))
		{
			System.out.println("The Text is verified");
		}
		else {
			System.out.println("The text is WRONG");
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText))
		{
			System.out.println("The text is verified");
		}
		else
		{
			System.out.println("The text is not verified");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		Set<String> NewWindow = driver.getWindowHandles();
		List<String> allwindows=new ArrayList<String> ();
		allwindows.addAll(NewWindow);
		driver.switchTo().window(allwindows.get(index));

	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		driver.switchTo().alert().accept(); 

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeActiveBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		System.out.println("I am closing your browsers Allan");
		driver.quit();

	}

	public void cleardata(WebElement ele) {
		try {
			driver.unregister(this);
			ele.clear();
			driver.register(this);
		} catch (Exception e) {


		}

	}
	public void waitMan() {
		try {
			driver.unregister(this);
			Thread.sleep(3000);
			driver.register(this);
		} catch (Exception e) {

		}		
	}
	public void ActionEscape() {

		driver.getKeyboard().sendKeys(Keys.ESCAPE);

	}

	public void ActionsMouseOver(WebElement ele) {
		builder=new Actions(driver);
		builder.moveToElement(ele).perform();

	}

	public String getCurrentURL() {
		System.out.println("Bangam");		
		return driver.getCurrentUrl();
	}

	public int ComparetwoNumbersMin(String data1,String data2) {
		int parseIntVal1 = Integer.parseInt(data1.replaceAll("\\D", "")) ;
		int parseIntVal2 = Integer.parseInt(data2.replaceAll("\\D", "")) ;
		if(parseIntVal1<parseIntVal2)
		{
			System.out.println(parseIntVal1);
			return parseIntVal1;
		}
		else 
		{
			System.out.println(parseIntVal2);
			return parseIntVal2;
		}

	}

}
