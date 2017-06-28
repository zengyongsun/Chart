package com.zy.chart.selectHead;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zy.chart.R;
import com.zy.chart.ReminderTargetBean;
import com.zy.chart.TargetTypeBean;

import java.util.ArrayList;

public class SelectHeadActivity extends AppCompatActivity implements PicCrop.CropHandler {

    private Context mContext;
    private CircleImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_head);
        mContext = this;
        initData();
        initView();
    }

    public ArrayList<TargetTypeBean> departTypeList;
    public ArrayList<TargetTypeBean> personTypeList;

    private void initData() {
        personTypeList = getIntent().getParcelableArrayListExtra("personType");
        departTypeList = getIntent().getParcelableArrayListExtra("departType");
        ReminderTargetBean bean = (ReminderTargetBean) getIntent().getSerializableExtra("bean");

        if (departTypeList != null && departTypeList.size() > 0) {//有部门目标
            departTypeList.get(0).setSelected(true);
            personTypeList.get(0).setSelected(true);
        } else if (departTypeList != null && departTypeList.size() > 0) {//没有部门目标
            personTypeList.get(0).setSelected(true);
        } else {
            personTypeList = bean.getPersonalTargetTypeList();
        }

    }

    private void initView() {

        image = (CircleImageView) findViewById(R.id.iv_image);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PicCrop.cropAvatarFromCamera(SelectHeadActivity.this);

            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PicCrop.cropAvatarFromGallery(SelectHeadActivity.this);

            }
        });
    }

    @Override
    public void handleCropResult(Uri uri, int tag) {
        image.setImageURI(uri);
    }

    @Override
    public void handleCropError(Intent data) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        PicCrop.onActivityResult(requestCode, resultCode, data, this, this);
    }
}
