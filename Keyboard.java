package klm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Keyboard {
	WebDriver d;
	

	@BeforeMethod
	public void abc()
	{
		System.setProperty("webdriver.chrome.driver","F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void kbv()
	{
		d.quit();
	}
	@Test
	public void browser() throws Exception
	{
		d.get("http://jqueryui.com/autocomplete/");
		d.switchTo().frame(0);
		d.findElement(By.id("tags")).sendKeys("b");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("no. of suggesions:" +s.size());
		for(WebElement k:s)
		{
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			//System.out.println(k.getText());
			if (k.getText().equals("COBOL"))
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				break;
				
			}
			Thread.sleep(4000);
		}
}
}
