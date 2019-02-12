package klm;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertDemo1 {
	
	WebDriver d;
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new FirefoxDriver();
		//d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 //d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@After
	public void tearDown()
	{
		d.quit();
	}
	
	@Test
	public void test_alert() throws Exception
	{
		d.get("https://www.irctc.co.in/eticketing/pageUnderConstruction.jsf");
		d.findElement(By.id("loginbutton")).click();
		Alert al=d.switchTo().alert();
		assertEquals("Enter User ID", al.getText());
		al.accept();
		Thread.sleep(4000);
		d.findElement(By.id("usernameId")).sendKeys("lavanya");
		d.findElement(By.id("loginbutton")).click();
		Thread.sleep(4000);
		assertEquals("Enter Password", al.getText());
		al.accept();
		d.findElement(By.className("loginPassword")).sendKeys("lavanya");
		Thread.sleep(4000);

		
		
	}
	
	
	
	
	
}
