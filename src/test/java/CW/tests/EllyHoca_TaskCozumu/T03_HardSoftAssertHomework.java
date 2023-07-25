package CW.tests.EllyHoca_TaskCozumu;

import CW.utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T03_HardSoftAssertHomework extends Base {
    //   Best Practice is to make the tests independent  : En İyi Uygulama, testleri bağımsız hale getirmektir
    /*
    Test Case1: Positive Login Test
    Open page https://practicetestautomation.com/practice-test-login/
    Type username student into Username field
    Type password Password123 into Password field
    Puch Submit button.
    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    Verify button Log out is displayed on the new page.
     */


    @Test
    public void testLoginHARD() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button#submit")).click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        WebElement successMessage = driver.findElement(By.tagName("strong"));
        String expectedMessage = "Congratulations student. You successfully logged in!";
        String actualMessage = successMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Actual message does not contain expected message.\nActual Message: " + actualMessage + "\nExpected Message: " + expectedMessage);
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible");
    }

    @Test
    public void testLoginSOFT() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button#submit")).click();

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

        WebElement successMessage = driver.findElement(By.tagName("strong"));
        String expectedMessage = "Congratulations student. You successfully logged in!";
        String actualMessage = successMessage.getText();

        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: " + actualMessage + "\nExpected Message: " + expectedMessage);
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        softAssert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible");

        softAssert.assertAll();
    }

    @Test
    public void negativeUsernameLoginSOFT() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button#submit")).click();

        SoftAssert softAssert = new SoftAssert();

        String expectedErrorMes = "Your username is invalid!";
        WebElement actualErrorMes = driver.findElement(By.cssSelector("div[id='error']"));
        softAssert.assertTrue(actualErrorMes.isDisplayed());
        softAssert.assertEquals(actualErrorMes.getText(), expectedErrorMes);
        softAssert.assertAll();
    }

    @Test
    public void negativePasswordeLoginSOFT() {

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("incorrectPassword");
        driver.findElement(By.cssSelector("button#submit")).click();

        SoftAssert softAssert = new SoftAssert();

        String expectedErrorMes = "Your password is invalid!";
        WebElement actualErrorMes = driver.findElement(By.cssSelector("div[id='error']"));
        softAssert.assertTrue(actualErrorMes.isDisplayed());
        softAssert.assertEquals(actualErrorMes.getText(), expectedErrorMes);

        softAssert.assertAll();
    }

}
