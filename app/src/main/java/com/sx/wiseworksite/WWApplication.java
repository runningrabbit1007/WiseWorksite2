package com.sx.wiseworksite;

import android.os.Build;
import android.os.StrictMode;

import com.common.base.cash.CustomActivityOnCrash;
import com.common.base.config.PreferencesManager;
import com.common.base.image.ImageDisplayManager;
import com.common.utils.LogUtils;
import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;
import com.sx.common_base.ConfigureApplication;
import com.sx.common_base.activity.ProjectMainActivity;
import com.sx.wiseworksite.adapter.ProjectListActivity;
import com.sx.wiseworksite.login.ForgotPswOneActivity;
import com.sx.wiseworksite.login.ForgotPswTwoActivity;

/**
 * Created by Administrator on 2018/4/9.
 */

public class WWApplication extends ConfigureApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

      /*  Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = newLocale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());//更新配置*/


        boolean isDebug = BuildConfig.DEBUG;
        //初始化打印工具isDebug
        LogUtils.init("WiseWorksite", isDebug);

        ImageDisplayManager.getInstance().init(this);

        PreferencesManager.init(this);

        CustomActivityOnCrash.install(this);

        initRouter();

    }

    private void initRouter() {

        Router.sharedRouter().setContext(getApplicationContext());

        /**忘记密码 第一步*/
        Router.sharedRouter().map(RouterActions.ACTION_FORGET_PASSWORD_ONE, ForgotPswOneActivity.class);

        /**忘记密码 第二步*/
        Router.sharedRouter().map(RouterActions.ACTION_FORGET_PASSWORD_TWO, ForgotPswTwoActivity.class);

        /**项目列表*/
        Router.sharedRouter().map(RouterActions.ACTION_PROJECT_LIST, ProjectListActivity.class);

        /**项目主页*/
        Router.sharedRouter().map(RouterActions.ACTION_PROJECT_MAIN, ProjectMainActivity.class);


    }


}
