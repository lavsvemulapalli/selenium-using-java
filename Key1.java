package klm;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Key1 {
	WebDriver d;
	@Test
	public void testAutocomplete() throws Exception
	{
		// Load web page
		d.get("http://jqueryui.com/autocomplete/");
		// Verify page title
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		//type text
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions:"+s.size());
		for(WebElement e:s)
		{
			//System.out.println(e.getText());
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			if(e.getText().equals("Asp")) 
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(1000);
		}
		Thread.sleep(4000);
	}
	
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\chromedriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","F:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}

}
