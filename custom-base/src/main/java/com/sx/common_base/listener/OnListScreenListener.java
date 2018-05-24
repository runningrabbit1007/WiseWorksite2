package com.sx.common_base.listener;

/**
 * Created by yonggege on 2017/7/5.
 * 列表筛选回掉
 */

public interface OnListScreenListener<T> {
    void screen(T filter);
}
