package klm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTab {
	WebDriver d;
	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void meth1()
	{
	d.quit();
	}


	@Test
	public void testKey() throws Exception
	{
		d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		assertEquals(":: Government Orders ::", d.getTitle());
	Select s=new Select(d.findElement(By.id("Select1")));
	s.selectByIndex(3);
	List<WebElement>tr_coll_loc=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
	System.out.println("no.of rows:" +tr_coll_loc.size());
	List<WebElement> td_coll_loc =d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
	System.out.println("no.of coloumns:"  +td_coll_loc.size()/+tr_coll_loc.size());
	int tr,td;
	tr=1;
	for(WebElement tr_ele:tr_coll_loc)
	{
		List<WebElement> td_ele=tr_ele.findElements(By.xpath("td"));
		//System.out.println(+td_ele.size());
		td=1;
		for(WebElement td_ele1:td_coll_loc)
		{
			System.out.println("Row # "+tr+", Col # "+td+ ", Text=" +td_ele1.getText());
			if(td_ele1.getText().contains("gfhh"))
			{
				System.out.println("cell found");
				break;
			}
			
			tr++;
			td++;
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
}