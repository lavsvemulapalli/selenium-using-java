package klm;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFrame {
	WebDriver d;
	@Before
	public void start()
	{
	System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	 d=new ChromeDriver();
	 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	 d.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);		
	}

	@After
	public void test()
	{
		d.quit();
		
	}
	@Test
	public void frameDemo() throws Exception
	{
		d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");	
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame(1);
		d.findElement(By.linkText("CommandProcessor")).click();
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame(2);
		d.findElement(By.linkText("HttpCommandProcessor")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
