package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BrowserDemo extends Common {
	
	
	
	@Test
	public void browser() throws Exception
	{
		d.get("http://www.seleniumhq.org/download/");
		Actions a=new Actions(d);
		assertEquals("Downloads", d.getTitle());
		for(int i=0;i<10;i++)
		{
			((RemoteWebDriver)d).executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
		}
		
	}
	
	
}
