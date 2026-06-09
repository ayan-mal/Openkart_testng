package Testing_practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CrossBrowserChecking {
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;
  @Test(groups="Smoke")
  public void chrome() {
	  driver =new ChromeDriver(); 
      driver.manage().window().maximize();

	  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	  driver.get("https://www.selenium.dev/");
  }
	  @Test(groups="Smoke")
	  public void Edge() {
		  driver =new EdgeDriver(); 
	      driver.manage().window().maximize();

		  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		  driver.get("https://www.selenium.dev/");

  }
}
