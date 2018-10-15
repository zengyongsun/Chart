package com.zy.chart.easypermissions;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.zy.chart.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class EasyPermissionsActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {

    String[] camera = {Manifest.permission.CAMERA};
    String[] loaction = {Manifest.permission.ACCESS_FINE_LOCATION};

    public final int CODE_CAMERA = 100;
    public final int CODE_LOCATION = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_permissions);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCamera)
    public void onBtCameraClicked() {
        if (hasCameraPermission()) {
            Toast.makeText(this, "有相机权限", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "没有请求开启", Toast.LENGTH_SHORT).show();
            EasyPermissions.requestPermissions(this, "描述", CODE_CAMERA, camera);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.d("onActivityResult:" + requestCode + ":" + resultCode);
    }

    /**
     * 直接跳系统的界面让用户去打开
     */
    private void SettingsStart() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivityForResult(intent, 1000);
    }

    @OnClick(R.id.btLocation)
    public void onBtLocationClicked() {
        if (hasLocationPermission()) {
            Toast.makeText(this, "有定位权限", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "没有请求开启", Toast.LENGTH_SHORT).show();
            EasyPermissions.requestPermissions(this, "描述", CODE_LOCATION, loaction);
        }
    }


    private boolean hasCameraPermission() {
        return EasyPermissions.hasPermissions(this, camera);
    }

    private boolean hasLocationPermission() {
        return EasyPermissions.hasPermissions(this, loaction);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Logger.d("onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Logger.d("onPermissionsDenied:" + requestCode + ":" + perms.size());

        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    //************请求理由对话框的回调**********************
    @Override
    public void onRationaleAccepted(int requestCode) {
        Logger.d("onRationaleAccepted =========" + requestCode);
    }

    @Override
    public void onRationaleDenied(int requestCode) {
        Logger.d("onRationaleDenied =========" + requestCode);
    }
}
