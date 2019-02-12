package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("https://www.facebook.com/");
		
		
		d.findElement(By.name("websubmit")).click();
		d.quit();
		
		

	}

}
