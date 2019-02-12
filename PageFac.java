package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFac {
	WebDriver d;
	@Test
	public void testLogin()throws Exception
	{
		d.get("http://env-4009812.cloud.cms500.com/do/admin/home");
		//assertEquals("SBI_Andhrapradesh",d.getTitle());
		ORDemo page1=new ORDemo(d);
		/*page1.uname.clear();
		page1.uname.sendKeys("admin");
		page1.pwd.clear();
		page1.pwd.sendKeys("1234");
		page1.submit.click();*/
		
		page1.login("admin", "1234");
		
		
		Thread.sleep(2000);
		page1.logout.click();
		//d.switchTo().alert().accept();
		page1.clickOk();
		
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		//d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
		d.manage().deleteAllCookies();
	}
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}


	
	

}
