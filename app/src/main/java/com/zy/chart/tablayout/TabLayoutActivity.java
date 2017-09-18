package com.zy.chart.tablayout;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.orhanobut.logger.Logger;
import com.zy.chart.R;
import com.zy.chart.tablayout.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends BaseTabLayoutActivity implements
    ItemFragment.OnListFragmentInteractionListener, ItemListDialogFragment.Listener,
    PlusOneFragment.OnFragmentInteractionListener {

    @BindView(R.id.tab_layout) TabLayout mTabLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);
        Logger.d("TabLayoutActivity");
        setPagerAdapterData();
    }

    @Override public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override public void onItemClicked(int position) {

    }

    @Override public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void setPagerAdapterData() {
        String[] tabNameArr = {"记录","联系","详情"};
        List<Fragment> fragmentList = new ArrayList<>();
        ItemFragment itemFragment = ItemFragment.newInstance(30);
        ItemListDialogFragment dialogFragment = ItemListDialogFragment.newInstance(30);
        PlusOneFragment plusOneFragment = PlusOneFragment.newInstance("one", "two");
        fragmentList.add(itemFragment);
        fragmentList.add(dialogFragment);
        fragmentList.add(plusOneFragment);
        mPagerAdapter.setAdapterData(tabNameArr,fragmentList);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
