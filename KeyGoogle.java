package klm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyGoogle {
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
		d.get("https://www.google.co.in/");
		assertEquals("Google", d.getTitle());
		d.findElement(By.id("lst-ib")).sendKeys("amazon");
		List<WebElement> n=d.findElements(By.className("sbqs_c"));
		System.out.println("no.of suggestion:" +n.size());
		for(WebElement s:n)
		{
			//System.out.println(s.getText());
			d.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
			if(s.getText().equals("amazon transportation services"))
			{
				d.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
				break;
			}
		Thread.sleep(1000);
		
		}
		Thread.sleep(2000);
}
}