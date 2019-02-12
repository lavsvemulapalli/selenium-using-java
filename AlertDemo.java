package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertDemo {
	WebDriver d;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		// d=new FirefoxDriver();
		 d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}

	@After
	
	public void teardown()
	{
		d.quit();
		
	}
	@Test
	public void alertDemo() throws Exception
	{
		d.get("https://www.irctc.co.in/eticketing/pageUnderConstruction.jsf");
		d.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		//d.switchTo().alert().accept();
		Alert ab=d.switchTo().alert();
		assertEquals("Enter User ID", ab.getText());
		ab.accept();
		Thread.sleep(1000);
		d.findElement(By.id("usernameId")).sendKeys("lavanya");
		d.findElement(By.id("loginbutton")).click();
		Thread.sleep(1000);
		ab.accept();
		d.findElement(By.name("j_password")).sendKeys("1234");
		Thread.sleep(2000);
		
		
	}
}
	
