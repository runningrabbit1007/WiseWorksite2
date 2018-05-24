package com.sx.common_base.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.sx.common_base.R;
import com.sx.common_base.activity.project_maneger.HinderDangerDetailActivity;
import com.sx.common_base.activity.project_maneger.UsingMaterialDetailActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public class UsingMaterialAdapter extends CommonAdapter {

    public UsingMaterialAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_using_material);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {

        holder.setImageResource(R.id.image_iv,R.drawable.default_img);
        holder.setText(R.id.material_name_tv,"物料名称");
        holder.setText(R.id.material_create_time_tv,"2018/02/02");
        holder.setText(R.id.material_spec_tv,"规格：");
        holder.setText(R.id.material_count_tv,"数量：");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UsingMaterialDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

    }
}
