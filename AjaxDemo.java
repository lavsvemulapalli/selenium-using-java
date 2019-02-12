package klm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AjaxDemo {
	WebDriver d;
		
@Test
public void banTest() throws Exception
{
	d.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
	d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
	//assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India", d.getTitle());
	/*Select bank=new Select(d.findElement(By.id("selBank")));
	bank.selectByIndex(4);
	Select state=new Select(d.findElement(By.id("selState")));
	state.selectByVisibleText("Andhra Pradesh");
	Select city=new Select(d.findElement(By.id("selCity")));
	city.selectByVisibleText("Hyderabad");
	Select branch=new Select(d.findElement(By.id("selBranch")));
	branch.selectByVisibleText("Jubilee Hills");*/
	
	
	selectOption(d.findElement(By.id("selBank")),"Axis Bank");
	selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
	selectOption(d.findElement(By.id("selCity")),"Hyderabad");
	selectOption(d.findElement(By.id("selBranch")),"Madhapur");
	
	Thread.sleep(4000);
	
	
}



public void selectOption(WebElement locator,String optionname)
{

	Select city=new Select(locator);
	city.selectByVisibleText(optionname);


}


@Before
public void SetUp()
{
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	d=new FirefoxDriver();
	d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
}
@After
public void tearDowm()
{
d.quit();
}
}
