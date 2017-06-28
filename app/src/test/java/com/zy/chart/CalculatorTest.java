package com.zy.chart;

import com.zy.chart.testdemo.Calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/15.
 */

public class CalculatorTest {

    Calculator mCalculator;

    @Before
    public void setup(){
        mCalculator = new Calculator();
    }

    @Test
    public void testAdd(){
        int sum = mCalculator.add(3,4);
        Assert.assertEquals(7,sum);
    }

    @Test
    public void testMultiply(){
        testAdd();
        int sum = mCalculator.multiply(3,4);
        Assert.assertEquals(12,sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivide(){
        mCalculator.divide(4,0);
    }

}
