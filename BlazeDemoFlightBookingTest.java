package BlazeDemo_Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BlazeDemoFlightBookingTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");
    }

    @Test(priority = 1)
    public void searchFlight() {

        Select fromCity = new Select(driver.findElement(By.name("fromPort")));
        fromCity.selectByVisibleText("Boston");

        Select toCity = new Select(driver.findElement(By.name("toPort")));
        toCity.selectByVisibleText("London");

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        String pageTitle = driver.findElement(By.tagName("h3")).getText();

        Assert.assertTrue(pageTitle.contains("Flights from Boston to London"),
                "Flight search failed!");
    }

    @Test(priority = 2)
    public void chooseFlight() {

        driver.findElement(
                By.xpath("(//input[@value='Choose This Flight'])[1]"))
                .click();

        String reservePage = driver.findElement(By.tagName("h2")).getText();

        Assert.assertTrue(reservePage.contains("Your flight"),
                "Flight selection failed!");
    }

    @Test(priority = 3)
    public void purchaseFlight() {

        driver.findElement(By.id("inputName"))
                .sendKeys("Ayan Mal");

        driver.findElement(By.id("address"))
                .sendKeys("Tarakeswar");

        driver.findElement(By.id("city"))
                .sendKeys("Hooghly");

        driver.findElement(By.id("state"))
                .sendKeys("West Bengal");

        driver.findElement(By.id("zipCode"))
                .sendKeys("712410");

        Select cardType = new Select(
                driver.findElement(By.id("cardType")));
        cardType.selectByVisibleText("Visa");

        WebElement cardNumber =
                driver.findElement(By.id("creditCardNumber"));
        cardNumber.clear();
        cardNumber.sendKeys("4111111111111111");

        WebElement month =
                driver.findElement(By.id("creditCardMonth"));
        month.clear();
        month.sendKeys("12");

        WebElement year =
                driver.findElement(By.id("creditCardYear"));
        year.clear();
        year.sendKeys("2028");

        WebElement cardName =
                driver.findElement(By.id("nameOnCard"));
        cardName.clear();
        cardName.sendKeys("Ayan Mal");

        driver.findElement(By.id("rememberMe")).click();

        driver.findElement(
                By.xpath("//input[@value='Purchase Flight']"))
                .click();

        String confirmation =
                driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(
                confirmation,
                "Thank you for your purchase today!",
                "Booking failed!");
    }

    @Test(priority = 4)
    public void verifyBookingDetails() {

        String id =
                driver.findElement(
                        By.xpath("//td[text()='Id']/following-sibling::td"))
                        .getText();

        Assert.assertFalse(id.isEmpty(),
                "Booking ID not generated!");

        System.out.println("Booking ID: " + id);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}