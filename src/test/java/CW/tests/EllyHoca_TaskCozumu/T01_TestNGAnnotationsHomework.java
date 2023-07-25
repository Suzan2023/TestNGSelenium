package CW.tests.EllyHoca_TaskCozumu;

import org.testng.annotations.*;

public class T01_TestNGAnnotationsHomework {
    /*
    Create a class.
    Create 2 test methods.
    Use TestNG annotations that can be used in the class.
    Interpret output in console.
     */
    @Test
    public void test1(){
        System.out.println("test case 1");
    }
    @Test
    public void test2(){
        System.out.println("test case 2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
/*
before suite
before test
before class
before method
test case 1
after method
before method
test case 2
after method
after class
after test
after suite
her zaman Suite'in yürütülmesinden başlar ve ardından yöntemin yürütülmesiyle sona erer. TestNG Ek Annotations bu şekilde kullanılır.
TestNG Annotations, test komut dosyasındaki yöntemlerin akışını kontrol etmek için kullanılan programa veya iş mantığına eklenen bir kod grubunu tanımlamak için kullanılır.
Selenium test komut dosyalarını daha yönetilebilir, sofistike ve etkili hale getirirler.
Bunları kullanmak, test edenler için son derece yararlıdır ve hayatlarını çok daha kolay hale getirir.
/*
     @BeforeClass -> // Her Classdan önce çalışacaklar buraya yazılıyor.
       @BeforeMethod -> //Her metod çalışmadan önce yapılacakları buraya yazıyoruz
           @Test -> // testimizin metodları
           @Test -> // testimizin metodları
       @AfterMethod  -> // Her metod çalıştıktan sonra yapılacakları buraya yazıyoruz.
     @AfterClass -> // Her class dan sonra yapıalcaklar buraya yazılıyor.
   */

}
