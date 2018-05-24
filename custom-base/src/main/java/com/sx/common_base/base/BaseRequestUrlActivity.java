package com.sx.common_base.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.view.WindowManager;
import android.widget.Toast;

import com.common.base.activity.BaseActivity;
import com.common.utils.LogUtils;
import com.common.utils.dialog.DialogUtil;
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
 * 需要像后台请求数据的activity基类
 */
public abstract class BaseRequestUrlActivity extends BaseActivity {
    /**
     * 向后台请求数据的参数封装实例
     */
    protected HashMap<String, String> param;
    /**
     * WindowManager下的LayoutParams实例
     */
    private WindowManager.LayoutParams mlodingParams;


    /**
     * TODO 添加一个正在加载数据的界面
     */
    protected final void addLodingView() {

        DialogUtil.addLoadingView(this);
    }


    /**
     * @param url
     * @param content
     * @param callback
     * @return
     * @deprecated 不要再使用这个方法，参考@link
     */
    public RequestCall sendPostStringRequest(String url, String content, BaseSmartCallback callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put(BundleKeys.PARAM_KEY_CONTENT, content);
        return RequestMaster.getInstance().callRequest(url, params, null, callback, TAG);
    }

    /**
     * 新的请求入口，底层封装了RequestModel方案。只需传入想要的bean。
     *
     * @param url
     * @param data
     * @param callback
     * @return
     */
    public RequestCall sendPostStringRequest(String url, Object data, BaseSmartCallback callback) {
        return RequestMaster.getInstance().callPostRequest(url, data, callback, TAG);
    }

    /**
     * 新的请求入口，底层封装了RequestModel方案。只需传入想要的bean。
     *
     * @param url
     * @param data
     * @param callback
     * @return
     */
    public RequestCall sendPostStringRequest(String url, Map data, BaseSmartMallCallback callback) {
        Iterator iter = data.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            LogUtils.e(TAG,"key="+key+";value="+val);
        }
        return RequestMaster.getInstance().callPostRequestMall(url, data, callback, TAG);
    }

    public RequestCall sendGetRequest(String url, HashMap<String, String> params, BaseSmartCallback callback) {
        HashMap<String, String> map = new HashMap();
        map.put("mw-client", "android");
        return RequestMaster.getInstance().callRequest(url, params, map, callback, TAG);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * TODO 监听Activity的生命状态 onResume
     *
     * @see Activity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * TODO 监听Activity的生命状态 onResume
     *
     * @see Activity#onPause()
     */
    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * TODO 覆盖父类的方法，实现取消网路请求，取消数据传递，取消进度条显示
     */
    @Override
    protected void onDestroy() {
        //TODO 取消全部请求
        BaseHttpManager.getInstance().doCancel(TAG);
        DialogUtil.dismissProgressDialog();
        dissmissLodingView();
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        BaseHttpManager.getInstance().doCancel(TAG);
        super.onBackPressed();
    }


    /**
     * TODO 如果有缓存或是数据获取成功了，就把正在加载数据的界面干掉
     */
    protected final void dissmissLodingView() {

//		DialogUtil.dissmissLodingView(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            //就像onActivityResult一样这个地方就是判断你是从哪来的。
            case 222:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Intent getImageByCamera = new Intent(
                            "android.media.action.IMAGE_CAPTURE");


                } else {
                    // Permission Denied
                    Toast.makeText(mContext, "很遗憾你把相机权限禁用了。请务必开启相机权限享受我们提供的服务吧。", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}
