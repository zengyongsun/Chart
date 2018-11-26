package com.zy.chart.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.zy.chart.R;

import butterknife.OnClick;

public class ServiceTestActivity extends Activity {

    private Intent intentBinder;
    private Intent intentStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        butterknife.ButterKnife.bind(this);
    }


    @OnClick(R.id.binder)
    public void onBinderClicked() {
        intentBinder = new Intent(this, MyService.class);
        bindService(intentBinder, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @OnClick(R.id.start)
    public void onStartClicked() {
        intentStart = new Intent(this, MyService.class);
        startService(intentStart);
    }

    MyService myService = null;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = (MyService) service;
            myService.sayHello();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @OnClick(R.id.stop)
    public void onStopClicked() {
        stopService(intentStart);
    }


}
