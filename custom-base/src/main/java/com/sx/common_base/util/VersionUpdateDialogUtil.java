/*
package com.sx.common_base.util;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.common.utils.dialog.DialogViewHolder;
//import com.ffu365.custom.R;
//import com.ffu365.custom.result.CheckVersionResult;

public class VersionUpdateDialogUtil {
	public interface OnDownloadClickListener {
		void onClick();

		void onCancle();
	}

	private static OnDownloadClickListener listener;

	public static void ShowVersionDialog(boolean isToast,
			final Context context, final CheckVersionResult versionResult,
			OnDownloadClickListener onDownloadClickListener) {
		listener = onDownloadClickListener;
		// 没有版本更新不用管
		if (versionResult.getHas_update() == 0) {
			if (isToast) {
				Toast.makeText(context, "当前已是最新版本", Toast.LENGTH_SHORT).show();
			}
			return;
		}
		final String update_describe = versionResult.getInfo().getTitle();
		DialogUtil utilDialog = new DialogUtil(context,R.layout.dialog_upgrade) {
			@Override
			public void convert(DialogViewHolder view) {
				TextView tView = view.getView(R.id.content);
				tView.setMovementMethod(ScrollingMovementMethod.getInstance());
				view.setText(R.id.title, update_describe);
				view.setText(R.id.content, versionResult.getInfo().getContent());
//				versionResult.getInfo().setForce_update(1);
				if(versionResult.getInfo().getForce_update() == 1){
					//强制更新
					view.getView(R.id.cancle).setVisibility(View.GONE);
				}else{
					view.setOnClick(R.id.cancle, new OnClickListener() {
						@Override
						public void onClick(View v) {
							listener.onCancle();
							cancelDialog();

						}
					});
				}
				view.setOnClick(R.id.sure, new OnClickListener() {
					@Override
					public void onClick(View v) {

						listener.onClick();
						cancelDialog();
					}
				});

			}
		};
		utilDialog.showDialog();
		if(versionResult.getInfo().getForce_update() == 1){
			//强制更新
			utilDialog.setCanceledOnTouchOutside(false);
		}
	}

}
*/
