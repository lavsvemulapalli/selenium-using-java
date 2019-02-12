package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHis1 {
	WebDriver d;
	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);		
		 d.manage().deleteAllCookies();
	}

@AfterMethod
public void tearDown()
{
	d.quit();
	
}

@Test
public void webTable() throws Exception
{
d.navigate().to("http://www.seleniumhq.org/");	
assertEquals("Selenium - Web Browser Automation", d.getTitle());
d.findElement(By.linkText("Documentation")).click();
d.navigate().forward();
Thread.sleep(2000);
d.navigate().back();
Thread.sleep(2000);
d.navigate().refresh();
Thread.sleep(2000);
d.navigate().forward();
Thread.sleep(2000);

}
}