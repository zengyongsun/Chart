package com.zy.chart;

/**
 * Created by Administrator on 2017/6/28.
 */

public class StartBean {

    private String description;//描述
    private Class<?> activity;

    public StartBean(String description, Class<?> activity) {
        this.description = description;
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }
}
