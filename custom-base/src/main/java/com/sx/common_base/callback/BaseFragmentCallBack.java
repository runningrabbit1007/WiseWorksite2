package com.sx.common_base.callback;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.common.base.App;
import com.common.base.config.PreferencesManager;
import com.common.utils.CheckUtil;
import com.common.utils.JSONUtil;
import com.common.utils.LogUtils;
import com.common.utils.ToastUtil;
import com.common.utils.dialog.DialogUtil;
//import com.ffu365.custom.constant.ErrorCode;
//import com.ffu365.custom.result.BaseResult;
import com.google.gson.JsonObject;
import com.sx.common_base.R;
import com.sx.common_base.constant.ErrorCode;
import com.sx.common_base.result.BaseResult;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jacklyy on 2016/11/19.
 * 针对Fragment优化的Callback，能监听onActivityForResult。
 */

public abstract  class BaseFragmentCallBack extends Callback<BaseResult> {
    private final String TAG = "BaseFragmentCallBack";

    protected FragmentActivity mContext;
    protected Fragment mFragment;

    public BaseFragmentCallBack(Context mContext, Fragment mFragment) {
        this.mContext = (FragmentActivity) mContext;
        this.mFragment = mFragment;
    }

    @Override
    public void onResponse(BaseResult response, int id) {
        if (response.getCode() == 200) {
            if (!CheckUtil.isNull(response.getData())) {
                onGetSuccess(response.getData());
            } else {
                onGetSuccess(null);
            }
        } else {
            onGetFailed(response.getCode());

            try {
                LogUtils.e(TAG, "Message : " + response.getMsg());
            } catch (Exception pE) {
            }
            /*if (response.getErrcode() == ErrorCode.E200) {
                PreferencesManager.getInstance().cleanUserCache();
                    ToastUtil.showToast(App.INSTANCE, "请先登录");

            } else if (response.getErrcode() == ErrorCode.E100) {

            }*/
        }
        if (mContext != null) {
            DialogUtil.dissmissLodingView(mContext);
            DialogUtil.dismissProgressDialog();
        }
    }

    @Override
    public BaseResult parseNetworkResponse(Response response, int id) throws Exception {
        BaseResult result = null;
        try {
            result = JSONUtil.parseObject(response.body().string(), BaseResult.class);
            LogUtils.object(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    public abstract void onGetSuccess(JsonObject result);

    public abstract void onGetFailed(int code);

    public void onApiError(int code){
        if(code == ErrorCode.E_NO_KEY){
            App.toast("请检查你得请求KEY，无法通过该KEY找的API");
        }else if(code == ErrorCode.E_NO_HANDLER){
            App.toast("请检查你得模拟数据");
        }
    }

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
        if (mContext == null) {
            return;
        }
        DialogUtil.dissmissLodingView(mContext);
        DialogUtil.dismissProgressDialog();
        onGetError(call, e, id);
    }

    public abstract void onGetError(Call call, Exception e, int id);
}
