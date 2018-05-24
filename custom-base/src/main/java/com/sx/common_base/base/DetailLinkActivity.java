/*
package com.sx.common_base.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.common.utils.LogUtils;
import com.ffu365.custom.R;
import com.ffu365.custom.R2;
import com.ffu365.custom.util.JavaScriptinterfaceUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URLDecoder;

import butterknife.BindView;

*/
/**
 * ============================================================
 * <p>
 * project name : TiantianFangFu
 * <p>
 * copyright ZENG HUI (c) 2015
 * <p>
 * author : HUI
 * <p>
 * version : 1.0
 * <p>
 * date created : On June, 2015
 * <p>
 * description : webView Activity
 * <p>
 * revision history :
 * <p>
 * ============================================================
 *//*

@SuppressLint({"ValidFragment", "JavascriptInterface", "HandlerLeak"})
public class DetailLinkActivity extends WebControlActivity implements OnClickListener {
    @BindView(R2.id.id_stickynavlayout_innerscrollview)
    public WebView mWebView;
    private WebSettings mWebSettings;
    private String mUrl;
    public static final String URL_KEY = "URL_KEY";
    public final String ERROR_FILE_PATH = "file:///android_asset/www/INDEX.html";
    @BindView(R2.id.myProgressBar)
    ProgressBar myProgressBar;
    private int mProgress;

    private Handler handler = new Handler() {

        */
/**
         * TODO
         * @param msg
         *//*

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (msg.what == 404) {// 主页不存在
                // 载入本地 assets 文件夹下面的错误提示页面 404.html
                mWebView.loadUrl(ERROR_FILE_PATH);
            } else {
                mWebView.loadUrl(mUrl);
            }
        }

    };

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initData() {
        mWebSettings = mWebView.getSettings();
        mWebSettings.setUseWideViewPort(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setJavaScriptEnabled(true);


        JavaScriptinterfaceUtils javaScriptinterfaceUtils = new JavaScriptinterfaceUtils(this,mWebView);
        mWebView.addJavascriptInterface(javaScriptinterfaceUtils, "control");

        // First of all, set up to monitor
        mWebView.setWebChromeClient(new UriWebChomeClient());
        mWebView.setWebViewClient(new UriWebViewClient());
        loadurl(mUrl);

        new Thread(new Runnable() {
            public void run() {
                Message msg = new Message();
                // 此处判断主页是否存在,因为主页是通过 loadUrl 加载的,
                // 此时不会执行 shouldOverrideUrlLoading 进行页面是否存在的判断
                // //进入主页后,点主页里面的链接,链接到其他页面就一定会执行
                // shouldOverrideUrlLoading 方法了
                if (getRespStatus(mUrl) == 404) {
                    msg.what = 404;
                }
                handler.sendMessage(msg);
            }
        }).start();

    }

    */
/**
     * load URL
     *
     * @param view
     * @param url
     *//*

    public void loadurl(final WebView view, final String url) {
        view.loadUrl(url);
    }

    */
/**
     * load URL
     *
     * @param url
     *//*

    public void loadurl(final String url) {
        mWebView.loadUrl(url);
    }

    @Override
    public void initTitle() {
        TitleModule module = TitleModuleBuilder.builder
                .setLeftImgVB2(new ViewBean(R.drawable.close))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        titleBar.setModel(module);
        titleBar.setTitle("天天防腐");
    }


    @Override
    public void initView() {
        mUrl = getIntent().getStringExtra(URL_KEY);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_external_link_detail;
    }


    protected void clearCache() {
        mWebView.clearCache(true);
        mWebView.clearHistory();
    }

    @SuppressWarnings("deprecation")
    private int getRespStatus(String url) {
        int status = -1;
        try {
            HttpHead head = new HttpHead(url);
            HttpClient client = new DefaultHttpClient();
            HttpResponse resp = client.execute(head);
            status = resp.getStatusLine().getStatusCode();
        } catch (IOException e) {
        }
        return status;
    }


    private class UriWebViewClient extends WebViewClient {
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LogUtils.e("url = " + url);


            if (url.startsWith("tel:")) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            }

            // 自定义一个拦截器
            if (url.contains("type") && url.contains("link")) {
                String jsonStr = URLDecoder.decode(url);
                // 没过时的方法：URLDecoder.decode(s, charsetName);
                int $start = 0;
                int $end = jsonStr.length();
                if (jsonStr.startsWith("http://")) {
                    $start = 7;
                }
                if (jsonStr.endsWith("/")) {
                    $end--;
                }


            }
            loadurl(view, url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            showLoadingView();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
//            dismissLoadingView();

            if (mWebView.canGoBack()) {
                titleBar.showReturnButton();
            }
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            // 加载错误的页面
			loadurl(ERROR_FILE_PATH);
			super.onReceivedError(view, errorCode, description, failingUrl);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    public class UriWebChomeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);

            if (!TextUtils.isEmpty(title)) {
                titleBar.setTitle(title);
            }
        }

        // 进度改变后需要更新进度条
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

            mProgress = newProgress;
            if (newProgress >= 100) {
                myProgressBar.setVisibility(View.GONE);
            } else {
                if (myProgressBar.getVisibility() == View.GONE) {
                    myProgressBar.setVisibility(View.VISIBLE);
                }
                myProgressBar.setProgress(newProgress);

            }
        }
    }

//    */
/**
//     * 打开指定的url
//     *//*

//    @JavascriptInterface
//    public void openWeb(String url, boolean newWeb, boolean bind) {
//        if (bind) {
//            url = url + "?" + PreferencesManager.getInstance().getReportNoDebug();
//        }
//        if (newWeb) {
//            Intent intent = new Intent(this, DetailLinkActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            Bundle bundle = new Bundle();
//            bundle.putString(URL_KEY, url);
//            intent.putExtras(bundle);
//            enterNextActivity(intent);
//        } else {
//            mWebView.loadUrl(url);
//        }
//    }
//
//    */
/**
//     * 打开一个原生界面，界面标识为flag，参数列表为param  isClose是否需要关闭上一个界面
//     *//*

//    @JavascriptInterface
//    public void openNative(String flag, String param, boolean isClose) {
//        if (isClose) {
//            finish();
//        }
//        OpenNativePageUtil.open(this, flag, param);
//    }
//
//    */
/**
//     * 关闭当前打开的Webview页面
//     */

