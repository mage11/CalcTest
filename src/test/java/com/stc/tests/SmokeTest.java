package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test(groups = {"smoke"})
    public void smokeNull(){
        Calculator calc = new Calculator();
        Assert.assertNotNull(calc);
    }

    @Test(dependsOnMethods = "smokeNull", groups = {"smoke"})
    public void smokeSum(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sum("1", "2"), 3.0);
    }

    @Test(dependsOnMethods = "smokeNull", groups = {"smoke"})
    public void smokeMul(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.multiplication("3", "2"), 6.0);
    }

    @Test(dependsOnMethods = "smokeNull",groups = {"smoke"})
    public void smokeDiv(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.division("4", "2"), 2.0);
    }

    @Test(dependsOnMethods = "smokeNull",groups = {"smoke"})
    public void smokeDiff(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.difference("2", "1"), 1.0);
    }

    @Test(dependsOnMethods = "smokeNull",groups = {"smoke"})
    public void divNull(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.division("1", "0"), Double.POSITIVE_INFINITY);
    }

}
