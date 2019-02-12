package klm;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DDemo {
	WebDriver d;

	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		// TODO Auto-generated method stub
		 d=new FirefoxDriver(); 
	}
	@Test
	public void test_Fb() throws Exception
	{
		
		assertEquals("pass", screenshot());
		Thread.sleep(4000);
	}
	public String screenshot() throws Exception

	{
		
		try
	
	{
		d.get("https://www.facebook.com/");
		Select dd=new Select(d.findElement(By.id("month")));
		dd.selectByIndex(11);
		Select dd1=new Select(d.findElement(By.id("day")));
		dd1.selectByVisibleText("10");
	
		Select dd2=new Select(d.findElement(By.id("year")));
		dd2.selectByValue("19895");
		
	System.out.println(dd.getFirstSelectedOption().getText());	
	return "pass";
	}
	
	
	catch(Exception e)
	{
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		DateFormat d1= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		Date dt=new Date();
		FileUtils.copyFile(screenshotFile, new File ("F:\\results\\"+d1.format(dt)+".jpg"));
		return "fail";
	}
	}
	
		
		
	@After
	public void tearDown()
	{	
		
		d.quit();
		
	}
	

}
