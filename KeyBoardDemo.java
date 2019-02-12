package klm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyBoardDemo {
WebDriver d;

	
	@BeforeMethod
	public void setUp()
	{
	
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	 d=new FirefoxDriver();
	 d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
	
	@Test
	public void test_Slider() throws InterruptedException
	{
		d.get("http://jqueryui.com/autocomplete/");
		d.switchTo().frame(0);
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		
		System.out.println("no.of suggestions is "+s.size());
		for(WebElement e:s)
		{
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			//System.out.println(e.getText());
			if(e.getText().equals("Haskell"))
			{
			
				
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				
				break;
			}
			
			Thread.sleep(2000);
			
			
		}
		assertEquals("Haskell",d.findElement(By.id("tags")).getAttribute("value"));
		Thread.sleep(3000);
		
		
		
		
		
		
		
		
	}	

}
