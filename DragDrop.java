package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDrop {
WebDriver d;
	
	@Test
	public void banTest() throws Exception
	{
		
		d.get("http://jqueryui.com/droppable/");
		assertEquals("Droppable | jQuery UI", d.getTitle());
		Actions a=new Actions(d);
		d.switchTo().frame(0);
		a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).perform();
		Thread.sleep(2000);
		
	}
	@BeforeMethod

	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown ()
	{
	d.quit();
	}
	}
	

