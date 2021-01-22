package covid.functionaltests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class CasTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		driver = new RemoteWebDriver(new java.net.URL("http://localhost:9515"), options);
		driver.manage().deleteAllCookies();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void casTest() {
    driver.get("http://localhost:8085/covid/");
    driver.manage().window().setSize(new Dimension(945, 826));
    driver.findElement(By.name("login")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("orsys");
    driver.findElement(By.xpath("//input[@value=\'Valider...\']")).click();
    assertThat(driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText(), is("Olivier Routier"));
    assertThat(driver.findElement(By.xpath("//th[2]")).getText(), is("Nom complet"));
    {
      List<WebElement> elements = driver.findElements(By.xpath("//input[@value=\'Ajouter cas\']"));
      assert(elements.size() > 0);
    }
  }
}
