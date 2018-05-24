package com.sx.common_base.listScreen.bean;

import android.webkit.JavascriptInterface;

import java.io.Serializable;

/**
 * 
 * ============================================================
 * 
 * 
 * copyright ZENG　HUI (c) 2014
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On November 20, 2014 10:14:21
 * 
 * description : base result
 * 
 * revision history :
 * 
 * ============================================================
 *
 */
public class BaseResult implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 判断请求操作是否成功 0：操作失败,1：操作成功*/
	public int errcode;
	/** 需要显示错误信息 */
	public String errmsg;
	/** 判断需要显示的提示框类型 0：不弹框，1：一个button的框，2：两个butto的框*/
	public int errdialog;
	
	public String sign;
	
}
