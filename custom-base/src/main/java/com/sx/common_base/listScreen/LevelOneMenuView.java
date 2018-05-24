/*
package com.sx.common_base.listScreen;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

//import com.ffu365.custom.R;
//import com.ffu365.custom.listScreen.adapter.ViewHolder;
//import com.ffu365.custom.modle.dick.ListScreenEntity;
//import com.ffu365.custom.ui.SecondaryMenuView;
//import com.ffu365.custom.view.proxy.ListItemProxy;

import java.util.ArrayList;

*/
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
 * description : 一级菜单View
 * 
 * revision history :
 * 
 * ============================================================
 * 
 *//*

public class LevelOneMenuView extends LinearLayout implements
		ListItemProxy.ProxyParamSelectLisenter<ListScreenEntity> {
	private Context mContext;
	private ListItemProxy<ListScreenEntity> mFirstItemProxy;
	private ListScreenEntity mCureentSelectItem;
	// 两个ListView
	private ListView mFirstMenuLv;
	// 监听参数
	private ArrayList<String> mScreenList;
	// 是否需要添加不限
	private boolean mIsLoadUnlimited = true;

	private ArrayList<ListScreenEntity> mDatas;

	private int mSelectedTextColor, mUnSelectTextColor, mSelectBgColor,
			mUnSelectBgColor;
	private SecondaryMenuView.OnScreenCompleteListener mListener;

	public LevelOneMenuView(Context context) {
		this(context, null);
	}

	public LevelOneMenuView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LevelOneMenuView(Context context, AttributeSet attrs,
                            int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		initView();
		initData();
	}

	*/
/**
	 * 初始化View
	 *//*

	private void initView() {
		mFirstMenuLv = new ListView(mContext);
		setListViewAttribute(mFirstMenuLv);
	}

	*/
/**
	 * 设置listView的属性
	 *//*

	private void setListViewAttribute(ListView listView) {
		LayoutParams params = new LayoutParams(0,
				LayoutParams.MATCH_PARENT);
		params.weight = 1;
		listView.setLayoutParams(params);
		this.addView(listView);

		// 没有分割线，不显示滚动条
		listView.setVerticalScrollBarEnabled(false);
		listView.setScrollBarSize(0);

		mDatas = new ArrayList<>();
	}

	*/
/**
	 * 初始化数据
	 *//*

	private void initData() {
		mScreenList = new ArrayList<>();
		mFirstItemProxy = new ListItemProxy<ListScreenEntity>(mFirstMenuLv);

		mSelectedTextColor = mContext.getResources().getColor(
				R.color.radio_button_selected_color);
		mUnSelectTextColor = mContext.getResources().getColor(
				R.color.defualt_text_color);

		mSelectBgColor = mContext.getResources()
				.getColor(R.color.root_bg_color);
		mUnSelectBgColor = Color.WHITE;
	}

	@Override
	public void selected(ListView proxyView,
			final ListScreenEntity selectedParam) {
		// 改变背景颜色
		mCureentSelectItem = selectedParam;
		mFirstItemProxy.notifyDataSetChanged();
		if (mListener != null) {
			mScreenList.clear();
			mScreenList.add(selectedParam.getId());
			mListener.complete(LevelOneMenuView.this,
					selectedParam.getDict_text(), mScreenList);
		}
	}

	@Override
	public void convert(ViewHolder holder, ListScreenEntity item,
						int position, ListView proxyView) {
		holder.setText(R.id.param_name, item.getDict_text());

		if (item == mCureentSelectItem) {
			holder.setBackgroundColor(R.id.item_view, mSelectBgColor);
			holder.setTextColor(mContext.getResources().getColor(R.color.text_main_color), R.id.param_name);

		} else {
			holder.setBackgroundColor(R.id.item_view, mUnSelectBgColor);
			holder.setTextColor(mUnSelectTextColor, R.id.param_name);
		}
	}

	@Override
	public ArrayList<ListScreenEntity> getParams(ListView proxyView) {
		if (mIsLoadUnlimited) {
			// 加入不限
			addUnlimitedItem(mDatas);
		}
		return mDatas;
	}

	private void addUnlimitedItem(ArrayList<ListScreenEntity> data) {
		data.add(0,new ListScreenEntity("不限"));
	}

	public void setData(ArrayList<ListScreenEntity> data) {
		setData(data, true);
	}

	public void setData(ArrayList<ListScreenEntity> data,
			boolean isLoadUnlimited) {
		this.mIsLoadUnlimited = isLoadUnlimited;
		mDatas.addAll(data);
		mFirstItemProxy.setProxyParamSelectLisenter(this);
	}

	public void setOnScreenCompleteListener(SecondaryMenuView.OnScreenCompleteListener listener) {
		this.mListener = listener;
	}

}
*/
