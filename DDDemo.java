
package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DDDemo {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver","F:\\Driver Server\\chromedriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("https://www.facebook.com/");
		Select a=new Select(d.findElement(By.id("day")));
		//a.selectByIndex(5);
		//a.selectByValue("10");
		a.selectByVisibleText("30");
		Thread.sleep(2000);
		System.out.println("selected value is" +a.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		d.quit();
		
		
}
}