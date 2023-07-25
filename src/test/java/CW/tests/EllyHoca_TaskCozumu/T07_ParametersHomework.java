package CW.tests.EllyHoca_TaskCozumu;


import CW.utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T07_ParametersHomework extends Base {
/*
Go to URL: https://www.amazon.com
Search words: Java, Selenium
Assert get text result est that the result text contains the searched Word.
Run tests from XML file.
  */

    @Test
    @Parameters("searchWords") //xml den alacagi parametrenin adi buraya yazilir
    public void test(String kelime) {  // parametre alabilir hale getirilir
        // go to url : https://www.amazon.com
        driver.get("https://www.amazon.com");
        // search words : java, selenium
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(kelime + Keys.ENTER);
        // assert get text result est that the result text contains the searched word
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("sonucYaziElementi.getText() = " + sonucYaziElementi.getText());
        Assert.assertTrue(sonucYaziElementi.getText().contains(kelime));
    }
}
