package com.sx.common_base.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.sx.common_base.R;
import com.sx.common_base.activity.project_maneger.DwgChangeDetailActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */

public class DwgChangeAdapter extends CommonAdapter {
    public DwgChangeAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_dwg_change);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {

        holder.setText(R.id.top_desc_tv,"发文编号");
        holder.setText(R.id.top_no_tv,"N001");
        holder.setText(R.id.top_status_tv,"已审核");
        holder.setText(R.id.top_time_tv,"2018-03-28");


        holder.setText(R.id.item_dwg_title,"桩基图纸");
        holder.setText(R.id.item_dwg_count,"（2份）");
        holder.setText(R.id.item_dwg_unit,"发文单位：湖南建工");
        holder.setText(R.id.item_dwg_consignee,"收件人：……");
        holder.setText(R.id.item_dwg_sure_btn,"确认");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DwgChangeDetailActivity.class);
                mContext.startActivity(intent);
            }
        });



    }
}
