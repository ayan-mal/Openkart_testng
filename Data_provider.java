package Testing_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;

public class Data_provider {
	WebDriver driver; 

	@DataProvider (name="browsers") 

	public Object[][] dp() { 

	return new Object[][] { 

	{"chrome"},

	//{"firefox"},

	{"edge"}

	 };
	}
	@Test(dataProvider = "browsers")

	 public void crossbrowser_test(String browser) { 
		if(browser.equalsIgnoreCase("chrome"))
	 {
	driver=new ChromeDriver();
	 }
	//else if(browser.equalsIgnoreCase("firefox"))
	// {
	//driver=new FirefoxDriver();

	// }
	else if(browser.equalsIgnoreCase("edge"))
	 {
	driver=new EdgeDriver();

	 }else {
		 System.out.println("Invalid Browser");
	 }
		driver.get("https://www.selenium.dev/");
		System.out.println("Title="+driver.getTitle());
}
}
