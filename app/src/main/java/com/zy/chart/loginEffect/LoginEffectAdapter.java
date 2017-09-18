package com.zy.chart.loginEffect;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView textView = helper.getView(R.id.tv_item_name);
        textView.setText(item.getName());
//        helper.setImageResource(R.id.iv_item_image,item.getImg());
        Logger.d("getLayoutPosition" + helper.getLayoutPosition());
        ImageView imageView = helper.getView(R.id.iv_item_image);
        if (item.isSelect()) {
            // the special one.Scale Large
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setTextColor(Color.parseColor("#ff0000"));
        } else {
            // the rest.Scale small
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            textView.setTextColor(Color.parseColor("#757575"));
        }
    }

}
