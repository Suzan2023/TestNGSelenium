package CW.tests.Day14;

import org.testng.annotations.Test;

public class C06_Description {


// Test methodlarinin ne yaptigini aciklamak icin kullandigimiz attribute tur.default degeri ""

    @Test(
            description = "This is a description"
    )
    public void test01(){

        System.out.println("test01");

    }
}
