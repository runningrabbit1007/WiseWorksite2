package com.common.utils.dialog.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.common.utils.R;
import com.common.utils.dialog.DialogFactory;
import com.common.utils.dialog.DialogViewHolder;


/**
 * 约定弹框Two
 */
public class DialogAppointTwo {
	// dialog
	private DialogFactory mDialog;
	// 内容
	private String mContent;
	
	public DialogAppointTwo(Context context, String content) {
		this.mContent = content;
		mDialog = new DialogFactory(context, R.layout.dialog_style_one){
			@Override
			public void convert(DialogViewHolder view) {
				view.setText(R.id.content, mContent);
				view.setViewGone(R.id.cancle);
				view.setViewGone(R.id.middle_line);
				view.setOnClick(R.id.sure, new OnClickListener() {

					@Override
					public void onClick(View v) {
						cancelDialog();
					}
				});
			}
		};
		
//		mDialog.setWidthAndHeight(
//				AppUtil.getScreenWidthHeight().x
//						- GeneralUtil.dip2px(mContext, 35) * 2,
//				LayoutParams.WRAP_CONTENT);
	}
	
	/**
	 * 显示dialog
	 */
	public void showDialog(){
		mDialog.showDialog();
	}
	
	/**
	 * 显示一个Dialog可以传递一个是否显示动画
	 */
	public void showDialog(boolean isAnimation){
		mDialog.showDialog(isAnimation);
	}
	
	/**
	 * 取显示
	 */
	public void cancelDialog(){
		mDialog.cancelDialog();
	}
}
