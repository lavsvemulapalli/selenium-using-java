package klm;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDrop {
	WebDriver d;
@Before
public void setUp()
{
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
 d=new FirefoxDriver();

}

		@Test
		public void testAbc() throws Exception
		{
		
		
		d.get("file:///C:/Users/Lavanya/Desktop/asd.html");
		Select a=new Select(d.findElement(By.id("abc")));
		for (int i=0;i<4;i++)
		{
			a.selectByIndex(i);
		
		
		}
		Thread.sleep(2000);
		a.deselectAll();
		Thread.sleep(2000);
		a.selectByIndex(0);
		a.selectByValue("audi");
		a.selectByVisibleText("Opel");
		Thread.sleep(2000);
		a.deselectByValue("audi");
		Thread.sleep(2000);
		}
		@After
		public void tearDown()
		{
		d.quit();
	

	}

}
