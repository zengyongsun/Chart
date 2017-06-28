package com.zy.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivityActivity extends AppCompatActivity {

    @BindView(R.id.top_imageView) ImageView topImageView;
    @BindView(R.id.top_textView) TextView topTextView;
    @BindView(R.id.start_recycler) RecyclerView startRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {



    }
}
