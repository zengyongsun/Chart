package com.zy.chart.shortcuts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2018/11/15 9:26
 * desc   :
 * version: 1.0
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = MyReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: " + intent);
        if (Intent.ACTION_LOCALE_CHANGED.equals(intent.getAction())) {
            // Refresh all shortcut to update the labels.
            // (Right now shortcut labels don't contain localized strings though.)
            new ShortcutHelper(context).refreshShortcuts(/*force=*/ true);
        }
    }
}
