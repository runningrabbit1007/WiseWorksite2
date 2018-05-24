package com.sx.common_base.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

import java.lang.reflect.Field;

/**
 * Created by yonggege on 2017/9/21.
 */


public class MyTabLayout extends TabLayout {
    private static int tabViewNumber = 3;
    private static final String SCROLLABLE_TAB_MIN_WIDTH = "mScrollableTabMinWidth";
    public MyTabLayout(Context context) {
        super(context);
//        initTabMinWidth();
    }

    public void setTabViewNumber(int tabViewNumber){
        MyTabLayout.tabViewNumber = tabViewNumber;
        initTabMinWidth();
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        initTabMinWidth();
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initTabMinWidth();
    }
    private void initTabMinWidth() {
        int screenWidth=getResources().getDisplayMetrics().widthPixels;
        int tabMinWidth = screenWidth / tabViewNumber;

        Field field;
        try {
            field = TabLayout.class.getDeclaredField(SCROLLABLE_TAB_MIN_WIDTH);
            field.setAccessible(true);
            field.set(this, tabMinWidth);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}