package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Enable {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		// TODO Auto-generated method stub
WebDriver d=new FirefoxDriver();
d.get("https://www.ifsccodebank.com/");
System.out.println("status of textbox:" +d.findElement(By.id("BC_ddlDistrict")).isEnabled());

	}

}
