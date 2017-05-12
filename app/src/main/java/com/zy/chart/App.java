package com.zy.chart;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/5/11.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init();
    }
}
