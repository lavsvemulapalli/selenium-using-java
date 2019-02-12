package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class SliderDemo extends Cmmon{
	
	
	
	@Test
	public void slider() throws Exception
	{
		d.get("http://jqueryui.com/slider/");
		assertEquals("Slider | jQuery UI", d.getTitle());
		Actions a=new Actions(d);
		d.switchTo().frame(0);
		a.dragAndDropBy(d.findElement(By.id("slider")), 0,0).perform();
		Thread.sleep(2000);
		
	}
	
	
	
	
}
