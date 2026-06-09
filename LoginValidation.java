package Testing_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginValidation {
WebDriver driver;
	
    @DataProvider(name="data")
	public Object[][] dp1() {
		return new Object[][] {
			{"username", "password"},
			{"invalid", "password"},
			{"username", "2345678"},
			{"invalid", "invalid"},
		};
	}
	
  @Test(dataProvider="data")
  public void f(String username1, String password1) {
	  driver=new ChromeDriver();
	  driver.get("http://zero.webappsecurity.com/login.html");
	  WebElement name=driver.findElement(By.id("user_login"));
	  name.sendKeys(username1);
	  WebElement pass=driver.findElement(By.id("user_password"));
	  pass.sendKeys(password1);
	  driver.findElement(By.name("submit")).click();
  }
}
