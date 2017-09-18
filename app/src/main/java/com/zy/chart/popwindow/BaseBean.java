package com.zy.chart.popwindow;

/**
 * Created by Administrator on 2017/7/31.
 * 面向接口编程，所有的选择实体类都需要实现这个
 */

public interface BaseBean {
    String getName();

    String getValue();

    boolean getSelect();

    void setSelectValue(boolean select);
}
