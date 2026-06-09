package Testing_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Pom_DemoWebshop {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	//Registration
	By Register=By.linkText("Register");
	By gender_male=By.id("gender-male");
	By FirstName=By.id("FirstName");
	By LastName=By.id("LastName");
	By Email=By.id("Email");
	By Password=By.id("Password");
	By ConfirmPassword=By.id("ConfirmPassword");
	By register_button=By.id("register-button");
	//login
	By linkText=By.linkText("Log in");
	By email=By.id("Email");
	By password=By.id("Password");
	By log_in= By.xpath("//input[@value='Log in']");
	//multiple search
	By small_search=By.id("small-searchterms");
	By search=By.xpath("//input[@value='Search']");
	//add to cart
	By add_to_cart=By.xpath("(//input[@value='Add to cart'])[1]");
	
	public Pom_DemoWebshop(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Registration()
	{
		driver.findElement(Register).click();
		driver.findElement(gender_male).click();
		driver.findElement(FirstName).sendKeys("Ayan");
		driver.findElement(LastName).sendKeys("Mal");
		driver.findElement(Email).sendKeys("Ayan1234@gmail.com");
		driver.findElement(Password).sendKeys("Ayan@123");
		driver.findElement(ConfirmPassword).sendKeys("Ayan@123");
		driver.findElement(register_button).click();
	}
	public void Login() {
		driver.findElement(linkText).click();
		driver.findElement(email).sendKeys("Ayan1234@gmail.com");
		driver.findElement(password).sendKeys("Ayan@123");
		driver.findElement(log_in).click();
		
	}
	public void multiple_search() throws InterruptedException {
		driver.findElement(small_search).sendKeys("Laptop");
		driver.findElement(search).click();
		Thread.sleep(2000);
		
		driver.findElement(small_search).sendKeys("Book");
		driver.findElement(search).click();

		
	}
	public void add_to_cart() {
		driver.navigate().to("https://demowebshop.tricentis.com/books");
		driver.findElement(add_to_cart).click();
	}
  @Test
  public void f() {
  }
}
