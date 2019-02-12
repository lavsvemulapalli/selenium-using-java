package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Keys2 {
	WebDriver d;

	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void meth1()
	{
	d.quit();
	}


	@Test
	public void testKey() throws Exception
	{
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI", d.getTitle());
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		d.findElement(By.id("tags")).sendKeys("a");
		a.sendKeys(d.findElement(By.id("tags"))).keyUp("Asp").build().perform();
		Thread.sleep(2000);
		
		
		
}
}