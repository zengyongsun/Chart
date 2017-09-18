package com.zy.chart.linkman;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

/**
 * Created by Zeyo on 2017-09-04 14:27
 * Description
 */


public class MyEditText extends EditText {

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getLineCount() > 1) {
            setGravity(Gravity.LEFT);
        } else {
            setGravity(Gravity.RIGHT);
        }
    }
}