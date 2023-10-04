package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

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
	public void learnMouseHover() {
		
		By PRODUCT_MENU_FIELD = By.xpath("//span[text() = 'IT Infrastructure']");
		By MONITOR_MENU_FIELD = By.xpath("//button[text() = 'Products']");
		By ALL_MONITOR_MENU_FIELD = By.xpath("//a[text() = 'Servers']");
		By VALIDATE_PAGE_ON_SERVERS = By.xpath("//h1[text()='Servers']");
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_MENU_FIELD)).build().perform();
		action.moveToElement(driver.findElement(MONITOR_MENU_FIELD)).build().perform();
		driver.findElement(ALL_MONITOR_MENU_FIELD).click();
		
		String pageOnServers = driver.findElement(VALIDATE_PAGE_ON_SERVERS).getText();
		Assert.assertEquals("Page not found!", "Servers", pageOnServers);

	}
	@After 
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
