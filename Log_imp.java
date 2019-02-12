package klm;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import jxl.Sheet;
import jxl.Workbook;

public class Log_imp {
	WebDriver d;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		 d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
		 d.manage().deleteAllCookies();
		
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	@Test
	public void logImport() throws Exception
	{
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		FileInputStream fsi=new FileInputStream("F:\\Testdata\\login.xls");
		Workbook wb=Workbook.getWorkbook(fsi);
		Sheet s=wb.getSheet(0);
		for(int i=1;i<s.getRows();i++)
		{
			d.findElement(By.id("cyclosUsername")).clear();
			d.findElement(By.id("cyclosUsername")).sendKeys(s.getCell(0, i).getContents());
			String uid=d.findElement(By.id("cyclosUsername")).getAttribute("value");
			d.findElement(By.id("cyclosPassword")).clear();
			d.findElement(By.id("cyclosPassword")).sendKeys(s.getCell(1, i).getContents());
			String pwd=d.findElement(By.id("cyclosPassword")).getAttribute("value");
			d.findElement(By.className("button")).click();
			if(uid.equals("")   &&  pwd.equals(""))
			{
				Alert a1=d.switchTo().alert();
				assertEquals("Login name is required\nPassword is required\n" , a1.getText());
				a1.accept();
			}
			
			else if(!(uid.equals(""))   &&  pwd.equals(""))
			{
				Alert a1=d.switchTo().alert();
				assertEquals("Password is required\n" , a1.getText());
				a1.accept();
			}
			
			
			else if(uid.equals("")   &&  !(pwd.equals("")))
			{
				Alert a1=d.switchTo().alert();
				assertEquals("Login name is required\n" , a1.getText());
				a1.accept();
			}
			
			/*else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
			{
				d.findElement(By.xpath("//span[text()='Logout']"));
				d.switchTo().alert().accept();
				
				
			}
			
			else if(isElementPresent(d,By.id("btn")))
			{
				d.findElement(By.id("btn")).click();
			}
			*/
			
			
			
			else if(d.findElement(By.id("btn")).isDisplayed())
			{
				d.findElement(By.id("btn")).click();
			
		}
			else if(d.findElement(By.xpath("//span[text()='Logout']")).isDisplayed())
			{
				d.findElement(By.xpath("//span[text()='Logout']"));
				d.switchTo().alert().accept();
			}
			Thread.sleep(2000);
		}
	
	Thread.sleep(2000);
	}
			
	
	
		private boolean isElementPresent(WebDriver driver,By by) 
		{
		    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			try 
		    {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

