package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SumTest {

    @Test
    public void naturalNumbers() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum("1", "2"), 3.0);
    }

    @Test
    public void negativeNumbers() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum("-1", "-2"), -3.0);
    }

}
