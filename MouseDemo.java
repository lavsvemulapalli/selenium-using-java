package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class MouseDemo {
	WebDriver d;
	
	@Test
	public void banTest() throws Exception
	{
		
		d.get("https://www.aptransport.in/tgcfstonline/");
		assertEquals("Welcome To TRANSPORT DEPARTMENT GOVERNMENT OF TELANGANA - INDIA", d.getTitle());
		Actions a=new Actions(d);
		/*a.moveToElement(d.findElement(By.linkText("EDUCATIONAL INSTITUTION"))).perform();
		Thread.sleep(2000);
		d.findElement(By.linkText("Educational Institution Login")).click();*/
		
		
a.moveToElement(d.findElement(By.linkText("EDUCATIONAL INSTITUTION"))).pause(2000).click(d.findElement(By.linkText("Registration Form"))).build().perform();
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


