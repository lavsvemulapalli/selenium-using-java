package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frame1 {
	WebDriver d;

	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		//d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		d.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		
	}
	
	@After
	public void tearDown()
	{
		d.quit();
		
		
	}
	
	@Test
	public void frameDemo() throws Exception
	{
		d.get("http://jqueryui.com/autocomplete/");
		
		assertEquals("Autocomplete | jQuery UI", d.getTitle());
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		d.findElement(By.id("tags")).sendKeys("lavanya");
		Thread.sleep(3000);
		d.switchTo().defaultContent();
		d.findElement(By.linkText("Accordion")).click();
		//d.switchTo().frame(d.findElement(By.className("ui-accordion-header ui-corner-top ui-accordion-header-collapsed ui-corner-all ui-state-default ui-accordion-icons")));
		
		Thread.sleep(3000);
		
		
		
	}
	

}
