package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		// TODO Auto-generated method stub
WebDriver d=new FirefoxDriver();
d.get("http://book.theautomatedtester.co.uk/chapter1");
d.findElement(By.id("radiobutton")).click();
Thread.sleep(2000);
System.out.println("status of radiobutton" +d.findElement(By.id("radiobutton")).isSelected());

d.quit();

	}

}
