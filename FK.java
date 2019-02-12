package klm;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.testng.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class FK {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
  public void setUp() throws Exception {
	  //System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	  System.setProperty("webdriver.ie.driver", "F:\\Driver Server\\IEDriverServer.exe");
	  System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
    driver = new FirefoxDriver();
    //driver=new ChromeDriver();
	 // driver=new InternetExplorerDriver();
    
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals("Facebook – log in or sign up", driver.getTitle());
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("selenium");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("selenium");
    driver.findElement(By.cssSelector("input[value='Log In']")).click();
    assertEquals("Log in to Facebook | Facebook", driver.getTitle());
    Thread.sleep(4000);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

