package CW.tests.Day14;

import CW.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Homework_TestngAnnotations {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test is runing...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test is runing...");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class is runing...");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After class is runing...");
    }

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get("https://www.patika.dev/tr");
        System.out.println("patika.dev'e gidildi");
        Driver.getDriver().findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();
        System.out.println("dersler sekmesine tiklandi");

    }


    @Test
    public void test02() {
        Driver.getDriver().get("https://amazon.com/");
        System.out.println("amazon'a gidildi");
        Driver.getDriver().quit();
    }

}
