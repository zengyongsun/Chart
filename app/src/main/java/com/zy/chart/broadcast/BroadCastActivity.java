package com.zy.chart.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zy.chart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadCastActivity extends AppCompatActivity {

    @BindView(R.id.button) Button button;
    private TestReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        ButterKnife.bind(this);
        receiver = new TestReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("can");
        registerReceiver(receiver, filter);
    }

    @OnClick(R.id.button) public void onViewClicked() {
        //带有参数就是Filter的action
        Intent intent = new Intent("can");
        sendBroadcast(intent);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
