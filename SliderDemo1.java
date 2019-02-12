package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class SliderDemo1 {
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
		d.get("http://jqueryui.com/slider/");
		Actions a=new Actions(d);
		d.switchTo().frame(0);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")), 300, 0).perform();
		Thread.sleep(5000);
			
		
		
	}
	
	
	
	
}
