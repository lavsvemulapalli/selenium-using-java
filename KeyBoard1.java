package klm;

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

public class KeyBoard1 {
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
		Actions a=new Actions(d);
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		
		System.out.println("no.of suggestions is "+s.size());
		for(WebElement e:s)
		{
			
			a.sendKeys(d.findElement(By.id("tags")), Keys.ARROW_DOWN).perform();
			//System.out.println(e.getText());
			if(e.getText().equals("Haskell"))
			{
			
			
				a.sendKeys(d.findElement(By.id("tags")), Keys.ENTER).perform();
				
				break;
			}
			
			Thread.sleep(2000);
			
			
		}
		Thread.sleep(3000);
		
		
		
		
		
		
		
		
	}	
}
