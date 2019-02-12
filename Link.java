package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Link {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("http://book.theautomatedtester.co.uk/chapter1");
		//d.findElement(By.linkText("Home Page")).click();
		d.findElement(By.partialLinkText(" Page")).click();
		Thread.sleep(2000);
		
		d.quit();
		

	}

}
