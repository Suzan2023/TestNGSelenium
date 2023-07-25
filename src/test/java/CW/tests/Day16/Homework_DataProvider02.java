package CW.tests.Day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_DataProvider02 {

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

    @Test(dataProvider = "data")
    public void test01(String username, String password) {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userN = driver.findElement(By.xpath("//input[@name='username']"));
        userN.sendKeys(username);

        WebElement passw = driver.findElement(By.xpath("//input[@name='password']"));
        passw.sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        WebElement invalidTxt = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        Assert.assertTrue(invalidTxt.isDisplayed(), "text is not displayed");
        driver.quit();
    }

    @DataProvider
    public Object[][] data() {
        Object[][] data = new Object[4][2];
        data[0] = new Object[]{"javacan", "admin123"};
        data[1] = new Object[]{"javacan", "Admin123"};
        data[2] = new Object[]{"javacan", "admin345"};
        data[3] = new Object[]{"javacan", "admin567"};
        return data;


    }
}
