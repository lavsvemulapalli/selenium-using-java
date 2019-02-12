package klm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDemo {
	WebDriver d;

	@Before
	public void setUp()
	{
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void dropDown() throws Exception
	{
		d.get("https://www.facebook.com/");
		//System.out.println(d.getTitle());
		assertEquals("Facebook – log in or sign up" ,d.getTitle());
		d.findElement(By.id("u_0_g")).sendKeys("lavanaya");
		d.findElement(By.id("u_0_i")).sendKeys("vemula");
		d.findElement(By.id("u_0_l")).sendKeys("abc@gmai.com");
		d.findElement(By.id("u_0_s")).sendKeys("test");
		Select dd1= new Select(d.findElement(By.id("month")));
	//WebDriverWait a=new WebDriverWait(d,45);
	//a.until(ExpectedConditions.elementSelectionStateToBe(By.id("month"), selected))
		assertTrue(d.findElement(By.id("month")).isDisplayed());
		//dd1.selectByIndex(7);
		dd1.selectByValue("1");
		//dd1.selectByVisibleText("Apr");
		Thread.sleep(2000);
		System.out.println("selected value is" +dd1.getFirstSelectedOption().getText());
		
		assertEquals("Jan",dd1.getFirstSelectedOption().getText());
		Thread.sleep(2000);
	}
	
	@After
	public void tearDowm()
	{
		
		d.quit();
		
		
		
				

	}

}
