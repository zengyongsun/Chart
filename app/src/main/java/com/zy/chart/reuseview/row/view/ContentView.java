package com.zy.chart.reuseview.row.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zy.chart.reuseview.row.bean.RowGroupDescription;
import com.zy.chart.reuseview.row.imp.RowGeneralClickListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/20.
 */

public class ContentView extends LinearLayout {

    private Context context;

    public ContentView(Context context) {
        super(context);
        init(context);
    }

    public ContentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ContentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        this.context = context;
    }

    public void initData(ArrayList<RowGroupDescription> group, RowGeneralClickListener listener) {
        if (group != null && group.size() > 0) {
            setVisibility(VISIBLE);
            RowGroupView groupView = null;
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = 20;
            for (int i = 0; i < group.size(); i++) {
                groupView = new RowGroupView(context);
                groupView.initData(group.get(i), listener);
                groupView.notifyDataChanged();
                groupView.setLayoutParams(params);
                addView(groupView);
            }

        } else {
            setVisibility(GONE);
        }

    }

}
