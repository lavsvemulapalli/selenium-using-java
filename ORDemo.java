package klm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ORDemo {
	WebDriver d;
	
	
	ORDemo(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
	}
	@FindBy(id="cyclosUsername") WebElement uname;
	@FindBy(id="cyclosPassword") WebElement pwd;
	@FindBy(className="button") WebElement submit;
	@FindBy(xpath="//span[text()='Logout']") WebElement logout;	
	
	public void login(String username, String password)
	
	{
		uname.clear();
		uname.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(password);
		submit.click();
		logout.click();	
		
	}
	
	public void clickOk()
	{
		d.switchTo().alert().accept();
	}
	
	public void clickCancel()
	{
		d.switchTo().alert().dismiss();
	}
}
