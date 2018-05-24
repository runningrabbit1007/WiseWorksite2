package com.common.base.widget.titlebar;

import android.view.View;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/8/4
 * Desc   :
 */
public class ViewBean {
    public int resId = 0;
    public int visibleId = View.GONE;

    public ViewBean(int resId) {
        this.resId = resId;
        this.visibleId = View.VISIBLE;
    }

    public ViewBean() {
        this.resId = -1;
        this.visibleId = View.GONE;
    }
}
