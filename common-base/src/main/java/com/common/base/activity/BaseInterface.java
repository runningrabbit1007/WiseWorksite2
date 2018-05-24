package com.common.base.activity;

/**
 * 基础组建的基础接口
 * Created by jack on 2017/5/19.
 */

public interface BaseInterface {
    /**
     * TODO 获取layout id
     */
    int getContentViewId();

    /**
     * TODO 抽象方法，定制顶部栏样式
     */
    void initTitle();

    /**
     * TODO 抽象方法，初始化View
     */
    void initView();

    /**
     * TODO 抽象方法，初始化数据
     */
    void initData();
}
