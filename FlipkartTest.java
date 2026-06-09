package Testing_practice;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class FlipkartTest {
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;
	
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();

	    driver.manage().window().maximize();

	    wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    js = (JavascriptExecutor) driver;

	    driver.get("https://www.flipkart.com/");
	  }
  @Test(enabled=false)
  public void registration() {
  }
  
  @Test(enabled=false)
  public void login() throws InterruptedException {
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(
              By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[1]/input")))
              .sendKeys("6204039515");

      wait.until(ExpectedConditions.elementToBeClickable(
              By.xpath("//button[contains(text(),'Request OTP')]")))
              .click();

      System.out.println("OTP sent successfully");

      // Manual OTP Entry
      Thread.sleep(25000);
  }
  
  @Test(priority=1)
  public void multiple_search() throws InterruptedException {
	// cutting login button because i am not login due to otp limits
		  WebElement cutBtn = wait.until(
					ExpectedConditions.elementToBeClickable(
							By.xpath("/html/body/div[5]/div/span")));
		  cutBtn.click();
	  String[] products = {"Laptop", "Watch", "iPhone"};

      JavascriptExecutor js0 = (JavascriptExecutor) driver;

      for (String item : products) {

          WebElement searchBox = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.name("q")));

          js0.executeScript("window.scrollTo(0,0)");

          Thread.sleep(2000);

          js0.executeScript("arguments[0].click();", searchBox);

          searchBox.sendKeys(Keys.CONTROL + "a");

          searchBox.sendKeys(Keys.DELETE);

          Thread.sleep(1000);

          searchBox.sendKeys(item);

          searchBox.sendKeys(Keys.ENTER);

          System.out.println(item + " searched successfully");

          Thread.sleep(4000);
      }

  }
  
  @Test(priority=2)
  public void shoes_for_add_to_cart() throws InterruptedException {
	// cutting login button because i am not login due to otp limits
		  WebElement cutBtn = wait.until(
					ExpectedConditions.elementToBeClickable(
							By.xpath("/html/body/div[5]/div/span")));
		  cutBtn.click();
	  WebElement searchBox = wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                      By.name("q")));

      js.executeScript("window.scrollTo(0,0)");

      Thread.sleep(2000);

      js.executeScript("arguments[0].click();", searchBox);

      searchBox.sendKeys(Keys.CONTROL + "a");

      searchBox.sendKeys(Keys.DELETE);

      Thread.sleep(1000);

      searchBox.sendKeys("Shoes");

      searchBox.sendKeys(Keys.ENTER);

      System.out.println("Shoes searched again for Add to Cart");

      Thread.sleep(5000);
  }
  
  @Test(priority=3)
  public void product_details() {
	  
	// cutting login button because i am not login due to otp limits
		  /*WebElement cutBtn = wait.until(
					ExpectedConditions.elementToBeClickable(
							By.xpath("/html/body/div[5]/div/span")));
		  cutBtn.click();*/
	  WebElement firstProduct = wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                      By.xpath("(//a[contains(@href,'/p/')])[1]")));

      System.out.println("Product Name : " + firstProduct.getText());

      WebElement productPrice = wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                      By.xpath("(//div[contains(text(),'₹')])[1]")));

      System.out.println("Product Price : " + productPrice.getText());
  }
  
  @Test(priority=4)
  public void openproduct() throws InterruptedException {
	  String parentWindow = driver.getWindowHandle();

	  JavascriptExecutor js = (JavascriptExecutor) driver;

	  // Locate first product
	  WebElement firstProduct = driver.findElement(
	          By.xpath("(//img)[1]"));   // change xpath according to your product

	  // Click product using JavaScript
	  js.executeScript("arguments[0].click();", firstProduct);

	  Thread.sleep(5000);

	  // Get all opened windows
	  Set<String> allWindows = driver.getWindowHandles();

	  // Switch to child window
	  for (String window : allWindows) {

	      if (!window.equals(parentWindow)) {

	          driver.switchTo().window(window);

	          break;
	      }
	  }
      
      // select size
      JavascriptExecutor js1 = (JavascriptExecutor) driver;

      Thread.sleep(3000);

      WebElement size = wait.until(
              ExpectedConditions.elementToBeClickable(
                      By.xpath("(//a[contains(@class,'CDlOaO')])[1]")));

      js1.executeScript("arguments[0].click();", size);

      System.out.println("Size selected");

      Thread.sleep(3000);
	  
  }
  
  @Test(priority=5)
  public void add_to_cart() throws InterruptedException {
	  WebElement addToCart = wait.until(
              ExpectedConditions.elementToBeClickable(
                      By.xpath("//button[contains(.,'Add to cart')]")));

      js.executeScript("arguments[0].scrollIntoView(true);", addToCart);

      Thread.sleep(2000);

      js.executeScript("arguments[0].click();", addToCart);

      System.out.println("Product added to cart");

      Thread.sleep(5000);
  }
  
  @Test(priority=6)
  public void delete_cart_item() {
	    try {

	        WebElement removeBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//div[contains(text(),'Remove')]")));

	        removeBtn.click();

	        Thread.sleep(2000);

	        WebElement confirmRemove = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//div[contains(text(),'Remove')]")));

	        confirmRemove.click();

	        System.out.println("Product removed from cart");

	        Thread.sleep(3000);

	    } catch (Exception e) {

	        System.out.println("Error Occurred : " + e);

	    } 
//	        finally {
//
//	        driver.quit();
//
//	        System.out.println("Browser closed successfully");
//	    }
	    }
  
  
  @Test
  public void change_Address() {
  }
  
  @Test
  public void Change_name() {
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();

	    System.out.println("Browser closed successfully");
  }

}