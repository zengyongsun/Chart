package com.zy.chart.viewpage;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class ViewPagerAdapter extends PagerAdapter {

    List<View> data;

    public ViewPagerAdapter(List<View> data) {
        this.data = data;
    }

    public void setData(List<View> data) {
        this.data = data;
    }

    //viewpager中的要显示的View的总数量
    @Override
    public int getCount() {
        return data.size();
    }

    // 官方建议这样写
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // 滑动切换的时候销毁当前的View
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(data.get(position));
    }

    // 每次滑动的时候生成的View
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(data.get(position));
        return data.get(position);
    }
}
