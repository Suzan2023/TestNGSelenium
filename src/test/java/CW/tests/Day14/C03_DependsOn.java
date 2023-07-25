package CW.tests.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOn {

    // Depensonmethods attribute u icerisine {} arasinda test isimleri alir ve bu testler basirili olursa asil testimiz calisir

    @Test
    public void test01(){
        System.out.println("01");
    }

    @Test(
            dependsOnMethods = {"test01", "test03"}
    )
    public void test02(){
        System.out.println("02");  //test 2 nin calismasi 1 ve 3 un calismasina bagli.yani 1ve 3 calisirsa 2 calisir
    }

    @Test
    public void test03(){
        System.out.println("03");
        Assert.fail();
    }

    @Test
    public void test04(){
        System.out.println("04");
    }

}
