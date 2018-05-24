package com.sx.common_base.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.sx.common_base.bean.EntriesBean;


/**
 * 作者：ZhouYou
 * 日期：2017/3/25.
 */
public class ObjectTagView extends BaseTagView<EntriesBean> {

    public ObjectTagView(Context context) {
        this(context, null);
    }

    public ObjectTagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ObjectTagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setItem(EntriesBean item) {
        super.setItem(item);
        textView.setText(item.getValue());
        textView.setTag(item);
    }
}
