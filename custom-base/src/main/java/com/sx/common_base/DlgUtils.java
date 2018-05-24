package com.sx.common_base;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import com.common.utils.dialog.DialogUtil;

/**
 * Created by Administrator on 2018/2/12.
 */

public class DlgUtils {

    /**
     * 显示定位服务未开启确认对话框
     */
    public static void showLocServiceDialog(final Context context) {

        DialogUtil.showMsgDialog(context, context.getString(R.string.activity_map_setting_str), true, context.getString(R.string.activity_map_setting), context.getString(R.string.cancel), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确认按钮
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    intent.setAction(Settings.ACTION_SETTINGS);
                    try {
                        context.startActivity(intent);
                        DialogUtil.dismissMsgDialog();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.dismissMsgDialog();
            }
        });


        /*new AlertDialog.Builder(context).setTitle("手机未开启位置服务")
                .setMessage("请在 设置-位置信息 (将位置服务打开))")
                .setNegativeButton("取消", null)
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            context.startActivity(intent);
                        } catch (ActivityNotFoundException ex) {
                            intent.setAction(Settings.ACTION_SETTINGS);
                            try {
                                context.startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                })
                .show();*/
    }

    /**
     * 显示定位权限被拒绝对话框
     */
    public static void showLocIgnoredDialog(final Context context) {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.default_img);
        builder.setTitle("手机已关闭位置权限");
        builder.setMessage("请在 设置-应用权限 (将位置权限打开))");

        //监听下方button点击事件
        builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent localIntent = new Intent();
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= 9) {
                    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    localIntent.setAction(Intent.ACTION_VIEW);
                    localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    localIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
                }
                context.startActivity(localIntent);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        //设置对话框是可取消的
        builder.setCancelable(true);
        final AlertDialog dialog = builder.create();
        dialog.show();*/


        DialogUtil.showMsgDialog(context, "请在 设置-位置信息 (将位置服务打开)", true, "去设置", context.getString(R.string.cancel), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确认按钮
                Intent localIntent = new Intent();
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= 9) {
                    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    localIntent.setAction(Intent.ACTION_VIEW);
                    localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    localIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
                }
                context.startActivity(localIntent);
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.dismissMsgDialog();
            }
        });

    }

}
