package klm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkDemo extends Common {
	

@Test
public void webTable()
{
d.get("http://www.seleniumhq.org/");  
List<WebElement> m=d.findElements(By.xpath("//li[starts-with(@id, 'menu')]"));
System.out.println("no.of links" +m.size());
String[] s=new String[m.size()];
int i=0;
for(WebElement k:m)
{
s[i]=k.getText();
i++;
	//System.out.println("name of links:"+s[i]);
}
for(String n:s)
{
	d.findElement(By.linkText(n)).click();
	if(d.getTitle().contains("404")||d.getTitle().contains("500"))
	{
		System.out.println("Link:"+s+" :is not working");
	}
	else
	{
		System.out.println("Link:"+s+" :is  working");
	}
}


}

}
