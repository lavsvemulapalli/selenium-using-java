package klm;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Google_import {
	
		WebDriver d;
		@Test
		public void testLogin()throws Exception
		{
			d.get("https://www.google.co.in");
			assertEquals("Google",d.getTitle());
			FileInputStream fis=new FileInputStream("F:\\Testdata\\google.xls");
			Workbook wb=Workbook.getWorkbook(fis);
			Sheet s=wb.getSheet(0);
			for(int i=0;i<s.getRows();i++)
			{
			d.findElement(By.id("lst-ib")).clear();
			d.findElement(By.id("lst-ib")).sendKeys(s.getCell(0, i).getContents());
			Thread.sleep(2000);
			
			}
			
			
	
		}

	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
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



