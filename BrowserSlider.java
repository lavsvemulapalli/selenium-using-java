package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSlider {
	
	
WebDriver d;

	
	@BeforeMethod
	public void setUp()
	{
	
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	 d=new FirefoxDriver();
	 d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
	
	@Test
	public void test_Slider() throws InterruptedException
	{
		d.get("http://www.seleniumhq.org/download/");
		
		
		for(int i=0;i<10;i++)
		{
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
		}
			
		
		           
	}

}
