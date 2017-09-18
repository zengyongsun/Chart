package com.zy.chart.reuseview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zy.chart.R;
import com.zy.chart.reuseview.row.bean.RowDescription;
import com.zy.chart.reuseview.row.bean.RowGeneralType;
import com.zy.chart.reuseview.row.bean.RowGroupDescription;
import com.zy.chart.reuseview.row.imp.RowGeneralClickListener;
import com.zy.chart.reuseview.row.view.ContentView;

import java.util.ArrayList;

public class ReuseViewActivity extends AppCompatActivity implements RowGeneralClickListener {

    private ContentView mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuse_view);

        mContentView = (ContentView) findViewById(R.id.mContentView);
//        mRowGeneralView.initViewData(R.drawable.icon_spectaculars, "自定义看板");
//        mRowGeneralView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ReuseViewActivity.this, "点击了", Toast.LENGTH_SHORT).show();
//            }
//        });

//        mRowGeneralView.initViewData(R.drawable.icon_spectaculars, "自定义看板", R.drawable.icon_right,
//            RowGeneralType.BOARD, this);

//        ArrayList<RowDescription> rowDescriptions = new ArrayList<>();
//        rowDescriptions.add(new RowDescription(R.drawable.icon_spectaculars, "看板自定义", R.drawable.icon_right, RowGeneralType.BOARD));
//        rowDescriptions.add(new RowDescription(R.drawable.icon_change_password, "修改密码", R.drawable.icon_right, RowGeneralType.CHANGE));
//        rowDescriptions.add(new RowDescription(R.drawable.icon_collect, "咨询收藏", R.drawable.icon_right, RowGeneralType.COLLECTION));
//        mRowGroup.initData(rowDescriptions, this);
//        mRowGroup.notifyDataChanged();
        initView();

    }

    private void initView() {
        ArrayList<RowGroupDescription> groupList = new ArrayList<>();

        ArrayList<RowDescription> rowDescription1 = new ArrayList<>();
        rowDescription1.add(new RowDescription(R.drawable.icon_spectaculars, "看板自定义", R.drawable.icon_right, RowGeneralType.BOARD));
        rowDescription1.add(new RowDescription(R.drawable.icon_change_password, "修改密码", R.drawable.icon_right, RowGeneralType.CHANGE));
        rowDescription1.add(new RowDescription(R.drawable.icon_collect, "咨询收藏", R.drawable.icon_right, RowGeneralType.COLLECTION));
        RowGroupDescription group1 = new RowGroupDescription(rowDescription1);
        groupList.add(group1);

        ArrayList<RowDescription> rowDescription2 = new ArrayList<>();
        rowDescription2.add(new RowDescription(R.drawable.icon_clear_cache, "清除缓存", R.drawable.icon_right, RowGeneralType.CLEAR));
        rowDescription2.add(new RowDescription(R.drawable.icon_grade, "评分", R.drawable.icon_right, RowGeneralType.GRADE));
        rowDescription2.add(new RowDescription(R.drawable.icon_feedback, "反馈", R.drawable.icon_right, RowGeneralType.BACK));
        RowGroupDescription group2 = new RowGroupDescription(rowDescription2);
        groupList.add(group2);

        ArrayList<RowDescription> rowDescriptions3 = new ArrayList<>();
        rowDescriptions3.add(new RowDescription(R.drawable.icon_usinghelp, "使用帮助", R.drawable.icon_right, RowGeneralType.HELP));
        rowDescriptions3.add(new RowDescription(R.drawable.icon_info, "关于", R.drawable.icon_right,null));
        rowDescriptions3.add(new RowDescription(R.drawable.icon_link_us, "联系我们", R.drawable.icon_right, RowGeneralType.LINK));
        RowGroupDescription group3 = new RowGroupDescription(rowDescriptions3);
        groupList.add(group3);

        mContentView.initData(groupList, this);
    }

    @Override
    public void rowClick(RowGeneralType type) {
        Toast.makeText(ReuseViewActivity.this, type + "", Toast.LENGTH_SHORT).show();
    }
}
