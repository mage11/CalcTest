package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumTest {

    @Test(dataProvider = "userDataInt")
    public void naturalNumbers(String a, String b, Double d) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), d);
    }

    @Test (dataProvider = "userDataFraction")
    public void fractionalNumbers(String a, String b, Double d, Double delta) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), d, delta);
    }

    @Test (dataProvider = "userInvalidData", expectedExceptions = NumberFormatException.class )
    public void invalidValues(String a, String b, double d) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum(a,b), d);
    }

    @DataProvider(name = "userDataInt")
    public Object[][] createDataInt() {
        Double max = Double.MAX_VALUE;
        Double min = -Double.MAX_VALUE;
        return new Object[][] {
                {"1", "2", 3.0},
                {"-1", "-2", -3.0},
                {"5", "0", 5.0},
                {"1", "-7", -6.0},
                {"0", "0", 0.0},
                {max.toString(), max.toString(), Double.POSITIVE_INFINITY},
                {min.toString(), min.toString(), Double.NEGATIVE_INFINITY},
        };
    }

    @DataProvider(name = "userDataFraction")
    public Object[][] createDataF() {
        double DELTA = 0.00000000000001;
        return new Object[][] {
                {"23.55", "5.03", 28.58, DELTA},
                {"-6.01", "-4.1", -10.11, DELTA},
                {"5.01", "-5.01", 0.0, DELTA},
                {"1.23", "0", 1.23, DELTA}
        };
    }

    @DataProvider(name = "userInvalidData")
    public Object[][] createInvalidData() {
        return new Object[][] {
                {"a", "b", 0},
                {"4", "c", 0},
                {".", "?", 0},
                {"0EFBC3C515", "0EFBC3C515", 0}
        };
    }

}
