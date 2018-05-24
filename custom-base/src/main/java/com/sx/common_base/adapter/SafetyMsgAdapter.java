package com.sx.common_base.adapter;

import android.content.Context;

import com.sx.common_base.R;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 */

public class SafetyMsgAdapter extends CommonAdapter {
    public SafetyMsgAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_safety_msg);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {

    }
}
