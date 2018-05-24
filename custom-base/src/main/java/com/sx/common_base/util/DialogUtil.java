package com.sx.common_base.util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.common.utils.dialog.DialogViewHolder;
import com.common.utils.system.AppUtil;
import com.sx.common_base.R;
import com.sx.common_base.constant.PermissionValue;
import com.sx.common_base.util.view.ViewUtils;
//import com.ffu365.custom.R;
//import com.ffu365.custom.util.view.ViewUtils;

import java.io.File;
import java.util.List;

/**
 * 
 * ============================================================
 * 
 * copyright ：好莱信息科技有限公司 (c) 2014
 * 
 * author : HUI
 * 
 * version ：1.0
 * 
 * date created ： On November 20, 2014 9:30:34
 * 
 * description ：dialog tools
 * 
 * revision history ：
 * 
 * ============================================================
 * 
 */
public abstract class DialogUtil {
	public static ProgressDialog mProgressDialog;
	private Dialog mDialog;
	private Window mDialogWindow;
	private DialogViewHolder dilaogVh;
	private View mRootView;

	LayoutParams params = new LayoutParams(
			LinearLayout.LayoutParams.WRAP_CONTENT,
			LinearLayout.LayoutParams.WRAP_CONTENT);

	public DialogUtil(Context context, int layoutId) {
		dilaogVh = DialogViewHolder.get(context, layoutId);
		mRootView = dilaogVh.getConvertView();
		mDialog = new Dialog(context, R.style.dialog);
		mDialog.setContentView(mRootView, new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		mDialogWindow = mDialog.getWindow();
		mDialog.setCanceledOnTouchOutside(true);
		convert(dilaogVh);
	}

	public void bindClick(Object container, Object item) {
		ViewUtils.inject(container, mRootView, item);

	}

	public void bindClick() {
		bindClick(null);
	}

	public void bindClick(Object item) {
		bindClick(this, item);
	}

	/**
	 * Show a progress prompt dialog
	 * 
	 * @param msg
	 *            : show message text content
	 */
	public static void showProgressDialog(final Context ct, final String msg) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Looper.prepare();

				if (mProgressDialog != null && mProgressDialog.isShowing()) {
					mProgressDialog.cancel();
				}
				mProgressDialog = null;
				mProgressDialog = new ProgressDialog(ct);
				mProgressDialog.setCanceledOnTouchOutside(false);
				mProgressDialog.setMessage(msg);
				mProgressDialog.show();
				Looper.loop();
			}
		}).start();
	}
	
	/**
	 * Show a progress prompt dialog
	 * 
	 * @param msg
	 *            : show message text content
	 */
	public static void showProgressFullCreenDialog(final Context ct, final String msg) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Looper.prepare();

				if (mProgressDialog != null && mProgressDialog.isShowing()) {
					mProgressDialog.cancel();
				}
				mProgressDialog = null;
				mProgressDialog = new ProgressDialog(ct,R.style.dialog_full_screen);
				mProgressDialog.setCanceledOnTouchOutside(false);
				mProgressDialog.setMessage(msg);
				mProgressDialog.show();
				Looper.loop();
			}
		}).start();
	}


	/**
	 * Dismiss a progress prompt dialog box
	 */
	public static void dismissProgressDialog() {
		if (mProgressDialog != null) {
			mProgressDialog.dismiss();
		}
	}

	/**
	 * 显示一个普通的dialog
	 */
	public DialogUtil showDialog() {
		if (mDialog != null && !mDialog.isShowing()) {
			mDialog.show();
		}
		return this;
	}

	/**
	 * 从底部一直弹到中间
	 */
	public DialogUtil fromBottomToMiddle() {
		mDialogWindow.setWindowAnimations(R.style.main_menu_animstyle);
		mDialogWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		return this;
	}

	/**
	 * 从底部弹出
	 */
	public DialogUtil fromBottom() {
		fromBottomToMiddle();
		mDialogWindow.setGravity(Gravity.CENTER | Gravity.BOTTOM);
		return this;
	}

	/**
	 * 从底部弹出
	 */
	public DialogUtil showDialog(int style) {
		mDialogWindow.setWindowAnimations(style);
		mDialog.show();
		return this;
	}

	/**
	 * 显示一个Dialog可以传递一个是否显示动画
	 */
	public DialogUtil showDialog(boolean isAnimation) {/**/
		mDialogWindow.setWindowAnimations(R.style.dialog_scale_animstyle);
		mDialog.show();
		return this;
	}

	/**
	 * 把弹出框view holder传出去
	 */
	public abstract void convert(DialogViewHolder view);

	// Choosing the way of picture or photo album dialog
	public static void showCameraOrPhotoDialog(final Context context,
			final File tempFile, final int imageResultCode,
			final int camreResultCode) {

		final DialogUtil dialogUtil = new DialogUtil(context,
				R.layout.single_param_choose_dialog) {
			@Override
			public void convert(DialogViewHolder view) {
				// 用户取消
				view.setOnClick(R.id.user_cancle, new OnClickListener() {
					@Override
					public void onClick(View v) {
						cancelDialog();
					}
				});

				// 用户选择照片
				view.setOnClick(R.id.image_depot, new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent("android.intent.action.PICK");
						intent.setDataAndType(
								MediaStore.Images.Media.INTERNAL_CONTENT_URI,
								"image/*");
						intent.putExtra(MediaStore.EXTRA_OUTPUT,
								Uri.fromFile(tempFile));
						((Activity) context).startActivityForResult(intent,
								imageResultCode);
						cancelDialog();
					}
				});

				// 用户选择拍照
				view.setOnClick(R.id.photo_camre, new OnClickListener() {
					@Override
					public void onClick(View v) {

						Intent getImageByCamera = new Intent(
								"android.media.action.IMAGE_CAPTURE");

						getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT,
								Uri.fromFile(tempFile));

						((Activity) context).startActivityForResult(
								getImageByCamera, camreResultCode);
						cancelDialog();
					}
				});
			}
		};
		dialogUtil.setWidthAndHeight(LayoutParams.MATCH_PARENT,
				ApplicationUtil.getScreenWidthHeight(context).y * 30 / 100);
		dialogUtil.fromBottom().fullWidth();
		dialogUtil.showDialog();
	}

	/**
	 * cancel dialog
	 */



	public void cancelDialog() {
		if (mDialog != null) {
			mDialog.cancel();
		}
	}

	public DialogUtil setDialogDismissListener(OnDismissListener listener) {
		mDialog.setOnDismissListener(listener);
		return this;
	}

	public DialogUtil setOnCancelListener(OnCancelListener listener) {
		mDialog.setOnCancelListener(listener);
		return this;
	}

	public DialogUtil setCancelable(boolean cancel) {
		mDialog.setCancelable(cancel);
		return this;
	}

	public DialogUtil setCanceledOnTouchOutside(boolean cancel) {
		mDialog.setCanceledOnTouchOutside(cancel);
		return this;
	}

	/**
	 * 全屏显示
	 */
	public DialogUtil fullScreen() {
		WindowManager.LayoutParams wl = mDialogWindow.getAttributes();
		wl.height = LayoutParams.WRAP_CONTENT;
		wl.width = LayoutParams.MATCH_PARENT;
		mDialog.onWindowAttributesChanged(wl);
		return this;
	}

	/**
	 * 全屏宽度
	 */
	public DialogUtil fullWidth() {
		WindowManager.LayoutParams wl = mDialogWindow.getAttributes();
		wl.width = LayoutParams.MATCH_PARENT;
		mDialog.onWindowAttributesChanged(wl);
		return this;
	}

	/**
	 * 设置高度和宽度
	 */
	public DialogUtil setWidthAndHeight(int width, int height) {
		WindowManager.LayoutParams wl = mDialogWindow.getAttributes();
		wl.width = width;
		wl.height = height;
		mDialog.onWindowAttributesChanged(wl);
		return this;
	}

	public DialogUtil setPercentWidthAndHeight(int pWidth, int pHeight) {
		WindowManager.LayoutParams wl = mDialogWindow.getAttributes();
		if (pWidth > 0) {
			wl.width = (AppUtil.getScreenWidthHeight().x * pWidth) / 100;
		} else {
			wl.width = LayoutParams.WRAP_CONTENT;
		}
		if (pHeight > 0) {
			wl.height = (AppUtil.getScreenWidthHeight().y * pHeight) / 100;
		} else {
			wl.height = LayoutParams.WRAP_CONTENT;
		}
		mDialog.onWindowAttributesChanged(wl);
		return this;
	}

	/**
	 * 全屏高度
	 */
	public DialogUtil fullHeight() {
		WindowManager.LayoutParams wl = mDialogWindow.getAttributes();
		wl.height = LayoutParams.MATCH_PARENT;
		mDialog.onWindowAttributesChanged(wl);
		return this;
	}
}
