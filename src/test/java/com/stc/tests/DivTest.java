package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dependsOnGroups = "smoke-div", groups = {"div-group"})
public class DivTest {
    Calculator calc;

    @BeforeClass
    void setUp(){
        calc = new Calculator();
    }

    @Test(dataProvider = "userDataInt")
    public void naturalNumbers(String a, String b, double d){
        Assert.assertEquals(calc.division(a, b), d);
    }

    @Test (dataProvider = "userDataFraction")
    public void fractionalNumbers(String a, String b, Double d, Double delta) {
        Assert.assertEquals(calc.division(a,b), d, delta);
    }

    @Test(dataProvider = "userDataNull")
    public void divNullNull(String a, String b, double d){
        Assert.assertEquals(calc.division(a, b), d);
    }

    @Test(dataProvider = "userInvalidData", expectedExceptions = NumberFormatException.class)
    public void invalidValues(String a, String b, double d) {
        Assert.assertEquals(calc.division(a, b), d);
    }


    @DataProvider(name = "userDataInt")
    public Object[][] createData() {
        Double max = Double.MAX_VALUE;
        Double min = -Double.MAX_VALUE;
        return new Object[][] {
                {"2", "1", 2.0},
                {"0", "3", 0.0},
                {"-4", "2", -2.0},
                {"-6", "-3", 2.0},
                {" 4", " 5 ", 0.8},
                {max.toString(), min.toString(), -1.0},
        };
    }

    @DataProvider(name = "userDataFraction")
    public Object[][] createDataF() {
        double DELTA = 0.00000000000001;
        return new Object[][] {
                {"23.55", "5.03", 4.681908548707753, DELTA},
                {"-6.01", "-4.1", 1.4658536585365853, DELTA},
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
