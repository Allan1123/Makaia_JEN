package lib.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.flipkart.com/");
		
		Actions builder= new Actions(driver);
		
		Thread.sleep(4000);
		driver.getKeyboard().sendKeys(Keys.ESCAPE);
		
		WebElement eleElectronics = driver.findElementByLinkText("Electronics");
		builder.moveToElement(eleElectronics).perform();
		


	}

}
