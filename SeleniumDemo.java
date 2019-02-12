package klm;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemo {
	
	WebDriver d;
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
 @After
 public void tearDown()
 {
	 d.quit();
 }
 
 @Test
 public void testsynch() throws Exception
 {
	 d.get("https://www.google.co.nz/");
	 d.findElement(By.id("lst-ib")).sendKeys("selenium");
	 d.findElement(By.xpath("//input[@value='Google Search']")).click();
	 d.findElement(By.linkText("Selenium - Web Browser Automation")).click();
	 WebDriverWait b= new WebDriverWait(d,120);
	 b.until(ExpectedConditions.elementToBeClickable( d.findElement(By.linkText("Projects"))));
	 d.findElement(By.linkText("Projects")).click();
	 Thread.sleep(3000);
 }
 
 
 
 
}
