package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHistoryDemo {
WebDriver d;

	
	@BeforeMethod
	public void setUp()
	{
	
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	 d=new FirefoxDriver();
	 d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	 d.manage().deleteAllCookies();
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
	
	@Test
	public void test_Slider() throws InterruptedException
	{
		d.navigate().to("http://www.seleniumhq.org/");
		d.findElement(By.linkText("Download")).click();
		Thread.sleep(2000);
		d.navigate().back();
		Thread.sleep(2000);
		d.navigate().forward();
		Thread.sleep(2000);
		d.navigate().refresh();
		Thread.sleep(2000);	
		
		
		
	}

}
