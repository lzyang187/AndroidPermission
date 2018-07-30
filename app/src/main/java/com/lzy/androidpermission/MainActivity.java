package com.lzy.androidpermission;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import com.lzy.permission.EasyPermissions;
import com.lzy.permission.custom.OnPermissionListener;
import com.lzy.permission.util.ListUtils;

import java.util.List;

public class MainActivity extends BaseActivity implements OnPermissionListener {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAndRequestPermissions("rationalestr", REQUEST_CODE, this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void onPermGranted(int requestCode, List<String> perms) {
        if (requestCode == REQUEST_CODE) {
            if (ListUtils.isNotEmpty(perms) &&
                    perms.contains(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Log.d(TAG, "读sd卡权限已获取");
            }
            if (ListUtils.isNotEmpty(perms) &&
                    perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.d(TAG, "写sd卡权限已获取");
            }
        }
    }

    @Override
    public void onPermDenied(int requestCode, List<String> perms) {
        if (requestCode == REQUEST_CODE) {
            if (ListUtils.isNotEmpty(perms) &&
                    perms.contains(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Log.d(TAG, "读sd卡权限已拒绝");
            }
            if (ListUtils.isNotEmpty(perms) &&
                    perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.d(TAG, "写sd卡权限已拒绝");
            }
        }
        if (!gotoSettingActivity(perms, "rationalestr")) {
            Log.d(TAG, "用户没有选中不再提示");
        }
    }

    @Override
    public void onPermSystemSettingResult(int requestCode) {
        if (requestCode == REQUEST_CODE) {
            if (EasyPermissions.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.d(TAG, "写sd卡权限已在系统设置页面获取");
            } else {
                Log.d(TAG, "写sd卡权限已在系统设置页面被拒绝");
            }
        }
    }

}
