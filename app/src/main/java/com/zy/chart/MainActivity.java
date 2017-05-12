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

import com.orhanobut.logger.Logger;

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
                Intent intent = new Intent(mContext, SimpleDrawActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,ShapeSelectActivity.class);
//                startActivity(intent);
                Logger.d(text.getText());
            }
        });

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);

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
                tv.setText(s);
//                Logger.d(s);
            }
        });
    }
}
