package CW.tests.Day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Hard_SoftAssert_Homework {

    //Test Case1: Positive Login Test
    //Open page https://practicetestautomation.com/practice-test-login/
    //Type username student into Username field
    //Type password Password123 into Password field
    //Push Submit button.
    //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
    //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    //Verify button Log out is displayed on the new page.
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCase1() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));

        WebElement newPageText = driver.findElement(By.xpath("//p[@class='has-text-align-center']"));
        Assert.assertTrue(newPageText.getText().contains("Congratulations"));

        WebElement logButton = driver.findElement(By.partialLinkText("wp-block-button_"));
        Assert.assertTrue(logButton.isDisplayed());

    }
    @AfterClass
    public void tearDown () {
        driver.close();
    }
}
