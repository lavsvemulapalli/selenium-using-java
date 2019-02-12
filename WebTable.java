package klm;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class WebTable {
	WebDriver d;
	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 d=new FirefoxDriver();
		 d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		 d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);		
	}

@AfterMethod
public void tearDown()
{
	
	d.quit();
	
}

@Test
public void webTable() throws Exception
{
d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");	
assertEquals(":: Government Orders ::", d.getTitle());
Select s=new Select(d.findElement(By.id("Select1")));
s.selectByIndex(4);
List<WebElement> tr_coll =d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
System.out.println("no.of rows in a table:" + tr_coll.size());
List<WebElement> td_col=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
System.out.println("no.of colomns in a table:" +td_col.size()/+tr_coll.size());
int tr,td;
tr=1;
for(WebElement tr_ele:tr_coll)
{
	//System.out.println(tr_ele.getText());
	List<WebElement> td_ele =tr_ele.findElements(By.xpath("td"));
	td=1;
	for(WebElement td_ele1:td_col)
	{
		if(td_ele1.getText().contains("Sai Prasad"))
        {
        	System.out.println("Name Found");
        	break;
        }
       	td++;
    }
   tr++;
}
Thread.sleep(4000);
}
}


	
	









