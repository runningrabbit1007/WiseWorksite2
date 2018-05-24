package com.common.base;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.content.Context;
import com.common.base.config.PreferencesManager;
import com.common.base.http.netdector.NetStateChangeReceiver;
import com.common.base.image.ImageDisplayManager;

/**
 * Created by Jack on 2016/6/12.
 * 基础配置Application
 */
public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
//        initGalleryFinal();
//        initFileDownloader();

        ImageDisplayManager.getInstance().init(this);

        PreferencesManager.init(this);


        // 注册BroadcastReceiver
        NetStateChangeReceiver.registerReceiver(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // 取消BroadcastReceiver注册
        NetStateChangeReceiver.unregisterReceiver(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

//    private void initGalleryFinal() {
//        CoreConfig coreConfig = new CoreConfig.Builder(getApplicationContext(), new GlideImageLoader(), BaseConfig.theme)
//                .setFunctionConfig(BaseConfig.functionConfig)
//                .setPauseOnScrollListener(new GlidePauseOnScrollListener(false, true))
//                .build();
//        GalleryFinal.init(coreConfig);
//    }


//    private void initFileDownloader(){
//
//        FileDownloader.init(getApplicationContext(),
//                new FileDownloadHelper.OkHttpClientCustomMaker() { // is not has to provide.
//                    @Override
//                    public OkHttpClient customMake() {
//                        // just for OkHttpClient customize.
//                        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                        // you can set the connection timeout.
//                        builder.connectTimeout(15000, TimeUnit.MILLISECONDS);
//                        // you can set the HTTP proxy.
//                        builder.proxy(Proxy.NO_PROXY);
//                        // etc.
//                        return builder.build();
//                    }
//                },5);
//
//    }

}
