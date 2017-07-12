package com.zy.chart;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Administrator on 2017/6/28.
 */

public class StartAdapter extends BaseQuickAdapter<StartBean, BaseViewHolder> {

    public StartAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, StartBean item) {
        helper.setText(R.id.tv_description, item.getDescription());
    }
}
