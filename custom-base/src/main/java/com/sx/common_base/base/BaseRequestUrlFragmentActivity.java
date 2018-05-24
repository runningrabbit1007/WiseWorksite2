package com.sx.common_base.base;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.sx.common_base.callback.BaseSmartCallback;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.BundleKeys;
import com.sx.common_base.http.BaseHttpManager;
import com.sx.common_base.http.RequestMaster;
import com.zhy.http.okhttp.request.RequestCall;

import com.common.base.activity.BaseFragmentActivity;

import java.util.HashMap;
import java.util.Map;


/**
 * 基础请求urlFragment
 */
public abstract class BaseRequestUrlFragmentActivity extends
        BaseFragmentActivity {


    /**
     * 向后台请求数据的参数封装实例
     */
    protected HashMap<String, String> param;
    /**
     * 正在加载数据的页面
     */
    private View mLoadingView;
    /**
     * WindowManager下的LayoutParams实例
     */
    private WindowManager.LayoutParams mlodingParams;


    /**
     * TODO 添加一个正在加载数据的界面
     */
    protected final void addLodingView() {

//        DialogUtil.addLoadingView(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
//        MobclickAgent.openActivityDurationTrack(false);
//        MobclickAgent.enableEncrypt(true);
    }


    /**
     * TODO 监听Activity的生命状态 onResume，实现友盟统计
     *
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    /**
     * TODO 监听Activity的生命状态 onResume，实现友盟统计
     *
     * @see android.app.Activity#onPause()
     */
    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }


    /**
     * TODO 覆盖父类的方法，实现取消网路请求，取消数据传递，取消进度条显示
     */
    @Override
    protected void onDestroy() {
        BaseHttpManager.getInstance().doCancel(TAG);
//        DialogUtil.dismissProgressDialog();
        dissmissLodingView();

        super.onDestroy();
    }

    /**
     * TODO 如果有缓存或是数据获取成功了，就把正在加载数据的界面干掉
     */
    protected final void dissmissLodingView() {
//        ?DialogUtil.dissmissLodingView(this);
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


    public RequestCall sendGetRequest(String url, HashMap<String, String> params, BaseSmartCallback callback) {
        HashMap<String, String> map = new HashMap();
        map.put("mw-client", "android");
        return RequestMaster.getInstance().callRequest(url, params, map, callback, TAG);
    }

    /**
     * 新的请求入口，底层封装了RequestModel方案。只需传入想要的bean。
     * @param url
     * @param data
     * @param callback
     * @return
     */
    public RequestCall sendPostStringRequest(String url, Map<String, String> data, BaseSmartMallCallback callback) {
        return RequestMaster.getInstance().callPostRequestMall(url,data,callback,TAG);
    }


}
