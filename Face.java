package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Face {
	WebDriver d;
	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	    d= new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		// d=new FirefoxDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);		
		 d.manage().deleteAllCookies();
	}

@AfterMethod
public void tearDown()
{
	//d.quit();
	
}
@Test
public void webTable() throws Exception
{
d.get("https://www.facebook.com/");	
d.findElement(By.id("email")).sendKeys("javji.bh@gmail.com");
d.findElement(By.id("pass")).sendKeys("1233@ghj");
d.findElement(By.cssSelector("input[value='Log In']")).click();

//


	
	
}	
	
}
