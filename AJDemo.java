package klm;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class AJDemo extends Cmmon {
	
		
			
	@Test
	public void banTest() throws Exception
	{
		
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India", d.getTitle());
		


	selectOption(d.findElement(By.id("selBank")),"Axis Bank");
	selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
	selectOption(d.findElement(By.id("selCity")),"Hyderabad");
	selectOption(d.findElement(By.id("selBranch")),"Madhapur");
	
	Thread.sleep(4000);
	
	
}



public void selectOption(WebElement locator,String optionname)
{

	Select ab=new Select(locator);
	ab.selectByVisibleText(optionname);


}
}
	