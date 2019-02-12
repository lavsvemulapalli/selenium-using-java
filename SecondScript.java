package klm;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondScript {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "F:\\Driver Server\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/?gfe_rd=cr&dcr=0&ei=hbL5WdAF0YvxB5HQsKAF&gws_rd=ssl");
    assertEquals("Google", driver.getTitle());
    driver.findElement(By.id("lst-ib")).clear();
   
   // driver.findElement(By.id("lst-ib")).sendKeys("selenium");
    //driver.findElement(By.name("q")).sendKeys("testing");
    //driver.findElement(By.className("gsfi")).sendKeys("Qtp");
    //driver.findElement(By.linkText("Sign in")).click();
    //driver.findElement(By.partialLinkText("Sign")).click();
    //driver.findElement(By.partialLinkText("in")).click();
   // driver.findElement(By.xpath("//a[@id='gb_70']")).click();
    System.out.println("no of links" + driver.findElements(By.tagName("a")).size());
    
    Thread.sleep(4000);
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
