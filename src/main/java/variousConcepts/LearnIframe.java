package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIframe {

	WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void iframeTest() {
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.applet")).click();
		/* for switching to other frames we should first go to parent frame than switching to frame and gonna use this code:
		   driver.switchTo().parentFrame();*/
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("AppletContext")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("Abstract Methods")).click();
		driver.findElement(By.linkText("Applet")).click();
	}
}
