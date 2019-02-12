



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

	public class DefectTestScreenshort {
		WebDriver d;
			
	@Test
	public void banTest() throws Exception
	{
		assertEquals("Pass",getScreenshort());
		Thread.sleep(4000);
	}
		
	



	public void selectOption(WebElement locator,String optionname)
	{

		Select city=new Select(locator);
		city.selectByVisibleText(optionname);


	}
	
	public String getScreenshort() throws Exception
	{
		
	
	try
	{
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India", d.getTitle());
		
		
	
		selectOption(d.findElement(By.id("selBank")),"Axis Bank");	
	
		selectOption(d.findElement(By.id("selState")),"Andhra Pradesh1");
	
		
		selectOption(d.findElement(By.id("selCity")),"Hyderabad");
		
		
		selectOption(d.findElement(By.id("selBranch")),"Madhapur");
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
		
	@Before
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
	}
	@After
	public void tearDowm()
	{
	d.quit();
	}
	}


