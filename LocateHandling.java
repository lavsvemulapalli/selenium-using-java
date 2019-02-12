package klm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LocateHandling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","F:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
//textbox
		
		d.get("https://www.facebook.com/");
		d.findElement(By.id("email")).sendKeys("Testing with lavanya");
		//Thread.sleep(2000);
//getAttribute
		System.out.println("attribute name is" +d.findElement(By.id("email")).getAttribute("value"));
		//Thread.sleep(2000);
//clear()
		//d.findElement(By.id("email")).clear();
		
//textarea
		
		//d.get("http://book.theautomatedtester.co.uk/chapter1");
		//d.findElement(By.className("belowcenter")).clear();
		//Thread.sleep(2000);
		//d.findElement(By.className("belowcenter")).sendKeys("lavanya\nfghyj\nbharath");
		//Thread.sleep(2000);
		//d.findElement(By.className("belowcenter")).clear();
		//Thread.sleep(2000);
		//d.findElement(By.className("belowcenter")).sendKeys("raja\ndad\nmom");
		//Thread.sleep(2000);
		
//button
		//d.get("https://www.facebook.com/");
		//d.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
		
//link
		//d.findElement(By.partialLinkText(" account?")).click();
		
//check box
//click
		//d.get("http://book.theautomatedtester.co.uk/chapter1");
		//d.findElement(By.xpath("//input[@name='selected(1234)']")).click();
		//Thread.sleep(2000);
		//d.findElement(By.xpath("//input[@name='selected(1234)']")).click();
		//Thread.sleep(2000);
		//d.findElement(By.xpath("//input[@name='selected(1234)']")).click();
		
//isSelected
		
		//d.get("http://book.theautomatedtester.co.uk/chapter1");
		//d.findElement(By.xpath("//input[@name='selected(1234)']")).click();
		//System.out.println("check box status" +d.findElement(By.xpath("//input[@name='selected(1234)']")).isSelected());
		
//radiobutton
		
		//d.get("https://www.facebook.com/");
//click
		//d.findElement(By.name("sex")).click();
//isSelected
		
		//System.out.println("check box radiobutton status" +d.findElement(By.name("sex")).isSelected());
		
//multidropdown
		
	//	d.get("file:///C:/Users/Lavanya/Desktop/asd.html");
	//	Select dd=new Select(d.findElement(By.id("abc")));
		//for(int i=0;i<3;i++)
	//	{
		//	dd.selectByIndex(i);	
	//}
	
	//Thread.sleep(4000);
	//dd.deselectByIndex(3);
	//Thread.sleep(2000);
	//dd.deselectAll();
	//Thread.sleep(2000);
	//dd.selectByIndex(0);
	//dd.selectByIndex(2);
	//Thread.sleep(2000);
	//d.quit();
		
//getAllSelectedOptions		
		
	//d.get("file:///C:/Users/Lavanya/Desktop/asd.html");
	//Select dd=new Select(d.findElement(By.id("abc")));

	//	for(int i=0;i<2;i++)
	//{
			//dd.selectByIndex(i);	
	//}
	
	//System.out.println("all selected options are" +dd.getAllSelectedOptions().getText());
	
//is enable		
	d.get("https://www.ifsccodebank.com/");
	//System .out.println("is enabled:" +d.findElement(By.id("BC_ddlState")).isEnabled());
	
			System .out.println("is enabled:" +d.findElement(By.id("BC_ddlBank")).isEnabled());
	}

	
		
	}


