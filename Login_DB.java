package klm;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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



public class Login_DB {
	WebDriver d;
	@Test
	public void testLogin()throws Exception
	{
		Connection conn=null;
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		assertEquals("SBI_Andhrapradesh",d.getTitle());
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","lavanya");
		 Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from login;");
			//Enter user name
		 while(rs.next())
         {
			 String username = rs.getString("UserName");
				String pwd = rs.getString("Password");
			d.findElement(By.id("cyclosUsername")).clear();
			d.findElement(By.id("cyclosUsername")).sendKeys(username);
			
			String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
			//Enter password
			d.findElement(By.id("cyclosPassword")).clear();
			d.findElement(By.id("cyclosPassword")).sendKeys(pwd);
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
				String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"' and Password='"+pwd+"';";
				PreparedStatement st1=con.prepareStatement(sql1);
				st1.executeUpdate();
			}
			//Blank user name & Valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\n",al.getText());
				al.accept();
				String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
				PreparedStatement st1=con.prepareStatement(sql1);
				st1.executeUpdate();
			}
			//Blank password & valid/invalid username
			else if(!(uname.equals("")) && password.equals(""))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Password is required\n",al.getText());
				al.accept();
				String sql1="UPDATE Login SET STATUS='Fail' WHERE Password='"+pwd+"';";
				PreparedStatement st1=con.prepareStatement(sql1);
				st1.executeUpdate();
			}
			//Valid user name & Valid password
			else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
			{
				d.findElement(By.xpath("//span[text()='Logout']")).click();
				//ok
				d.switchTo().alert().accept();
				String sql1="UPDATE Login SET STATUS='Pass' WHERE UserName='"+username+"'and Password='"+pwd+"';";
				PreparedStatement st1=con.prepareStatement(sql1);
				st1.executeUpdate();
			}
			//Invalid user name & Invalid password
			else if(isElementPresent(d,By.id("btn")))
			{
				d.findElement(By.id("btn")).click();
				String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"'and Password='"+pwd+"';";
				PreparedStatement st1=con.prepareStatement(sql1);
				st1.executeUpdate();
			}
		
			Thread.sleep(4000);
		}
		 stmt.close();
			con.close();
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
