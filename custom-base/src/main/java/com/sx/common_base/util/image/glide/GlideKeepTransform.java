package com.sx.common_base.util.image.glide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.sx.common_base.util.image.BitmapUtil;
//import com.ffu365.custom.util.image.BitmapUtil;


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
 * QQ ：240336124
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
public class GlideKeepTransform extends BitmapTransformation {
	private float radius = 0f;

	public GlideKeepTransform(Context context) {
		this(context, 10);
	}

	public GlideKeepTransform(Context context, int dp) {
		super(context);
		this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
	}

	@Override
	protected Bitmap transform(BitmapPool pool, Bitmap toTransform,
                               int outWidth, int outHeight) {
		int width = outWidth;
		int height = outHeight;
		if (toTransform.getWidth() != width) {
			height = (toTransform.getWidth() / toTransform.getHeight()) * toTransform.getHeight();
		}
		Bitmap bitMap =  BitmapUtil.getBitmap(toTransform, width, height);
				toTransform.recycle();
		return bitMap;
	}



	@Override
	public String getId() {
		return getClass().getName() + Math.round(radius);
	}
}