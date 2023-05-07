package CW.tests.Day15;

import org.testng.annotations.Test;

public class C01_Groups {

    @Test(groups ={"smoke"})
    public void smokeTest(){
        System.out.println("Smoke test is running");
    }

    @Test(groups = {"regression"})
    public void regressionTest(){
        System.out.println("Regression test is running");
    }
    @Test(groups = {"smoke", "regression"})
    public void smokeRegressionTest(){
        System.out.println("Smoke and Regression test is running");
    }
}
