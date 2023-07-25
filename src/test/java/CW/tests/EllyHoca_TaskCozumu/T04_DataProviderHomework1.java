package CW.tests.EllyHoca_TaskCozumu;

import CW.utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T04_DataProviderHomework1 extends Base {
    /*
    @DataProvider bir TestNG annotation’idir.
    Dolayisiyla sadece TestNG ile kullanilir.
    Veri sağlamak için kullanılır/ TestNG'deki verilerin listesini almak için kullanılır
    DDT (Data Driven Test) yapilir
    Cucumber’daki Scenario Outline ile ayni isleve sahiptir
    DataProvider ile bir yöntemden test yöntemine veri nasıl geçirilir?
  - Test yönteminde dataProvider kullanın ve acıklamayı yöntem adına eşit olarak ayarlayın
       name ="alternative name" kullanarak alternatif isim verebiliriz.
     */

    /*
    Open the site: https://www.amazon.com/
    Search the following keys with DataProvider:
    Java
    JavaScript
    Phyton
     */

    @Test(dataProvider = "aranacakKelimeler")
    public void amazonAramaTesti1(String kelime) {
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime + Keys.ENTER);

    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        String data[][] = {{"Java"}, {"JavaScript"}, {"Pyhton"}};
        return data;
    }

    @Test(dataProvider = "getData")
    public void amazonAramaTesti2(String datas) {

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(datas + Keys.ENTER);

        WebElement resultText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        Assert.assertTrue(resultText.getText().contains(datas));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Java"},
                {"JavaScript"},
                {"Python"}
        };
    }

    @Test(dataProvider = "data")
    public void amazonAramaTesti3(String language) {
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(language + Keys.ENTER);
    }

    @DataProvider
    public Object[][] data() {
        Object[][] data = new Object[3][1];
        data[0] = new Object[]{"java"};
        data[1] = new Object[]{"JavaScript"};
        data[2] = new Object[]{"Python"};
        return data;
    }

}
