package com.zy.chart.reuseview.row.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/20.
 */

public class RowGroupDescription {

    public String title;
    public ArrayList<RowDescription> groupDescriptions;

    public RowGroupDescription(ArrayList<RowDescription> groupDescriptions) {
        this.groupDescriptions = groupDescriptions;
    }

    public RowGroupDescription(String title, ArrayList<RowDescription> groupDescriptions) {
        this.title = title;
        this.groupDescriptions = groupDescriptions;
    }
}
