package Testing_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class POM_impl {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	By user=By.id("user_login");
	By pass=By.id("user_password");
	By submitbutton=By.name("submit");
public POM_impl(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login()
	{
		driver.findElement(user).click();
		driver.findElement(user).sendKeys("username");
		driver.findElement(pass).click();
		driver.findElement(pass).sendKeys("password");
		driver.findElement(submitbutton).click();
	}
  @Test
  public void f() {
  }
}
