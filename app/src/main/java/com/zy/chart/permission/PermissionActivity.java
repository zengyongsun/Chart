package com.zy.chart.permission;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.zy.chart.R;

public class PermissionActivity extends Activity {

    private Context mContext;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        mContext = this;

        findViewById(R.id.request_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                    //有权限做操作
                    Logger.d("有权限");
                } else {
                    //无权限，请求权限  判断是否会弹权限申请对话框
                    requestCameraPermission();
                }
            }
        });

    }

    private void requestCameraPermission() {
        boolean shouldShow = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA);
        if (shouldShow) {
            //能弹窗，申请权限
            ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA
            }, 1);
            Logger.d("可以弹窗提示权限");
        } else {
            showDialogRequestPermission();
            Logger.d("不可弹窗提示权限，6.0(23)以下");
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //有权限 // TODO: 2017/6/23
                Logger.d("授予了有权限");
            } else {
                showDialogRequestPermission();
            }
        }

    }

    private void showDialogRequestPermission() {
        Dialog alertDialog = new AlertDialog.Builder(PermissionActivity.this)
            .setTitle("提示")
            .setMessage("没有权限，请授予")
            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create();
        alertDialog.show();
    }

}
