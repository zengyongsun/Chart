package com.zy.chart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.zy.chart.addEffect.MoreWindow;
import com.zy.chart.permission.PermissionActivity;
import com.zy.chart.selectHead.SelectHeadActivity;
import com.zy.chart.viewpage.ViewPageActivity;
import com.zy.chart.x5.WebViewX5Activity;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private EditText et;
    private TextView tv;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, SimpleDrawActivity.class);
                Intent intent = new Intent(mContext, PermissionActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,ShapeSelectActivity.class);
//                startActivity(intent);
                Intent intent = new Intent(mContext, WebViewX5Activity.class);
                startActivity(intent);
                Logger.d(text.getText());
            }
        });

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        tv.setText("onCreate");
//        tv.isShown();

        text = (TextView) findViewById(R.id.text);

        et.addTextChangedListener(new TextWatcher() {
            int i = 1;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Logger.d("CharSequence==" + s + "  start==" + start + "  before==" + before + "   count==" + count);

            }

            @Override
            public void afterTextChanged(Editable s) {
                text.setText(s.toString());
//                tv.setText(s);
//                Logger.d(s);
            }
        });

        findViewById(R.id.show_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoreWindow(v);
            }
        });

        findViewById(R.id.view_pager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPageActivity.class);
                startActivity(intent);
            }
        });

    }

    private MoreWindow mMoreWindow;

    private void showMoreWindow(View view) {
        if (null == mMoreWindow) {
            mMoreWindow = new MoreWindow(this);
            mMoreWindow.init();
        }

        mMoreWindow.showMoreWindow(view, 0);
        mMoreWindow.setmOnItemClickListener(new MoreWindow.OnItemClickListener() {
            @Override
            public void onItemClick(View v) {
                switch (v.getId()) {
                    case R.id.more_window_local:
                        Toast.makeText(mContext, "more_window_local", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more_window_online:
                        Intent intent = new Intent(MainActivity.this, SelectHeadActivity.class);
                        ReminderTargetBean bean = new ReminderTargetBean();
                        intent.putExtra("bean", bean);
                        startActivity(intent);

                        break;
                    case R.id.more_window_delete:
                        break;
                    case R.id.more_window_collect:
                        break;
                    case R.id.more_window_auto:
                        Toast.makeText(mContext, "more_window_auto", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more_window_external:
                        break;

                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText("onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv.setText("onDestroy");
    }
}
