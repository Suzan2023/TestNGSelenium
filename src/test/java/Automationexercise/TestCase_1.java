package Automationexercise;

import CW.utilities.Base;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_1 extends Base {
    /*1. Launch browser
2. Navigate to url 'https://automationexercise.com/'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/

    @Test
    public void testCase1() {
        //go to http://automationexercise.com
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).getText().contains("New User Signup!"));

        //   6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Suzan G");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("suzan5@gmail.com");

        //   7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Enter Account Information']")).getText().contains("ENTER ACCOUNT INFORMATION"));

        //  9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MyPassword");

        WebElement selectDays = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(selectDays);
        select.selectByIndex(10);
        WebElement selectMonths = driver.findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(selectMonths);
        select2.selectByIndex(2);
        WebElement selectYears = driver.findElement(By.xpath("//select[@id='years']"));
        Select select3 = new Select(selectYears);
        select3.selectByValue("1981");
        //    10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Suzan");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Goger");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("US");

        WebElement counrty = driver.findElement(By.xpath("//select[@id='country']"));
        Select select4 = new Select(counrty);
        select4.selectByIndex(2);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Florida");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Florida");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("752000000");

    //    13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    //    14. Verify that 'ACCOUNT CREATED!' is visible
       WebElement isVisible=driver.findElement(By.xpath("//b[.='Account Created!']"));
      Assert.assertTrue(isVisible.isDisplayed());

     //   15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    //    16. Verify that 'Logged in as username' is visible


    }

}
