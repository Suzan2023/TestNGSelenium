package CW.tests.Day17;

import CW.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_DriverClass {


    @Test
    public void test01(){
        //driver objesi kullanmak istedigimizde Driver class inin getDriver methoduyla driver imizi alabiliriz.

        Driver.getDriver().get("https://www.amazon.com/");
        String title = Driver.getDriver().getTitle();

        Assert.assertTrue(title.contains("Amazon"));

        Driver.closeDriver();


    }
}
