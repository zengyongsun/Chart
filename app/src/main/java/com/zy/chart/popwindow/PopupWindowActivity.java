package com.zy.chart.popwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zy.chart.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupWindowActivity extends AppCompatActivity {

    @BindView(R.id.tvName) TextView tvName;

    private CustomPopupWindow customPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        ButterKnife.bind(this);
        tvName.setText(initData().get(0).getName());
    }

    @OnClick(R.id.tvName)
    public void onViewClicked() {
        if (customPopupWindow == null) {
            customPopupWindow = new CustomPopupWindow(this, tvName.getWidth(), 500);
            customPopupWindow.setOutsideTouchable(true);//设置点击外部消失
            customPopupWindow.setData(initData());
        }
        customPopupWindow.setItemClickListener(new CustomPopupWindow.OnItemClickListener() {
            @Override
            public void itemClick(BaseBean popBean) {
                tvName.setText(popBean.getName());
            }
        });
        customPopupWindow.showAsDropDown(tvName,0,-2);
    }

    private List<BaseBean> initData() {
        List<BaseBean> datas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                datas.add(new PopBean("name" + i, i * 10 + "", true));
            } else {
                datas.add(new PopBean("name" + i, i * 10 + "", false));
            }
        }
        return datas;
    }

}
