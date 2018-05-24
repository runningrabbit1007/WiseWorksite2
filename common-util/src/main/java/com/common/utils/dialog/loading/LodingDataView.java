package com.common.utils.dialog.loading;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import com.common.utils.R;


public class LodingDataView extends LinearLayout {
	
	public LodingDataView(Context context) {
		this(context, null);
	}

	public LodingDataView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.dialog_loding,this);
		initView();
	}

	/**
	 * initialization
	 */
	private void initView() {

	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		return ((Activity) getContext()).dispatchKeyEvent(event);
	}
}