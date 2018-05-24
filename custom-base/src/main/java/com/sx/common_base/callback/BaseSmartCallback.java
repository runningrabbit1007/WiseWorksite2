package com.sx.common_base.callback;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.common.base.App;
import com.common.base.AppManagerUtil;
import com.common.base.config.PreferencesManager;
import com.common.base.http.netdector.NetworkUtils;
import com.common.utils.CheckUtil;
import com.common.utils.JSONUtil;
import com.common.utils.ToastUtil;
import com.common.utils.dialog.DialogUtil;
import com.common.utils.string.MD5Util;
//import com.ffu365.custom.constant.ConstantValue;
//import com.ffu365.custom.constant.ErrorCode;
//import com.ffu365.custom.jump.JumpActionHelper;
//import com.ffu365.custom.modle.ApiEntity;
//import com.ffu365.custom.orm.entity.CacheEntity;
//import com.ffu365.custom.result.BaseResult;
//import com.ffu365.custom.util.ApiMaster;
//import com.ffu365.custom.util.QueryHelper;
import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;
import com.google.gson.JsonObject;
import com.sx.common_base.R;
import com.sx.common_base.constant.ConstantValue;
import com.sx.common_base.constant.ErrorCode;
import com.sx.common_base.modle.ApiEntity;
import com.sx.common_base.result.BaseResult;
import com.sx.common_base.util.ApiMaster;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by Jack on 2016/8/2.
 * Smartmall Project的基础回掉
 * DESC:
 * 20161118:修改回掉方法，空数据不会调用onSuccess方法，在onSuccess的实现中不需要在判断空。相应的如果数据为空，则会调用onGetFailed code 为 0
 */
public abstract class BaseSmartCallback extends Callback<BaseResult> {

    private static final String TAG = "BaseSmartCallback";

    protected Activity mContext;

    private HttpUrl httpUrl = null;
    private boolean isFinishCreentActivity = true;

    public BaseSmartCallback(Context mContext) {
        try {
            this.mContext = (Activity) mContext;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BaseSmartCallback(Context mContext, boolean isFinish) {
        try {
            this.mContext = (Activity) mContext;
            this.isFinishCreentActivity = isFinish;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResponse(BaseResult response, int id) {
        if (null == response) {
            return;
        }
        if (response.getCode() == 200) {
            if (!CheckUtil.isNull(response.getData())) {
                onGetSuccess(response.getData());
            } else {
                onGetSuccess(null);
            }
        } else {
            onGetFailed(response.getCode());
            App.toast(response.getMsg());

            if (response.getCode() == ErrorCode.E401) {
                PreferencesManager.getInstance().cleanUserCache();
                Router.sharedRouter().open(RouterActions.ACTION_LOGIN);
            }

        }
        hindDialog();
    }

    public void onApiError(int code) {
        if (code == ErrorCode.E_NO_KEY) {
            App.toast("请检查你的请求KEY，无法通过该KEY找的API");
        } else if (code == ErrorCode.E_NO_HANDLER) {
            App.toast("请检查你的模拟数据");
        }
    }

    @Override
    public BaseResult parseNetworkResponse(Response response, int id) throws Exception {
        BaseResult result = null;
        String body = response.body().string();
        try {
            result = JSONUtil.parseObject(body, BaseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        doSave(response, result);
        return result;
    }

    public abstract void onGetSuccess(JsonObject result);

    public abstract void onGetFailed(int code);

    @Override
    public void onBefore(Request request, int id) {
        super.onBefore(request, id);
        if (mContext == null) {
            return;
        }
        DialogUtil.showProgressDialog(mContext, mContext.getString(R.string.xlistview_header_hint_loading));
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        hindDialog();
        onGetError(call, e, id);
    }

    private void hindDialog() {
        if (mContext != null) {
            DialogUtil.dissmissLodingView(mContext);
        }
        DialogUtil.dismissProgressDialog();
    }

    public abstract void onGetError(Call call, Exception e, int id);

    /**
     * TODO 判断是否有网络，没有网络弹一个toast，返回布尔值
     *
     * @return boolean
     */
    protected final boolean notNet() {
        return NetworkUtils.isConnected(App.INSTANCE);
    }


    private void doSave(Response response, BaseResult result) {
        Request request = response.request();
        httpUrl = request.url();//request中的请求地址
        String tempUrl;//最终要被MD5的请求地址
        try {
            tempUrl = URLDecoder.decode(httpUrl.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            tempUrl = "";
        }
        String api = ""; // 完整的api地址
        String cacheKey = "";
        if (request.method().toUpperCase().equals(ConstantValue.NET_METHOD_GET)) {
            api = tempUrl.substring(0, tempUrl.indexOf("?")); // api是请求地址截掉"问号"之后数据
            cacheKey = MD5Util.strToMd5(tempUrl);//get方法的cacheKey是，URL请求完整地址MD5之后的数据
        } else if (request.method().toUpperCase().equals(ConstantValue.NET_METHOD_POST)) {
            api = tempUrl; //api是请求地址
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    if (isText(mediaType)) {
                        String content = bodyToString(request);
                        tempUrl += content;
                    }
                }
            }
            cacheKey = MD5Util.strToMd5(tempUrl);
        }
        String str = "";
        try {
            String endStr = httpUrl.pathSegments().get(0);
            int endIndex = api.indexOf(endStr) + endStr.length();
            str = api.substring(0, endIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        api = api.replace(str, ConstantValue.INDEX_PLACEHOLDER);
        if (api.contains("?accessToken=")) {
            api = api.substring(0, api.indexOf("?accessToken="));
        }
        ApiEntity apiEntity = ApiMaster.findApiByUrl(api);
        if (apiEntity == null) {
            return;
        }
        /*if (Integer.parseInt(apiEntity.expires) > 0) {//表示需要缓存
            CacheEntity cacheEntity = new CacheEntity();
            cacheEntity.setApi(apiEntity.url);
            cacheEntity.setCacheKey(cacheKey);
            cacheEntity.setContent(result.data.toString());
            cacheEntity.setEndTime(System.currentTimeMillis() + (Integer.parseInt(apiEntity.expires) * 1000));
            cacheEntity.setScope(Integer.parseInt(apiEntity.scope));
            QueryHelper.saveCache(cacheEntity);
        }*/
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype().equals("json") ||
                    mediaType.subtype().equals("xml") ||
                    mediaType.subtype().equals("html") ||
                    mediaType.subtype().equals("webviewhtml")
                    )
                return true;
        }
        return false;
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
    }

}
