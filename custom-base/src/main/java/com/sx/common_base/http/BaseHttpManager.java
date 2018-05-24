package com.sx.common_base.http;

import android.text.TextUtils;

import com.common.base.bean.ServiceBean;
import com.common.base.bean.pojo.BaseSaveFilePojo;
import com.common.base.bean.pojo.BaseUplodFilePojo;
import com.common.base.config.BaseConfig;
import com.common.base.http.BaseLoggerInterceptor;
import com.common.base.http.HttpBase;
import com.common.base.http.NullHostNameVerifier;
import com.common.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.https.HttpsUtils;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Jack on 2016/5/19.
 * 网络请求同意分装接口 V1.0
 */
public class BaseHttpManager extends HttpBase {


    private String TAG = "BaseHttpManager";
    private static BaseHttpManager httpManager = null;
    private final String URL_ERROR = "The url is empty or not valid";
    private final String RESULT_CALLBACK_ERROR = "CallBack is empty, you can't get the message";
    private final String DATA_TYPE_ERROR = "the data type is null, you can't get the message";
    private final String GSON_ERROT = "Parser the Gson have error";

    private BaseHttpManager() {
    }

    public void initParam() {
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
//        CookieJarImpl cookieJar1 = new CookieJarImpl(new PersistentCookieStore(App.INSTANCE));
        OkHttpClient okHttpClient = null;
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .hostnameVerifier(new NullHostNameVerifier())
                .addInterceptor(new BaseLoggerInterceptor(BaseConfig.TAG))
//                .cookieJar(cookieJar1)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();

        OkHttpUtils.initClient(okHttpClient);

    }

    public static BaseHttpManager getInstance() {
        if (httpManager == null) {
            synchronized (BaseHttpManager.class) {
                httpManager = new BaseHttpManager();
            }
        }
        return httpManager;
    }


    @Override
    public void doGetAsyn(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, final Callback resultCallBack) {
        GetBuilder myGetBuilder = OkHttpUtils.get().addHeader("mw-client", "android");


        if (!TextUtils.isEmpty(targetUrl)) {
            myGetBuilder.url(targetUrl);
        }
        if (params != null) {
            myGetBuilder.params(params);
        }
        if (headers != null) {
            myGetBuilder.headers(headers);
        }
        if (tag != null) {
            myGetBuilder.tag(tag);
        } else {
            myGetBuilder.tag(BaseConfig.TAG);
        }

        RequestCall myRequestCall = myGetBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }

        if (resultCallBack == null) {
            LogUtils.e(TAG, RESULT_CALLBACK_ERROR);
        }


        myRequestCall.execute(resultCallBack);

    }


    /**
     * 发送异步GET请求
     * 特别说明：虽然okhttpUtil支持我们通过Map集合的形式去设置请求参数，但是为了配合我们的缓存方案，如果用map设置参数的话，在拿到结果之后，无法拿到请求参数（即map中的参数），所以无法生成对应的cacheKey。
     * 但是如果直接使用完整的get url（http://xxx.xx?key1=value1&key2=value2），这种形式下，在拿到结果（Response）之后，请求参数我们是可以拿到的，这样就可以还原cacheKey，从而实现缓存方案
     *
     * @param targetUrl 完整的get url
     * @param headers 头部
     * @param tag 请求标记
     * @param resultCallBack 请求回掉
     * @return  请求实
     */
    public RequestCall doGetAsynReturnCall(String targetUrl, Map headers, String tag, final Callback resultCallBack) {
        GetBuilder myGetBuilder = OkHttpUtils.get().addHeader("mw-client", "android");

        if (!TextUtils.isEmpty(targetUrl)) {
            myGetBuilder.url(targetUrl);
        }

        if (headers != null) {
            myGetBuilder.headers(headers);
        }
        if (tag != null) {
            myGetBuilder.tag(tag);
        } else {
            myGetBuilder.tag(BaseConfig.TAG);
        }

        RequestCall myRequestCall = myGetBuilder.build();


        if (resultCallBack == null) {
            LogUtils.e(TAG, RESULT_CALLBACK_ERROR);
        }


        myRequestCall.execute(resultCallBack);

        return myRequestCall;

    }

    @Override
    public Response doGetSync(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime) {
        GetBuilder myGetBuilder = OkHttpUtils.get().addHeader("mw-client", "android");

        if (!TextUtils.isEmpty(targetUrl)) {
            myGetBuilder.url(targetUrl);
        }
        if (params != null) {
            myGetBuilder.params(params);
        }
        if (headers != null) {
            myGetBuilder.headers(headers);
        }
        if (tag != null) {
            myGetBuilder.tag(tag);
        } else {
            myGetBuilder.tag(BaseConfig.TAG);
        }

        RequestCall myRequestCall = myGetBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }


        try {
            Response response = myRequestCall.execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void doPostAsyn(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime,
                           final Callback resultCallBack) {
        PostFormBuilder postFormBuilder = OkHttpUtils.post().addHeader("mw-client", "android");

        if (!TextUtils.isEmpty(targetUrl)) {
            postFormBuilder.url(targetUrl);
        }
        if (params != null) {
            postFormBuilder.params(params);
        }
        if (headers != null) {
            postFormBuilder.headers(headers);
        }
        if (tag != null) {
            postFormBuilder.tag(tag);
        } else {
            postFormBuilder.tag(BaseConfig.TAG);
        }

        RequestCall myRequestCall = postFormBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }
        if (resultCallBack == null) {
            LogUtils.e(TAG, RESULT_CALLBACK_ERROR);
        }


        LogUtils.d(TAG, "doPostAsyn");

        myRequestCall.execute(resultCallBack);
    }

    @Override
    public Response doPostSync(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime
    ) {
        PostFormBuilder postFormBuilder = OkHttpUtils.post().addHeader("mw-client", "android");


        if (!TextUtils.isEmpty(targetUrl)) {
            postFormBuilder.url(targetUrl);
        }
        if (params != null) {
            postFormBuilder.params(params);
        }
        if (headers != null) {
            postFormBuilder.headers(headers);
        }
        if (tag != null) {
            postFormBuilder.tag(tag);
        } else {
            postFormBuilder.tag(BaseConfig.TAG);
        }

        RequestCall myRequestCall = postFormBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }


        try {
            Response response = myRequestCall.execute();
            return response;

        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    //    @Override.addHeader("mw-client", "android")
    public void doPostStringAsyn(String url, String content, Callback callback) {
        OkHttpUtils
                .postString().tag(BaseConfig.TAG).addHeader("mw-client", "android")
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(content)
                .build()
                .execute(callback);

    }

    public void doPostStringAsyn(String url, String content, Callback callback, String tag) {
        OkHttpUtils
                .postString().tag(tag).addHeader("mw-client", "android")
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(content)
                .build()
                .execute(callback);

    }

    @Override
    public Response doPsotStringSync(String url, String content) throws IOException {


        return OkHttpUtils
                .postString().tag(BaseConfig.TAG).addHeader("mw-client", "android")
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(content)
                .build()
                .execute();

    }




    public RequestCall doPostStringAsynReturnCall(String url, String content, Callback callback, String tag) {
        RequestCall lCall = OkHttpUtils
                .postString().addHeader("mw-client", "android")
                .tag(tag)
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(content)
                .build();
        lCall.execute(callback);

        return lCall;
    }

    /**
     * 发送post数据流请求，并返回call
     * @param url
     * @param content
     * @param headers
     * @param callback
     * @param tag
     * @return
     */
    public RequestCall doPostStringAsynReturnCall(String url, String content, Map<String, String> headers, Callback callback, String tag) {

        RequestCall lCall = OkHttpUtils
                .postString().headers(headers)
                .tag(tag)
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(content)
                .build();
        lCall.execute(callback);

        return lCall;
    }


    /**
     * 发送post数据流请求，并返回call  商城
     * @param url
     * @param headers
     * @param callback
     * @param tag
     * @return
     */
    public RequestCall doPostStringAsynReturnCallMall(String url, Map data, Map<String, String> headers, Callback callback, String tag) {

        RequestCall lCall = OkHttpUtils
                .post().headers(headers)
                .params(data)
                .tag(tag)
                .url(url)
                .build();
        lCall.execute(callback);

        return lCall;
    }


    @Override
    public void doMultiUploadFiles(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, List<? extends BaseUplodFilePojo> list, final Callback progressCallback) {
        PostFormBuilder postFormBuilder = OkHttpUtils.post().addHeader("mw-client", "android");

        if (!TextUtils.isEmpty(targetUrl)) {
            postFormBuilder.url(targetUrl);
        }

        if (params != null) {
            postFormBuilder.params(params);
        }
        if (headers != null) {
            postFormBuilder.headers(headers);
        }
        if (tag != null) {
            postFormBuilder.tag(tag);
        } else {
            postFormBuilder.tag(BaseConfig.TAG);
        }

        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                postFormBuilder.addFile(list.get(i).key, list.get(i).filename, list.get(i).file);
            }
        }

        final RequestCall myRequestCall = postFormBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }
        if (progressCallback == null) {
            LogUtils.e(TAG, RESULT_CALLBACK_ERROR);
        }


        myRequestCall.execute(progressCallback);
    }


    @Override
    public void doSimpleUploadFile(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime, final ServiceBean pojo, final Callback progressCallback) {
        PostFormBuilder postFormBuilder = OkHttpUtils.post().addHeader("mw-client", "android");

        if (!TextUtils.isEmpty(targetUrl)) {
            postFormBuilder.url(targetUrl);
        }

        if (params != null) {
            postFormBuilder.params(params);
        }
        if (headers != null) {
            postFormBuilder.headers(headers);
        }
        if (tag != null) {
            postFormBuilder.tag(tag);
        } else {
            postFormBuilder.tag(BaseConfig.TAG);
        }

        try {
            LogUtils.object(pojo);
            postFormBuilder.addFile(pojo.getServiceId(), pojo.getServiceValues(), new File(pojo.getServiceValues()));
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }


        final RequestCall myRequestCall = postFormBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }
        if (progressCallback == null) {
            LogUtils.e(TAG, RESULT_CALLBACK_ERROR);
        }


        myRequestCall.execute(progressCallback);


    }




    @Override
    public void doSimpleDownloadFiles(String targetUrl, HashMap params, HashMap headers, Object tag, long readTime, long connTime,
                                      BaseSaveFilePojo saveFileBean, final FileCallBack baseFileProgressCallback) {

        GetBuilder getBuilder = OkHttpUtils.get().addHeader("mw-client", "android");


        if (!TextUtils.isEmpty(targetUrl)) {
            getBuilder.url(targetUrl);
        }

        if (params != null) {
            getBuilder.params(params);
        }
        if (headers != null) {
            getBuilder.headers(headers);
        }
        if (tag != null) {
            getBuilder.tag(tag);
        } else {
            getBuilder.tag(BaseConfig.TAG);
        }

        final RequestCall myRequestCall = getBuilder.build();

        if (readTime != -1) {
            myRequestCall.readTimeOut(readTime);
        }
        if (connTime != -1) {
            myRequestCall.connTimeOut(connTime);
        }
        if (baseFileProgressCallback == null) {
            LogUtils.e(TAG, RESULT_CALLBACK_ERROR);
        }


        myRequestCall.execute(baseFileProgressCallback);
    }


    @Override
    public void doCancel(Object tag) {
        if (tag != null) {
            OkHttpUtils.getInstance().cancelTag(tag);
        } else {
            OkHttpUtils.getInstance().cancelTag(BaseConfig.TAG);
        }
    }


}
