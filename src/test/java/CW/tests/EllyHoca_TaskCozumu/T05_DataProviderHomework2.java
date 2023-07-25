package CW.tests.EllyHoca_TaskCozumu;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class T05_DataProviderHomework2 {
//    Go to URL: https://opensource-demo.orangehrmlive.com/
//    Login with negative credentilas by Data Provider.
//    Then assert that ‘’Invalid credentials’’ is displayed.


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "getData_faker")
    public void test(String username, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("//input[@name ='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        // Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text)")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText(), "Invalid credentials");
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"admin*", "admin123"},
                {"admin12", "123345"},
                {"Admin", "098"},
                {"test", "123"},
                {"user", "0**"}
        };
    }

    @DataProvider
    public Object[][] getData_faker() {
        Object[][] data = new Object[3][2];
        Faker faker_data = new Faker();
        data[0] = new Object[]{faker_data.name().username(), faker_data.internet().password()};
        data[1] = new Object[]{faker_data.name().username(), faker_data.internet().password()};
        data[2] = new Object[]{faker_data.name().username(), faker_data.internet().password()};
        return data;
    }
}
