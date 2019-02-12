package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchDemo {
	private static final Function ExpectedCondition = null;
	WebDriver d;

	
	@Before
	public void setUp()
	{
		 System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
			//d=new FirefoxDriver();
			d=new ChromeDriver();
			d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	@After
	public void tearDown() {
		d.quit();
	}
	
	@Test
	public void testSynch() throws Exception
	{
		d.get("https://www.google.co.in/");
		
		assertEquals("Google",d.getTitle());
		
	
		d.findElement(By.id("lst-ib")).sendKeys("selenium");
		WebDriverWait b=new WebDriverWait(d,45);
		b.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		d.findElement(By.name("btnK")).click();
		d.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		WebDriverWait a=new WebDriverWait(d,120);
		a.until(ExpectedConditions.elementToBeClickable(By.linkText("Projects")));
		d.findElement(By.linkText("Projects")).click();
		Thread.sleep(2000);
		
		
		
	}
	
	
	
}
