package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class Cmmon {
	
	WebDriver d;
	@Parameters("browser")
	@BeforeMethod
	public void SetUp(String bt)
	
	{
		if(bt.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		    d= new ChromeDriver();
		    
		}
		else if (bt.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
			d=new FirefoxDriver();
		}
		else if (bt.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Driver Server\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDowm()
	{
	d.quit();
	}
	}



