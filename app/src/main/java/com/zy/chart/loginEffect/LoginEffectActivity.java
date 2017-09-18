package com.zy.chart.loginEffect;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zy.chart.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginEffectActivity extends AppCompatActivity {

    @BindView(R.id.login_recycler_view) RecyclerView loginRecyclerView;
    @BindView(R.id.iv_left) ImageView ivLeft;
    @BindView(R.id.iv_right) ImageView ivRight;
    private LoginEffectAdapter mAdapter;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_effect);
        ButterKnife.bind(this);
        mContext = this;
        init();
    }

    private void init() {
        List<LoginBean> list = initData();
        loginRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new LoginEffectAdapter(R.layout.login_effect_item);
        loginRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(list);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mAdapter.setNewData(changeSelect(position));
            }
        });
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

    @OnClick({R.id.iv_left, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                if (selectIndex() > 0) {
                    mAdapter.setNewData(changeSelect(selectIndex() - 1));
                    loginRecyclerView.smoothScrollToPosition(selectIndex());
                } else {
                    Toast.makeText(mContext, "没有前一个了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_right:
                if (selectIndex() < mAdapter.getData().size() - 1) {
                    mAdapter.setNewData(changeSelect(selectIndex() + 1));
                    loginRecyclerView.smoothScrollToPosition(selectIndex());
                } else {
                    Toast.makeText(mContext, "没有下一个了", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 选中的头像,修改数据
     *
     * @param position 选中的位置
     */
    private List<LoginBean> changeSelect(int position) {
        List<LoginBean> old = mAdapter.getData();
        for (int i = 0; i < old.size(); i++) {
            if (i == position) {
                old.get(i).setSelect(true);
            } else {
                old.get(i).setSelect(false);
            }
        }
        return old;
    }

    /**
     * 获取当前选中的位置
     */
    private int selectIndex() {
        List<LoginBean> list = mAdapter.getData();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelect()) {
                return i;
            }
        }
        return 0;
    }

}
