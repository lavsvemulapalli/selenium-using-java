package klm;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Google1 {

	
WebDriver d;
	
	
	@BeforeMethod
	
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
	}

	@AfterMethod
	public void TearDown()
	{
		d.quit();
	}
	@Test
	public void login() throws Exception
	{
	d.get("https://www.google.co.nz");
	FileInputStream fis=new FileInputStream("F:\\Testdata\\google1.xls");
	Workbook wb=Workbook.getWorkbook(fis);
	Sheet s=wb.getSheet(0);
	for(int i=0;i<s.getRows();i++)
	{
		d.findElement(By.id("lst-ib")).clear();
		d.findElement(By.id("lst-ib")).sendKeys(s.getCell(0, i).getContents());
		Thread.sleep(1000);
	}
	Thread.sleep(1000);
	
	
	}
	
}
