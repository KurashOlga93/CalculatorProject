package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.addition.Retry;

public class MultiplyTest extends BaseTest {

    @DataProvider(name = "multiplyIntegerData")
    public Object[][] multiplyIntegerData() {
        return new Object[][] {
                {5,2,10},
                {-5, -2, 10},
                {1000, 2, 2000},
                {4, 0, 0},
        };
    }

    @DataProvider(name = "multiplyDoubleData")
    public Object[][] multiplyDoubleData() {
        return new Object[][] {
                {5.3, 2.5, 13.25},
                {-5.2, 1, -5.2},
                {1000.1, 2.5, 2500.25},
        };
    }

    @Test(dataProvider = "multiplyIntegerData", description = "Multiply of integer numbers",
            priority = 1, invocationCount = 2, threadPoolSize = 2, retryAnalyzer = Retry.class)
    public void multiplyIntegerTest(double x, double y, double expectedMultiply) {
        double actualMultiply = calculator.multiply(x,y);
        Assert.assertEquals(actualMultiply, expectedMultiply);
    }

    @Test(dataProvider = "multiplyDoubleData", description = "Multiply of double numbers",
            priority = 2, invocationCount = 1, threadPoolSize = 1, retryAnalyzer = Retry.class)
    public void multiplyDoubleTest(double x, double y, double expectedMultiply) {
        double actualMultiply = calculator.multiply(x,y);
        Assert.assertEquals(actualMultiply, expectedMultiply);
    }
}
