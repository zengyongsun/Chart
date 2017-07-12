package com.zy.chart.loginEffect;

/**
 * Created by Administrator on 2017/7/11.
 */

public class LoginBean {

    private String name;

    private String img;

    private boolean select;

    public LoginBean(String name, boolean select) {
        this.name = name;
        this.select = select;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
