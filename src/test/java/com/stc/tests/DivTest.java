package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {
    @Test(dataProvider = "userDataInt")
    public void naturalNumbers(String a, String b, double d){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.division(a, b), d);
    }

    @Test (dataProvider = "userDataFraction")
    public void fractionalNumbers(String a, String b, Double d, Double delta) {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.division(a,b), d, delta);
    }
    
    @Test(dataProvider = "userDataNull")
    public void divNullNull(String a, String b, double d){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.division(a, b), d);
    }


    @DataProvider(name = "userDataInt")
    public Object[][] createData() {
        Double max = Double.MAX_VALUE;
        Double min = Double.MIN_VALUE;
        return new Object[][] {
                {"2", "1", 2.0},
                {"0", "3", 0.0},
                {"-4", "2", -2.0},
                {"-6", "-3", 2.0},
                {max.toString(), min.toString(), -1.0},
        };
    }

    @DataProvider(name = "userDataFraction")
    public Object[][] createDataF() {
        double DELTA = 0.00000000000001;
        return new Object[][] {
                {"23.55", "5.03", 4.88071570577, DELTA},
                {"-6.01", "-4.1", 1.46585365854, DELTA},
                {"5.01", "-5.01", -1.0, DELTA},
                {"0", "0.55", 0.0, DELTA}
        };
    }

    @DataProvider(name = "userDataNull")
    public Object[][] createDataNull() {
        return new Object[][] {
                {"1", "0", Double.POSITIVE_INFINITY},
                {"0", "0", Double.NaN}
        };
    }
}