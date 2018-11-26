package com.zy.chart.shortcuts;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2018/11/15 9:17
 * desc   :
 * version: 1.0
 */
public class Utils {

    private Utils() {
    }

    public static void showToast(final Context context, final String message) {
//        new Handler(Looper.getMainLooper()).post(() -> {
//            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//        });

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
