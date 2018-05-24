package com.sx.common_base.listener;


import android.widget.ImageView;

import com.sx.common_base.view.proxy.SingleUploadImageProxy;


/**
 * 
 * ============================================================
 * 
 * project name : TiantianFangFu
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On July, 2015
 * 
 * description : 
 * 
 * revision history :
 * 
 * ============================================================
 *
 */
public interface SingleImageCureentListener {
	void current(SingleUploadImageProxy currentObj);
	void uploadSuccess(ImageView proxyIv, SingleUploadImageProxy uploadSuccessObj);
}
