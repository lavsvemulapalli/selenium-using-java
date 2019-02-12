package klm;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Login_Status {

	WebDriver d;
	@Test
	public void testLogin()throws Exception
	{
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		FileInputStream fis=new FileInputStream("F:\\Testdata\\login.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet s=wb.getSheet(0);
		FileOutputStream fos=new FileOutputStream("F:\\results\\login_status.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("result", 0);
		for(int i=0; i<s.getRows();i++)
		{
			for(int j=0;j<s.getColumns();j++)
			{
				Label l=new Label(j,i,s.getCell(j, i).getContents());
				ws.addCell(l);
			}
		}
			
		for(int i=1;i<s.getRows();i++)
		{
			d.findElement(By.id("cyclosUsername")).clear();
			d.findElement(By.id("cyclosUsername")).sendKeys(s.getCell(0, i).getContents());
			
			String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
			//Enter password
			d.findElement(By.id("cyclosPassword")).clear();
			d.findElement(By.id("cyclosPassword")).sendKeys(s.getCell(1, i).getContents());
			String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
			//Click on Submit
			d.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(1000);
			
			//Blank user name & Blank password
			if(uname.equals("") && password.equals(""))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\nPassword is required\n",al.getText());
				al.accept();
				Label l=new Label(2,i,"fail");
				ws.addCell(l);
				
			}
			//Blank user name & Valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\n",al.getText());
				al.accept();
				Label l=new Label(2,i,"fail");
				ws.addCell(l);
			}
			//Blank password & valid/invalid username
			else if(!(uname.equals("")) && password.equals(""))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Password is required\n",al.getText());
				al.accept();
				Label l=new Label(2,i,"fail");
				ws.addCell(l);
			}
			//Valid user name & Valid password
			else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
			{
				d.findElement(By.xpath("//span[text()='Logout']")).click();
				//ok
				d.switchTo().alert().accept();
				Label l=new Label(2,i,"pass");
				ws.addCell(l);
			}
			//Invalid user name & Invalid password
			else if(isElementPresent(d,By.id("btn")))
			{
				d.findElement(By.id("btn")).click();
				Label l=new Label(2,i,"fail");
				ws.addCell(l);
			}
		
		}
			wwb.write();
			wwb.close();
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
	
	








