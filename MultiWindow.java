package klm;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindow {
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
		assertEquals("IRCTC Next Generation eTicketing System", d.getTitle());
		d.findElement(By.linkText("Flights")).click();
		Set<java.lang.String> h= d.getWindowHandles();
		String handle []=new String[h.size()];
		int i=0;
		
		System.out.println("no of handles:" +h.size());
		for(String s:h)
		{
		handle[i]=s;
		i++;
			//System.out.println(s);
			
		}
		
Thread.sleep(4000);
d.switchTo().window(handle[1]);
assertTrue(d.findElement(By.id("origin")).isDisplayed());

Thread.sleep(2000);

d.switchTo().window(handle[0]);
assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
Thread.sleep(2000);


}

}
