package com.zy.chart.viewpage;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.zy.chart.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        initView();
    }

    private void initView() {

        LayoutInflater lf = LayoutInflater.from(this);
        View one = lf.inflate(R.layout.view_pager_one, null);
        View two = lf.inflate(R.layout.view_pager_two, null);

        List<View> list = new ArrayList<>();
        list.add(one);
        list.add(two);

        ViewPagerAdapter adapter = new ViewPagerAdapter(list);

        viewPager.setAdapter(adapter);

    }
}
