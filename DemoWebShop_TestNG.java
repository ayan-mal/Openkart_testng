package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoWebShop_TestNG {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;


	@BeforeTest(alwaysRun = true)
	public void browserSetup() {

		driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver,Duration.ofSeconds(15));

		js = (JavascriptExecutor) driver;

		driver.get("https://demowebshop.tricentis.com/");

	}

	// Registration
	
	@Test(groups="Smoke")//(priority = 1)
	public void registration()
	throws InterruptedException {

		driver.findElement(	By.linkText("Register")).click();

		driver.findElement(By.id("gender-male")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("FirstName")).sendKeys("Ayan");

		Thread.sleep(2000);

		driver.findElement(By.id("LastName")).sendKeys("Mal");

		Thread.sleep(2000);

		driver.findElement(By.id("Email")).sendKeys("Ayan1234@gmail.com");

		Thread.sleep(2000);

		driver.findElement(By.id("Password")).sendKeys("Ayan@123");

		Thread.sleep(2000);

		driver.findElement(By.id("ConfirmPassword")).sendKeys("Ayan@123");

		Thread.sleep(2000);

		driver.findElement(By.id("register-button")).click();

		Thread.sleep(3000);

		System.out.println(
		"Registration Completed");

	}

	// Login
	
	@Test//(groups="Smoke")//(priority = 2)
	public void login()throws InterruptedException {

		driver.findElement(By.linkText("Log in")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("Email")).sendKeys("Ayan1234@gmail.com");

		Thread.sleep(2000);

		driver.findElement(By.id("Password")).sendKeys("Ayan@123");

		Thread.sleep(2000);

		driver.findElement(
		By.xpath("//input[@value='Log in']")).click();

		Thread.sleep(3000);

		System.out.println(	"Login Successful");

	}

		// Search Product
	
	@Test(groups="Smoke")//(priority = 3)
	public void multiple_search()throws InterruptedException {

		WebElement search =driver.findElement(By.id("small-searchterms"));

		search.sendKeys("Laptop");

		Thread.sleep(2000);

		driver.findElement(	By.xpath("//input[@value='Search']"))
		.click();

		Thread.sleep(3000);
		WebElement search1 =driver.findElement(By.id("small-searchterms"));

		search1.sendKeys("Book");

		Thread.sleep(2000);

		driver.findElement(	By.xpath("//input[@value='Search']"))
		.click();

		Thread.sleep(3000);

		System.out.println(	"Search Completed");

	}

	// Add To Cart
		@Test (groups="Smoke")//(priority = 4)
	public void add_to_cart()throws InterruptedException {

		driver.navigate().to("https://demowebshop.tricentis.com/books");

		Thread.sleep(3000);

		driver.findElement(

		By.xpath("(//input[@value='Add to cart'])[1]")).click();

		Thread.sleep(3000);

		System.out.println("Product Added To Cart");

	}

		// Product Details
	@Test//(groups="Smoke")//(priority = 5)
	public void product_details()throws InterruptedException {

		driver.findElement(By.linkText("Books")).click();

		Thread.sleep(2000);

		driver.findElement(

		By.xpath("(//a[@href='/computing-and-internet'])[1]")).click();

		Thread.sleep(3000);

		String title =driver.findElement(By.xpath("//h1")).getText();

		System.out.println("Product Title : "+ title);

		Thread.sleep(2000);

	}

	// Remove Cart Item
	
	@Test//(priority = 6)
	public void delete_cart_item()
	throws InterruptedException {

		driver.findElement(By.linkText("Shopping cart")).click();

		Thread.sleep(3000);

		driver.findElement(By.name("removefromcart")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("updatecart")).click();

		Thread.sleep(3000);

		System.out.println("Cart Item Removed");

	}

		// Wishlist
	
	@Test//(priority = 7)
	public void wishlist()
	throws InterruptedException {

		driver.navigate().to(
		"https://demowebshop.tricentis.com/books");

		Thread.sleep(3000);

		driver.findElement(

		By.xpath(
		"(//input[@value='Add to wishlist'])[1]"))

		.click();

		Thread.sleep(3000);

		System.out.println(
		"Added To Wishlist");

	}

			// Logout
	
	@Test//(priority = 9)
	public void logout()throws InterruptedException {

		driver.findElement(	By.linkText("Log out")).click();

		Thread.sleep(1000);

		System.out.println("Logout Successful");

	}

	// Close Browser
	
	@AfterTest(alwaysRun = true)
	public void closeBrowser()throws InterruptedException {

		Thread.sleep(1000);

		driver.quit();

	}

}
