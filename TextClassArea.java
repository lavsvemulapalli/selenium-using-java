package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextClassArea {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
         WebDriver d=new FirefoxDriver();
         d.get("http://book.theautomatedtester.co.uk/");
         d.findElement(By.id("q")).sendKeys("lavanya");
       Thread.sleep(2000);
       d.findElement(By.id("q")).clear();
       Thread.sleep(2000);
        d.findElement(By.id("q")).sendKeys("lavanya");  
        System.out.println("attribute name is"+ d.findElement(By.id("q")).getAttribute("value"));
        Thread.sleep(2000);
        d.quit();
	}

}
