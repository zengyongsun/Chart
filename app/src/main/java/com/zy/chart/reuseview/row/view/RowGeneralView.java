package com.zy.chart.reuseview.row.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zy.chart.R;
import com.zy.chart.reuseview.row.bean.RowDescription;
import com.zy.chart.reuseview.row.bean.RowGeneralType;
import com.zy.chart.reuseview.row.imp.RowGeneralClickListener;

/**
 * Created by Administrator on 2017/7/19.
 */

public class RowGeneralView extends LinearLayout implements View.OnClickListener {

    private Context context;
    private ImageView mRowImageLeft;
    private TextView mRowTextView;
    private ImageView mRowImageRight;

    private RowGeneralClickListener listener;
    private RowGeneralType type;

    public RowGeneralView(Context context) {
        super(context);
        this.context = context;
        initView();

    }

    public RowGeneralView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public RowGeneralView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.row_view_layout, this);

        mRowImageLeft = (ImageView) findViewById(R.id.mRowImageLeft);
        mRowTextView = (TextView) findViewById(R.id.mRowTextView);
        mRowImageRight = (ImageView) findViewById(R.id.mRowImageRight);
    }

    public void initViewData(@DrawableRes int imageLeft, String label) {
        mRowImageLeft.setImageResource(imageLeft);
        mRowTextView.setText(label);
    }

    public void initViewData(RowDescription rowDescription, RowGeneralClickListener listener) {
        mRowImageLeft.setImageResource(rowDescription.imageLeft);
        mRowTextView.setText(rowDescription.label);
        mRowImageRight.setImageResource(rowDescription.imageRight);
        if (rowDescription.type != null) {
            this.type = rowDescription.type;
            this.listener = listener;
            setOnClickListener(this);
            setBackgroundResource(R.drawable.row_view_background_slelect);
            mRowImageRight.setVisibility(VISIBLE);
        } else {
            setBackgroundColor(Color.WHITE);
            mRowImageRight.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.rowClick(type);
        }
    }
}
