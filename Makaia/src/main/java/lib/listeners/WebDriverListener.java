	package lib.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;




public class WebDriverListener extends Reports implements WebDriverEventListener {

	public static ChromeDriver webdriver;
	public static EventFiringWebDriver driver;
	public int i = 1;

	public WebDriverListener() {

	}

	public void beforeAlertAccept(WebDriver driver) {
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("The alert is accepted");
		takeSnap();

	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("The alert is dismissed");
		takeSnap();

	}

	public void beforeAlertDismiss(WebDriver driver) {		

	}

	public void beforeNavigateTo(String url, WebDriver driver) {

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("The browser loaded the URL "+url);
		takeSnap();
	}

	public void beforeNavigateBack(WebDriver driver) {

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("The browser has loaded the previous page from the history");
		takeSnap();
	}

	public void beforeNavigateForward(WebDriver driver) {

	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("The browser has loaded the next page from the history");
		takeSnap();
	}

	public void beforeNavigateRefresh(WebDriver driver) {


	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("The browser has reloaded successfully");
		takeSnap();
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// Here we may have to wait for click		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("The element "+element +" is clicked successfully");		
		takeSnap();

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("The value "+keysToSend[0]+" is entered successfully in element "+element);	
		takeSnap();

	}

	public void beforeScript(String script, WebDriver driver) {

	}

	public void afterScript(String script, WebDriver driver) {

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("The driver is moved to the window with title "+driver.getTitle());		
		takeSnap();

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// We need to handle exception		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	public long takeSnap() {

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".png"));
		} catch (WebDriverException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}

}
