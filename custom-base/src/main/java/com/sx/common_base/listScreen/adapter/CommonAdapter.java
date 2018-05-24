package com.sx.common_base.listScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

//import com.ffu365.custom.listScreen.adapter.annotation.AdapterUtil;

import com.sx.common_base.listScreen.adapter.annotation.AdapterUtil;

import java.util.List;

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
 * date created : On November, 2014
 * 
 * description : Universal adapter
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected final LayoutInflater mInflater;
	protected final Context mContext;
	protected List<T> mDatas;
	protected int mItemLayoutId;
	private Object mViewpageItemObj;

	protected MultiItemTypeSupport<T> mMultiItemSupport;

	/**
	 * 单个布局的构造方法
	 * 
	 * @param context
	 *            Interface to global information about an application
	 *            environment. This is an abstract class whose implementation is
	 *            provided by the Android system. It allows access to
	 *            application-specific resources and classes, as well as
	 *            up-calls for application-level operations such as launching
	 *            activities, broadcasting and receiving intents, etc.
	 * @param mDatas
	 *            data list
	 * @param itemLayoutId
	 *            item layout
	 */
	public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}
	
	/**
	 * 单个布局的构造方法
	 * 
	 * @param context
	 *            Interface to global information about an application
	 *            environment. This is an abstract class whose implementation is
	 *            provided by the Android system. It allows access to
	 *            application-specific resources and classes, as well as
	 *            up-calls for application-level operations such as launching
	 *            activities, broadcasting and receiving intents, etc.
	 * @param mDatas
	 *            data list
	 * @param itemLayoutId
	 *            item layout
	 */
	public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId, Object viewpageItemObj) {
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
		this.mViewpageItemObj = viewpageItemObj;
	}

	/**
	 * 两个不同布局的构造方法，可以不用写在本类里面，使用继承的方式
	 * multiItemSupport : 回调的接口，根据不同的对象拿对应的布局id
	 */
	public CommonAdapter(Context context, List<T> datas,
                         MultiItemTypeSupport<T> multiItemSupport) {
		this.mContext = context;
		this.mDatas = datas;
		this.mInflater = LayoutInflater.from(mContext);
		this.mMultiItemSupport = multiItemSupport;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (this.mMultiItemSupport != null) {
			// 多种布局
			viewHolder = getViewHolder(
					position,
					convertView,
					parent,
					// 回调一次拿具体的布局
					this.mMultiItemSupport.getLayoutId(position,
							getItem(position)));
		} else {
			// 单种布局
			viewHolder = getViewHolder(position, convertView, parent,
					mItemLayoutId);
		}
		// 动态绑定点击事件
		AdapterUtil.inject(mContext, this, viewHolder.getConvertView(), getItem(position), mViewpageItemObj);
		convert(viewHolder, getItem(position), position);
		return viewHolder.getConvertView();
	}

	public abstract void convert(ViewHolder holder, T item, int position);

	private ViewHolder getViewHolder(int position, View convertView,
			ViewGroup parent, int layoutId) {
		return ViewHolder.get(mContext, convertView, parent, layoutId,
				position);
	}
	
}
