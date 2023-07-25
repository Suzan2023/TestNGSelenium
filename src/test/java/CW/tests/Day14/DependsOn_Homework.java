package CW.tests.Day14;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependsOn_Homework {

        //Create tests that depend on each other
//Create beforeClass and set up settings.
//By creating interdependent tests;
//First go to Facebook.
//Then go to Google depending on Facebook,
//Then go to Amazon depending on Google
//Close the driver.
        WebDriver driver;

        @BeforeClass
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
    public void test1(){
            driver.get("https://www.facebook.com/");
        }
        @Test(dependsOnMethods = {"test1"})
    public void test2() throws InterruptedException {
            Thread.sleep(2000);
            driver.get("https://www.google.com/");
        }
        @Test(dependsOnMethods = {"test2"})
    public void test3(){
            driver.get("https://www.amazon.com/");
        }

        @AfterClass
    public void tearDown(){
           driver.close();
        }
}
