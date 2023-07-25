package CW.tests.Day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_DataProvider03 {
    //   Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "data")
    public void test01(String datas) {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("clarusway@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(datas + Keys.ENTER);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Mac"}, {"Ipad"}, {"Samsung"}
        };
    }

    @AfterMethod
    public void teardown() {
         driver.quit();
    }


}
