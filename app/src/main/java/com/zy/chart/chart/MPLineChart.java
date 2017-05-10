package com.zy.chart.chart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 折线图的
 */

public class MPLineChart {

    private MPLineChart() {
    }

  public static void setLineChartStyle(LineChart lineChart) {

    lineChart.setDrawBorders(false);//是否在折线图上添加边框
    lineChart.setDescription(""); // 数据描述
    lineChart.setNoDataTextDescription("暂无数据");// 如果没有数据的时候，会显示这个
    lineChart.setAlpha(0.8f); //设置透明度
    lineChart.setDrawGridBackground(false);// 是否显示表格颜色
    lineChart.setTouchEnabled(true);  // 设置是否可以触摸
    lineChart.setDragEnabled(true);// 是否可以拖拽
    lineChart.setScaleEnabled(false);// 是否可以缩放

    //选中时的高亮
    lineChart.setHighlightPerTapEnabled(false);
    lineChart.setHighlightPerDragEnabled(false);
    lineChart.setPinchZoom(false); //设置是否能扩大扩小

    /* X轴设定 */
    XAxis xAxis = lineChart.getXAxis();
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//位置
    xAxis.setDrawGridLines(false);//表格线
    xAxis.setTextSize(12L);//字体大小
    xAxis.setAxisLineColor(Color.parseColor("#e5e5e5"));
    xAxis.setTextColor(Color.parseColor("#373737"));
    xAxis.setDrawLabels(true);//x轴的值，默认ture
    xAxis.setDrawAxisLine(true);

    /* Y轴设定*/
    YAxis leftY = lineChart.getAxisLeft();
    leftY.setDrawGridLines(true);
    leftY.setDrawAxisLine(true);
    leftY.setAxisLineColor(Color.parseColor("#e5e5e5"));
    leftY.setTextColor(Color.parseColor("#373737"));
    leftY.setGridColor(Color.parseColor("#e5e5e5"));
    leftY.setAxisMinValue(0);

    YAxis rightY = lineChart.getAxisRight();
    rightY.setDrawAxisLine(false);
    rightY.setDrawLabels(false);
    rightY.setDrawGridLines(false);
    rightY.setAxisMinValue(0);

    Legend mLegend = lineChart.getLegend(); // 设置比例图标示，
    mLegend.setForm(Legend.LegendForm.SQUARE);// 样式
    mLegend.setFormSize(6f);// 字体
    mLegend.setTextColor(Color.RED);// 颜色

    lineChart.animateX(1000); // 立即执行的动画,x轴

  }

  /**
   * 获得数据显示一条曲线
   *
   * @param xValues x轴的数据
   * @param yValues y轴的数据
   * @param desc    显示在比例图上
   * @return LineData 折线图的数据
   */
  public static LineData getLineData(List<String> xValues,
                                     List<Entry> yValues, String desc) {
    // y轴的数据集合
    LineDataSet lineDataSet = new LineDataSet(yValues, desc/*显示在比例图上*/);
    lineDataSet.setDrawCircles(true);//设置曲线为圆滑的线
    lineDataSet.setCubicIntensity(0.2f); //设置立体的感觉
    lineDataSet.setDrawCircles(true);  //设置有圆点，默认有
    lineDataSet.setDrawFilled(false);  //设置包括的范围区域填充颜色
    //用y轴的集合来设置参数
    lineDataSet.setValueTextColor(Color.RED);
    lineDataSet.setLineWidth(0.75f); // 线的线宽
    lineDataSet.setCircleRadius(3f);// 显示的圆形大小
    lineDataSet.setColor(Color.RED);// 显示曲线颜色
    lineDataSet.setCircleColor(Color.RED);// 圆形的颜色
    lineDataSet.setHighLightColor(Color.BLUE); // 高亮的线的颜色
    ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
    lineDataSets.add(lineDataSet);
    LineData lineData = new LineData(xValues, lineDataSets);
    lineData.setDrawValues(true);
    lineData.setValueTextColor(Color.parseColor("#373737"));
    lineData.setValueTextSize(12);
    return lineData;
  }

  public static LineData getLineData(List<String> xValues,
                                     List<Entry> y1Values, String desc1,
                                     List<Entry> y2Values, String desc2) {
    LineDataSet lineSet1, lineSet2;

    lineSet1 = new LineDataSet(y1Values, desc1);
    lineSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
    lineSet1.setColor(ColorTemplate.getHoloBlue());
    lineSet1.setCircleColor(Color.WHITE);
    lineSet1.setLineWidth(2f);
    lineSet1.setCircleRadius(3f);
    lineSet1.setFillAlpha(65);
    lineSet1.setFillColor(ColorTemplate.getHoloBlue());
    lineSet1.setHighLightColor(Color.rgb(244, 117, 117));
    lineSet1.setDrawCircleHole(false);

    lineSet2 = new LineDataSet(y2Values, desc2);
    lineSet2.setAxisDependency(YAxis.AxisDependency.RIGHT);
    lineSet2.setColor(Color.RED);
    lineSet2.setCircleColor(Color.WHITE);
    lineSet2.setLineWidth(2f);
    lineSet2.setCircleRadius(3f);
    lineSet2.setFillAlpha(65);
    lineSet2.setFillColor(Color.RED);
    lineSet2.setDrawCircleHole(false);
    lineSet2.setHighLightColor(Color.rgb(244, 117, 117));

    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    dataSets.add(lineSet1);
    dataSets.add(lineSet2);

    LineData lineData = new LineData(xValues, dataSets);
    lineData.setValueTextColor(Color.WHITE);
    lineData.setValueTextSize(9f);

    return lineData;
  }

  public static LineData getLineData(List<String> xValues,
                                     List<Entry> y1Values, String desc1,
                                     List<Entry> y2Values, String desc2,
                                     List<Entry> y3Values, String desc3) {
    LineDataSet lineSet1, lineSet2, lineSet3;

    lineSet1 = new LineDataSet(y1Values, desc1);
    lineSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
    lineSet1.setColor(ColorTemplate.getHoloBlue());
    lineSet1.setCircleColor(Color.WHITE);
    lineSet1.setLineWidth(2f);
    lineSet1.setCircleRadius(3f);
    lineSet1.setFillAlpha(65);
    lineSet1.setFillColor(ColorTemplate.getHoloBlue());
    lineSet1.setHighLightColor(Color.rgb(244, 117, 117));
    lineSet1.setDrawCircleHole(false);

    lineSet2 = new LineDataSet(y2Values, desc2);
    lineSet2.setAxisDependency(YAxis.AxisDependency.RIGHT);
    lineSet2.setColor(Color.RED);
    lineSet2.setCircleColor(Color.WHITE);
    lineSet2.setLineWidth(2f);
    lineSet2.setCircleRadius(3f);
    lineSet2.setFillAlpha(65);
    lineSet2.setFillColor(Color.RED);
    lineSet2.setDrawCircleHole(false);
    lineSet2.setHighLightColor(Color.rgb(244, 117, 117));

    lineSet3 = new LineDataSet(y2Values, desc2);
    lineSet3.setAxisDependency(YAxis.AxisDependency.RIGHT);
    lineSet3.setColor(Color.RED);
    lineSet3.setCircleColor(Color.WHITE);
    lineSet3.setLineWidth(2f);
    lineSet3.setCircleRadius(3f);
    lineSet3.setFillAlpha(65);
    lineSet3.setFillColor(Color.RED);
    lineSet3.setDrawCircleHole(false);
    lineSet3.setHighLightColor(Color.rgb(244, 117, 117));

    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    dataSets.add(lineSet1);
    dataSets.add(lineSet2);
    dataSets.add(lineSet3);

    LineData lineData = new LineData(xValues, dataSets);
    lineData.setValueTextColor(Color.WHITE);
    lineData.setValueTextSize(9f);

    return lineData;
  }

}
