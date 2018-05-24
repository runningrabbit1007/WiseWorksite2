package com.sx.common_base.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.sx.common_base.R;
import com.sx.common_base.activity.project_maneger.HinderDangerDetailActivity;
import com.sx.common_base.activity.project_maneger.MaterialRctDetailActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */

public class MaterialRctAdapter extends CommonAdapter {
    public MaterialRctAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_material_rct);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {

        holder.setText(R.id.top_desc_tv,"收料编号");
        holder.setText(R.id.top_no_tv,"N001");
        holder.setText(R.id.top_status_tv,"已签收");
        holder.setText(R.id.top_time_tv,"发货日期：2018-03-28");


        holder.setText(R.id.item_mr_title,"材料名称");
        holder.setText(R.id.item_mr_receive_time,"收货日期：2018/03/28 15:08");
        holder.setText(R.id.item_mr_dsg,"车牌号：湘A-12345");
        holder.setText(R.id.item_mr_consignee,"签收人：……");
        holder.setText(R.id.item_mr_rct_btn,"签收");
        holder.setText(R.id.item_mr_count,"数    量：200吨");
        holder.setText(R.id.item_mr_supplier,"供应商：上海宝钢集团");
        holder.setText(R.id.item_mr_dsg,"车牌号：湘A-12345");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MaterialRctDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

    }
}
