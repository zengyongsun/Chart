package com.zy.chart.loginEffect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zy.chart.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginEffectActivity extends AppCompatActivity {

    @BindView(R.id.login_recycler_view) RecyclerView loginRecyclerView;
    private LoginEffectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_effect);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        List<LoginBean> list = initData();
        loginRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new LoginEffectAdapter(R.layout.login_effect_item);
        loginRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(list);

    }

    private List<LoginBean> initData() {
        List<LoginBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i == 2) {
                list.add(new LoginBean("姓名" + i, true));
            }
            list.add(new LoginBean("姓名" + i, false));
        }
        return list;
    }

}
