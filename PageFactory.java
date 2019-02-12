package klm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class PageFactory  {
WebDriver d;
	
	
	@BeforeMethod
	
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
		 d=new ChromeDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);	
	}

	@AfterMethod
	public void TearDown()
	{
		d.quit();
	}
	
	@Test
	public void login() throws Exception
	{
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		ORDemo page=new ORDemo(d);
		/*page.uname.clear();
		page.uname.sendKeys("qttesters");
		page.pwd.clear();
		page.pwd.sendKeys("qttesters");
		page.submit.click();*/
		page.login("qttesters", "qttesters");
		
		Thread.sleep(2000);
		page.logout.click();
		//d.switchTo().alert().accept();
		page.clickOk();
		Thread.sleep(2000);
		
	}
	
	
}
