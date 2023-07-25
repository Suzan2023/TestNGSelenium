package CW.tests.EllyHoca_TaskCozumu;

import CW.utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class T06_DataProviderHomework3 extends Base {

/*
Open the site: http://opencart.abstracta.us/index.php?route=account/login
Login with that credentials
Email: claruswayTest@gmail.com
Password: test_password
Using the Search function do it with Data Provider for Mac, iPhone and Samsung.
*/


    @Test(dataProvider = "getData")
    public void test01(String devices) throws InterruptedException {

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("claruswayTest@gmail.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("test_password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
        Thread.sleep(2000);
        searchBox.sendKeys(devices + Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='image']"));

        System.out.println("productList = " + productList);
        for (WebElement each : productList) {
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @DataProvider
    public Object[][] getData() {

        return new Object[][]{
                {"Mac"},
                {"iPhone"},
                {"Samsung"},};


    }
}