package com.zy.chart.reuseview.row.bean;

import android.support.annotation.DrawableRes;

/**
 * Created by Administrator on 2017/7/19.
 */

public class RowDescription {

    @DrawableRes
    public int imageLeft;

    public String label;

    @DrawableRes
    public int imageRight;

    public RowGeneralType type;

    public RowDescription(int imageLeft, String label, int imageRight, RowGeneralType type) {
        this.imageLeft = imageLeft;
        this.label = label;
        this.imageRight = imageRight;
        this.type = type;
    }
}
