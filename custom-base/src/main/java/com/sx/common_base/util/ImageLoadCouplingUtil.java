package com.sx.common_base.util;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.common.utils.GeneralUtil;
import com.common.utils.LogUtils;
import com.sx.common_base.util.image.glide.GlideCircleTransform;
import com.sx.common_base.util.image.glide.GlideRoundTransform;
//import com.ffu365.custom.util.image.glide.GlideCircleTransform;
//import com.ffu365.custom.util.image.glide.GlideRoundTransform;

import java.io.File;

/**
 * 
 * ============================================================
 * 
 * copyright ZENG　HUI (c) 2014
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On November 24, 2014 9:14:37
 * 
 * description : 图片加载的耦合工具类
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class ImageLoadCouplingUtil {
	private static ImageLoadCouplingUtil mInstance;

	private static int mErrorResouce;

	public static void initErrorResouce(int errorResouce) {
		mErrorResouce = errorResouce;
	}

	private ImageLoadCouplingUtil() {
		
	}

	public static ImageLoadCouplingUtil getInstance() {
		if (mInstance == null) {
			synchronized (ImageLoadCouplingUtil.class) {
				if (mInstance == null) {
					mInstance = new ImageLoadCouplingUtil();
				}
			}
		}
		return mInstance;
	}
	
	
	/************************** 本地文件圆角图片加载 ****************************/
	public void loadRoundImage(File file, ImageView imageView) {
		Glide.with(imageView.getContext()).load(file)
				.transform(new GlideRoundTransform(imageView.getContext()))
				.error(mErrorResouce).into(imageView);
	}

	public void loadRoundImage(File file, ImageView imageView, int errorResouce) {
		Glide.with(imageView.getContext()).load(file)
				.transform(new GlideRoundTransform(imageView.getContext()))
				.error(errorResouce).into(imageView);
	}

	/************************** 本地资源圆角图片加载 ****************************/
	public void loadRoundImage(int resouceId, ImageView imageView) {
		Glide.with(imageView.getContext()).load(resouceId)
				.transform(new GlideRoundTransform(imageView.getContext()))
				.error(mErrorResouce).into(imageView);
	}

	public void loadRoundImage(int resouceId, ImageView imageView,
			int errorResouce) {
		Glide.with(imageView.getContext()).load(resouceId)
				.transform(new GlideRoundTransform(imageView.getContext()))
				.error(errorResouce).into(imageView);
	}

	/************************** url圆角图片加载 ****************************/
	public void loadRoundImage(String url, ImageView imageView) {
		displayRoundImage(url, imageView, mErrorResouce);
	}

	public void loadRoundImage(String url, ImageView imageView,
			int errorResouce) {
		displayRoundImage(url, imageView, errorResouce);
	}
	
	

	private void displayRoundImage(String url, ImageView imageView,
			int errorResouce) {
		if (GeneralUtil.isNumeric(url)) {
			// 如果全是数字认为它是资源
			Glide.with(imageView.getContext())
					.load(Integer.parseInt(url))
					.transform(new GlideRoundTransform(imageView.getContext()))
					.error(errorResouce).into(imageView);
		} else if (url.startsWith("http")) {
			// 如果是一个合法的网络路径认为它是这个
			Glide.with(imageView.getContext())
					.load(url)
					.transform(new GlideRoundTransform(imageView.getContext()))
					.error(errorResouce).into(imageView);
		} else {
			// 认为他是一个本地文件
			File file = new File(url);
			if (file.exists()) {
				Glide.with(imageView.getContext())
						.load(file)
						.transform(
								new GlideRoundTransform(imageView.getContext()))
						.error(errorResouce).into(imageView);
			}
		}
	}

	
	
	

	/************************** 本地文件圆形图片加载 ****************************/
	public void loadCircleImage(File file, ImageView imageView) {
		Glide.with(imageView.getContext()).load(file)
				.transform(new GlideCircleTransform(imageView.getContext()))
				.error(mErrorResouce).into(imageView);
	}

	public void loadCircleImage(File file, ImageView imageView, int errorResouce) {
		Glide.with(imageView.getContext()).load(file)
				.transform(new GlideCircleTransform(imageView.getContext()))
				.error(errorResouce).into(imageView);
	}

	/************************** 本地资源图片加载 ****************************/
	public void loadCircleImage(int resouceId, ImageView imageView) {
		Glide.with(imageView.getContext()).load(resouceId)
				.transform(new GlideCircleTransform(imageView.getContext()))
				.error(mErrorResouce).into(imageView);
	}

	public void loadCircleImage(int resouceId, ImageView imageView,
			int errorResouce) {
		Glide.with(imageView.getContext()).load(resouceId)
				.transform(new GlideCircleTransform(imageView.getContext()))
				.error(errorResouce).into(imageView);
	}

	/************************** url圆形图片加载 ****************************/
	public void loadCircleImage(String url, ImageView imageView) {
		displayCircleImage(url, imageView, mErrorResouce);
	}

	public void loadCircleImage(String url, ImageView imageView,
			int errorResouce) {
		displayCircleImage(url, imageView, errorResouce);
	}
	
	

	private void displayCircleImage(String url, ImageView imageView,
			int errorResouce) {
		if (GeneralUtil.isNumeric(url)) {
			LogUtils.d("isNumeric");
			// 如果全是数字认为它是资源
			Glide.with(imageView.getContext())
					.load(Integer.parseInt(url))
					.transform(new GlideCircleTransform(imageView.getContext()))
					.error(errorResouce).into(imageView);
		} else if (url.startsWith("http")) {
			LogUtils.d("isUrl  && url == " + url);
			// 如果是一个合法的网络路径认为它是这个
			Glide.with(imageView.getContext())
					.load(url)
					.transform(new GlideCircleTransform(imageView.getContext()))
					.error(errorResouce).into(imageView);
		} else {
			LogUtils.d("isFile");
			// 认为他是一个本地文件
			File file = new File(url);
			if (file.exists()) {
				Glide.with(imageView.getContext())
						.load(file)
						.transform(
								new GlideCircleTransform(imageView.getContext()))
						.error(errorResouce).into(imageView);
			}
		}
	}

	/************************** 本地文件图片加载 ****************************/
	public void loadImage(File file, ImageView imageView) {
		Glide.with(imageView.getContext()).load(file).error(mErrorResouce)
				.into(imageView);
	}

	public void loadImage(File file, ImageView imageView, int errorResouce) {
		Glide.with(imageView.getContext()).load(file).error(errorResouce)
				.into(imageView);
	}

	/************************** 本地资源图片加载 ****************************/
	public void loadImage(int resouceId, ImageView imageView) {
		Glide.with(imageView.getContext()).load(resouceId).error(mErrorResouce)
				.into(imageView);
	}

	public void loadImage(int resouceId, ImageView imageView, int errorResouce) {
		Glide.with(imageView.getContext()).load(resouceId).error(errorResouce)
				.into(imageView);
	}

	/************************** url图片加载 ****************************/
	public void loadImage(String url, ImageView imageView) {
		display(url, imageView, mErrorResouce);
	}

	public void loadImage(String url, ImageView imageView, int errorResouce) {
		display(url, imageView, errorResouce);
	}

	private void display(String url, ImageView imageView, int errorResouce) {
		
		
		if (GeneralUtil.isNumeric(url)) {
			// 如果全是数字认为它是资源
			Glide.with(imageView.getContext()).load(Integer.parseInt(url))
					.error(errorResouce).into(imageView);
	

		} else if (!TextUtils.isEmpty(url)) {
			// 如果是一个合法的网络路径认为它是这个
			Glide.with(imageView.getContext()).load(url).error(errorResouce)
					.into(imageView);
		} else {
			// 认为他是一个本地文件
			File file = new File(url);
			if (file.exists()) {
				Glide.with(imageView.getContext()).load(file)
						.error(errorResouce).into(imageView);
			}
		}
	}
	
	public void loadImageNoCache(String url, ImageView imageView) {
		
		Glide.with(imageView.getContext()).load(url).error(mErrorResouce).diskCacheStrategy(DiskCacheStrategy.NONE)
		.into(imageView);
	}

}
