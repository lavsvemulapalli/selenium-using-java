package klm;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.*;

public class DragDropDemo {
	
	WebDriver d;

	@BeforeMethod
	public void setUp()
	{
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		//d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown ()
	{
	d.quit();
	}
	
@Test
public void banTest() throws Exception
{
	
	d.get("http://jqueryui.com/droppable/");
	Actions a =new Actions(d);
	d.switchTo().frame(0);
	a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).perform();
	Thread.sleep(3000);

}
}
