/*
package com.sx.common_base.base;

import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.common.base.config.PreferencesManager;
import com.common.utils.GeneralUtil;


*/
/**
 * Created by Jack on 2016/7/1.
 *//*

public abstract class WebControlActivity extends WebBaseActivity {

    @JavascriptInterface
    public void openWithWeb(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            Intent intent = new Intent(this, this.getClass());
            intent.putExtra("URL_KEY", url);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            enterNextActivity(intent);
        }
    }

    @JavascriptInterface
    public void openCall(String phoneNum) {
        GeneralUtil.showAnyPhoneDial(this, phoneNum);
    }
    @JavascriptInterface
    public void openMaterialDetail(String id){
    	Intent intent = new Intent();
//    	intent.setClass(this, MaterialDetailActivity.class);
		intent.putExtra("id",
				Integer.valueOf(id));
		startActivity(intent);
    }
    @JavascriptInterface
    public String getUid(){

  		return PreferencesManager.getInstance().getUid();
    }
    
    
  	*/
/**
  	 * 用户是否登陆 (不用跳转)
  	 * 
  	 * @return false 没有登陆，true 已登陆
  	 *//*

  	protected final boolean isLogin() {
  		return PreferencesManager.getInstance().isLogin();
  	}
  	


  
}
*/
