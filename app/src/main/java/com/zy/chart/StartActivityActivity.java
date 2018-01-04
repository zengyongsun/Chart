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
import com.zy.chart.broadcast.BroadCastActivity;
import com.zy.chart.chart.MainChartActivity;
import com.zy.chart.coustomview.CustomViewActivity;
import com.zy.chart.linkman.LinkManActivity;
import com.zy.chart.loginEffect.LoginEffectActivity;
import com.zy.chart.popwindow.PopupWindowActivity;
import com.zy.chart.reuseview.activity.ReuseViewActivity;
import com.zy.chart.rxjava.RxJavaActivity;
import com.zy.chart.searchview.SearchViewActivity;
import com.zy.chart.selectHead.SelectHeadActivity;
import com.zy.chart.selectfile.SelectFileActivity;
import com.zy.chart.tablayout.TabLayoutActivity;

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
        data.add(new StartBean("选择头像及裁剪", SelectHeadActivity.class));
        data.add(new StartBean("自定义view的尝试", CustomViewActivity.class));
        data.add(new StartBean("组合自定义view", ReuseViewActivity.class));
        data.add(new StartBean("弹出窗口", PopupWindowActivity.class));
        data.add(new StartBean("RxJava试用", RxJavaActivity.class));
        data.add(new StartBean("侧滑菜单", MenuActivity.class));
        data.add(new StartBean("联系人相关", LinkManActivity.class));
        data.add(new StartBean("广播发送", BroadCastActivity.class));
        data.add(new StartBean("tabLayout +　ViewPager", TabLayoutActivity.class));
        data.add(new StartBean("搜索效果", SearchViewActivity.class));

        mStartAdapter.setNewData(data);
    }

}
