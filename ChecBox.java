package klm;
import java.io.File;
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

public class ChecBox {
	WebDriver d;

	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
	}
	@Test
	public void testSetUp() throws Exception
	
	{
		
		try
		{
			d.get("http://book.theautomatedtester.co.uk/chapter1");
			d.findElement(By.name("selected(12345tty)")).click();
			Thread.sleep(2000);
			d.findElement(By.name("selected(12345)")).click();
			Thread.sleep(2000);
			d.findElement(By.name("selected(12345)")).click();
			System.out.println("check box satus" +d.findElement(By.name("selected(1234)")).isSelected());		
		}
		
		
		catch(Exception e)
		{
			DateFormat Dmt =new SimpleDateFormat("dd-mm-yy hh-mm-ss");
			Date dt=new Date();
			File sc=((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sc, new File("F:\\results" +Dmt.format(dt)+ ".jpg"));
			
		}
		
		
Thread.sleep(2000);
	}
	@After
	public void tearDown()
	{
d.quit();

	}

}
