package com.zy.chart.reuseview.row.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.zy.chart.reuseview.row.bean.RowGroupDescription;
import com.zy.chart.reuseview.row.imp.RowGeneralClickListener;

/**
 * Created by Administrator on 2017/7/19.
 */

public class RowGroupView extends LinearLayout {

    private RowGroupDescription rowGroupDescription;
    private Context context;
    private RowGeneralClickListener listener;

    public RowGroupView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public RowGroupView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public RowGroupView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
    }

    public void initData(RowGroupDescription rowGroupDescription, RowGeneralClickListener listener) {
        this.rowGroupDescription = rowGroupDescription;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        if (rowGroupDescription.groupDescriptions != null) {
            RowGeneralView rowView = null;
            View line = null;
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = 10;
            for (int i = 0; i < rowGroupDescription.groupDescriptions.size(); i++) {
                rowView = new RowGeneralView(context);
                rowView.initViewData(rowGroupDescription.groupDescriptions.get(i), listener);
                addView(rowView);
                if (i != rowGroupDescription.groupDescriptions.size() - 1) {
                    line = new View(context);
                    line.setBackgroundColor(Color.parseColor("#3F51B5"));
                    line.setLayoutParams(params);
                    addView(line);
                }
            }
        } else {
            setVisibility(GONE);
        }
    }

}
