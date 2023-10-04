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

public class LearnKeyboardEvent {

	WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test 
	public void learnKeyboardEvent() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		
		//for any keyboard action we need actions interface and will add driver on it.
		// After that we use action name . sendkeys (Key. + any action).build().perform();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		//in mac we can use Return beside enter...
		String text = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]")).getText();
		Assert.assertEquals("Page not found", "Dashboard", text);
		System.out.println(text);
	}
	@After 
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
