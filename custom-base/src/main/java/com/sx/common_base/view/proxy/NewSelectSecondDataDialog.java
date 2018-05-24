/*
package com.sx.common_base.view.proxy;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.utils.GeneralUtil;
import com.common.utils.dialog.DialogViewHolder;
import com.common.utils.dialog.OnDialogListener;
import com.ffu365.custom.R;
import com.ffu365.custom.modle.bean.publish.SelectBean;
import com.ffu365.custom.modle.dick.ListScreenEntity;
import com.ffu365.custom.util.ApplicationUtil;
import com.ffu365.custom.util.DialogUtil;

import java.util.ArrayList;

*/
/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2017/7/27
 * Desc   : 二级菜单参数选择框
 *//*


public class NewSelectSecondDataDialog implements OnTouchListener, SecondaryMenuViewNew.OnScreenCompleteListener {
	private DialogUtil mDialog;
	private Context mContext;
	protected TextView mProxyView;
	private ArrayList<ListScreenEntity> mSourceData;
	private ArrayList<String> mSelectData;
	private SecondaryMenuViewNew mSecondaryMenuView;
	private OnDialogListener onDialogListener;


	public NewSelectSecondDataDialog(TextView proxyView, Context context,
                                     ArrayList<ListScreenEntity> pSourceData) {
		this.mContext = context;
		this.mProxyView = proxyView;
		if (mProxyView != null){
			this.mProxyView.setOnTouchListener(this);
		}
		this.mSourceData = pSourceData;
		initDialog();
	}

	public NewSelectSecondDataDialog(TextView proxyView, Context context,
                                     ArrayList<ListScreenEntity> pSourceData, ArrayList<String> pSelectData) {
		this.mContext = context;
		this.mProxyView = proxyView;
		if(mProxyView != null){

			this.mProxyView.setOnTouchListener(this);
		}
		this.mSourceData = pSourceData;
		this.mSelectData = pSelectData;
		initDialog();
	}

	private void initDialog() {
		mDialog = new DialogUtil(mContext, R.layout.dialog_select_two_levels_new) {
			@Override
			public void convert(DialogViewHolder view) {
				mSecondaryMenuView = view.getView(R.id.secondary_menuview);
				mSecondaryMenuView.setData(mSourceData,false);
				mSecondaryMenuView.setOnScreenCompleteListener(NewSelectSecondDataDialog.this);
				view.getView(R.id.dialog_select_top).setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						mDialog.cancelDialog();
					}
				});
			}
		};
		// 宽度为全屏，高度为屏幕的65%
		mDialog.setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT,
				ApplicationUtil.getScreenWidthHeight(mContext).y * 65 / 100)
				.fromBottom();
	}

	public void showDialog() {
		mSecondaryMenuView.recoveryRecord();
		mDialog.showDialog();
	}

	// According to the motion event to judge single click
	private long mFingerDown, mFingerUp;
	private int mFingerDownY, mFingerUpY;

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		// finger down time - up time and distance y scope of [-10,10] to judge
		// whether the click
		case MotionEvent.ACTION_DOWN:
			mFingerDown = System.currentTimeMillis();
			mFingerDownY = (int) event.getY();
			break;
		case MotionEvent.ACTION_UP:
			mFingerUp = System.currentTimeMillis();
			mFingerUpY = (int) event.getY();
			long distanceTime = mFingerUp - mFingerDown;
			int distanceY = mFingerUpY - mFingerDownY;

			// The scope of [-10,10] -> single click
			boolean yJudge = distanceY <= GeneralUtil.dip2px(mContext, 10)
					&& distanceY >= GeneralUtil.dip2px(mContext, -10);
			if (yJudge || distanceTime <= 100) {
				showDialog();
			}
			break;
		}
		return true;
	}

	@Override
	public void complete(View view, SelectBean bean,
			ListScreenEntity entity) {

		if (onDialogListener != null){
			if (mSelectData != null){
				if (!mSelectData.contains(entity.getId())){
					mSelectData.add(entity.getId());
				}
			}
			onDialogListener.sureClick(bean);

		}
		mDialog.cancelDialog();
	}


	public OnDialogListener getOnDialogListener() {
		return onDialogListener;
	}

	public void setOnDialogListener(OnDialogListener onDialogListener) {
		this.onDialogListener = onDialogListener;
	}
}
*/
