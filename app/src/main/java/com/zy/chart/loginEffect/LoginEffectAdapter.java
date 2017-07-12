package com.zy.chart.loginEffect;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.zy.chart.R;

/**
 * Created by Administrator on 2017/7/11.
 */

public class LoginEffectAdapter extends BaseQuickAdapter<LoginBean, BaseViewHolder> {

    public LoginEffectAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, LoginBean item) {
        helper.setText(R.id.tv_item_name, item.getName());
//        helper.setImageResource(R.id.iv_item_image,item.getImg());
        Logger.d("getLayoutPosition" + helper.getLayoutPosition());
        ImageView imageView = helper.getView(R.id.iv_item_image);
        if (item.isSelect()) {
            imageView.setLayoutParams(new ViewGroup.LayoutParams(60,60));
        } else {
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        }

    }


}
