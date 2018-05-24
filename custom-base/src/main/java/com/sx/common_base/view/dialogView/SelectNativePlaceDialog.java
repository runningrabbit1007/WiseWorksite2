package com.sx.common_base.view.dialogView;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.common.base.config.PreferencesManager;
import com.common.utils.GeneralUtil;
import com.common.utils.dialog.BaseSelectParamDialog;
import com.common.utils.dialog.DialogViewHolder;
import com.google.gson.JsonObject;
import com.sx.common_base.R;
import com.sx.common_base.bean.MallCityItemBean;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.APIKeys;
import com.sx.common_base.http.RequestMaster;
import com.sx.common_base.listScreen.adapter.ViewHolder;
import com.sx.common_base.result.AreaListResult;
import com.sx.common_base.util.ApplicationUtil;
import com.sx.common_base.util.JSONUtil;
import com.sx.common_base.view.CenterListItemProxy;
import com.sx.common_base.view.proxy.ListItemProxy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

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
 * description : 选择详细地址
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class SelectNativePlaceDialog extends BaseSelectParamDialog implements
		OnClickListener, ListItemProxy.ProxyParamSelectLisenter<MallCityItemBean> {

	private static ListView mProviceLv, mCityLv, mAreaLv;

	private static CenterListItemProxy<MallCityItemBean> mProviceItemProxy,
			mCityItemProxy, mAreaItemProxy;

	// 选择好的位置
	private MallCityItemBean mSelectProvice, mSelectCity, mSelectArea;

	static ArrayList<MallCityItemBean> cityItemBeanList = new ArrayList<>();


	// 选择好的位置
	private int mSelectProvicePosition, mSelectCityPosition,
			mSelectAreaPosition;
	// 当前位置
	private int mCureentProvicePosition, mCureentCityPosition,
			mCureentAreaPosition;

	private ArrayList<MallCityItemBean> mCurrentVillages;
	private TextView textView;
	private boolean isHaveNext = true;
	private String selectCityId = "0";

	public SelectNativePlaceDialog(TextView proxyView,Context context) {
		super(proxyView.getContext(),proxyView);
		this.textView = proxyView;
		initListParams(mContext,0);
	}

	private void initListParams(Context mContext,int parentId) {
			//后台获取
			Map<String, String> params = new HashMap<>();
			if(parentId != 0){
				params.put("parentId",String.valueOf(parentId));

			}
			int siteId = PreferencesManager.getInstance().getSITE_ID();
			params.put("siteId", String.valueOf(siteId) );
			RequestMaster.getInstance().callPostRequestMall(APIKeys.SHELL.API_GET_AREA_LISR, params, new BaseSmartMallCallback(mContext){
				@Override
				public void onGetSuccess(JsonObject result) {

					AreaListResult areaListResult = JSONUtil.parseObject(result.toString(), AreaListResult.class);
					cityItemBeanList =areaListResult.getAreaList();

				}
				@Override
				public void onGetFailed(int code) {
					cityItemBeanList = null;
				}
				@Override
				public void onGetError(Call call, Exception e, int id) {
					cityItemBeanList = null;

				}
			},mContext.getClass().getName());
	}


	@Override
	protected int getDialogWidth() {
		return ViewGroup.LayoutParams.MATCH_PARENT;
	}

	@Override
	protected int getDialogHeight() {
		return ApplicationUtil.getScreenWidthHeight(mContext).y * 65 / 100;
	}

	@Override
	protected void convertView(DialogViewHolder view) {
		mProviceLv = view.getView(R.id.provice_lv);
		mCityLv = view.getView(R.id.city_lv);
		mAreaLv = view.getView(R.id.area_lv);
		mProviceItemProxy = new CenterListItemProxy<>(mProviceLv);
		mProviceItemProxy.setProxyParamSelectLisenter(this);
		view.setOnClick(R.id.user_cancle, this);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.dialog_select_native_place;
	}

	@Override
	public void onClick(View v) {
		cancelDialog();
	}

	@Override
	public void selected(ListView proxyView, MallCityItemBean selectedParam) {
		if (proxyView == mProviceLv) {
			mSelectProvice = selectedParam;
			GeneralUtil.setViewInVisible(mAreaLv);
			mProviceItemProxy.notifyDataSetChanged();
			initListParams(mContext,mSelectProvice.getValue());
			mCityItemProxy = new CenterListItemProxy<>(mCityLv);
			mCityItemProxy.setProxyParamSelectLisenter(this);
		}
		if (proxyView == mCityLv) {
			mSelectCity = selectedParam;
			mCityItemProxy.notifyDataSetChanged();
			initListParams(mContext,mSelectCity.getValue());
			mAreaItemProxy = new CenterListItemProxy<>(mAreaLv);
			mAreaItemProxy.setProxyParamSelectLisenter(this);
			if(isHaveNext){
				GeneralUtil.setViewVisible(mAreaLv);
			}else {
				cancelDialog();
				selectCityId = String.valueOf(selectedParam.getValue());
				textView.setText(selectedParam.getName());
//				sureVillagePosition();
			}
		}

		if (proxyView == mAreaLv) {
			mSelectArea = selectedParam;

			mAreaItemProxy.notifyDataSetChanged();
			initListParams(mContext,mSelectArea.getValue());
			cancelDialog();
			selectCityId = String.valueOf(selectedParam.getValue());
			textView.setText(selectedParam.getName());
//			sureVillagePosition();
		}
	}

	private void sureVillagePosition() {
		for (int i = 0; i < mCurrentVillages.size(); i++) {
			if (mSelectArea.getName() == mCurrentVillages.get(i).getName()) {
				mSelectAreaPosition = i;
				break;
			}
		}
	}


	@Override
	public void convert(ViewHolder holder, MallCityItemBean item, int position,
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
		if (proxyView == mAreaLv) {
			setItemStyle(proxyView, position, itemView, item, mSelectArea, tv);
		}
	}

	private void setItemStyle(ListView proxyView, int position, View itemView,
							  MallCityItemBean item, MallCityItemBean select, TextView tv) {
		if (select != null && item.getValue() == select.getValue()) {
			itemView.setBackgroundColor(mContext.getResources().getColor(
					R.color.root_bg_color));
			tv.setTextColor(Color.parseColor("#FC4E22"));

			if (proxyView == mProviceLv) {
				mCureentProvicePosition = position;
			}

			if (proxyView == mCityLv) {
				mCureentCityPosition = position;
			}
			if (proxyView == mAreaLv) {
				mCureentAreaPosition = position;
			}
		} else {
			itemView.setBackgroundColor(Color.WHITE);
			tv.setTextColor(Color.parseColor("#3F3F3F"));
		}
	}

	@Override
	public ArrayList<MallCityItemBean> getParams(ListView proxyView) {
		if (proxyView == mProviceLv) {
//			getCityList(0,mContext);

			return  cityItemBeanList;
		}
		if (proxyView == mCityLv) {

			return  cityItemBeanList;
		}

		if (proxyView == mAreaLv) {
//			getCityList(mSelectProvice.getValue(),mContext);
//			mCurrentVillages =   requestData(mContext,mSelectCity.getValue(),proxyView);
			mCurrentVillages = cityItemBeanList;
			isHaveNext = mCurrentVillages.size() != 0;
			return mCurrentVillages;
		}
		return new ArrayList<>();
	}







	@Override
	public void showDialog() {
		super.showDialog();
	}

	/**
	 * 滚动到记录的位置
	 */
	private void scrollToRecordPosition() {
		mProviceLv.setSelection(mSelectProvicePosition);
		mCityLv.setSelection(mSelectCityPosition);
		if(!isHaveNext){
			mAreaLv.setSelection(mSelectAreaPosition);
		}
	}


//	//获取省
//	private ArrayList<MallCityItemBean> requestData(final Context context, int parent_id, final ListView proxyView) {
//		//后台获取
//
//		Map<String, String> params = new HashMap<>();
//		if(parent_id != 0){
//			params.put("parentId",String.valueOf(parent_id));
//		}
//		RequestMaster.getInstance().callPostRequestMall(APIKeys.SHELL.API_GET_AREA_LISR, params, new BaseSmartMallCallback(context){
//			@Override
//			public void onGetSuccess(JsonObject result) {
//
//				AreaListResult areaListResult = JSONUtil.parseObject(result.toString(), AreaListResult.class);
//				cityItemBeanList =areaListResult.getAreaList();
//				//重新获得数据
//
//				if (proxyView == mProviceLv) {
//					mProviceItemProxy.set(cityItemBeanList);
//				}
//				if (proxyView == mCityLv) {
//					mCityItemProxy.set(cityItemBeanList);
//				}
//
//				if (proxyView == mAreaLv) {
//					mAreaItemProxy.set(cityItemBeanList);
//
//				}
//
//
//
//			}
//			@Override
//			public void onGetFailed(int code) {
//				cityItemBeanList = null;
//			}
//			@Override
//			public void onGetError(Call call, Exception e, int id) {
//				cityItemBeanList = null;
//
//			}
//		},context.getClass().getName());
//
//		return  cityItemBeanList;
//
//	}

	private void  getData(){

	}

	public int getmSelectProviceId() {
		return mSelectProvice.getValue();
	}

	public int getmSelectCityId() {
		return mSelectCity.getValue();
	}

	public int getmSelectAreaId() {
		return mSelectArea.getValue();
	}

	public String getSelectCityId() {
		return selectCityId;
	}
}
