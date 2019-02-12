package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker {

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
	public void testdate() throws Exception
	{
		d.get("https://www.tripadvisor.co.nz/CheapFlightsHome");
		d.findElement(By.xpath("//div[@id='rt_ui_picker']/span/span[2]/span")).click();
		
	}
}
