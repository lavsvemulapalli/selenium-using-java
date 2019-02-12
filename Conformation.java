package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Conformation {
	WebDriver d;
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 //d=new FirefoxDriver();
		 d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		 d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		 
	}
	
	
		@After
		public void tearDown()
		{
			d.quit();
			
		}
		@Test
		public void conformationTest() throws Exception
		{
			d.get("http://output.jsbin.com/enifaf");
			d.findElement(By.cssSelector("button")).click();
			Alert c=d.switchTo().alert();
		assertEquals("Press a button!", c.getText());
		Thread.sleep(1500);
		
		 c.dismiss();
	
		Thread.sleep(1500);
		d.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		c.accept();
		Thread.sleep(2000);
		}

}
