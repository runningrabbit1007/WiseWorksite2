package com.sx.common_base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ImplantGridView extends GridView {
	
	
    public ImplantGridView(Context context) {  
        super(context);  
    }  
  
    public ImplantGridView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
  
    public ImplantGridView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
        // TODO 自动生成的构造函数存根  
    }  
  
	


	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}
	

}
