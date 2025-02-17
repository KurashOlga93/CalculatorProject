package tests;

import app.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.addition.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    Calculator calculator;

    @BeforeMethod
    public void initTest() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void after(){
        System.out.println("End test success.");
    }
}
