package CW.tests.Day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_DataProvider01 {

    //    Open the site: https://www.amazon.com/
//    Search the following keys with DataProvider:
//    Java
//    JavaScript
//    Phyton
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
        driver.get("https://www.amazon.com/");
        WebElement searchWords = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchWords.sendKeys(datas + Keys.ENTER);

    }

    @DataProvider
    public Object[][] data() {
        Object[][] data = new Object[3][1];
        data[0] = new Object[]{"Java"};
        data[1] = new Object[]{"JavaScript"};
        data[2] = new Object[]{"Phyton"};
        return data;
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
