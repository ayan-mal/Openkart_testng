package Testing_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register {
	 WebDriver driver;

	    @DataProvider(name = "registerData")
	    public Object[][] data() {
	        return new Object[][]{
	                {"Ayan", "Mal", "Ayan1@test.com", "12345"},
	                {"Rahul", "Singh", "rahul@test.com", "23456"},
	                {"Aman", "Singh", "aman@test.com", "34567"},
	                {"Neha", "Gupta", "neha@test.com", "45678"},
	                {"Riya", "Singh", "priya@test.com", "56789"}
	        };
	    }

	    @Test(dataProvider = "registerData")
	    public void registerUser(String fname, String lname,
	                             String email, String password)
	            throws InterruptedException {

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // sample registration page
	        driver.get("https://demo.automationtesting.in/Register.html");

	        // First Name
	        driver.findElement(By.xpath("//input[@placeholder='First Name']"))
	              .sendKeys(fname);

	        // Last Name
	        driver.findElement(By.xpath("//input[@placeholder='Last Name']"))
	              .sendKeys(lname);

	        // Email
	        driver.findElement(By.xpath("//input[@type='email']"))
	              .sendKeys(email);

	        // Password
	        driver.findElement(By.id("firstpassword"))
	              .sendKeys(password);

	        System.out.println("Registered: " + fname + " " + lname);

	        Thread.sleep(2000);

	        driver.quit();
	    }
	}
