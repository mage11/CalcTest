package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dependsOnGroups = "smoke-diff", groups = {"diff-group"})
public class DiffTest {
    Calculator calc;

    @BeforeClass
    void setUp(){
        calc = new Calculator();
    }

    @Test(dataProvider = "userDataInt")
    public void naturalNumbers(String a, String b, double d){
        Assert.assertEquals(calc.difference(a, b), d);
    }

    @Test(dataProvider = "userDataF")
    public void fractionalNumbers(String a, String b, double d, double delta){
        Assert.assertEquals(calc.difference(a, b), d, delta);
    }

    @Test(dataProvider = "userInvalidData", expectedExceptions = NumberFormatException.class)
    public void invalidValues(String a, String b, double d) {
        Assert.assertEquals(calc.difference(a, b), d);
    }

    @DataProvider(name = "userDataInt")
    public Object[][] createData() {
        Double max = Double.MAX_VALUE;
        Double min = -Double.MAX_VALUE;
        return new Object[][] {
                {"2", "1", 1.0},
                {"0", "3", -3.0},
                {"-4", "2", -6.0},
                {"-7", "-3", -4.0},
                {max.toString(), min.toString(), Double.POSITIVE_INFINITY},
        };
    }

    @DataProvider(name = "userDataF")
    public Object[][] createDataF() {
        double DELTA = 0.00000000000001;
        return new Object[][] {
                {"5.23", "3.23", 2.0, DELTA},
                {"0", "3.56", -3.56, DELTA},
                {"5", "4.87", 0.13, DELTA},
                {"-4.423", "5.1", -9.523, DELTA},
                {"4.78576893999999999999","6.28576893985199999999", -1.4999999998520002, DELTA},
                {"-6.23", "-7.66", 1.43, DELTA}
        };
    }

    @DataProvider(name = "userInvalidData")
    public Object[][] createInvalidData() {
        return new Object[][] {
                {"a", "b", 0},
                {"4", "c", 0},
                {".", "?", 0},
                {",", "@", 0},
                {"4,5", "6", 0},
                {"\\","!", 0 },
                {" ", "/", 0},
                {"", "", 0},
                {"0EFBC3C515", "0EFBC3C515", 0}
        };
    }
}
