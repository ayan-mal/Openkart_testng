package Testing_practice;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


public class Validate_Search {

    WebDriver driver;

   // @BeforeTest
   // public void beforeTest() throws InterruptedException {

       // driver = new ChromeDriver();

       // driver.manage().window().maximize();

       // driver.get("https://www.tirabeauty.com/");

        //Thread.sleep(5000);
  //  }

    @DataProvider(name = "searchData")
    public Object[][] data() {
        return new Object[][]{
                {"iphmr"},
                {"578695"},
                {"!@#$%^&"},
                {"shadgjhsa766543"},
                {"Mobile"},
                {"Hp"},
                {"3 star rated"},
                {"under 1000"},
                {"20% discount"}
        };
    }

    @Test(dataProvider = "searchData")
    public void validateSearch(String keyword)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")));

        WebElement searchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("nav-search-submit-button")));

        Assert.assertTrue(searchBtn.isEnabled(),
                "Search button not clickable");

        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchBtn.click();

        System.out.println("Searched: " + keyword);

        Thread.sleep(2000);

        driver.quit();
    }
}