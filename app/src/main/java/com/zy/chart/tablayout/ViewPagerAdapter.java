package com.zy.chart.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * <pre>
 *     author : Zeyo
 *     e-mail : zengyongsun@163.com
 *     time   : 2017/09/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    private String[] mTabNameArr;

    private Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override public int getCount() {
        if (mFragmentList == null) {
            return 0;
        }
        return mFragmentList.size();
    }

    @Override public CharSequence getPageTitle(int position) {
        return mTabNameArr[position];
    }

    public List<Fragment> getFragementList() {
        return mFragmentList;
    }

    public void setFragmentList(List<Fragment> mFragmentList) {
        this.mFragmentList = mFragmentList;
    }

    public String[] getTabNameArr() {
        return mTabNameArr;
    }

    public void setTabNameArr(String[] mTabNameArr) {
        this.mTabNameArr = mTabNameArr;
    }

    public void setAdapterData( String[] mTabNameArr, List<Fragment> mFragmentList) {
        setTabNameArr(mTabNameArr);
        setFragmentList(mFragmentList);
    }

}
