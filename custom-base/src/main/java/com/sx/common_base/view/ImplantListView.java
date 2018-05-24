package com.sx.common_base.view;

import android.content.Context;
import android.widget.ListView;

public class ImplantListView extends ListView {
	public ImplantListView(Context context,
						   android.util.AttributeSet attrs) {
		super(context, attrs);
	}
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}

}
