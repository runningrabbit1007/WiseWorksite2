package com.sx.common_base.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;


import com.sx.common_base.R;
import com.sx.common_base.activity.project_maneger.SafetyInspectionDetailActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/14.
 */

public class SafetyInspectionAdapter extends CommonAdapter{
    public SafetyInspectionAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_safety_inspection);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {
        holder.setText(R.id.top_desc_tv,"创建时间：");
        holder.setText(R.id.top_time_tv,"2018-04-04 16:15:16");
        holder.setText(R.id.top_status_tv,"待整改");
        holder.setText(R.id.item_title,"塔吊使用不规范");
        holder.setText(R.id.item_content,"limia内容limia内容limia内容limia内容limia内容limia内容limia内容limia内容limia内容limia内容limia内容");
        holder.setText(R.id.item_status,"整改");
        holder.setText(R.id.rectification_person_desc,"整改人：");
        holder.setText(R.id.rectification_person,"张三");

        holder.setText(R.id.deadline,"2014-04-11");
        holder.setText(R.id.deadline_desc,"截止时间：");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SafetyInspectionDetailActivity.class);
                mContext.startActivity(intent);
            }
        });


    }
}
