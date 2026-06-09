package Testing_practice;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
 
public class Tira_Beauty {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
  @BeforeTest
   public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  driver.get("https://www.tirabeauty.com/");
   }
  
//  @Test
//  public void registration() throws InterruptedException {
//	  wait.until(ExpectedConditions.elementToBeClickable(
//			  By.xpath("//span[contains(text(), 'Login')]"))).click();
//	  Thread.sleep(1500);
//  }
  
//  @Test(dependsOnMethods = {"registration"})
//  public void login() throws InterruptedException {
//
//	WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
//		     By.xpath("//input[@id='mobile-number-input' or @name='mobile-number']")));
//
//	phoneInput.click();
//	phoneInput.clear();
//
//	phoneInput.sendKeys("7439073905");
//
//	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//	jsExecutor.executeScript("arguments[0].value='7439073905'; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", phoneInput);
//	System.out.println("Phone number value filled");
//
//	WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
//	        By.xpath("//div[contains(@class, 'filterCheckbox')] | //div[contains(@class, 'checkbox')]")));
//	termsCheckbox.click();
//	System.out.println("Terms checkbox verified and checked.");
//	
//	Thread.sleep(1000); 
//
//	WebElement sendOtpBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
//	        By.xpath("//button[text()='Send OTP']")));
//	sendOtpBtn.click();
//	System.out.println("Send OTP button executed successfully via native click!");
//	
//  }
 
  
  @Test
  public void multiple_search() throws InterruptedException {
	  WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
			     By.id("search")));
	  searchInput.click();
	  searchInput.sendKeys("Men's facewash");
	  Thread.sleep(2000);
	  searchInput.sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  
  }
  
  @Test(dependsOnMethods = {"multiple_search"})
  public void product_details() throws InterruptedException {
	  WebElement opnBrnd = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//div[@id='Brand']//button")));
	  opnBrnd.click();
	  System.out.println("Brand dropdown accordion opened successfully.");

	  Thread.sleep(1500);

	  WebElement selBrnd = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//div[text()='Nivea']")));
	  selBrnd.click();
	  System.out.println("Nivea filter applied successfully!");
	  Thread.sleep(2000);
	  
	  WebElement opnType = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//div[@id='Skin Type']//button")));
	  opnType.click();
	  System.out.println("Skin Type dropdown accordion opened successfully.");
	  
	  WebElement skin = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//div[text()='Oily']")));
	  skin.click();
	  System.out.println("Oily filter applied successfully!");
	  Thread.sleep(2000);
  }
  
  @Test(dependsOnMethods = {"product_details"})
  public void add_to_cart() throws InterruptedException {
	  WebElement addProd = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("/html/body/div/div/div[2]/div[4]/div[2]/div[2]/div/div/div[1]/a/div/div[1]/div[2]/div[1]/div[1]")));
	  addProd.click();
	  System.out.println("Bagegd successfully.");
	  Thread.sleep(2000);
	  
	  String originalWindow = driver.getWindowHandle();

	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	  for (String windowHandle : driver.getWindowHandles()) {
		  if (!originalWindow.contentEquals(windowHandle)) {
			  driver.switchTo().window(windowHandle);
			  break;
		  }
	  }
	  System.out.println("Switched focus to the product details tab successfully.");

	  WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//button[./span[text()='Add To Bag']]")));
	  addToBag.click();
	  System.out.println("Product added to bag successfully!");
	  Thread.sleep(2000);
	  
	  WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(
			  By.cssSelector("a[href='/cart/bag']")));
	  cart.click();
	  System.out.println("Cart Clicked");
	  Thread.sleep(2000);
	  
	  
  }
  
  @Test(dependsOnMethods = {"add_to_cart"})
  public void login() throws InterruptedException {
	  WebElement login = wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/button")));
	  login.click();
	  System.out.println("Login Clicked");
	  Thread.sleep(2000);
	  
		WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("//input[@id='mobile-number-input' or @name='mobile-number']")));

		phoneInput.click();
		phoneInput.clear();
		phoneInput.sendKeys("7044859633");
		
		WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class, 'filterCheckbox')] | //div[contains(@class, 'checkbox')]")));
		termsCheckbox.click();
		System.out.println("Terms checkbox verified and checked.");
		Thread.sleep(1000); 

		WebElement sendOtpBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[text()='Send OTP']")));
		sendOtpBtn.click();
		System.out.println("Send OTP button executed successfully via native click!");
		Thread.sleep(10000);
		WebElement firstname=driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/section/div/div[3]/div[1]/div[2]/div[1]/input"));
		firstname.sendKeys("Ayan");
		WebElement lastname=driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/section/div/div[3]/div[1]/div[2]/div[2]/input"));
		lastname.sendKeys("Mal");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/section/div/div[3]/div[1]/div[3]/input"));
		email.sendKeys("ayan1234@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/section/div/div[3]/div[1]/div[4]/div[2]/button/img")).click();
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/section/div/div[3]/div[2]/button")).click();

  }
  
//  @Test
//  public void delete_cart() {
//	  
//  }
  
  @Test(dependsOnMethods = {"login"})
  public void change_Address() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/div[2]/div[2]/div/button")).click(); 
	  Thread.sleep(2000);
	  WebElement House=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/div[5]/div[2]/div/div/div/form/div/div[1]/div/input"));
		House.sendKeys("AB1234");
		 WebElement street=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/div[5]/div[2]/div/div/div/form/div/div[2]/div/input"));
			street.sendKeys("Deulpur");
			WebElement pincode=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/div[5]/div[2]/div/div/div/form/div/div[2]/div/input"));
			pincode.sendKeys("711411");
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[2]/div[5]/div[3]/div/div/button")).click();
		
  }
//  @Test
//  public void Change_name() {
//  }
 
  @AfterTest
  public void afterTest() {
	  System.out.println("Successfully completed");
//	  driver.quit();
  }
 
}