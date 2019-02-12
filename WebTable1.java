package klm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class WebTable1 {
	WebDriver d;
	
	@Test
	public void testTable() throws Exception
	{
		d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		Select s=new Select(d.findElement(By.id("Select1")));
		s.selectByIndex(4);
		List<WebElement> tr_collection =d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
		System.out.println("no.of rows:" +tr_collection.size());
		List<WebElement> td_collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
		System.out.println("no.of col:" +td_collection.size()/+tr_collection.size());
		Thread.sleep(2000);
		int row_num,col_num;
		row_num=1;
		for(WebElement tr_element:tr_collection)
		{
			List<WebElement> td_Collection1 =tr_element.findElements(By.xpath("td"));
			col_num=1;
			for(WebElement td_element:td_Collection1)
			{
			//System.out.println("row no:" +row_num+ "col no:" +col_num+ "Text=" +td_element.getText() );
				
				if(td_element.getText().contains("Sai Prasad"))
				{
					System.out.println("name found");
					break;
				}
			col_num++;
			}
			
			row_num++;
					}
		
	}
	
	
	
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
		 d.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		 d.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void tearDown()
	{
		d.quit();
	}
	
	

}
