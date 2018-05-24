package com.sx.common_base.base;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.common.base.config.PreferencesManager;
import com.common.utils.LogUtils;
import com.common.utils.system.PhoneTools;
import com.sx.common_base.constant.PermissionValue;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

/**
 * Created by edz on 2016/12/21.
 */

public abstract class PermissionActivity extends BaseRequestUrlActivity implements PermissionListener, IRequestPermission, RationaleListener{

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        // 只需要调用这一句，剩下的AndPermission自动完成。
        AndPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults, this);
    }

    @Override
    public void onRequestPermission(String[] pStrings, int requestCode){
        AndPermission.with(PermissionActivity.this).requestCode(requestCode).permission(pStrings).rationale(this).send();
    }

    @Override
    public void onFailed(int requestCode){
        LogUtils.e(TAG, "onFailed() called with:*********************** requestCode = " + requestCode);
        if(PhoneTools.isMIUI()){
            if(!(boolean) PreferencesManager.getInstance().getParam(PermissionValue.MIUI, true)){
                showPermissionMsg(requestCode, true, null);
            }
            if((boolean) PreferencesManager.getInstance().getParam(PermissionValue.MIUI, true)){
                PreferencesManager.getInstance().saveParam(PermissionValue.MIUI, false);
            }
        }
    }

    final protected void showPermissionMsg(int requestCode, final boolean isMiui, final Rationale pRationale){
        String title = null;
        String msg = null;
        switch(requestCode){
            case 1001:
                title = PermissionValue.PER_TITLE_SD;
                msg = PermissionValue.PER_MSG_SD;
                break;
            case 1002:
                title = PermissionValue.PER_TITLE_CAMERA;
                msg = PermissionValue.PER_MSG_CAMERA;
                break;
            case 1003:
                title = PermissionValue.PER_TITLE_VOICE;
                msg = PermissionValue.PER_MSG_VOICE;
                break;
            case 1004:
                title = PermissionValue.PER_TITLE_CONTACT;
                msg = PermissionValue.PER_MSG_CONTACT;
                break;
            case 1005:
                title = PermissionValue.PER_TITLE_LOACTION;
                msg = PermissionValue.PER_MSG_LOACTION;
                break;
            case 1006:
                title = PermissionValue.PER_TITLE_SD_AND_CAMERA;
                msg = PermissionValue.PER_MSG_SD_AND_CAMERA;
                break;
            case 1007:
                title = PermissionValue.PER_TITLE_CAMERA_AND_VOICE;
                msg = PermissionValue.PER_MSG_CAMERA_AND_VOICE;
                break;
            default:
                title = "权限提醒";
                msg = "你需要为我们授权，才能使用部分功能";
                break;
        }
        String sureText = "去设置";
        if(!isMiui){
            sureText = "授权";
        }
        new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(sureText, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                        if(isMiui){
                            gotoSetting();
                        }else{
                            if(pRationale != null){
                                pRationale.resume();
                            }
                        }
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                        if(!isMiui){
                            pRationale.cancel();
                        }
                    }
                }).show();
    }

    private void gotoSetting(){
        Intent i = new Intent("miui.intent.action.APP_PERM_EDITOR");
        ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        i.setComponent(componentName);
        i.putExtra("extra_pkgname", getPackageName());
        try{
            startActivity(i);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showRequestPermissionRationale(int requestCode, final Rationale rationale){
        showPermissionMsg(requestCode, false, rationale);
    }
}
