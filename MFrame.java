package klm;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MFrame {
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
		System.out.println("num of frames in page " +d.findElements(By.tagName("frame")).size());
		d.switchTo().frame(0);
		d.findElement(By.linkText("org.openqa.selenium")).click();
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame(1);
		d.findElement(By.linkText("Alert")).click();
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame(2);
		d.findElement(By.linkText("accept")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
		
	}
}
