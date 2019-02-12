package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingEle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		/*d.get("https://www.facebook.com/");
		d.findElement(By.xpath("//input[@id='email']")).clear();
		
		d.findElement(By.xpath("//input[@id='email']")).sendKeys("selenium");
		d.findElement(By.xpath("//input[@id='pass']")).clear();
		d.findElement(By.xpath("//input[@id='pass']")).sendKeys("selenium");
		d.findElement(By.xpath("//input[@value='Log In']")).click();
		System.out.println(" user name: " +d.findElement(By.xpath("//input[@id='email']")).getAttribute("value"));
		
		Thread.sleep(4000);
		d.quit();*/
		
		d.get("http://book.theautomatedtester.co.uk/chapter1");
		d.findElement(By.className("belowcenter")).clear();
		d.findElement(By.className("belowcenter")).sendKeys("lavanya\n bharath");
		//System.out.println("attribute value is: "+d.findElement(By.className("belowcenter")).getAttribute("value"));
		Thread.sleep(3000);
		WebElement checkbox=d.findElement(By.name("selected(1234)"));
		if(checkbox.isSelected())
		{
			System.out.println("check box selected");
		}
		else
		{
			checkbox.click();
		}
		
		WebElement radio=d.findElement(By.id("radiobutton"));
		if(radio.isSelected())
		{
			System.out.println("check box selected");
		}
		else
		{
			radio.click();
		}
		
	Thread.sleep(3000);
		/*d.findElement(By.name("selected(1234)")).click();
		System.out.println("status of check box: "  +d.findElement(By.name("selected(1234)")).isSelected());
		Thread.sleep(2000);
		d.findElement(By.name("selected(1234)")).click();
		System.out.println("status of check box: "   +d.findElement(By.name("selected(1234)")).isSelected());
		d.findElement(By.id("radiobutton")).click();
		System.out.println("status of radio button: "   +d.findElement(By.id("radiobutton")).isSelected());
		Thread.sleep(3000);
		d.findElement(By.linkText("Home Page")).click();
		Thread.sleep(3000);*/
		d.quit();
	}

}
