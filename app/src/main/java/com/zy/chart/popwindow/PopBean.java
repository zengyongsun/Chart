package com.zy.chart.popwindow;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PopBean implements BaseBean {

    private String showName;
    private String showValue;
    private boolean select;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public PopBean(String showName, String showValue, boolean select) {
        this.showName = showName;
        this.showValue = showValue;
        this.select = select;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowValue() {
        return showValue;
    }

    public void setShowValue(String showValue) {
        this.showValue = showValue;
    }

    @Override
    public String getName() {
        return getShowName();
    }

    @Override
    public String getValue() {
        return getShowValue();
    }

    @Override
    public boolean getSelect() {
        return isSelect();
    }

    @Override
    public void setSelectValue(boolean select) {
        this.select = select;
    }

}
