package com.zy.chart.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

/**
 * <pre>
 *     author : Zeyo
 *     e-mail : zengyongsun@163.com
 *     time   : 2017/09/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public abstract class BaseTabLayoutActivity extends AppCompatActivity {

    protected ViewPagerAdapter mPagerAdapter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        Logger.d("BaseTabLayoutActivity");
    }

    /**
     * 设置 PageAdapter 数据
     */
    public abstract void setPagerAdapterData();

}
