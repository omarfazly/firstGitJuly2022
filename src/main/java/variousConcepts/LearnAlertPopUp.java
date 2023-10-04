package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlertPopUp {

	WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertPopupTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		/*Now the driver is in original page , so we need to swith our driver to alet box. Based on our alert type 
		 we approch 
		Handling Alert/Popup
		
		To click on the 'Cancel' button:
			driver.switchTo().alert().dismiss();
		To click on the 'OK' button:
			driver.switchTo().alert().accept();
		To capture the alert message:
			driver.switchTo().alert().getText();
		To send some data to alert box:
			driver.switchTo().alert().sendkeys("Text");*/
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		System.out.println(alertMessage);
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
