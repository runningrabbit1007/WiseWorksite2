package com.sx.common_base.activity.project_maneger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.base.BaseRequestUrlActivity;


/**
 *
 * 工人信息--add
 *
 */

public class WorkerInformationAddActivity extends BaseRequestUrlActivity {


    @Override
    public int getContentViewId() {
        return R.layout.activity_worker_information_add;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("添加信息");
        mTitleBar.setRightText("完成");
        mTitleBar.setLeftText("取消");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.setRightTextColor(Color.WHITE);
        mTitleBar.setleftTextColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线
        mTitleBar.setLeftTextClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
