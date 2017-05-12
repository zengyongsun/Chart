package com.zy.chart.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zy.chart.R;

public class ShapeSelectView extends View {

    private int shapeWidth = 100;
    private int shapeHeight = 100;
    private int textXOffset = 0;
    private int textYOffset = 30;
    private Paint paintShape;

    private String[] shapeValues = {"square", "circle", "triangle"};
    private int currentShapeIndex = 0;

    private int shapeColor;
    private boolean displayShapeName;

    //必须提供一个构造函数，它接受一个 Context 和 一个 AttributeSet。
    //这个构造函数允许通过 UI 创建和编辑
    public ShapeSelectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupAttributes(attrs);
        setupPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //定义文本的 padding
        int textPadding = 10;
        int contentWidth = shapeWidth;

        //根据我们的最小和测量规格决定宽度
        int minw = contentWidth + getPaddingLeft() + getPaddingRight();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 0);

        //要求一个高度，让视图尽可能的大
        int minh = shapeHeight + getPaddingBottom() + getPaddingTop();
        if (displayShapeName) {
            minh += textYOffset + textPadding;
        }
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);

        //调用此方法确定测量的宽度和高度
        //稍后使用 getMeasuredWidth 或 getMeasuredHeight 方法检索
        setMeasuredDimension(w, h);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String shapeSelected = shapeValues[currentShapeIndex];
        if (shapeSelected.equals("square")) {
            canvas.drawRect(0, 0, shapeWidth, shapeHeight, paintShape);
            textXOffset = 0;

        } else if (shapeSelected.equals("circle")) {
            canvas.drawCircle(shapeWidth / 2, shapeHeight / 2, shapeWidth / 2, paintShape);
            textXOffset = 12;

        } else if (shapeSelected.equals("triangle")) {
            canvas.drawPath(getTrianglePath(), paintShape);
            textXOffset = 0;
        }

        if (displayShapeName) {
            canvas.drawText(shapeSelected, textXOffset, shapeHeight + textYOffset, paintShape);
        }

    }

    protected Path getTrianglePath() {
        Point p1 = new Point(0, shapeHeight), p2 = null, p3 = null;
        p2 = new Point(p1.x + shapeWidth, p1.y);
        p3 = new Point(p1.x + (shapeWidth / 2), p1.y - shapeHeight);
        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);
        return path;
    }

    //每当点击形状时，更改currentShapeIndex
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            currentShapeIndex = (++currentShapeIndex) % shapeValues.length;
            postInvalidate();
            return true;
        }

        return result;
    }

    private void setupAttributes(AttributeSet attrs) {
        //获取属性的类型数组
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ShapeSelectView, 0, 0);
        //将自定义属性提取到成员变量中
        try {
            shapeColor = a.getColor(R.styleable.ShapeSelectView_shapeColor, Color.BLACK);
            displayShapeName = a.getBoolean(R.styleable.ShapeSelectView_displayShapeName, false);
        } finally {
            // TypedArray 对象是共享的，必须回收。
            a.recycle();
        }
    }

    private void setupPaint() {
        paintShape = new Paint();
        paintShape.setStyle(Paint.Style.FILL);
        paintShape.setColor(shapeColor);
        paintShape.setTextSize(30);
    }

    public boolean isDisplayShapeName() {
        return displayShapeName;
    }

    public void setDisplayShapeName(boolean state) {
        this.displayShapeName = state;
        //当视图属性更改并可能需要重绘时，请确保调用invalidate()并requestLayout()更新外观。
        invalidate();
        requestLayout();
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int color) {
        this.shapeColor = color;
        //当视图属性更改并可能需要重绘时，请确保调用invalidate()并requestLayout()更新外观。
        invalidate();
        requestLayout();
    }


    @Override
    protected Parcelable onSaveInstanceState() {
        //创建一个序列化对象
        Bundle bundle = new Bundle();
        //存储视图状态
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        //保存我们的自定义视图状态以进行捆绑
        bundle.putInt("currentShapeIndex", this.currentShapeIndex);
        // ...存储任何其他自定义状态在这里...
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        // 检查状态是否是我们保存的包
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            // 加载我们的自定义视图状态
            this.currentShapeIndex = bundle.getInt("currentShapeIndex");
            // ...加载任何其他自定义状态在这里...
            // 加载基本视图状态
            state = bundle.getParcelable("instanceState");
        }
        //将基本视图状态传递给父类
        super.onRestoreInstanceState(state);
    }

}
