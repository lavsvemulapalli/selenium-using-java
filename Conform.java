package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conform {
WebDriver d;
	
	@Before
	public void setUp()

	{
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@After
	public void tearDown()
	{
		d.quit();
	}
	
	@Test
	public void testAjax() throws Exception
	{
		d.get("http://output.jsbin.com/enifaf");
		d.findElement(By.xpath("//button[@onclick='launchConfirm()']")).click();
		Alert al=d.switchTo().alert();
		assertEquals("Press a button!", al.getText());
		al.dismiss();
		Thread.sleep(2000);
		d.findElement(By.xpath("//button[@onclick='launchConfirm()']")).click();
		al.accept();
		
		Thread.sleep(2000);
		
		
		
}
}