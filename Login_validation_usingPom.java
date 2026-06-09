package Testing_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Login_validation_usingPom {
	WebDriver driver;
	@DataProvider(name="data")
	  public Object[][] dp() {
	    return new Object[][] {
	    	// validate login
	    	//{"username1","password1"},
	    	{"username","password"},//valid username and password 
	    	{"invalid","password"},//invalid username and valid password
	    	{"username","invalid"},//valid username and invalid password
	    	{"invalid","inalid"},//invalid username and password
	    };
	}
  @Test(dataProvider = "data")
    public void f(String user1, String pass1) throws InterruptedException{
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://zero.webappsecurity.com/login.html");
	  
	  // using pom file
	  POM_impl page=new POM_impl(driver);
	  page.login();
	  
	  
	  // for normal
	  /*WebElement user=driver.findElement(By.id("user_login"));
	  user.sendKeys(user1);
	  WebElement pass=driver.findElement(By.id("user_password"));
	  user.sendKeys(pass1);
	  driver.findElement(By.name("submit")).click();*/
	  Thread.sleep(3000);
  }

  
  }
