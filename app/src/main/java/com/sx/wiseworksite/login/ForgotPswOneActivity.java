package com.sx.wiseworksite.login;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.wiseworksite.R;

import butterknife.OnClick;

public class ForgotPswOneActivity extends BaseRequestUrlActivity {


    @Override
    public int getContentViewId() {
        return R.layout.activity_forgot_psw_one;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("忘记密码");
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

    @OnClick(R.id.goToForgotPswTwo)
    public void goToForgotPswTwo(){
        Router.sharedRouter().open(RouterActions.ACTION_FORGET_PASSWORD_TWO);
    }

}
