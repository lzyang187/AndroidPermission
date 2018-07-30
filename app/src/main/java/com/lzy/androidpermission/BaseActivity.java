package com.lzy.androidpermission;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lzy.permission.AppSettingsDialog;
import com.lzy.permission.EasyPermissions;
import com.lzy.permission.PermissionRequest;
import com.lzy.permission.custom.OnPermissionListener;

import java.util.List;

/**
 * 基础activity,所有业务Activity均继承于它
 * 加入运行时权限申请的接口 2018/3/2 10:28
 *
 * @author: cyli8
 * @date: 2018/2/28 10:44
 */

public class BaseActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    public static final String L_FINISH_ANIMATION_ID = "l_finish_anim_id"; // 当前界面
    public static final String R_FINISH_ANIMATION_ID = "r_finish_anim_id"; // 下级界面

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState,
                         @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //运行时权限的结果回调
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            if (mPermissionListener != null) {
                mPermissionListener.onPermSystemSettingResult(mRequestPermCode);
            }
        }
    }

    //运行时权限部分
    private OnPermissionListener mPermissionListener;
    private int mRequestPermCode;

    /**
     * 检查并且申请运行时权限
     *
     * @param rationaleStr 用户拒绝后的声明需要权限的提示语，为空则用户拒绝后不再进行后续权限申请
     * @param requestCode  请求code
     * @param listener     回调监听
     * @param permissions  权限组
     */
    public void checkAndRequestPermissions(String rationaleStr, int requestCode,
                                           OnPermissionListener listener, String... permissions) {
        checkAndRequestPermissions(rationaleStr, R.string.lib_view_ok,
                R.string.lib_view_cancel, requestCode, listener, permissions);
    }

    public void checkAndRequestPermissions(String rationaleStr, int positiveId,
                                           int negativeId, int requestCode,
                                           OnPermissionListener listener, String... permissions) {
        mRequestPermCode = requestCode;
        mPermissionListener = listener;
        PermissionRequest request = new PermissionRequest.Builder(this, requestCode, permissions)
                .setRationale(rationaleStr)
                .setPositiveButtonText(positiveId)
                .setNegativeButtonText(negativeId)
                .build();
        EasyPermissions.requestPermissions(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,
                this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (mPermissionListener != null) {
            mPermissionListener.onPermGranted(requestCode, perms);
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (mPermissionListener != null) {
            mPermissionListener.onPermDenied(requestCode, perms);
        }
    }

    public boolean gotoSettingActivity(List<String> perms, String rationale) {
        return gotoSettingActivity(perms, rationale, getString(R.string.lib_view_ok),
                getString(R.string.lib_view_cancel));
    }

    public boolean gotoSettingActivity(List<String> perms, String rationale, String positiveStr, String negativeStr) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            //用户选中了不再提示
            new AppSettingsDialog.Builder(this).build(rationale, positiveStr,
                    negativeStr).show();
            return true;
        }
        return false;
    }
}
