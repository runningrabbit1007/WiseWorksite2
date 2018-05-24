package com.sx.common_base.view.mlistv;

import android.content.Context;

public class ImplantXListView extends XListView {

	/**
	 * TODO
	 * 
	 * @param context
	 */
	public ImplantXListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public ImplantXListView(Context context,
			android.util.AttributeSet attrs) {
		super(context, attrs);
	}

	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}
}
