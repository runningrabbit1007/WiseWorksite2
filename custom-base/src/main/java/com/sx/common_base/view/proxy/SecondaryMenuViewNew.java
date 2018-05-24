/*
package com.sx.common_base.view.proxy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.common.utils.GeneralUtil;
import com.common.utils.LogUtils;
//import com.ffu365.custom.R;
//import com.ffu365.custom.listScreen.adapter.ViewHolder;
//import com.ffu365.custom.modle.bean.publish.SelectBean;
//import com.ffu365.custom.modle.dick.ListScreenEntity;

import java.util.ArrayList;

*/
/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2017/7/27
 * Desc   : 新的二级菜单
 *//*


@SuppressLint("NewApi")
public class SecondaryMenuViewNew extends LinearLayout implements
		ListItemProxy.ProxyParamSelectLisenter<ListScreenEntity> {
	private Context mContext;
	private ListItemProxy<ListScreenEntity> mFirstItemProxy,
			mSecondItemProxy;
	protected ListScreenEntity mCureentFirstSelectItem,
			mCureentSecondSelectItem, mRecordItem;
	// 两个ListView
	private ListView mFirstMenuLv, mSecondMenuLv;
	// 监听参数
	private ArrayList<String> mScreenList;
	private String mScreenStr;
	// 是否需要添加不限
	private boolean mIsLoadUnlimited = true;

	private ArrayList<ListScreenEntity> mParentDatas, mChildIndustrys;

	private int mSelectedTextColor, mUnSelectTextColor, mSelectBgColor,
			mUnSelectBgColor;

	public SecondaryMenuViewNew(Context context) {
		this(context, null);
	}

	public SecondaryMenuViewNew(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SecondaryMenuViewNew(Context context, AttributeSet attrs,
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
		this.setBackgroundColor(Color.WHITE);

		mFirstMenuLv = new ListView(mContext);
		setListViewAttribute(mFirstMenuLv);
		mSecondMenuLv = new ListView(mContext);
		setListViewAttribute(mSecondMenuLv);
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
		listView.setDividerHeight(0);
		listView.setVerticalScrollBarEnabled(false);
		listView.setScrollBarSize(0);
	}

	private void initData() {
		mParentDatas = new ArrayList<>();
		mChildIndustrys = new ArrayList<>();
		mScreenList = new ArrayList<>();
		mFirstItemProxy = new ListItemProxy<ListScreenEntity>(mFirstMenuLv);
		//选择后的字体颜色
		mSelectedTextColor = mContext.getResources().getColor(
				R.color.text_main_color);
		//没有选择的字体颜色
		mUnSelectTextColor = mContext.getResources().getColor(
				R.color.c333333);
		mSelectBgColor = Color.WHITE;
		mUnSelectBgColor = Color.parseColor("#F7F7F7");

		mFirstMenuLv.setBackgroundColor(mUnSelectBgColor);
	}

	*/
/**
	 * 打开二级
	 *//*

	private void openSecondIndustry() {
		GeneralUtil.setViewVisible(mSecondMenuLv);
		if (mSecondItemProxy == null) {
			mSecondItemProxy = new ListItemProxy<ListScreenEntity>(
					mSecondMenuLv);
		}
		mSecondItemProxy.setProxyParamSelectLisenter(this);
	}

	@Override
	public void selected(ListView proxyView,
			final ListScreenEntity selectedParam) {

		if (proxyView == mFirstMenuLv) {
			// 改变背景颜色
			mCureentFirstSelectItem = selectedParam;
			mFirstItemProxy.notifyDataSetChanged();

			if (selectedParam.getDict_text().equals("不限")) {
				mScreenList.clear();
				mCureentSecondSelectItem = null;
				GeneralUtil.setViewInVisible(mSecondMenuLv);
				mRecordItem = mCureentFirstSelectItem;
				mScreenStr = selectedParam.getDict_text();
				if (mListener != null){
					SelectBean selectBean = new SelectBean(selectedParam.getId(),selectedParam.getDict_text());
					mListener.complete(this, selectBean, selectedParam);
				}

				return;
			}
			openSecondIndustry();
		}

		if (proxyView == mSecondMenuLv) {
			mCureentSecondSelectItem = selectedParam;
			mSecondItemProxy.notifyDataSetChanged();

			mRecordItem = mCureentFirstSelectItem;
			mScreenList.clear();

			if (selectedParam.getDict_text().equals("不限")) {
				mScreenList.add(mCureentFirstSelectItem.getId());
				mScreenStr = mCureentFirstSelectItem.getDict_text();
			} else {
				mScreenList.add(mCureentFirstSelectItem.getId());
				mScreenList.add(selectedParam.getId());
				mScreenStr = mCureentFirstSelectItem.getDict_text() + "-"
						+ selectedParam.getDict_text();
			}

			if (mListener != null){
				SelectBean selectBean = new SelectBean(selectedParam.getId(),mScreenStr);
				mListener.complete(this, selectBean, selectedParam);
			}
		}
	}

	@Override
	public void convert(ViewHolder holder, ListScreenEntity item,
						int position, ListView proxyView) {
		holder.setText(R.id.param_name, item.getDict_text());

		if (proxyView == mFirstMenuLv) {
			// 改变背景颜色
			if (item.equals(mCureentFirstSelectItem)) {
				holder.getView(R.id.item_view).setBackgroundColor(
						mSelectBgColor);
				holder.setTextColor(mSelectedTextColor, R.id.param_name);
			} else {
				holder.getView(R.id.item_view).setBackgroundColor(
						mUnSelectBgColor);
				holder.setTextColor(mUnSelectTextColor, R.id.param_name);
			}
		}

		if (proxyView == mSecondMenuLv) {
			// 改变字体颜色
			if (item.equals(mCureentSecondSelectItem)) {
				holder.setTextColor(mSelectedTextColor, R.id.param_name);
			} else {
				holder.setTextColor(mUnSelectTextColor, R.id.param_name);
			}
		}
	}

	@Override
	public ArrayList<ListScreenEntity> getParams(ListView proxyView) {
		if (proxyView == mFirstMenuLv) {
			if (mIsLoadUnlimited) {
				// 加入不限
				mParentDatas.add(0, new ListScreenEntity("不限"));
			}
			return mParentDatas;
		}

		if (proxyView == mSecondMenuLv) {
			mChildIndustrys.clear();
			LogUtils.d("mCurrentFirstSelectItem == " + mCureentFirstSelectItem.getDict_text());
			mChildIndustrys.addAll(mCureentFirstSelectItem.getChildren());
			if (mIsLoadUnlimited) {
				mChildIndustrys.add(0, new ListScreenEntity("不限"));
			}
			return mChildIndustrys;
		}

		return new ArrayList<ListScreenEntity>();
	}

	public void setData(ArrayList<ListScreenEntity> datas) {
		LogUtils.d("setData");
		setData(datas, true);
	}

	private OnScreenCompleteListener mListener;

	public void setOnScreenCompleteListener(OnScreenCompleteListener listener) {
		this.mListener = listener;
	}

	*/
/**
	 * 恢复记录
	 *//*

	public void recoveryRecord() {
		if (mRecordItem != null) {
			mCureentFirstSelectItem = mRecordItem;
			mFirstItemProxy.notifyDataSetChanged();
			if (!mCureentFirstSelectItem.getDict_text().equals("不限")) {
				openSecondIndustry();
			} else {
				mChildIndustrys.clear();
				mSecondItemProxy.notifyDataSetChanged();
			}
		}
	}

	public interface OnScreenCompleteListener {
		public void complete(View view, SelectBean bean,
							 ListScreenEntity entity);
	}

	public void setData(ArrayList<ListScreenEntity> datas,
			boolean isLoadUnlimited) {
		mParentDatas.clear();
		mParentDatas.addAll(datas);
		this.mIsLoadUnlimited = isLoadUnlimited;
		mFirstItemProxy.setProxyParamSelectLisenter(this);
	}

	public void setRecord(ListScreenEntity firstItem,
						  ListScreenEntity secondItem) {
		mRecordItem = firstItem;
		mCureentSecondSelectItem = secondItem;
	}

	public String getSecondStr() {
		return mCureentFirstSelectItem.getDict_text();
	}

	public String getFirstStr() {
		return mCureentSecondSelectItem.getDict_text();
	}

	*/
/**
	 * 清除记录
	 *//*

	public void clearRecord() {
		mRecordItem = null;
		mCureentFirstSelectItem = null;
		mCureentSecondSelectItem = null;
		mFirstItemProxy.notifyDataSetChanged();
		mSecondItemProxy.notifyDataSetChanged();

	}
}
*/
