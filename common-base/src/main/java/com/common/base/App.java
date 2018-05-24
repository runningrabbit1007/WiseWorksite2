package com.common.base;

import android.app.Application;
import android.widget.Toast;

import com.common.utils.LogUtils;
import com.common.utils.ToastUtil;

/**
 * 获取全局Application工具类，非常好用的类
 * copy至com.kymjs.core:common
 */
public class App {

    public static final Application INSTANCE;

    static {
        Application app = null;
        try {
            app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
            if (app == null)
                throw new IllegalStateException("Static initialization of Applications must be on main thread.");
        } catch (final Exception e) {
            LogUtils.e("Failed to get current application from AppGlobals." + e.getMessage());
            try {
                app = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (final Exception ex) {
                LogUtils.e("Failed to get current application from ActivityThread." + e.getMessage());
            }
        } finally {
            INSTANCE = app;
        }
    }

    public static void toast(String msg) {
//        ToastUtil.showToast(INSTANCE,msg);
        Toast.makeText(INSTANCE,msg,Toast.LENGTH_SHORT).show();
    }

    public static void toast(int msgId) {
        ToastUtil.showToast(INSTANCE,msgId);
//        Toast.makeText(INSTANCE,INSTANCE.getResources().getString(msgId),Toast.LENGTH_SHORT).show();
    }

    public static void longToast(String msg) {
        ToastUtil.showToast(INSTANCE,msg, Toast.LENGTH_LONG);
    }
}
