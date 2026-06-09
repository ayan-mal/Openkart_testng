package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoWebShop_UsingPOM {
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor js;
Pom_DemoWebshop page;


@BeforeTest(alwaysRun = true)
public void browserSetup() {

	driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	js = (JavascriptExecutor) driver;
	driver.get("https://demowebshop.tricentis.com/");

}

// Registration

@Test(groups="Smoke", priority = 1)
public void registration()
throws InterruptedException {

	page=new Pom_DemoWebshop(driver);
	page.Registration();

	System.out.println(
	"Registration Completed");

}
//Login

	@Test(groups="Smoke", priority = 2)
	public void login()throws InterruptedException {
		
		page=new Pom_DemoWebshop(driver);
		page.Login();

		System.out.println(	"Login Successful");

	}
	//multiple_search
	@Test(groups="Smoke", priority = 3)
	public void multiple_search()throws InterruptedException {

		page=new Pom_DemoWebshop(driver);
		page.multiple_search();

		System.out.println(	"Search Completed");

	}
	//add_to_cart
	@Test (groups="Smoke", priority = 4)
		public void add_to_cart() {

			page=new Pom_DemoWebshop(driver);
			page.add_to_cart();

			System.out.println("Product Added To Cart");
	}
}