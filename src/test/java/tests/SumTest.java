package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.addition.Retry;

public class SumTest extends BaseTest {

    @DataProvider(name = "sumIntegersData")
    public Object[][] sumIntegersData() {
        return new Object[][]{
                {5, 2, 7},
                {-5, -2, -7},
                {1000, 2500, 3500},
                {55, 0, 55},
        };
    }

    @DataProvider(name = "sumDoubleData")
    public Object[][] sumDoubleData() {
        return new Object[][]{
                {5.3, 2.5, 7.8},
                {-5.2, -2.6, -7.800000000000001},
                {1000, 2.5, 1002.5},
                {5.55, 0, 5.55},
        };
    }

    @Test(dataProvider = "sumIntegersData", description = "Sum of integers test", priority = 1,
            invocationCount = 1, threadPoolSize = 1, retryAnalyzer = Retry.class)
    public void sumOfIntegersTest(double x, double y, double expectedSum) {
        double actualSum = calculator.sum(x, y);
        Assert.assertEquals(actualSum, expectedSum);
    }

    @Test(dataProvider = "sumDoubleData", description = "Sum of doubles test", priority = 2,
            invocationCount = 1, threadPoolSize = 1, retryAnalyzer = Retry.class)
    public void sumOfDoubleTest(double x, double y, double expectedSum) {
        double actualSum = calculator.sum(x, y);
        Assert.assertEquals(actualSum, expectedSum);
    }
}
