package klm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class KeyEvents {
	WebDriver d;

@BeforeMethod
public void SetUp()
{
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	 d=new FirefoxDriver();
	 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	 d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	
}
@AfterMethod
public void meth1()
{
d.quit();
}


@Test
public void testKey() throws Exception
{
	d.get("http://jqueryui.com/autocomplete/");
	assertEquals("Autocomplete | jQuery UI", d.getTitle());
	d.switchTo().frame(0);
	
	d.findElement(By.id("tags")).sendKeys("a");
	List<WebElement> k=d.findElements(By.className("ui-menu-item"));
	System.out.println("no.of suggestions:" +k.size());
	Thread.sleep(2000);
	for(WebElement m:k)
	{
		//System.out.println(m.getText());
		d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
		if(m.getText().equals("Asp"))
		{
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
			break;
		}
		Thread.sleep(4000);
	}
	Thread.sleep(4000);
	
}





}
