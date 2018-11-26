package com.zy.chart.jni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zy.chart.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NDKTestActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.sample_text)
    TextView sampleText;
    @BindView(R.id.two)
    TextView two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndktest);
        ButterKnife.bind(this);

        two.setText("10之后" + addNum() + "");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native int addNum();

    public int num = 10;
}
