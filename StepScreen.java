package klm;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StepScreen {
	WebDriver d;
		
@Test
public void banTest() throws Exception
{
	d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
	d.get("http://www.veethi.com/places/");
	getScreenshort();
	//assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India", d.getTitle());
	
	
	getScreenshort();
	selectOption(d.findElement(By.id("state")),"Andhra Pradesh");
	getScreenshort();
	Thread.sleep(1000);
	selectOption(d.findElement(By.id("district_id")),"Anantapur");
	getScreenshort();
	Thread.sleep(1000);
	selectOption(d.findElement(By.id("list_city")),"Abbedoddi");
	getScreenshort();
	//Thread.sleep(1000);
	//selectOption(d.findElement(By.id("selBranch")),"Madhapur");
	//getScreenshort();
	
	Thread.sleep(4000);
	
	
}



public void selectOption(WebElement locator,String optionname)
{

	Select city=new Select(locator);
	city.selectByVisibleText(optionname);


}

public void getScreenshort() throws Exception
{
	File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
	DateFormat d1= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
	Date dt=new Date();
	FileUtils.copyFile(screenshotFile, new File ("F:\\results\\"+d1.format(dt)+".jpg"));
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
