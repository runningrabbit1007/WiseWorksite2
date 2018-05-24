package com.sx.common_base.view.proxy;


//import com.ffu365.custom.listScreen.bean.BaseResult;

import com.sx.common_base.listScreen.bean.BaseResult;

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
 * date created : On June, 2015
 * 
 * description : 单张图片上传
 * 
 * revision history :
 * 
 * ============================================================
 *
 */
public class MultipleSingleUploadImageResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	public MultipleSingleUploadImage data;
	public class MultipleSingleUploadImage{
		public String img_path;
		public String unique;
	}
	/*
  result: {
    "data": {
        "img_path": "http:\/\/resource.ffu365.com\/upload\/images\/resume\/55d2d66586367.jpg",
        "unique": "-storage-emulated-0-DCIM-Camera-IMG20150814152122.jpg"
    },
    "errcode": 1,
    "errmsg": "\u64cd\u4f5c\u6210\u529f"
}
     */
}
