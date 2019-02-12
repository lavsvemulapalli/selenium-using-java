package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
	WebDriver d;
	@Parameters("browse1")
	@BeforeMethod
	public void SetUp(String b)
	{
		if(b.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		    d= new ChromeDriver();
		}
		else if(b.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
			 d=new FirefoxDriver();
		}
		else if(b.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Driver Server\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		
		 d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);		
	}

@AfterMethod
public void tearDown()
{
	d.quit();
	
}
}
