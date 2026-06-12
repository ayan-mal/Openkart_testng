package ParabankTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Testclass {

     WebDriver driver;
     WebDriverWait wait;
     JavascriptExecutor js;
@BeforeTest
	 public void beforeTest() {
	 driver = new EdgeDriver();
     //driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     driver.get("https://parabank.parasoft.com/parabank/index.htm");
}
  @Test(priority = 1)
  public void registerUser() {

      driver.findElement(By.linkText("Register")).click();

      driver.findElement(By.id("customer.firstName")).sendKeys("Ayan");
      driver.findElement(By.id("customer.lastName")).sendKeys("Mal");
      driver.findElement(By.id("customer.address.street")).sendKeys("Kolkata");
      driver.findElement(By.id("customer.address.city")).sendKeys("Kolkata");
      driver.findElement(By.id("customer.address.state")).sendKeys("WB");
      driver.findElement(By.id("customer.address.zipCode")).sendKeys("700001");
      driver.findElement(By.id("customer.phoneNumber")).sendKeys("9999999999");
      driver.findElement(By.id("customer.ssn")).sendKeys("12345");

      String username = "ayan12";
      String password = "Password123";

      driver.findElement(By.id("customer.username")).sendKeys(username);
      driver.findElement(By.id("customer.password")).sendKeys(password);
      driver.findElement(By.id("repeatedPassword")).sendKeys(password);

      driver.findElement(By.xpath("//input[@value='Register']")).click();

      Assert.assertTrue(driver.getPageSource().contains("Welcome"));
  }
  @Test(priority = 2)
  public void login() {

      driver.findElement(By.linkText("Log Out")).click();

      driver.findElement(By.name("username")).sendKeys("ayan12");
      driver.findElement(By.name("password")).sendKeys("Password123");
      driver.findElement(By.xpath("//input[@value='Log In']")).click();

      Assert.assertTrue(driver.getPageSource().contains("Accounts Overview"));
  }

  @Test(priority = 3)
  public void openNewAccount() {

      driver.findElement(By.linkText("Open New Account")).click();

      driver.findElement(By.xpath("//input[@value='Open New Account']")).click();

      Assert.assertTrue(driver.getPageSource()
              .contains("Account Opened"));
  }

  @Test(priority = 4)
  public void transferFunds() {

      driver.findElement(By.linkText("Transfer Funds")).click();

      driver.findElement(By.id("amount")).sendKeys("100");

      driver.findElement(By.xpath("//input[@value='Transfer']")).click();

      Assert.assertTrue(driver.getPageSource()
              .contains("Transfer Complete"));
  }

  @Test(priority = 5)
  public void logout() {

      driver.findElement(By.linkText("Log Out")).click();

      Assert.assertTrue(driver.getCurrentUrl()
              .contains("index"));
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
