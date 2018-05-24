package com.common.utils.image;

import android.text.TextUtils;

public class ImageUtilOption {
	// 如果加载错误就加载服务器上默认加载错误的图片路径地址
	private String serviceErrorUrl = "";
	// 如果加载错误就加载本地资源ID
	private int errorSourceId = 0;
	
	public String getServiceErrorUrl() {
		return serviceErrorUrl;
	}

	public ImageUtilOption setServiceErrorUrl(String serviceErrorUrl) {
		this.serviceErrorUrl = serviceErrorUrl;
		return this;
	}

	public int getErrorSourceId() {
		return errorSourceId;
	}

	public ImageUtilOption setErrorSourceId(int errorSourceId) {
		this.errorSourceId = errorSourceId;
		return this;
	}

	/**
	 * 服务器加载图片错误路径是否是null
	 */
	public boolean serviceErrorUrlIsNull(){
		return TextUtils.isEmpty(serviceErrorUrl);
	}
	
	/**
	 * 服务器加载图片错误路径是否是null
	 */
	public boolean errorSourceIdIsZero(){
		return errorSourceId == 0;
	}
}
