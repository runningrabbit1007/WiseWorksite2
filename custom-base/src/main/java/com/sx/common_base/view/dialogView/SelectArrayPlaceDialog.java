package com.sx.common_base.view.dialogView;

import android.content.Context;
import android.graphics.Color;
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
import com.sx.common_base.bean.CityItemBean;
import com.sx.common_base.bean.MallCityItemBean;
import com.sx.common_base.callback.BaseSmartMallCallback;
import com.sx.common_base.constant.APIKeys;
import com.sx.common_base.http.RequestMaster;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
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
public class SelectArrayPlaceDialog extends BaseSelectParamDialog implements
		OnClickListener{

	private static ListView mProviceLv, mCityLv, mAreaLv;

	// 选择好的位置
	private MallCityItemBean mSelectProvice, mSelectCity, mSelectArea;

	private CommonAdapter<MallCityItemBean> mProviceAdapter,mCityAdapter,mAreaAdapter;

	static ArrayList<MallCityItemBean> cityItemBeanList = new ArrayList<>();


	private ArrayList<MallCityItemBean> mCurrentVillages;
	private TextView textView;
	private boolean isHaveNext = true;
	private String selectCityId = "0";

	// 当前位置
	private int mCureentProvicePosition, mCureentCityPosition,
			mCureentAreaPosition;


	public SelectArrayPlaceDialog(TextView proxyView, Context context) {
		super(proxyView.getContext(),proxyView);
		this.textView = proxyView;
//		initListParams(mContext,0);
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
		//初始化省的点击
		initProvice(mProviceLv);

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
	public void showDialog() {
		super.showDialog();
	}

	private void initProvice(final ListView mProviceLv){

   		 int parentId = 0;
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

				mProviceAdapter = new CommonAdapter<MallCityItemBean>(mContext, cityItemBeanList,
						R.layout.item_text_list, false) {
					@Override
					public void convert(ViewHolder holder,final MallCityItemBean item, int position) {
						holder.setItemClick(new OnClickListener() {
							@Override
							public void onClick(View v) {
								mSelectProvice = item;
								GeneralUtil.setViewInVisible(mAreaLv);
								mProviceAdapter.notifyDataSetChanged();
								//开始设置区
								initCity();
//							initListParams(mContext,mSelectProvice.getValue());
//							mCityItemProxy = new CenterListItemProxy<>(mCityLv);
							}
						});
						TextView tv = holder.getView(R.id.param_name);
						View itemView = holder.getView(R.id.item_view);
						holder.setText(R.id.param_name, item.getName());
						setItemStyle(mProviceLv, position, itemView, item, mSelectProvice,
								tv);

					}
				};
				mProviceLv.setAdapter(mProviceAdapter);

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

		//得到数据
		/*if(mProviceAdapter == null){
			mProviceAdapter = new CommonAdapter<MallCityItemBean>(mContext, cityItemBeanList,
					R.layout.item_text_list, false) {
				@Override
				public void convert(ViewHolder holder,final MallCityItemBean item, int position) {
					holder.setItemClick(new OnClickListener() {
						@Override
						public void onClick(View v) {
							mSelectProvice = item;
							GeneralUtil.setViewInVisible(mAreaLv);
							mProviceAdapter.notifyDataSetChanged();
							//开始设置区
							initCity();
//							initListParams(mContext,mSelectProvice.getValue());
//							mCityItemProxy = new CenterListItemProxy<>(mCityLv);
						}
					});
					TextView tv = holder.getView(R.id.param_name);
					View itemView = holder.getView(R.id.item_view);
					holder.setText(R.id.param_name, item.getName());
					setItemStyle(mProviceLv, position, itemView, item, mSelectProvice,
							tv);

				}
			};
			mProviceLv.setAdapter(mProviceAdapter);
		}else{
			mProviceAdapter.notifyDataSetChanged();
		}*/
	}


	private void initCity(){
			Map<String, String> params = new HashMap<>();
			params.put("parentId",String.valueOf(mSelectProvice.getValue()));
			int siteId = PreferencesManager.getInstance().getSITE_ID();
			params.put("siteId", String.valueOf(siteId) );
			RequestMaster.getInstance().callPostRequestMall(APIKeys.SHELL.API_GET_AREA_LISR, params, new BaseSmartMallCallback(mContext){
				@Override
				public void onGetSuccess(JsonObject result) {

					AreaListResult areaListResult = JSONUtil.parseObject(result.toString(), AreaListResult.class);
					cityItemBeanList =areaListResult.getAreaList();

//					if(mCityAdapter == null) {
						mCityAdapter = new CommonAdapter<MallCityItemBean>(mContext, cityItemBeanList,
								R.layout.item_text_list, false) {
							@Override
							public void convert(ViewHolder holder, final MallCityItemBean item, int position) {
								holder.setItemClick(new OnClickListener() {
									@Override
									public void onClick(View v) {
										mSelectCity = item;
										mCityAdapter.notifyDataSetChanged();
										initArea();


									}
								});
								TextView tv = holder.getView(R.id.param_name);
								View itemView = holder.getView(R.id.item_view);
								holder.setText(R.id.param_name, item.getName());
								setItemStyle(mCityLv, position, itemView, item, mSelectCity,
										tv);

							}
						};
						mCityLv.setAdapter(mCityAdapter);
//					}else{
//						mCityAdapter.notifyDataSetChanged();
//					}
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

	private void initArea(){
			Map<String, String> params = new HashMap<>();
			params.put("parentId",String.valueOf(mSelectCity.getValue()));
			int siteId = PreferencesManager.getInstance().getSITE_ID();
			params.put("siteId", String.valueOf(siteId) );
			RequestMaster.getInstance().callPostRequestMall(APIKeys.SHELL.API_GET_AREA_LISR, params, new BaseSmartMallCallback(mContext){
				@Override
				public void onGetSuccess(JsonObject result) {

					AreaListResult areaListResult = JSONUtil.parseObject(result.toString(), AreaListResult.class);
					cityItemBeanList =areaListResult.getAreaList();

					isHaveNext = cityItemBeanList.size() != 0;

					if (isHaveNext) {
						GeneralUtil.setViewVisible(mAreaLv);
					} else {
						cancelDialog();
						selectCityId = String.valueOf(mSelectCity.getValue());
						textView.setText(mSelectCity.getName()+" "+mSelectProvice.getName());
					}

						mAreaAdapter = new CommonAdapter<MallCityItemBean>(mContext, cityItemBeanList,
								R.layout.item_text_list, false) {
							@Override
							public void convert(ViewHolder holder, final MallCityItemBean item, int position) {
								holder.setItemClick(new OnClickListener() {
									@Override
									public void onClick(View v) {
										mSelectArea = item;
										GeneralUtil.setViewInVisible(mAreaLv);
										mAreaAdapter.notifyDataSetChanged();
										cancelDialog();
										selectCityId = String.valueOf(mSelectArea.getValue());
										textView.setText(mSelectArea.getName()+" "+mSelectCity.getName()+" "+mSelectProvice.getName());

									}
								});
								TextView tv = holder.getView(R.id.param_name);
								View itemView = holder.getView(R.id.item_view);
								holder.setText(R.id.param_name, item.getName());
								setItemStyle(mAreaLv, position, itemView, item, mSelectArea,
										tv);
							}
						};
						mAreaLv.setAdapter(mAreaAdapter);
//					}else{
//						mCityAdapter.notifyDataSetChanged();
//					}


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

	public String getSelectCityId() {
		return selectCityId;
	}
}
