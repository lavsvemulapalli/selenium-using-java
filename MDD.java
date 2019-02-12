package klm;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MDD {
	WebDriver d;

	@Before
	public void setUp()

	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
	}
	
	
	
	// TODO Auto-generated method stub
	
	@Test
	public void testMd() throws Exception
	{
		d.get("file:///C:/Users/Lavanya/Desktop/mdd.html");
		Select Md= new Select(d.findElement(By.id("abc")));
		System.out.println(Md.isMultiple());    
		Md.selectByVisibleText("Volvo");
		Md.selectByIndex(1);
		Md.selectByValue("audi");

		Thread.sleep(4000);
		Md.deselectAll();
		Thread.sleep(3000);

		Md.selectByVisibleText("Volvo");

		Md.selectByIndex(1);
		Md.selectByValue("audi");
		Thread.sleep(3000);
		Md.deselectByIndex(0);
		Thread.sleep(3000);
		Md.deselectByIndex(3);
		Thread.sleep(3000);
		
	}
	
	@After
	public void tearDown()
	
	{
		d.quit();

	}
	



	}

