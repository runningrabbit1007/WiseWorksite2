package com.sx.common_base.http;

import android.util.Log;

import com.common.base.bean.ServiceBean;
import com.common.base.bean.pojo.BaseSaveFilePojo;
import com.common.base.config.PreferencesManager;
import com.common.utils.CheckUtil;
import com.common.utils.JSONUtil;
import com.common.utils.LogUtils;
import com.common.utils.security.Base64Coder;
import com.common.utils.string.MD5Util;
//import com.ffu365.custom.callback.BaseSmartCallback;
//import com.ffu365.custom.callback.BaseSmartMallCallback;
//import com.ffu365.custom.constant.BundleKeys;
//import com.ffu365.custom.constant.ConstantValue;
//import com.ffu365.custom.constant.ErrorCode;
//import com.ffu365.custom.modle.ApiEntity;
//import com.ffu365.custom.modle.request.RequestModel;
//import com.ffu365.custom.orm.entity.MockHandler;
//import com.ffu365.custom.util.ApiMaster;
//import com.ffu365.custom.util.QueryHelper;
import com.sx.common_base.callback.BaseSmartCallback;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.BundleKeys;
import com.sx.common_base.constant.ConstantValue;
import com.sx.common_base.constant.ErrorCode;
import com.sx.common_base.modle.ApiEntity;
import com.sx.common_base.modle.request.RequestModel;
import com.sx.common_base.util.ApiMaster;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2017/6/6$
 * Desc   : 网络请求管理者
 * 1. 作为全局网络请求入口，所有的网络请求都由该类承接
 * 2. 在内部有机制去控制缓存数据、模拟数据、网络请求数据的调用和存储
 * 3. 全局API主机地址替换入口
 */

public class RequestMaster {


    private String protocol;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIndex() {
        if (!CheckUtil.isEmpty(protocol)) {
            if (INDEX_ENV.startsWith("https://")) {
                INDEX_ENV = INDEX_ENV.replace("https://", protocol);

            }
            if (INDEX_ENV.startsWith("http://")) {
                INDEX_ENV = INDEX_ENV.replace("http://", protocol);
            }
        }
        return INDEX_ENV;
    }


    private static final String TAG = "RequestMaster";

    private static RequestMaster requestMaster;


    private static String INDEX_ENV = "http://api.factory-connect.com/";
//    private static String INDEX_ENV = "http://k.hnsxtech.com:8088";
//        private static String INDEX_ENV = "http://192.168.0.123:8082";
//    private static String INDEX_ENV = "http://192.168.0.188:8082";
//    private static String INDEX_ENV = "http://192.168.0.140:8082";
//    private static String INDEX_ENV = "http://192.168.0.250:8088";

    private static String INDEX_ENV_MALL = "http://api.factory-connect.com/";
//    private static String INDEX_ENV_MALL = "http://k.hnsxtech.com:8088";
//    private static String INDEX_ENV_MALL = "http://192.168.0.123:8082";//春梅
//    private static String INDEX_ENV_MALL = "http://192.168.0.188:8082";//188
//    private static String INDEX_ENV_MALL = "http://192.168.0.140:8082";//刘13548政
//    private static String INDEX_ENV_MALL = "http://192.168.0.250:8088";


    public static String DEALER_TYPE="2";
    public static String SALESTYPE_TYPE="1";
    public static String SUPPLIER_TYPE="3";

    public static String GOOGLE_MAP_KEY="AIzaSyAI7Evc3IdzWDcmEggRTNgC2rIqUcH2H58";




    public static void setIndex(String newUrl) {
        INDEX_ENV = newUrl;
    }


    public static RequestMaster getInstance() {
        if (requestMaster == null) {
            synchronized (RequestMaster.class) {
                requestMaster = new RequestMaster();
            }
        }
        return requestMaster;
    }

    /**
     * 通过API_KEY 获取ApiEntity
     *
     * @param key
     * @return
     */
    private ApiEntity getApiByKey(String key) {
        return ApiMaster.findApiByKey(key);
    }

    /**
     * 通过API_URL 获取ApiEntity
     *
     * @return
     */
    public ApiEntity getApiByUrl(String url) {
        return ApiMaster.findApiByUrl(url);
    }

    /**
     * 获取拼装好之后的URL
     *
     * @param key
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getOriginUrl(String key, Map<String, String> params) {
        String originUrl = "";
        ApiEntity apiEntity = getApiByKey(key);
        //生成完整真实的url
        String realUrl = getRealUrl(apiEntity);
        StringBuffer stringBuffer = new StringBuffer(realUrl);
        if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {//如果是get类型，将请求字段排序后，追加到url后面，并进行md5转码
            List<Map.Entry<String, String>> list = new ArrayList<>(params.entrySet());
            if (list.size() > 0) { //如果参数不为空
                if (list.size() > 1) {
                    //然后通过比较器来实现排序
                    Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                        //升序排序
                        public int compare(Map.Entry<String, String> o1,
                                           Map.Entry<String, String> o2) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                    });
                }
                for (Map.Entry<String, String> mapping : list) {
                    stringBuffer.append("&").append(mapping.getKey()).append("=").append(mapping.getValue());
                }
                Log.i("tag", new String(stringBuffer));
            } else {
                //如果参数为空，则需要删除最后一个问号（？）
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf("?"));
            }
        } else if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_POST)) { //如果是post类型，将请求content追加到url的最后，进行MD5转码
            stringBuffer.append(params.get(BundleKeys.PARAM_KEY_CONTENT));
        }
        originUrl = new String(stringBuffer);
        return originUrl;
    }

    /**
     * 获取拼装好之后的URL   商城
     *
     * @param key
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getOriginUrlMall(String key, Map params) {
        String originUrl = "";
        ApiEntity apiEntity = getApiByKey(key);
        //生成完整真实的url
        String realUrl = getRealUrlMall(apiEntity);
        StringBuffer stringBuffer = new StringBuffer(realUrl);
        if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {//如果是get类型，将请求字段排序后，追加到url后面，并进行md5转码
            List<Map.Entry<String, String>> list = new ArrayList<>(params.entrySet());
            if (list.size() > 0) { //如果参数不为空
                if (list.size() > 1) {
                    //然后通过比较器来实现排序
                    Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                        //升序排序
                        public int compare(Map.Entry<String, String> o1,
                                           Map.Entry<String, String> o2) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                    });
                }
                for (Map.Entry<String, String> mapping : list) {
                    stringBuffer.append("&").append(mapping.getKey()).append("=").append(mapping.getValue());
                }
                Log.i("tag", new String(stringBuffer));
            } else {
                //如果参数为空，则需要删除最后一个问号（？）
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf("?"));
            }
        } else if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_POST)) { //如果是post类型，将请求content追加到url的最后，进行MD5转码\
            if(params!=null) {
                stringBuffer.append(params.get(BundleKeys.PARAM_KEY_CONTENT));
            }
        }
        originUrl = new String(stringBuffer);
        return originUrl;
    }

    public String getCacheKey(String key, Map<String, String> params) {
        return MD5Util.strToMd5(getOriginUrl(key, params));
    }

    public String getCacheKey(String originUrl) {
        return MD5Util.strToMd5(originUrl);
    }

    /**
     * 匹配替换掉index url
     *
     * @param entity
     * @return 1. 如果需要加token，则在url上加"?accessToken=tokenValue"
     * 1. 如果需要不加，但是又是GET方法，则在url上加"?"
     */
    public String getRealUrl(ApiEntity entity) {
        if (entity == null) {
            return "";
        }
        String targetUrl = entity.url;
        if (!CheckUtil.isEmpty(targetUrl)) {
//            String replace = targetUrl.replace("${indexUrl}", getIndex());
            String replace = targetUrl.replace("${indexUrl}", INDEX_ENV);

            if (entity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
                replace += "?";
            }

            return replace;
        } else {
            return "";
        }
    }

    /**
     * 匹配替换掉index url 商城
     *
     * @param entity
     * @return 1. 如果需要加token，则在url上加"?accessToken=tokenValue"
     * 1. 如果需要不加，但是又是GET方法，则在url上加"?"
     */
    public String getRealUrlMall(ApiEntity entity) {
        if (entity == null) {
            return "";
        }
        String targetUrl = entity.url;
        if (!CheckUtil.isEmpty(targetUrl)) {
//            String replace = targetUrl.replace("${indexUrl}", getIndex());
            String replace = targetUrl.replace("${indexUrl}", INDEX_ENV_MALL);

            if (entity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
                replace += "?";
            }

            return replace;
        } else {
            return "";
        }
    }

    public String processUrl(String targetUrl) {
        if (!CheckUtil.isEmpty(targetUrl)) {
            String replace = targetUrl.replace("${indexUrl}", getIndex());
            replace = replace.replace("/", "_");
            replace = replace.toUpperCase(Locale.getDefault());
            return replace;
        } else {
            return "";
        }
    }

    /**
     * 获取缓存到期时间
     *
     * @param second
     * @return
     */
    public long getCacheTime(int second) {
        return System.currentTimeMillis() + (second * 1000);
    }

    /**
     * 请求入口
     *
     * @param apiKey   API接口的key
     * @param params   API的参数
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     */
    public RequestCall callGetRequest(String apiKey, Map<String, String> params, BaseSmartCallback callback, String tag) {

        return callRequest(apiKey, params, null, callback, tag);
    }


    /**
     * @param apiKey   API接口的key
     * @param content  API的请求内容
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     * @deprecated 请求入口
     */
    public RequestCall callPostRequest(String apiKey, String content, BaseSmartCallback callback, String tag) {
        HashMap<String, String> params = new HashMap<>();
        params.put(BundleKeys.PARAM_KEY_CONTENT, content);
        return callRequest(apiKey, params, null, callback, tag);
    }


    /**
     * 请求入口
     *
     * @param apiKey   API接口的key
     * @param data     API DATA bean
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     */
    public RequestCall callPostRequest(String apiKey, Object data, BaseSmartCallback callback, String tag) {
        RequestModel requestModel = new RequestModel(data);
        HashMap<String, String> params = new HashMap<>();
        //requestModel 上传图片的时候内存溢出
        try {
            params.put(BundleKeys.PARAM_KEY_CONTENT, JSONUtil.toJSON(requestModel));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callRequest(apiKey, params, null, callback, tag);
    }

    /**
     * 请求入口
     *
     * @param apiKey   API接口的key
     * @param data     API DATA bean
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     */
    public RequestCall callPostRequestMall(String apiKey, Map data, BaseSmartMallCallback callback, String tag) {

        return callRequestMall(apiKey, data, null, callback, tag);
    }

    public void doSimpleDownloadFiles(String loadUrl, Object data, BaseSaveFilePojo baseSaveFilePojo, FileCallBack callback, String tag) {
        RequestModel requestModel = new RequestModel(data);
        HashMap<String, String> params = new HashMap<>();
        params.put(BundleKeys.PARAM_KEY_CONTENT, JSONUtil.toJSON(requestModel));

        BaseHttpManager.getInstance().doSimpleDownloadFiles(loadUrl, params, null, tag, baseSaveFilePojo, callback);

    }

    /**
     * 请求入口
     *
     * @param apiKey   API接口的key
     * @param content  API的请求内容
     * @param callback API接口的回掉
     * @return 返回请求call实例
     */
    public RequestCall callPostRequest(String apiKey, String content, BaseSmartCallback callback) {
        return callPostRequest(apiKey, content, callback, TAG);
    }

    /**
     * 请求入口
     *
     * @param apiKey   API接口的key
     * @param params   API的参数或者内容：GET方法时，params是参数；POST方法时，params只有一个键值对"content":"{...}"
     * @param heads    API接口的头部参数
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     */
    public RequestCall callRequest(String apiKey, Map<String, String> params, Map<String, String> heads, BaseSmartCallback callback, String tag) {

        String sessionid = PreferencesManager.getInstance().getSESSIONID();
        heads = new HashMap<>();
        heads.put("Content-Type","application/json");
//        heads.put("Cookie", mallCookie);
        heads.put("Cookie","JSESSIONID="+sessionid);
        ApiEntity apiEntity = getApiByKey(apiKey);
        if (apiEntity == null) {
            callback.onApiError(ErrorCode.E_NO_KEY);
            return null;
        }
        String originUrl = getOriginUrlMall(apiKey, params); // 降url拼接起来，如果是GET：http://xxx.xx?key1=value1&key2=value2；如果是POST:http://xxx.xx?{...}
        String key = getCacheKey(originUrl); //获取cacheKey
        if (!CheckUtil.isEmpty(apiEntity.mockhandler)) {//如果有模拟数据
            try {
                Class<?> mockHandler = Class.forName(apiEntity.mockhandler);
                Constructor constructor = mockHandler.getConstructor();/*
                MockHandler instance = (MockHandler) constructor.newInstance();
                callback.onGetSuccess(instance.getMockJson());*/
            } catch (Exception e) {
                callback.onApiError(ErrorCode.E_NO_HANDLER);
            }
        } /*else if (Integer.parseInt(apiEntity.expires) > 0) {// 没有模拟数据,但是该api有缓存标志
            //检查是否有缓存
            if (QueryHelper.checkCacheDue(key)) {//缓存过期了
                LogUtils.d("callRequest() called with: 拿的是网络请求数据");
                if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
                    return BaseHttpManager.getInstance().doGetAsynReturnCall(originUrl, heads, tag, callback);
                } else if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_POST)) {
                    return BaseHttpManager.getInstance().doPostStringAsynReturnCallMall(getRealUrlMall(apiEntity), params, heads, callback, tag);
                }
            } else {//缓存还没过期，返回缓存数据
                String result = QueryHelper.getCacheEntity(key).getContent();
                callback.onGetSuccess(JSONUtil.toJsonObject(new String(Base64Coder.decode(result))));
                LogUtils.e("result == " + new String(Base64Coder.decode(result)));
            }
        }*/ else {
            //api没有缓存机制，则直接获取数据
            if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
                return BaseHttpManager.getInstance().doGetAsynReturnCall(originUrl, heads, tag, callback);
            } else if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_POST)) {
                return BaseHttpManager.getInstance().doPostStringAsynReturnCallMall(getRealUrlMall(apiEntity), params, heads, callback, tag);
            }
            LogUtils.d("callRequest() called with: 拿的是网络请求数据");
        }
        return null;
    }


    /**
     * 请求入口 图片上传
     *
     * @param apiKey   API接口的key
     * @param params   API的参数或者内容：GET方法时，params是参数；POST方法时，params只有一个键值对"content":"{...}"
     * @param headers    API接口的头部参数
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     */
    public void callRequestFile(String apiKey,  HashMap params, HashMap headers,  BaseSmartCallback callback, String tag, ServiceBean serviceBean) {

        String sessionid = PreferencesManager.getInstance().getSESSIONID();
//        heads = new HashMap<>();
        ApiEntity apiEntity = getApiByKey(apiKey);
        if (apiEntity == null) {
        }
        String originUrl = getOriginUrlMall(apiKey, params); // 降url拼接起来，如果是GET：http://xxx.xx?key1=value1&key2=value2；如果是POST:http://xxx.xx?{...}
        if (!CheckUtil.isEmpty(apiEntity.mockhandler)) {//如果有模拟数据
            try {
                Class<?> mockHandler = Class.forName(apiEntity.mockhandler);
                Constructor constructor = mockHandler.getConstructor();
            } catch (Exception e) {
//                callback.onApiError(ErrorCode.E_NO_HANDLER);
            }
        }else {
            //api没有缓存机制，则直接获取数据
            BaseHttpManager.getInstance().doSimpleUploadFile(getRealUrlMall(apiEntity), params,headers,null,500l,2000l,serviceBean,callback);
            LogUtils.d("callRequest() called with: 拿的是网络请求数据");
        }
    }


    /**
     * 请求入口 商城
     *
     * @param apiKey   API接口的key
     * @param params   API的参数或者内容：GET方法时，params是参数；POST方法时，para ms只有一个键值对"content":"{...}"
     * @param heads    API接口的头部参数
     * @param callback API接口的回掉
     * @param tag      API接口请求的tag
     * @return 返回请求call实例
     */
    public RequestCall callRequestMall(String apiKey, Map params, Map<String, String> heads, BaseSmartMallCallback callback, String tag) {
        String sessionid = PreferencesManager.getInstance().getSESSIONID();
        heads = new HashMap<>();
//        heads.put("Cookie", mallCookie);
        heads.put("Cookie","JSESSIONID="+sessionid);
//        heads.put("cookie","84A4E96A29AEB23CD9279D01092184F7");
        ApiEntity apiEntity = getApiByKey(apiKey);
        if (apiEntity == null) {
            callback.onApiError(ErrorCode.E_NO_KEY);
            return null;
        }
        String originUrl = getOriginUrlMall(apiKey, params); // 降url拼接起来，如果是GET：http://xxx.xx?key1=value1&key2=value2；如果是POST:http://xxx.xx?{...}
        String key = getCacheKey(originUrl); //获取cacheKey
        if (!CheckUtil.isEmpty(apiEntity.mockhandler)) {//如果有模拟数据
            try {
                Class<?> mockHandler = Class.forName(apiEntity.mockhandler);
                Constructor constructor = mockHandler.getConstructor();/*
                MockHandler instance = (MockHandler) constructor.newInstance();
                callback.onGetSuccess(instance.getMockJson());*/
            } catch (Exception e) {
                callback.onApiError(ErrorCode.E_NO_HANDLER);
            }
        } /*else if (Integer.parseInt(apiEntity.expires) > 0) {// 没有模拟数据,但是该api有缓存标志
            //检查是否有缓存
            if (QueryHelper.checkCacheDue(key)) {//缓存过期了
                LogUtils.d("callRequest() called with: 拿的是网络请求数据");
                if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
                    return BaseHttpManager.getInstance().doGetAsynReturnCall(originUrl, heads, tag, callback);
                } else if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_POST)) {
                    return BaseHttpManager.getInstance().doPostStringAsynReturnCallMall(getRealUrlMall(apiEntity), params, heads, callback, tag);
                }
            } else {//缓存还没过期，返回缓存数据
                String result = QueryHelper.getCacheEntity(key).getContent();
                callback.onGetSuccess(JSONUtil.toJsonObject(new String(Base64Coder.decode(result))));
                LogUtils.e("result == " + new String(Base64Coder.decode(result)));
            }
        }*/ else {
            //api没有缓存机制，则直接获取数据
            if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
                return BaseHttpManager.getInstance().doGetAsynReturnCall(originUrl, heads, tag, callback);
            } else if (apiEntity.netType.toUpperCase().equals(ConstantValue.NET_METHOD_POST)) {
                return BaseHttpManager.getInstance().doPostStringAsynReturnCallMall(getRealUrlMall(apiEntity), params, heads, callback, tag);
            }
            LogUtils.d("callRequest() called with: 拿的是网络请求数据");
        }
        return null;
    }





    public void cancleRequest(String tag) {
        OkHttpUtils.getInstance().cancelTag(tag);
    }


}
