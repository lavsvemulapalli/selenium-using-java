package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdScript {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		WebDriver d= new ChromeDriver();
		d.get("https://www.facebook.com/");
		d.findElement(By.id("email")).sendKeys("selenium");
d.findElement(By.id("pass")).sendKeys("test");
d.findElement(By.id("loginbutton")).click();
Thread.sleep(4000);
d.quit();
	}

}
