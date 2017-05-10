package com.zy.chart.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * 通过用户手指在屏幕上绘画
 */
public class SimpleDrawView extends View {

    //设置初始颜色
    private final int paintColor = Color.BLACK;

    //定义画笔
    private Paint drawPaint;

    private Context mContext;

    private Path path = new Path();

    public SimpleDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
    }

    //设置画笔的颜色和样式
    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);//去锯齿
        drawPaint.setStrokeWidth(dp2px(mContext,3));
        drawPaint.setStyle(Paint.Style.STROKE);//改回为 stroke
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制触摸事件期间创建的路径
        canvas.drawPath(path,drawPaint);
    }


    //得到 x , y 并把他们添加到 path 中
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

        //检查发生的事件
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //在路径中启动新行
                path.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                //在最后一点，和这一点之间划线
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }

        postInvalidate(); //指示视图应重绘
        return true; //消费这个事件
    }

    /**
     * dp转px
     */
    private int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            dpVal, context.getResources().getDisplayMetrics());
    }
}
