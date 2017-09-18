package com.zy.chart.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Zeyo on 2017-09-12 16:12
 * Description
 */

public class TestReceiver extends BroadcastReceiver {

    //BroadcastReceiver的生命周期只有10秒左右，不能再里面做一些耗时的操作
    @Override public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "启动了广播", Toast.LENGTH_SHORT).show();
    }
}
