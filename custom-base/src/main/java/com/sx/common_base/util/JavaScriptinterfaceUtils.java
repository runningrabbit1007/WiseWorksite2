package com.sx.common_base.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.common.base.bean.ReportBean;
import com.common.base.config.PreferencesManager;
//import com.ffu365.custom.base.DetailLinkActivity;

/**
 * Created by yonggege on 2017/9/4.
 */

public class JavaScriptinterfaceUtils {

    public static final String URL_KEY = "URL_KEY";
    private Activity mActivity;
    public WebView mWebView;
    public JavaScriptinterfaceUtils(Activity activity, WebView webView){
        this.mActivity = activity;
        this.mWebView = webView;
    }

    /**
     * 打开指定的url
    @JavascriptInterface
    public void openWeb(String url, boolean newWeb, boolean bind) {
        if (bind) {
            url = url + "?" + PreferencesManager.getInstance().getReportNoDebug();
        }
        if (newWeb) {
            Intent intent = new Intent(mActivity, DetailLinkActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putString(URL_KEY, url);
            intent.putExtras(bundle);
            mActivity.startActivity(intent);
        } else {
            mWebView.loadUrl(url);
        }
    }*/

    /**
     * 打开一个原生界面，界面标识为flag，参数列表为param  isClose是否需要关闭上一个界面
     */
    @JavascriptInterface
    public void openNative(String flag, String param, boolean isClose) {
        if (isClose) {
            mActivity.finish();
        }
        OpenNativePageUtil.open(mActivity, flag, param);
    }

    /**
     * 关闭当前打开的Webview页面
     */
    @JavascriptInterface
    public void closeCurrent() {
        mActivity.finish();
    }

    /**
     * 返回当前登录的用户信息，包含以下属性：uid、cookie、appid、location、version；如果用户未登录或者获取失败，则返回null
     */
    @JavascriptInterface
    public Object userInfo() {
        return  null;
    }

    @JavascriptInterface
    public String getReport(String type) {
        String result;
        if (type.equals("url")) {
            result = "?" + PreferencesManager.getInstance().getReportNoDebug();
        } else {
            ReportBean reportBean = new ReportBean();
            result = com.common.utils.JSONUtil.toJSON(reportBean);
        }
        return result;
    }

    @JavascriptInterface
    public void clearLogin() {
        PreferencesManager.getInstance().cleanUserCache();
    }

    /**
     * 拨打电话，转跳至拨号盘，电话号码为phone
     */
    @JavascriptInterface
    public void callPhone(String phone) {
        call(phone);
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mActivity.startActivity(intent);
    }
}
