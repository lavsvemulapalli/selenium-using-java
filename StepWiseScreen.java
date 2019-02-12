package klm;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StepWiseScreen {
	
	WebDriver d;
	
	@Test
	public void banTest() throws Exception
	{
		d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India", d.getTitle());
		getScreen();
		Thread.sleep(1000);
		selectOption(d.findElement(By.id("selBank")),"Axis Bank");
		getScreen();
		Thread.sleep(1000);
		selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
		getScreen();
		Thread.sleep(1000);
		selectOption(d.findElement(By.id("selCity")),"Hyderabad");
		getScreen();
		Thread.sleep(1000);
		selectOption(d.findElement(By.id("selBranch")),"Madhapur");
		getScreen();
		Thread.sleep(4000);
		
		
	}



	public void selectOption(WebElement locator,String optionname)
	{

		Select city=new Select(locator);
		city.selectByVisibleText(optionname);
	}
	
	public void getScreen() throws Exception
	{
		DateFormat dmt=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		Date dt=new Date();
		File sh=((TakesScreenshot) d).getScreenshotAs(OutputType.FILE );
		FileUtils.copyFile(sh, new File ("F:\results" +dmt.format(dt)+ ".png" ));
		
				
	}


	@Before
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	@After
	public void tearDowm()
	{
	d.quit();
	}
	

	
	

}
