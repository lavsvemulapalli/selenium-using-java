package klm;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Pay1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	  System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
		 //driver=new ChromeDriver();
    driver = new FirefoxDriver();
    baseUrl = "https://paytm.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals("Paytm.com – Digital & Utility Payment, Entertainment, Travel, Payment Gateway & more Online !", driver.getTitle());
    driver.findElement(By.cssSelector("div._3ac-")).click();
    driver.switchTo().frame(0);
    driver.findElement(By.id("input_0")).clear();
    driver.findElement(By.id("input_0")).sendKeys("hjgjhfhghjg");
    driver.findElement(By.id("input_1")).clear();
    driver.findElement(By.id("input_1")).sendKeys("fhfhjgjgjhgjhjk");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(5000);
  }

  @After
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
