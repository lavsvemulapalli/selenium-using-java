package klm;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShort {
	
WebDriver d;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new FirefoxDriver();
		 //d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}

	@After
	
	public void teardown()
	{
		d.quit();
		
	}
	@Test
	public void alertDemo() throws Exception
	{
		d.get("https://www.google.co.in/");
		d.findElement(By.linkText("Gmail")).click();
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		DateFormat d1= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		Date dt=new Date();
		FileUtils.copyFile(screenshotFile, new File ("F:\\results\\"+d1.format(dt)+".jpg"));
		
		//FileUtils.copyFile(screenshotFile, new File("F:\\results\\loves.jpg"));
		
		Thread.sleep(2000);
		
	
	}
}
