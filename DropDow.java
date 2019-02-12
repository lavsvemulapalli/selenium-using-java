package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDow {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		// TODO Auto-generated method stub
		WebDriver d=new FirefoxDriver();
		d.get("http://book.theautomatedtester.co.uk/chapter1");
	Select ab=new Select(d.findElement(By.id("selecttype")));
	//ab.selectByIndex(1);
	//ab.selectByValue("Selenium RC");
	ab.selectByVisibleText("Selenium Grid");
	Thread.sleep(2000);
	System.out.println("selected element" +  ab.getFirstSelectedOption().getText());
		

	}

}
