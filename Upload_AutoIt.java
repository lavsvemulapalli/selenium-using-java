
	
	package klm;

	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Upload_AutoIt   {
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
			d.get("https://www.sendspace.com/");
			d.findElement(By.id("upload_file")).click();
			new ProcessBuilder("F:\\results\\lll.exe").start();
		}
		@AfterMethod
		public void tearDown()
		{
		//d.quit();	
		}
				
		
	}


