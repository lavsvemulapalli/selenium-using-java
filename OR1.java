package klm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OR1 {
	
	
	OR1(WebDriver d)
	{
		//PageFactory.initElements(d,ORDemo);
	}

	@FindBy(id="cyclosUsername") WebElement uname;
	@FindBy(id="cyclosPassword") WebElement pwd;
	@FindBy(xpath="//input[@value='Submit']") WebElement login;
	@FindBy(xpath="//span[text()='Logout']") WebElement logout;
	
	
	
	
	
	
}
