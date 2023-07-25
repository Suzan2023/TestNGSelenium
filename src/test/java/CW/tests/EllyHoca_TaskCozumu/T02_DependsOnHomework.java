package CW.tests.EllyHoca_TaskCozumu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T02_DependsOnHomework {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    /*
      DependsOnMethods test method'larinin calisma siralamasina karismaz
      Sadece bagli olan test, baglandigi testin sonucuna bakar
      baglandigi test PASSED olmazsa, baglanan test hic calismaz(ignore)
     */
    WebDriver driver;
    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void facebookTest(){
        driver.get("http://www.facebook.com");
    }
    @Test(dependsOnMethods="facebookTest")
    public void googleTest(){
        driver.get("http://www.google.com");
    }

    @Test(dependsOnMethods="googleTest")
    public void amazonTest(){
        driver.get("http://www.amazon.com");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
