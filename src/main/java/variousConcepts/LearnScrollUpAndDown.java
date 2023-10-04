package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnScrollUpAndDown {
WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test 
	public void scrollLearn() throws InterruptedException {
		// casting login in here
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("scroll(0,2000)");
		Thread.sleep(2000);
		
		js.executeScript("scroll(0,0)");

	}
	//@After 
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
