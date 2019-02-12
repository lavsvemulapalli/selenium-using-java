package klm;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxDemo1 {
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
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		selopt(d.findElement(By.id("selBank")),"Andhra Bank");
		selopt(d.findElement(By.id("selState")),"Andhra Pradesh");
		selopt(d.findElement(By.id("selCity")),"Hyderabad");
		selopt(d.findElement(By.id("selBranch")),"Banjara Hills");
		
		
		/*Select bank=new Select(d.findElement(By.id("selBank")));
		bank.selectByVisibleText("Andhra Bank");
		
		Select state=new Select(d.findElement(By.id("selState")));
		//WebDriverWait dd=new WebDriverWait(d,45);
		//dd.until(ExpectedConditions.elementToBeSelected(d.findElement(By.xpath("//option[@value='1']"))));
		state.selectByVisibleText("Andhra Pradesh");
		Select city=new Select(d.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		Select branch=new Select(d.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Banjara Hills");*/
		
		
		Thread.sleep(3000);
			
	}
	
	public void selopt(WebElement locator, String Option)
	{
		Select s=new Select(locator);
		s.selectByVisibleText(Option);
		
	}
	
	
	
	
	
}
