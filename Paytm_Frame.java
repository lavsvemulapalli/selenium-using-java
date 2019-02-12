package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Paytm_Frame {
	WebDriver d;
	@Before
	public void start()
	{
	System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	 System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	 //d=new ChromeDriver();
	 d = new FirefoxDriver();
	 d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);		
	}

	@After
	public void test()
	{
		d.quit();
		
	}
	@Test
	public void frameDemo() throws Exception
	{
		d.get("https://paytm.com/");	
		assertEquals("Paytm.com – Digital & Utility Payment, Entertainment, Travel, Payment Gateway & more Online !", d.getTitle());
	    d.findElement(By.xpath("//div[3]/div[3]/div")).click();
		
		d.findElement(By.cssSelector("div._3ac-")).click();
		//System.out.println("No of Frames:"+d.findElements(By.tagName("frame")).size());
		//System.out.println("No of Frames:"+d.findElements(By.tagName("iframe")).size());
		d.switchTo().frame(0);
		d.findElement(By.id("input_0")).sendKeys("lllll");
		d.findElement(By.id("input_1")).sendKeys("kkkk");
		Thread.sleep(2000);
		//d.findElement(By.linkText("X")).click();
		
		
		//d.switchTo().frame(1);
		//d.switchTo().defaultContent();
		d.findElement(By.linkText("Sign Up")).click();
		d.findElement(By.className("ng-pristine ng-untouched md-input ng-invalid ng-invalid-required ng-valid-maxlength ng-valid-mobile-valid")).sendKeys("99hgf");
		//d.switchTo().defaultContent();
		//d.findElement(By.linkText("Proceed to Recharge")).click();
		
		Thread.sleep(3000);
		
	}
	
	
	
	
	
	
}
