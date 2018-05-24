/*
package com.sx.common_base.listScreen;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.common.utils.GeneralUtil;
import com.sx.common_base.bean.CityItemBean;
//import com.ffu365.custom.R;
//import com.ffu365.custom.bean.CityItemBean;
//import com.ffu365.custom.db.PlaceUtil;
//import com.ffu365.custom.listScreen.adapter.ViewHolder;
//import com.ffu365.custom.ui.SecondaryMenuView;
//import com.ffu365.custom.view.proxy.ListItemProxy;
//import com.ffu365.custom.view.screen.list.CenterListItemProxy;

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
 * description : 所在地筛选
 *
 * revision history :
 *
 * ============================================================
 *
 *//*

public class LocationScreenMenuView extends LinearLayout implements
		ListItemProxy.ProxyParamSelectLisenter<CityItemBean>, OnClickListener {
	private Context mContext;
	private ListView mProviceLv, mCityLv;

	private CenterListItemProxy<CityItemBean> mProviceItemProxy,
			mCityItemProxy;

	// 选择好的位置
	private CityItemBean mSelectProvice, mSelectCity;

	// 选择好的Id
	private int mSelectProviceId, mSelectCityId;

	// 选择好的CityCode
	private String mSelectProviceCc, mSelectCityCc;
	private String mSelectProviceName, mSelectCityName;

	// 选择好的位置
	private int mSelectProvicePosition, mSelectCityPosition;
	// 当前位置
	private int mCureentProvicePosition, mCureentCityPosition;

	private String mSelectName;

	private SecondaryMenuView.OnScreenCompleteListener mCompleteListener;

	public LocationScreenMenuView(Context context) {
		this(context, null);
	}

	public LocationScreenMenuView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LocationScreenMenuView(Context context, AttributeSet attrs,
                                  int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		initView();
		initData();
	}

	*/
/**
	 * 初始化数据
	 *//*

	private void initData() {
		mProviceItemProxy = new CenterListItemProxy<>(mProviceLv);
		mProviceItemProxy.setProxyParamSelectLisenter(this);
	}

	*/
/**
	 * 初始化View
	 *//*

	private void initView() {
		mProviceLv = new ListView(mContext);
		mCityLv = new ListView(mContext);

		setListViewAttribute(mProviceLv);
		setListViewAttribute(mCityLv);

		setOnClickListener(this);
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

	@Override
	public void selected(ListView proxyView, CityItemBean selectedParam) {
		if (proxyView == mProviceLv) {
			mSelectProvice = selectedParam;
			mSelectCity = null;
			mProviceItemProxy.notifyDataSetChanged();
			if (selectedParam.getName().equals("不限")) {
				GeneralUtil.setViewInVisible(mCityLv);
				mCureentProvicePosition = 0;
				recordData();
				responseLisenter();
				return;
			}

			GeneralUtil.setViewVisible(mCityLv);
			mCityItemProxy = new CenterListItemProxy<>(mCityLv);
			mCityItemProxy.setProxyParamSelectLisenter(this);
		}
		if (proxyView == mCityLv) {
			mSelectCity = selectedParam;
			mCityItemProxy.notifyDataSetChanged();
			if (selectedParam.getName().equals("不限")) {
				mCureentCityPosition = 0;
			}
			recordData();
			responseLisenter();
		}

	}

	private void responseLisenter() {
		if (mCompleteListener != null) {
			String screenStr = mSelectProviceName;
			if(!mSelectCityName.equals("不限")&&!mSelectCityName.equals("")){
				screenStr = mSelectProviceName+"-"+mSelectCityName;
			}
			mCompleteListener.complete(this,screenStr,null);
		}
	}

	@Override
	public void convert(ViewHolder holder, CityItemBean item, int position,
                        ListView proxyView) {
		TextView tv = holder.getView(R.id.param_name);
		View itemView = holder.getView(R.id.item_view);
		holder.setText(R.id.param_name, item.getName());

		if (proxyView == mProviceLv) {
			setItemStyle(proxyView, position, itemView, item, mSelectProvice,
					tv);
		}

		if (proxyView == mCityLv) {
			setItemStyle(proxyView, position, itemView, item, mSelectCity, tv);
		}


	}

	private void setItemStyle(ListView proxyView, int position, View itemView,
                              CityItemBean item, CityItemBean select, TextView tv) {
		if (select != null && item.getId() == select.getId()) {
			itemView.setBackgroundColor(mContext.getResources().getColor(
					R.color.root_bg_color));
			tv.setTextColor(mContext.getResources().getColor(
					R.color.text_main_color));

			if (proxyView == mProviceLv) {
				mCureentProvicePosition = position;
			}

			if (proxyView == mCityLv) {
				mCureentCityPosition = position;
			}

		} else {
			itemView.setBackgroundColor(Color.WHITE);
			tv.setTextColor(Color.parseColor("#3F3F3F"));
		}
	}

	@Override
	public ArrayList<CityItemBean> getParams(ListView proxyView) {
		if (proxyView == mProviceLv) {
			return PlaceUtil.getArea(mContext, 0);
		}
		if (proxyView == mCityLv) {
			return PlaceUtil.getArea(mContext, mSelectProvice.getId());
		}

		return new ArrayList<>();
	}

	@Override
	public void onClick(View v) {

	}

	*/
/**
	 * 记录数据
	 *//*

	public void recordData() {

		if (mSelectProvice != null) {
			mSelectProviceId = mSelectProvice.getId();
			mSelectProviceName = mSelectProvice.getName();
			mSelectProviceCc = mSelectProvice.getCityCode();
			mSelectProvicePosition = mCureentProvicePosition;
			mSelectName = mSelectProviceName;
		} else {
			mSelectName = "不限";
			mSelectProviceId = 0;
			mSelectProviceName = "";
			mSelectProviceCc = "0";
			mSelectProvicePosition = 0;
		}

		if (mSelectCity != null) {
			mSelectCityId = mSelectCity.getId();
			mSelectCityName = mSelectCity.getName();
			mSelectCityCc = mSelectCity.getCityCode();
			mSelectCityPosition = mCureentCityPosition;
			mSelectName = mSelectName + "-" + mSelectCityName;
		} else {
			mSelectCityId = 0;
			mSelectCityName = "";
			mSelectCityCc = "0";
			mSelectCityPosition = 0;
		}
	}

	*/
/**
	 * 恢复记录
	 *//*

	public void recoveryRecord() {
		mProviceItemProxy.setProxyParamSelectLisenter(this);
		if (mSelectProviceId != 0) {
			mSelectProvice = new CityItemBean();
			mSelectProvice.setCityCode(mSelectProviceCc);
			mSelectProvice.setId(mSelectProviceId);
			mSelectProvice.setName(mSelectProviceName);
			mCityItemProxy.setProxyParamSelectLisenter(this);
			mProviceLv.setSelection(mSelectProvicePosition);
		}

		if (mSelectCityId != 0) {
			mSelectCity = new CityItemBean();
			mSelectCity.setId(mSelectCityId);
			mSelectCity.setCityCode(mSelectCityCc);
			mSelectCity.setName(mSelectCityName);
			mCityLv.setSelection(mSelectCityPosition);
			GeneralUtil.setViewVisible(mCityLv);
		} else {
			GeneralUtil.setViewInVisible(mCityLv);
		}
	}

	*/
/**
	 * 清空所有
	 *//*

	public void clearAllData() {
		mSelectProvice = null;
		mSelectCity = null;
		recordData();
	}

	public String getSelectName() {
		return mSelectName;
	}

	public String getProvinceCode() {
		return mSelectProviceCc;
	}

	public String getCityCode() {
		return mSelectCityCc;
	}

	public void setOnScreenCompleteListener(
			SecondaryMenuView.OnScreenCompleteListener completeListener) {
		this.mCompleteListener = completeListener;
	}
}
*/
