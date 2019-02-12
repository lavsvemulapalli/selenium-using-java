package klm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class LinkText1 extends Cmmon {
	
	
	@Test
	public void link1()
	{
		d.get("http://www.seleniumhq.org/");
		assertEquals("Selenium - Web Browser Automation", d.getTitle());
		List<WebElement> s =d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("no.of links:" +s.size());
		String[] k=new String[s.size()];
		int i=0;
		for(WebElement m:s)
		{
			//System.out.println("names of links:"  +m.getText());
			
			k[i]=m.getText();
			i++;		
		}
		
		for(String n:k)
		{
			d.findElement(By.linkText(n)).click();
			if(d.getTitle().contains("404")||d.getTitle().contains("500"))
			{
				System.out.println("link"    +n+     "link is not woking" );
				
			}
			else
			{
				System.out.println("link"    +n+     "link is woking" );
			}
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
