package com.sx.common_base.base;

import android.view.WindowManager;

import com.common.base.activity.BaseFragment;
import com.common.utils.LogUtils;
//import com.ffu365.custom.callback.BaseSmartCallback;
//import com.ffu365.custom.callback.BaseSmartMallCallback;
//import com.ffu365.custom.constant.BundleKeys;
//import com.ffu365.custom.http.BaseHttpManager;
//import com.ffu365.custom.http.RequestMaster;
//import com.umeng.analytics.MobclickAgent;
import com.sx.common_base.callback.BaseSmartCallback;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.BundleKeys;
import com.sx.common_base.http.BaseHttpManager;
import com.sx.common_base.http.RequestMaster;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 带有请求要求的Fragment
 */
public abstract class BaseRequestUrlFragment extends BaseFragment {
    /**
     * 向后台请求数据的参数封装实例
     */
    protected HashMap<String, String> param;

    /**
     * WindowManager下的LayoutParams实例
     */
    private WindowManager.LayoutParams mlodingParams;




    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    /**
     * TODO 覆盖父类的方法，实现取消网路请求，取消数据传递，取消进度条显示
     *
     * @see android.support.v4.app.Fragment#onDestroy()
     */
    @Override
    public void onDestroy() {
        BaseHttpManager.getInstance().doCancel(TAG);
//		DialogUtil.dismissProgressDialog();
        super.onDestroy();
    }


    /**
     * @deprecated 不要再使用这个方法，参考@link
     * @param url
     * @param content
     * @param callback
     * @return
     */
    public RequestCall sendPostStringRequest(String url, String content, BaseSmartCallback callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put(BundleKeys.PARAM_KEY_CONTENT,content);
        RequestMaster.getInstance().callPostRequest(url,content,callback,TAG);
        return RequestMaster.getInstance().callRequest(url, params, null, callback, TAG);
    }

    /**
     * 新的请求入口，底层封装了RequestModel方案。只需传入想要的bean。
     * @param url
     * @param data
     * @param callback
     * @return
     */
    public RequestCall sendPostStringRequest(String url, Object data, BaseSmartCallback callback) {
        return RequestMaster.getInstance().callPostRequest(url,data,callback,TAG);
    }

    /**
     * 新的请求入口，底层封装了RequestModel方案。只需传入想要的bean。
     * @param url
     * @param data
     * @param callback
     * @return
     */
    public RequestCall sendPostStringRequest(String url, Map<String, String> data, BaseSmartMallCallback callback) {
        Iterator iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            LogUtils.e(TAG,"key="+key+";value="+val);
        }
        return RequestMaster.getInstance().callPostRequestMall(url,data,callback,TAG);
    }


    public RequestCall sendGetRequest(String url, HashMap<String, String> params, BaseSmartCallback callback) {
        return RequestMaster.getInstance().callRequest(url, params, null, callback, TAG);
    }
}
