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
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	WebDriver driver;

	
	String fullName = "Ahmad";
	
	
//all element locators are there	
	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@type='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@type='submit']");
	By DASHBOAR_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
	By CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By ADD_FULL_NAME = By.xpath("//input[@id='account']");
	By ADD_CONTACT_HEADER = By.xpath("//h2[contains(text(),'Contacts')]");
	By SELECT_COMPANY_DROPDOWN = By.xpath("//select[@id='cid']");
	By ADD_EMAIL_FIELD = By.xpath("//input[@id='email']");
	By ADD_PHONE_FIELD = By.xpath("//input[@id='phone']");
	By ADD_ADDRESS_FIELD = By.xpath("//input[@id='address']");
	By ADD_CITY_FIELD = By.xpath("//input[@id='city']");
	By ADD_STATE_FIELD = By.xpath("//input[@id='state']");
	By ADD_ZIP_FIELD = By.xpath("//input[@id='zip']");
	By SELECT_COUNTRY_DROPDOWN = By.xpath("//select[@id='country']");
	
	By ADD_TAGS_FIELD = By.xpath("//input[@class='select2-search__field']");
	By SELECT_CURRENCY_DROPDOWN = By.xpath("//select[@id='currency']");
	By SELECT_GROUP_DROPDOWN = By.xpath("//select[@id='group']");
	By ADD_PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By ADD_CONFIRM_PASSWORD = By.xpath("//input[@id='cpassword']");
	By WELCOME_EMAIL_FIELD = By.xpath("//label[@class='btn btn-primary btn-sm toggle-on']");
	By SAVE_BUTTON_FIELD = By.xpath("//button[@id='submit']");
	
	By SELECT_CUSTOMER_LIST = By.xpath("//a[text()='List Customers']");
	By SEARCH_ADDED_CUSTOMER = By.xpath("//input[@id='foo_filter']");
	By DELETE_ADDED_CUSTOMER = By.xpath("//*[@id=\'uid6079\']");
	By CONFIRM_DELETE_CUSTOMER = By.xpath("//button[text()='OK']");
	By SUCCESSFUL_MESSAGE = By.xpath("//i[@class='fa-fw fa fa-check']");
	By CLOSE_ALERT_SUCCESS = By.xpath("//button[@class='close']");
	
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void loginTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		String dashboardtitletext = driver.getTitle();

//		 Assert.assertTrue("Dashboard page not found!",
//		 driver.findElement(DASHBOAR_HEADER_FIELD).isDisplayed());
//		 Assert.assertEquals("Dashboard page not found!", "Dashboard",
//		 driver.findElement(DASHBOAR_HEADER_FIELD).getText());

		Assert.assertEquals("Dashboard page not found!", "Dashboard- iBilling", dashboardtitletext);

		String text = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[3]/a/span")).getText();
		System.out.println(text);



	}

	@Test
	public void addCustomerTest() throws InterruptedException {

		loginTest();
		Thread.sleep(1000);
		 driver.findElement(CUSTOMER_MENU_FIELD).click();
		 driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		 Thread.sleep(1000);
		 Assert.assertEquals("Add contact page not found", "Contacts", driver.findElement(ADD_CONTACT_HEADER).getText());
		 
		 driver.findElement(ADD_FULL_NAME).sendKeys(fullName);
		Select sel = new Select(driver.findElement(SELECT_COMPANY_DROPDOWN));
		sel.selectByVisibleText("Techfios");
		driver.findElement(ADD_EMAIL_FIELD).sendKeys("ahmad@gmail.com");
		driver.findElement(ADD_PHONE_FIELD).sendKeys("0123456789");
		driver.findElement(ADD_ADDRESS_FIELD).sendKeys("MAIN STREET");
		driver.findElement(ADD_CITY_FIELD).sendKeys("DALLAS");
		driver.findElement(ADD_STATE_FIELD).sendKeys("TX");
		driver.findElement(ADD_ZIP_FIELD).sendKeys("75024");
		Select sel1 = new Select(driver.findElement(SELECT_COUNTRY_DROPDOWN));
		sel1.selectByVisibleText("United States");
		
		driver.findElement(ADD_TAGS_FIELD).sendKeys("Tech");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Select sel2 = new Select(driver.findElement(SELECT_CURRENCY_DROPDOWN));
		sel2.selectByVisibleText("USD");
		Select sel3 = new Select(driver.findElement(SELECT_GROUP_DROPDOWN));
		sel3.selectByVisibleText("Selenium");
		driver.findElement(ADD_PASSWORD_FIELD).sendKeys("abc123123");
		driver.findElement(ADD_CONFIRM_PASSWORD).sendKeys("abc123123");
		driver.findElement(SAVE_BUTTON_FIELD).click();
		
		driver.findElement(SELECT_CUSTOMER_LIST).click();
		driver.findElement(SEARCH_ADDED_CUSTOMER).sendKeys(fullName);
		driver.findElement(DELETE_ADDED_CUSTOMER).click();
		driver.findElement(CONFIRM_DELETE_CUSTOMER).click();
		driver.switchTo().alert().dismiss();

		
	}

	// @After
	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
