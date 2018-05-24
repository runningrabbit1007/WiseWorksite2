package com.sx.common_base.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.common.utils.LogUtils;
import com.sx.common_base.R;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;
import com.sx.common_base.view.proxy.ListItemProxy;

import java.util.ArrayList;

/**
 * 
 * ============================================================
 * 
 * project name :
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On October, 2015
 * 
 * description : 列表条目代理选择
 * 
 * revision history :
 * 
 * =============================================================
 * 
 */
public class CenterListItemProxy<T> {
	private ListView mProxyView;
	private ArrayList<T> mParams;
	private Context mContext;
	private ListItemProxy.ProxyParamSelectLisenter<T> mLisenter;
	private CommonAdapter<T> mAdapter;
	
	private int mSelection = 0;

	public CenterListItemProxy(ListView mProxyView) {
		this.mProxyView = mProxyView;
		this.mContext = this.mProxyView.getContext();
		this.mParams = new ArrayList<T>();
	}

	/**
	 * 设置可选择的集合参数
	 */
	public void set(ArrayList<T> params) {
		this.mParams = params;
		setShowParams();
	}

	/**
	 * 设置参数选择的监听
	 */
	public void setProxyParamSelectLisenter(ListItemProxy.ProxyParamSelectLisenter<T> lisenter) {
		this.mLisenter = lisenter;
		setShowParams();
	}
	

	/**
	 * @return the mSelection
	 */
	public int getmSelection() {
		return mSelection;
	}


	// 显示一个参数选择的dialog
	private void setShowParams() {
		if (mParams == null) {
			if (mLisenter == null) {
				throw new NullPointerException(
						"select param lisenter isn't set,ArrayList is null");
			}
		}
		mParams.clear();
		mParams.addAll(mLisenter.getParams(mProxyView));

		if (mParams == null || mParams.size() == 0) {
			// 再次判断如果是空或者没有数据，不做处理至少不让程序崩掉
			LogUtils.i("param 是空可能没有获取到数据或是没有传递过来");
			return;
		}
		
		if(mAdapter == null){
			mAdapter = new CommonAdapter<T>(mContext, mParams,
					R.layout.item_text_list, false) {
				@Override
				public void convert(ViewHolder holder, final T item, final int position) {
					holder.setItemClick(new OnClickListener() {
						@Override
						public void onClick(View v) {
							mSelection = position;
							// 选中
							if (mLisenter != null) {
								
								mLisenter.selected(mProxyView, item);
							}
						}
					});
					
					if (mLisenter != null) {
						mLisenter.convert(holder, item,
								position,mProxyView);
					}
				}
			};
			mProxyView.setAdapter(mAdapter);
		}else{
			mAdapter.notifyDataSetChanged();
		}
	}
	
	/**
	 * 数据改变
	 */
	public void notifyDataSetChanged(){
		mAdapter.notifyDataSetChanged();
		
	}
	
	public void backTop() {
		mProxyView.smoothScrollToPosition(0);
	}
}