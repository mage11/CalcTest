package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyTest {
    @Test(dataProvider = "userDataInt")
    public void naturalNumbers(String a, String b, double d) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.multiplication(a, b), d);
    }

    @Test(dataProvider = "userDataF")
    public void fractionalNumbers(String a, String b, double d, double delta) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.multiplication(a, b), d, delta);
    }

    @Test(dataProvider = "userInvalidData", expectedExceptions = NumberFormatException.class)
    public void invalidValues(String a, String b, double d) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.multiplication(a, b), d);
    }

    @DataProvider(name = "userDataInt")
    public Object[][] createData() {
        Double max = Double.MAX_VALUE;
        Double min = -Double.MAX_VALUE;
        return new Object[][] {
                {"1", "2", 2.0},
                {"0", "3", 0.0},
                {"-4", "5", -20.0},
                {"-6", "-7", 42.0},
                {"0", "0", 0.0},
                {max.toString(), "2", Double.POSITIVE_INFINITY},
                {min.toString(), "2", -Double.POSITIVE_INFINITY}
        };
    }

    @DataProvider(name = "userDataF")
    public Object[][] createDataF() {
        double DELTA = 0.00000000000001;
        return new Object[][] {
                {"1.23", "3.33", 4.0959, DELTA},
                {"0", "3.56", 0.0, DELTA},
                {"-4.423", "5.1", -22.5573, DELTA},
                {"-6.23", "-7.66", 47.7218, DELTA},
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
