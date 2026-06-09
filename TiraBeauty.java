package Testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TiraBeauty {
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;
	@BeforeTest
	  public void beforeTest() {
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.google.com/aclk?sa=L&pf=1&ai=DChsSEwjAuaiVoruUAxVYiWYCHYFyC04YACICCAEQABoCc20&co=1&ase=2&gclid=Cj0KCQjwiJvQBhCYARIsAMjts3I58CDsIDnXQD4ZgmJ77BZ1EbqFXK_4JX3P0KKyJG3EHH_wvsLTz-kaAsVnEALw_wcB&cid=CAASuwHkaNK-OhpSC1UeG9ROpPtuY7uI4SOT1_GehmQ9UdCxSWwyQojCJNWcwMco3RrjpXRrEON0LJWhR9uNfbSHQKrCOcAl2iksrGiQQ8S9u7iAQNpRBnr0mRcKh0--11W-CnrjD1FODGMZ7tLlvvMtdbETUoiotla2QCDsZSJ8W4STzphkUfjqJneqOMTvB6pjbzhXT3loxRa1UvK5y9ymFpf2Z2liO9CTxUdyoi3fJYuWexHLcTwFPG3QuWXf&cce=2&category=acrcp_v1_32&sig=AOD64_1ddc4Vv4HLDkuy9d78AqKaZsf7-w&q&nis=4&adurl=https://www.tirabeauty.com/?utm_source%3Dgoogle%26utm_medium%3Dcpc%26utm_campaign%3DVib_HP_GGL_Search_Pur_New_TiraCore_Exact_140323%26utm_content%3D146454269223%26gad_source%3D1%26gad_campaignid%3D19933316617%26gbraid%3D0AAAAApF9nNE9UzPNvS71tLaRHVp210DyM%26gclid%3DCj0KCQjwiJvQBhCYARIsAMjts3I58CDsIDnXQD4ZgmJ77BZ1EbqFXK_4JX3P0KKyJG3EHH_wvsLTz-kaAsVnEALw_wcB&ved=2ahUKEwiKkqGVoruUAxWNRmcHHafsDa4Q0Qx6BAgMEAE");
	  }
  @Test
  public void multiple_search() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Lipstick");
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(Keys.ENTER);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("acne face wash");
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(Keys.ENTER);
	  Thread.sleep(3000);
  }
  @Test
  public void add_to_cart() throws InterruptedException {
	  Thread.sleep(3000);
	 WebElement cream = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id=\"main-content\"]/div[4]/div[2]/div[2]/div[1]/div/div[3]/a/div/div[1]/div[1]/div[2]/picture/img")));
	 	cream.click();
		WebElement addtocart = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id=\"main-content\"]/div[4]/div[2]/div[2]/div[1]/div/div[3]/a/div/div[3]/div/div[1]/div/button")));
		addtocart.click();
	  
  }
 // @Test 
  //public void delete_to_cart() {
	 // WebElement gotobag = wait.until(
			//	ExpectedConditions.elementToBeClickable(
				//		By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a/div[1]")));
	//	gotobag.click();
		// WebElement remove = wait.until(
					//ExpectedConditions.elementToBeClickable(
						//	By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[1]/div/div[2]/div[1]/div[3]/div[2]/div/div/button[1]")));
		//	remove.click();
			//WebElement delete = wait.until(
			//		ExpectedConditions.elementToBeClickable(
			//				By.xpath("//*[@id=\"main-content\"]/div/div[1]/div[1]/div[3]/div[3]/div/button[1]")));
		//	delete.click();
	  
//  }
  

  @AfterTest
  public void afterTest() {
	  System.out.println("Successfully done");
  }

}
