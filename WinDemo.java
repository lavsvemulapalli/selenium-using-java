package klm;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WinDemo {
	WebDriver d;

	@Before
	public void setUp()
	{
	System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
	 d=new FirefoxDriver();
	 d.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	 d.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	 
	}
	
	@After
	public void tearDown()
	{
	d.quit();
	
	}
	@Test
	public void winTest() throws Exception
	{
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		d.findElement(By.linkText("Alerts & Updates")).click();
		//d.findElement(By.linkText("Observance of Vigilance Awareness Week-2017.")).click();
		
		Set<String> h =d.getWindowHandles();
	String handle []=new String[h.size()];
	int i=0;
	System.out.println("no of handles:" +h.size());
	for (String s:h)
	{
		handle[i]=s;
		i++;
		//System.out.println(s);
	}
	Thread.sleep(1000);
	d.switchTo().window(handle[1]);
	d.findElement(By.linkText("For offer details - Click here.")).click();
	Set<String> h1 =d.getWindowHandles();
	String handle1 []=new String[h1.size()];
	i=0;
	
	System.out.println("no of handles:" +h1.size());
	for (String s:h1)
	{
		handle1[i]=s;
		i++;
		//System.out.println(s);
	}
	d.switchTo().window(handle1[2]);
	System.out.println("element is present: " +d.findElement(By.linkText("Help")).isDisplayed());
	Thread.sleep(3000);
	
	d.switchTo().window(handle[0]);
	d.findElement(By.id("usernameId")).sendKeys("hhkhkhk");
	
d.findElement(By.className("loginPassword")).sendKeys("hhkhkhk");
Thread.sleep(5000);
d.switchTo().window(handle[1]);
Thread.sleep(2000);
	}
	
	
}

	