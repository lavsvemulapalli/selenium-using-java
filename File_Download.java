package klm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class File_Download   {
	WebDriver d;
	@BeforeMethod
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	    d= new ChromeDriver();	
	}
	@Test
	public void test_Down() throws IOException
	{
		d.get("http://www.seleniumhq.org/download/");
		d.findElement(By.linkText("3.8.1")).click();
		new ProcessBuilder("F:\\results\\source.exe").start();
	}
	@AfterMethod
	public void tearDown()
	{
	//d.quit();	
	}
			
	
}
