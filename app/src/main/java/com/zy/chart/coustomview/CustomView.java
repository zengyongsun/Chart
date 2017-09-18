package com.zy.chart.coustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/14.
 */

public class CustomView extends View {

    private Paint mPaint;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(21)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);    // Style 修改为画线模式
        mPaint.setStrokeWidth(40);  // 线条宽度为 20 像素
        mPaint.setAntiAlias(true);  //开启抗锯齿


//        canvas.drawCircle(500, 500, 400, mPaint);   //画圆
//        canvas.drawColor(Color.parseColor("#88880000"));    //画布背景
//        canvas.drawRect(400,400,800,800,mPaint);    //矩形

        canvas.drawRoundRect(400,400,800,800,50,50,mPaint);

    }
}
