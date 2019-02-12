package klm;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MulWin {
	WebDriver d;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new FirefoxDriver();
		 //d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}

	@After
	
	public void teardown()
	{
		d.quit();
		
	}
	@Test
	public void alertDemo() throws Exception
	{
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		d.findElement(By.linkText("Flights")).click();
		
		 Set<String> h= d.getWindowHandles();
		 String h1 []=new String[h.size()]; 
		 int i=0;
		 System.out.println(h.size());
		 for (String k:h)
		 {
			 //System.out.println(k);
			 h1[i]=k;
			 i++; 
		 }
		 
		d.switchTo().window(h1[1]);
	assertTrue(d.findElement(By.id("origin")).isDisplayed());
	Thread.sleep(2000);
	d.close();
	d.switchTo().window(h1[0]);
	assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
	Thread.sleep(2000);
		
		
	}
	
	

}
