package com.common.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by jack on 2017/5/18.
 * 操作View的工具
 */

public class ViewUtil {
    /**
     * 根据布局文件id得到view
     *
     * @param layoutId
     *            layout id
     * @return
     */
    public static View getView(Context context, int layoutId, ViewGroup group) {
        return View.inflate(context, layoutId, group);
    }



    /**
     * 设置view不可用
     *
     * @param views
     */
    public static void setViewUnAble(View... views) {
        for (View view : views)
            view.setEnabled(false);
    }

    public static void setViewInVisible(View... views) {
        for (View view : views)
            view.setVisibility(View.INVISIBLE);
    }

    public static void setViewVisible(View... views) {
        for (View view : views)
            view.setVisibility(View.VISIBLE);
    }

    public static void setViewGone(View... views) {
        for (View view : views)
            view.setVisibility(View.GONE);
    }

    /**
     * 设置view可见
     *
     * @param visibility
     * @param views
     */
    public static void setViewVisibility(int visibility, View... views) {
        for (View view : views)
            view.setVisibility(visibility);
    }

    /**
     * 设置view可用
     *
     * @param views
     */
    public static void setViewAble(View... views) {
        for (View view : views)
            view.setEnabled(true);
    }

    /**
     * 发布模块设置工种等提示
     * */
    public static void setHintTextViewStatus(FrameLayout fram, int number, TextView topTv, TextView underTv){
        if(number == 0){
            topTv.setVisibility(View.INVISIBLE);
            fram.addView(underTv);
        }else {
            topTv.setVisibility(View.VISIBLE);
            fram.removeView(underTv);
        }
    }

}
