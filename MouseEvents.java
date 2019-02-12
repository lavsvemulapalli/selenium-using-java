package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class MouseEvents {
WebDriver d;
	
	@Test
	public void banTest() throws Exception
	{
		
		d.get("https://www.aptransport.in/tgcfstonline/");
		//assertEquals("Welcome To TRANSPORT DEPARTMENT GOVERNMENT OF TELANGANA - INDIA", d.getTitle());
		Actions a=new Actions(d);
		/*a.moveToElement(d.findElement(By.linkText("DEALER"))).perform();
		Thread.sleep(2000);
	
		d.findElement(By.linkText("Receipt Reprint/MakePayment")).click();*/
		a.moveToElement(d.findElement(By.linkText("DEALER"))).pause(1000).click(d.findElement(By.linkText("Dealer New Registration"))).build().perform();
		Thread.sleep(4000);
		
	}
		
	@BeforeMethod
	public void meth1()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void meth2 ()
	{
	d.quit();
	}
	}


