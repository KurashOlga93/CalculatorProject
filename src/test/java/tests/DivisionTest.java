package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.addition.Retry;

public class DivisionTest extends BaseTest {

    @DataProvider(name = "divisionIntegersData")
    public Object[][] divisionIntegersData() {
        return new Object[][] {
                {10,2,5},
                {-5, -2, 2.5},
                {1000, 2, 500},
        };
    }

    @DataProvider(name = "divisionDoubleData")
    public Object[][] divisionDoubleData() {
        return new Object[][] {
                {10.5,2,5.25},
                {-5.5, -2.5, 2.2},
                {118.34, 2.5, 47.336},
        };
    }

    @DataProvider(name = "divisionOfZeroData")
    public Object[][] divisionOfZeroData() {
        return new Object[][] {
                {118.34, 0, 0},
                {4, 0, 0},
        };
    }

    @Test(dataProvider = "divisionIntegersData", description = "Division of integer numbers",
            priority = 1, invocationCount = 2, threadPoolSize = 2, retryAnalyzer = Retry.class)
    public void integerDivisionTest(double x, double y, double expectedDivision) {
        double actualDivision = calculator.division(x,y);
        Assert.assertEquals(actualDivision, expectedDivision );
    }

    @Test(dataProvider = "divisionDoubleData", description = "Division of integer numbers",
            priority = 2, invocationCount = 3, threadPoolSize = 1, retryAnalyzer = Retry.class)
    public void doubleDivisionTest(double x, double y, double expectedDivision) {
        double actualDivision = calculator.division(x,y);
        Assert.assertEquals(actualDivision, expectedDivision );
    }

    @Test(dataProvider = "divisionOfZeroData", description = "Division of integer numbers",
            priority = 1, invocationCount = 1, threadPoolSize = 2, retryAnalyzer = Retry.class)
    public void zeroDivisionTest(double x, double y, double expectedDivision) {
        double actualDivision = calculator.division(x,y);
        Assert.assertEquals(actualDivision, expectedDivision );
    }
}
