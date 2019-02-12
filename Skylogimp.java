package klm;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Skylogimp {

	WebDriver d;
	@Test
	public void testLogin()throws Exception
	{
		d.navigate().to("https://www.skygo.co.nz/");
		assertEquals("SKY GO",d.getTitle());
		d.findElement(By.xpath("//a[@class='signin']")).click();
		FileInputStream fsi=new FileInputStream("F:\\Testdata\\skylog.xls");
		Workbook wb=Workbook.getWorkbook(fsi);
		Sheet s=wb.getSheet(0);
		for(int i=1;i<s.getRows();i++)
		{
			//Enter user name
			d.findElement(By.xpath("//input[@id='email']")).clear();
			d.findElement(By.xpath("//input[@id='email']")).sendKeys(s.getCell(0, i).getContents());
			
			String uname=d.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
			//Enter password
			d.findElement(By.xpath("//input[@id='password']")).clear();
			d.findElement(By.xpath("//input[@id='password']")).sendKeys(s.getCell(1, i).getContents());
			String password=d.findElement(By.xpath("//input[@id='password']")).getAttribute("value");
			//Click on Submit
			d.findElement(By.xpath("//button[text()='Sign in']")).click();
			Thread.sleep(1000);
			
			//Blank user name & Blank password
			if(uname.equals("") && password.equals(""))
			{
				WebElement errortxt=d.findElement(By.xpath(("//*[@id='signinForm']/div[3]/p")));
				
				assertEquals("Please enter a valid email address and password.",errortxt.getText());
			}
			//Blank user name & Valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				WebElement errortxt=d.findElement(By.xpath(("//*[@id='signinForm']/div[3]/p")));
				
				assertEquals("Please enter a valid email address and password.",errortxt.getText());
			}
			//Blank password & valid/invalid username
			else if(!(uname.equals("")) && password.equals(""))
			{
				 WebElement errortxt=d.findElement(By.xpath(("//*[@id='signinForm']/div[3]/p")));
					
					assertEquals("Please enter a valid email address and password.",errortxt.getText());
					
					
			}
			//Valid user name & Valid password
			else if(isElementPresent(d,By.xpath("//a[@title='Sign In']")))
			{
				d.findElement(By.xpath("//a[@title='Sign In']")).click();
			}
			//Invalid user name & Invalid password
			else if(!(uname.equals("")) && (!(password.equals(""))))
			{
				 WebElement errortxt=d.findElement(By.xpath(("//*[@id='signinForm']/div[3]/p")));
					
					assertEquals("You have entered an invalid username or password..",errortxt.getText());
			}
		
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
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
	
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		//d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\New folder\\chromedriver.exe");
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
