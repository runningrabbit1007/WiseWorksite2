package com.sx.common_base;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;

import com.common.base.BaseApplication;
import com.common.utils.LogUtils;
import com.sx.common_base.http.BaseHttpManager;
import com.sx.common_base.http.RequestMaster;
import com.sx.common_base.loader.UILImageLoader;
import com.sx.common_base.util.ApiMaster;

import java.io.File;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by android001 on 2016/7/26.
 */
public class ConfigureApplication extends BaseApplication {
//    private DaoSession mDaoSession;
    private static ConfigureApplication instance;

    public static ConfigureApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化网络请求
        BaseHttpManager.getInstance().initParam();
        //出事化请求管理者，设置http或者https协议
        RequestMaster.getInstance().setProtocol("http://");
        //导入api
        ApiMaster.loadApi();
        //初始化crash
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
//        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
//        SDKInitializer.setCoordType(CoordType.BD09LL);

//        new BaiduMapUtil(getApplicationContext()).initLocation();

        //设置主题
//ThemeConfig.CYAN
        ThemeConfig themeConfig = null;
        ThemeConfig theme = new ThemeConfig.Builder()
                .setTitleBarBgColor(Color.rgb(0xFF, 0x57, 0x22))
                .setTitleBarTextColor(Color.WHITE)
                .setTitleBarIconColor(Color.WHITE)
                .setFabNornalColor(instance.getApplicationContext().getResources().getColor(R.color.text_main_color))
                .setFabPressedColor(instance.getApplicationContext().getResources().getColor(R.color.text_main_color))
                .setCheckNornalColor(Color.GRAY)
                .setCheckSelectedColor(instance.getApplicationContext().getResources().getColor(R.color.text_main_color))
                .setIconBack(R.drawable.common_back)
                .build();
        themeConfig = theme;
//配置功能
        FunctionConfig.Builder functionConfigBuilder  = new FunctionConfig.Builder();
        functionConfigBuilder.setEnableCamera(true)
                .setEnablePreview(true);


        final FunctionConfig functionConfig = functionConfigBuilder.build();



//配置imageloader
        ImageLoader imageloader = new UILImageLoader(instance.getApplicationContext());
        CoreConfig coreConfig = new CoreConfig.Builder(instance.getApplicationContext(), imageloader, theme)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);



    }

}
