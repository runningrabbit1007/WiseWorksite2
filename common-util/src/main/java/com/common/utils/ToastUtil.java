package com.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



public class ToastUtil {
    private static Toast myToast;
    private static TextView contentText;
    public static View view = null;
    private static int mScreenHeight = 800;

    public static void initToast(Context context) {
        view = ViewUtil.getView(context, R.layout.layout_toast, null);
        contentText = (TextView) view.findViewById(R.id.toast_content_tv);
        contentText.setAlpha((float) 0.9);
        myToast = new Toast(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(100, 40));
        myToast.setView(view);
    }

    /**
     * 初始化toast参数
     *
     * @param screenHeight
     */
    public static void initToastParam(int screenHeight) {
        mScreenHeight = screenHeight;
    }

    public static void showToast(Context context, CharSequence msg, int duration) {
        if (context == null) {
            return;
        }
        if (null == view) {
            initToast(context.getApplicationContext());
        }
        if (contentText != null) {
            synchronized (contentText) {
                if (myToast != null) {
                    contentText.setText(msg);
                    myToast.setGravity(Gravity.BOTTOM, 0, mScreenHeight / 2);
                    myToast.setDuration(duration);
                    myToast.show();
                } else {
                    Toast.makeText(context, msg, duration).show();
                }
            }

        } else {
            Toast.makeText(context, msg, duration).show();
        }

    }
    public static void showToast(Context context, CharSequence msg) {
//        showToast(context, msg, Toast.LENGTH_SHORT);
        if(msg!=null) {
            Toast.makeText(context, msg.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void showToast(Context context, int msg) {
//        showToast(context, context.getResources().getString(msg), Toast.LENGTH_SHORT);
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}