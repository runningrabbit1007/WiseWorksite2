package com.sx.common_base.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ListAdapter;

import com.sx.common_base.R;
import com.sx.common_base.activity.project_maneger.DwgChangeDetailActivity;
import com.sx.common_base.activity.project_maneger.HinderDangerDetailActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public class HinderDangerMangerAdapter extends CommonAdapter {

    public HinderDangerMangerAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_hinder_danger_manger);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {


        holder.setText(R.id.top_desc_tv,"隐患编号");
        holder.setText(R.id.top_no_tv,"N001");
        holder.setText(R.id.top_status_tv,"已排查");
        holder.setText(R.id.top_time_tv,"上报日期：2018-03-28");


        holder.setText(R.id.item_hinder_title,"隐患名称");
        holder.setText(R.id.item_hinder_content,"发文单位：湖南建工发文单位：湖南建工发文单位：湖南建工发文单位：湖南建工发文单位：湖南建工发文单位：湖南建工发文单位：湖南建工");
        holder.setText(R.id.item_hinder_close_btn,"关闭");
        holder.setText(R.id.item_hinder_check_btn,"排查");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HinderDangerDetailActivity.class);
                mContext.startActivity(intent);
            }
        });




    }
}
