package com.sx.common_base.activity.project_maneger;

import android.graphics.Color;
import android.os.Bundle;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.base.BaseRequestUrlActivity;

/**
 *
 * 添加物料使用单-add
 *
 */
public class UsingMaterialAddActivity extends BaseRequestUrlActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_using_material_add;
    }

    @Override
    public void initTitle() {


        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("添加物料使用单");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
