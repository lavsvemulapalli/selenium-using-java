package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextArea {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("http://book.theautomatedtester.co.uk/chapter1");
		d.findElement(By.className("belowcenter")).clear();
		Thread.sleep(2000);
		d.findElement(By.className("belowcenter")).sendKeys("lavanya\nbharath\njavvaji");
		Thread.sleep(2000);
		d.findElement(By.className("belowcenter")).clear();
		Thread.sleep(2000);
		d.findElement(By.className("belowcenter")).sendKeys("loves\nkumar\nvemula");

		System.out.println("attribute name is:" +d.findElement(By.className("belowcenter")).getAttribute("value") );
		Thread.sleep(2000);
		d.quit();
	}
	

}
