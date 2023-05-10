package CW.tests.Day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Parameters_Homework {


//    Go to URL: https://www.amazon.com
//Search words: Java, Selenium
//Assert get text result est that the result text contains the searched Word.
//Run tests from XML file.

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    @Parameters("searchwords")
    public void test01(String searchwords) {
        driver.get("https://www.amazon.com");
        WebElement searchWords = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchWords.sendKeys(searchwords);
        searchWords.submit();

        WebElement textResult = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(textResult.getText().contains(searchwords));

    }

    @Test
    @Parameters("searchwords1")
    public void test02(String searchwords1) {

        driver.get("https://www.amazon.com");
        WebElement searchWords = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchWords.sendKeys(searchwords1);
        searchWords.submit();

        WebElement textResult = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(textResult.getText().contains(searchwords1));


    }
    }

