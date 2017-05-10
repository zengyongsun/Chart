package com.zy.chart.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.PieData;
import com.zy.chart.R;

import java.util.ArrayList;
import java.util.Random;

public class MainChartActivity extends AppCompatActivity {

  private LineChart mLineChart;
  private PieChart mPieChart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initDate();
    initView();

    // 设置数据
    mLineChart.setData(lineData);
    mPieChart.setData(pieData);
  }

  LineData lineData;
  PieData pieData;

  private void initDate() {
//    List<String> xVals, ILineDataSet dataSet
    ArrayList<String> xVals = new ArrayList<>();
    xVals.add("4/01");
    xVals.add("4/02");
    xVals.add("4/03");
    xVals.add("4/04");
    xVals.add("4/05");
    xVals.add("4/06");

    ArrayList<Entry> entrys = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      entrys.add(new Entry(random.nextInt(20), i));
    }

    lineData = MPLineChart.getLineData(xVals, entrys, "描述");
    pieData = MPPieChart.getPieDate(xVals, entrys);
  }

  private void initView() {

    mLineChart = (LineChart) findViewById(R.id.line_chart);
    mPieChart = (PieChart) findViewById(R.id.pie_chart);
    MPLineChart.setLineChartStyle(mLineChart);
    MPPieChart.setPieChartStyle(mPieChart);

  }

}
