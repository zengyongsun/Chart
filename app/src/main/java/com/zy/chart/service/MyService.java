package com.zy.chart.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2018/11/26 13:31
 * desc   :
 * version: 1.0
 */
public class MyService extends Service {

    public static final String TAG = MyService.class.getSimpleName();

    public MyService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
         Log.d(TAG, "onCreate ==> 调用了");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
         Log.d(TAG, "onStart ==> 调用了");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand ==> 调用了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy ==> 调用了");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mService;
    }

    public void sayHello(){
         Log.d(TAG, "sayHello ==> 调用了");
    }

    Binder mService = new Binder();

}
