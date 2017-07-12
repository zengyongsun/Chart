package com.zy.chart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zy.chart.chart.MainChartActivity;
import com.zy.chart.loginEffect.LoginEffectActivity;
import com.zy.chart.selectfile.SelectFileActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivityActivity extends AppCompatActivity {

    @BindView(R.id.top_imageView) ImageView topImageView;
    @BindView(R.id.top_textView) TextView topTextView;
    @BindView(R.id.start_recycler) RecyclerView startRecycler;
    private StartAdapter mStartAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
        ButterKnife.bind(this);
        mContext = this;
        initView();
        initData();
    }

    private void initView() {
        topImageView.setVisibility(View.GONE);
        topTextView.setText("主列表");
        startRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mStartAdapter = new StartAdapter(R.layout.adapter_start_item);
        startRecycler.setAdapter(mStartAdapter);
        mStartAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                StartBean bean = (StartBean) adapter.getData().get(position);
                Intent intent = new Intent(mContext, bean.getActivity());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        List<StartBean> data = new ArrayList<>();
        data.add(new StartBean("图标的展示，以及设置方式", MainChartActivity.class));
        data.add(new StartBean("文本打开方式尝试", SelectFileActivity.class));
        data.add(new StartBean("一种奇葩的登录方式", LoginEffectActivity.class));

        mStartAdapter.setNewData(data);
    }

}
