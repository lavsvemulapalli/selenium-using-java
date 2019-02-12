package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("http://www.seleniumhq.org/");
		d.findElement(By.xpath("//div[@id='sidebar']/img"));
		System.out.println("status of image" +d.findElement(By.xpath("//div[@id='sidebar']/img")).isDisplayed());
		d.quit();

	}

}
