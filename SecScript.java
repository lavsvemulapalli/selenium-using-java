package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SecScript {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","F:\\Driver Server\\geckodriver.exe");
         WebDriver d= new FirefoxDriver();
         d.get("https://www.facebook.com/");
         d.findElement(By.id("email")).sendKeys("lavanya");
         d.findElement(By.id("pass")).sendKeys("test");
         d.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
         Thread.sleep(4000);
         d.quit();
         
         

	}

}
