package com.sx.common_base.fragment;

import android.graphics.Color;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.base.BaseRequestUrlFragment;

/**
 * Created by Administrator on 2018/4/10.
 */

public class IndexFragment extends BaseRequestUrlFragment {



    @Override
    public int getContentViewId() {
        return R.layout.fragment_index_layout;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.dingwei))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("首页");
        mTitleBar.setLeftText("工地1号");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.setleftTextColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
