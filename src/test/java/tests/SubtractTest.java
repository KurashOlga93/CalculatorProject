package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.addition.Retry;

public class SubtractTest extends BaseTest {

    @DataProvider(name = "subtractIntegersData")
    public Object[][] subtractIntegersData() {
        return new Object[][] {
                {5,2,3},
                {-5, -2, -3},
                {1000, 2, 998},
                {0, 0, 0},
        };
    }

    @DataProvider(name = "subtractDoubleData")
    public Object[][] subtractDoubleData() {
        return new Object[][] {
                {5.2, 2.1, 3.1},
                {-5.45, -2, -3.45},
                {-0, 0, 0},
        };
    }

    @Test(dataProvider = "subtractIntegersData", description = "Subtract of integer numbers",
            priority = 1, invocationCount = 1, threadPoolSize = 1, retryAnalyzer = Retry.class)
    public void subtractIntegerTest(double x, double y, double expectedSubtract) {
        double actualSubtract = calculator.subtract(x,y);
        Assert.assertEquals(actualSubtract, expectedSubtract);
    }

    @Test(dataProvider = "subtractDoubleData", description = "Subtract of double numbers",
            priority = 2, invocationCount = 1, threadPoolSize = 1, retryAnalyzer = Retry.class)
    public void subtractDoubleTest(double x, double y, double expectedSubtract) {
        double actualSubtract = calculator.subtract(x,y);
        Assert.assertEquals(actualSubtract, expectedSubtract);
    }
}
