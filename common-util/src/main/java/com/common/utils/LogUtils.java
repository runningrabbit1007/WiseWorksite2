package com.common.utils;

/**
 * Created by
 * Author: wswenyue
 * Email: wswenyue@163.com
 * Date: 2015/10/28
 * GitHub: https://github.com/wswenyue
 */

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;


/**
 * Log打印工具同意管理类
 * Create by Jacklyy
 */
public final class LogUtils {
    private LogUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /**
     * 因为 BuildConfig.DEBUG 这个值在lib中，会一直为ture，所以要从外部module传入要给值来设定，否则一直不会打印
     */
    public static  boolean isDebug = false;


    private static String TAG = "Maowo";

    /** Log打印工具初始化
     * @param tag 自定义TAG，可以传空
     */
    public static void init(String tag, boolean debug){
        if (!TextUtils.isEmpty(tag)){
            TAG = tag;
        }
        isDebug = debug;
        Logger.initialize(
                new Settings().isShowMethodLink(true)
                        .isShowThreadInfo(false)
                        .setMethodOffset(1)
                        .setLogPriority(isDebug ? Log.VERBOSE : Log.ASSERT)
        );



    }


    public static void v(String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).v(msg, args);
        }
    }

    public static void d(String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).d(msg, args);
        }
    }

    public static void i(String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).i(msg, args);
        }
    }

    public static void w(String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).w(msg, args);
        }
    }

    public static void w(Throwable throwable,String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).w(msg, args);
        }
    }

    public static void e(String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).e(msg, args);
        }
    }

    public static void e(Throwable throwable, String msg, Object... args) {
        if (isDebug){
            Logger.t(TAG).e(msg, args);
        }
    }

    public static void v(String tag, String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).v(msg, args);
        }
    }

    public static void d(String tag, String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).d(msg, args);
        }
    }

    public static void i(String tag, String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).i(msg, args);
        }
    }

    public static void w(String tag,String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).w(msg, args);
        }
    }

    public static void w(String tag,Throwable throwable,String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).w(throwable,msg, args);
        }
    }

    public static void e(String tag,String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).e(msg, args);
        }
    }

    public static void e(String tag,Throwable throwable, String msg, Object... args) {
        if (isDebug){
            Logger.t(tag).e(throwable,msg, args);
        }
    }

    /**
     * Formats the json content and print it
     *
     * @param json the json content
     */
    public static void json(String json) {
        if (isDebug){
            try {
                Logger.json(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Formats the json content and print it
     *
     * @param xml the xml content
     */
    public static void xml(String xml) {
        if (isDebug){
            Logger.xml(xml);
        }
    }

    /**
     * Formats the json content and print it
     *
     * @param object Bean,Array,Collection,Map,Pojo and so on
     */
    public static void object(Object object) {
        if (isDebug){
            Logger.object(object);
        }
    }


}
