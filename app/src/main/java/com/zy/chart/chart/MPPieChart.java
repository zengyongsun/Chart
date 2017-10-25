package com.zy.chart.chart;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.List;

/**
 * 饼状图
 */

public class MPPieChart {

  private MPPieChart() {
  }

  public static void setPieChartStyle(PieChart pieChart) {
    pieChart.setUsePercentValues(true);//计算转化百分比的值
//    pieChart.setDescription("");//图标下方的描述Label
    pieChart.setExtraOffsets(20, 10, 10, 5);//边距（left,top,right,bottom）

    pieChart.setDragDecelerationFrictionCoef(0.95f);//减速摩擦系数[ 0；1 ]区间，较高值指示速度会缓慢下降

    pieChart.setDrawHoleEnabled(false);//设置为true将饼中心清空
    pieChart.setHoleColor(Color.WHITE);//套孔，绘制在PieChart中心的颜色（如果启用）
    pieChart.setTransparentCircleColor(Color.RED);//设置透明圆应有的颜色（如果启用）

    pieChart.setTransparentCircleAlpha(100);//设置透明度圆的透明度应该有0 =完全透明， 255 =完全不透明

    pieChart.setHoleRadius(5f);//套在成的饼图中心的黑洞的半径 最大半径（最大=整个图表的半径），默认50%
    pieChart.setTransparentCircleRadius(61f);
    pieChart.setCenterTextColor(Color.parseColor("#373737"));
    pieChart.setCenterTextSize(13f);
    pieChart.setDrawCenterText(true);

    pieChart.setRotationAngle(270);//动画的起始位置，默认270f 顶（北）
    // enable rotation of the chart by touch
    pieChart.setRotationEnabled(true);//是否可以触摸转动
    pieChart.setHighlightPerTapEnabled(true);//饼块是否可以点击

    pieChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
    // mChart.spin(2000, 0, 360);
    pieChart.setNoDataText("暂无数据");
    Legend l = pieChart.getLegend();
    l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
    l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
    l.setOrientation(Legend.LegendOrientation.VERTICAL);
    l.setDrawInside(false);
    l.setEnabled(false);//图例不可见

//    pieChart.highlightValues(null);
    pieChart.invalidate();
  }

  public static PieData getPieDate( List<PieEntry> entryList) {

    //饼状图的颜色
    int[] setColor = {ColorTemplate.rgb("#F75046"), ColorTemplate.rgb("#F7726A")};

    PieDataSet dataSet = new PieDataSet(entryList, ""/*显示在比例图上*/);
    dataSet.setSliceSpace(3f);//设置个饼状图之间的距离
    dataSet.setSelectionShift(5f);// 选中态多出的长度
    dataSet.setColors(setColor);
    dataSet.setValueLinePart1OffsetPercentage(75.f);//线指的位置
    dataSet.setValueLinePart1Length(0.4f);//里面的长度
    dataSet.setValueLinePart2Length(0.8f);//外面的长度
    dataSet.setXValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
    dataSet.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
    dataSet.setValueLineColor(Color.RED);
    dataSet.setDrawValues(true);
//    dataSet.setValueLineColor(Color.TRANSPARENT);//线设置呈透明的，即不显示

    PieData data = new PieData(dataSet);
    data.setValueFormatter(new PercentFormatter());
    data.setValueTextSize(13f);
    data.setValueTextColor(Color.parseColor("#373737"));

    return data;
  }

}
