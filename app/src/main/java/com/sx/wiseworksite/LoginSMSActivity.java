package com.sx.wiseworksite;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.base.BaseRequestUrlActivity;

public class LoginSMSActivity extends BaseRequestUrlActivity {


    @Override
    public int getContentViewId() {
        return R.layout.activity_login_sms;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("登录");
        mTitleBar.setRightText("密码登录");
        mTitleBar.setBackgroundResource(R.color.white);
        mTitleBar.setTitleColor(R.color.text_first_color);
        mTitleBar.setTitleColor(Color.BLACK);
        mTitleBar.setRightTextColor(R.color.text_main_color);
        mTitleBar.hiddenGrayLine();//隐藏灰线
        mTitleBar.setRightTextClick(new View.OnClickListener() {
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
