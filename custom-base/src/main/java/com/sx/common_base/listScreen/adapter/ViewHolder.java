package com.sx.common_base.listScreen.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.common.utils.GeneralUtil;
import com.sx.common_base.util.ImageLoadCouplingUtil;
//import com.ffu365.custom.util.ImageLoadCouplingUtil;

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
 * date created : On November 20, 2014 9:30:34
 * 
 * description : view holder
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class ViewHolder {
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	public int layoutId;

	private ViewHolder(Context context, ViewGroup parent, int layoutId,
			int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		this.layoutId = layoutId;
		mConvertView.setTag(this);
	}

	/**
	 * 
	 * Get a ViewHolder object
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static ViewHolder get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);
		}
		// get tag
		ViewHolder existingHelper = (ViewHolder) convertView.getTag();

		// 判断layout id 针对多种布局
		if (existingHelper.layoutId != layoutId) {
			return new ViewHolder(context, parent, layoutId, position);
		}

		return existingHelper;
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * Through control the Id of the access to control, if not join views
	 * 
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 设置条目的点击事件
	 * 
	 * @return
	 */
	public ViewHolder setItemClick(OnClickListener clickListener) {
		mConvertView.setOnClickListener(clickListener);
		return this;
	}

	/**
	 * Set the string for TextView
	 * 
	 * @param viewId
	 * @return
	 */
	public ViewHolder setText(int viewId, Object obj) {
		TextView view = getView(viewId);
		view.setText(obj + "");
		return this;
	}

	/**
	 * For ImageView image (image based on resource Settings)
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int drawableId) {
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);
		return this;
	}

	/**
	 * @param viewId
	 * @return
	 */
	public ViewHolder setBackgroundResource(int viewId, int resourceId) {
		View view = getView(viewId);
		view.setBackgroundResource(resourceId);
		return this;
	}

	/**
	 * @param viewId
	 * @return
	 */
	public ViewHolder setBackgroundColor(int viewId, int color) {
		View view = getView(viewId);
		view.setBackgroundColor(color);
		return this;
	}

	/**
	 * 设置是否可见
	 * 
	 * @param viewId
	 * @param visible
	 * @return
	 */
	public ViewHolder setVisible(int viewId, boolean visible) {
		View view = getView(viewId);
		view.setVisibility(visible ? View.VISIBLE : View.GONE);
		return this;
	}

	/**
	 * 设置可见
	 * 
	 * @param viewIds
	 * @return
	 */
	public ViewHolder setViewVisible(int... viewIds) {
		for (int viewId : viewIds) {
			setVisible(viewId, true);
		}
		return this;
	}

	/**
	 * 设置可见
	 * 
	 * @param viewIds
	 * @return
	 */
	public ViewHolder setViewInVisible(int... viewIds) {
		for (int viewId : viewIds) {
			getView(viewId).setVisibility(View.INVISIBLE);
		}
		return this;
	}

	/**
	 * 设置影藏
	 * 
	 * @param viewIds
	 * @return
	 */
	public ViewHolder setViewGone(int... viewIds) {
		for (int viewId : viewIds) {
			setVisible(viewId, false);
		}
		return this;
	}

	/**
	 * 设置影藏
	 * 
	 * @param viewIds
	 * @return
	 */
	public ViewHolder setVisibility(int visibility, int... viewIds) {
		for (int viewId : viewIds) {
			getView(viewId).setVisibility(visibility);
		}
		return this;
	}

	/**
	 * For ImageView image (based on bitmap set)
	 * 
	 * @param viewId
	 * @return
	 */
	public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bm);
		return this;
	}


	public void display(String url, ImageView imageView) {


		if (GeneralUtil.isNumeric(url)) {
			// 如果全是数字认为它是资源
			Glide.with(imageView.getContext()).load(Integer.parseInt(url))
					.into(imageView);


		} else if (!TextUtils.isEmpty(url)) {
			// 如果是一个合法的网络路径认为它是这个
			Glide.with(imageView.getContext()).load(url)
					.into(imageView);
		} else {
			// 认为他是一个本地文件
			File file = new File(url);
			if (file.exists()) {
				Glide.with(imageView.getContext()).load(file).into(imageView);
			}
		}
	}

	/**
	 * For ImageView image (network load)
	 *
	 * @param viewId
	 * @return
	 */
	public ViewHolder setCircleImageByUrl(int viewId, String url) {
		ImageLoadCouplingUtil.getInstance().loadCircleImage(url,
				(ImageView) getView(viewId));
		return this;
	}

	/**
	 * For ImageView image (network load)
	 *
	 * @param viewId
	 * @return
	 */
	public ViewHolder setImageByUrl(int viewId, String url) {
		ImageLoadCouplingUtil.getInstance().loadImage(url,
				(ImageView) getView(viewId));
		return this;
	}

	public int getPosition() {
		return mPosition;
	}

	/**
	 * 设置点击事件
	 * 
	 * @param viewId
	 * @param listener
	 * @return
	 */
	public ViewHolder setOnClickListener(int viewId,
			OnClickListener listener) {
		View view = getView(viewId);
		view.setOnClickListener(listener);
		return this;
	}

	/**
	 * 设置字体颜色
	 * 
	 * @param color
	 *            颜色
	 * @param ids
	 *            TextView 的id集合
	 * @return
	 */
	public ViewHolder setTextColor(int color, int... ids) {
		for (int id : ids) {
			TextView tv = getView(id);
			tv.setTextColor(color);
		}
		return this;
	}

	/**
	 * 设置touch事件
	 * 
	 * @param viewId
	 * @param listener
	 * @return
	 */
	public ViewHolder setOnTouchListener(int viewId,
			View.OnTouchListener listener) {
		View view = getView(viewId);
		view.setOnTouchListener(listener);
		return this;
	}

	/**
	 * 设置长按事件
	 * 
	 * @param viewId
	 * @param listener
	 * @return
	 */
	public ViewHolder setOnLongClickListener(int viewId,
			View.OnLongClickListener listener) {
		View view = getView(viewId);
		view.setOnLongClickListener(listener);
		return this;
	}
}