package klm;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frame {
	WebDriver d;
	
	@Before
	public void setUp()
	{
	
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");

	d=new FirefoxDriver();
	}
 @Test
 public void testSetUp() throws Exception
 {
 d.get("https://www.facebook.com/");
 //System.out.println(d.getTitle());
 assertEquals("Facebook – log in or sign up", d.getTitle());
 d.findElement(By.id("email")).sendKeys("admin");
 d.findElement(By.id("pass")).sendKeys("test");
 d.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
 Thread.sleep(2000);
 }
@After
public void tearDown()
{
d.quit();
}

 

	}	
	
	

