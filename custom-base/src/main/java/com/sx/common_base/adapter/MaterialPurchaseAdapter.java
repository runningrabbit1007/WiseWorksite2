package com.sx.common_base.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.sx.common_base.R;
import com.sx.common_base.activity.project_maneger.HinderDangerDetailActivity;
import com.sx.common_base.activity.project_maneger.MaterialPurchaseDetailActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */

public class MaterialPurchaseAdapter extends CommonAdapter {
    public MaterialPurchaseAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_marterial_purchase);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {

        holder.setText(R.id.top_desc_tv,"采购编号：");
        holder.setText(R.id.top_no_tv,"N001");
        holder.setText(R.id.top_status_tv,"已完成");
        holder.setText(R.id.top_time_tv,"2018-03-28");


        holder.setText(R.id.item_mp_title,"材料名称");
        holder.setText(R.id.item_mp_arrival_time,"到货时间：2018/18/18 10：10:10");
        holder.setText(R.id.item_mp_supplier,"供应商：湖南建工");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MaterialPurchaseDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

    }
}
