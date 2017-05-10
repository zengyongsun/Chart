package com.zy.chart.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zy.chart.R;

public class ShapeSelectView extends View {

  private int shapeColor;
  private boolean displayShapeName;

  //必须提供一个构造函数，它接受一个 Context 和 一个 AttributeSet。
  //这个构造函数允许通过 UI 创建和编辑
  public ShapeSelectView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    setupAttributes(attrs);
  }

  private void setupAttributes(AttributeSet attrs) {
    //获取属性的类型数组
    TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ShapeSelectView, 0, 0);
    //将自定义属性提取到成员变量中
    try {
      shapeColor = a.getColor(R.styleable.ShapeSelectView_shapeColor, Color.BLACK);
      displayShapeName = a.getBoolean(R.styleable.ShapeSelectView_displayShapeName,false);
    } finally {
      // TypedArray 对象是共享的，必须回收。
      a.recycle();
    }
  }

  public boolean isDisplayShapeName(){
    return displayShapeName;
  }

  public void setDisplayShapeName(boolean state){
    this.displayShapeName = state;
    //当视图属性更改并可能需要重绘时，请确保调用invalidate()并requestLayout()更新外观。
    invalidate();
    requestLayout();
  }

  public int getShapeColor(){
    return  shapeColor;
  }

  public void setShapeColor(int color){
    this.shapeColor = color;
    //当视图属性更改并可能需要重绘时，请确保调用invalidate()并requestLayout()更新外观。
    invalidate();
    requestLayout();
  }


}
