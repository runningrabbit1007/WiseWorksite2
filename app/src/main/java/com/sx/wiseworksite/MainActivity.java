package com.sx.wiseworksite;


import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.wiseworksite.adapter.ProjectListActivity;

import butterknife.OnClick;

public class MainActivity extends BaseRequestUrlActivity {


    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("登录");
        mTitleBar.setRightText("短信登录");
        mTitleBar.setBackgroundResource(R.color.white);
        mTitleBar.setTitleColor(R.color.text_first_color);
        mTitleBar.setTitleColor(Color.BLACK);
        mTitleBar.setRightTextColor(R.color.text_main_color);
        mTitleBar.hiddenGrayLine();//隐藏灰线
        mTitleBar.setRightTextClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,LoginSMSActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.goToForgotPswOne)
    public void goToForgotPswOne(){
        Router.sharedRouter().open(RouterActions.ACTION_FORGET_PASSWORD_ONE);
    }

    @OnClick(R.id.gotoProjectList)
    public void gotoProjectList(){
        Router.sharedRouter().open(RouterActions.ACTION_PROJECT_LIST);
    }

}
