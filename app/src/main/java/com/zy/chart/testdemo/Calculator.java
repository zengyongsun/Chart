package com.zy.chart.testdemo;

/**
 * Created by Administrator on 2017/5/15.
 */

public class Calculator {

    public int add(int one, int another) {
        return one + another;
    }

    public int multiply(int one, int another) {
        return one * another;
    }

    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("除数不能为零");
        return divident / dividor;

    }

}
