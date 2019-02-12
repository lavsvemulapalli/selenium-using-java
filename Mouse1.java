package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mouse1 {
WebDriver d;
	
	@Test
	public void banTest() throws Exception
	{
		
		d.get("https://www.aptransport.in/tgcfstonline/");
		assertEquals("Welcome To TRANSPORT DEPARTMENT GOVERNMENT OF TELANGANA - INDIA", d.getTitle());
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.linkText("DEALER"))).pause(2000).click(d.findElement(By.linkText("Receipt Reprint/MakePayment"))).build().perform();
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown ()
	{
	d.quit();
	}
	}


