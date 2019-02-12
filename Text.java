package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("http://book.theautomatedtester.co.uk/chapter1");
		 WebElement a=d.findElement(By.id("divontheleft"));
		
		 
		System.out.println(a.getText());

	}

	
	}


