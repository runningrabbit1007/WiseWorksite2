package com.common.base.activity;

import com.common.base.http.netdector.NetworkType;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.Map;

/**
 * 基础组建之网络请求接口
 * Created by jack on 2017/5/19.
 */

public interface RequestInterface {



    /**
     * 是否有网络
     * @return true是有，false是无网络
     */
    boolean isHaveNet();

    /**
     * 获取网络类型
     * @return 2G,3G,4G,WIFI
     */
    NetworkType getNetType();



//    RequestCall sendPostRequest(String tag, String url, Map<String, String> params, Callback callback);

//    RequestCall sendGetRequest(String tag, String url, Map<String, String> params, Callback callback);

//    RequestCall sendPostRequest(String tag, String url, Map<String, String> params,Map<String, String> heads, Callback callback);

//    RequestCall sendGetRequest(String tag, String url, Map<String, String> params,Map<String, String> heads, Callback callback);

//    RequestCall sendPostStringRequest(String url, String content, Map<String, String> heads , Callback callback,String tag);
//
//    RequestCall sendPostStringRequest(String url, String content, Callback callback, String tag);

//    RequestCall sendGetStringRequest(String tag, String url, String content, Callback callback);

}
