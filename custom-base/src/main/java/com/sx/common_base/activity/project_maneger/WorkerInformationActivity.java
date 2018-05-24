package com.sx.common_base.activity.project_maneger;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;
import com.sx.common_base.view.mlistv.XListDataIsNullView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 * 工人信息--main
 *
 */

public class WorkerInformationActivity extends BaseRequestUrlActivity {

    @BindView(R2.id.contact_list_view)
    XListDataIsNullView mlistView;

    @Override
    public int getContentViewId() {
        return R.layout.activity_dwg_change;
    }

    @Override
    public void initTitle() {
        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("工人信息");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线


    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            strings.add("");
        }

        mlistView.setAdapter( new WorkerInformationAdapter(mContext,strings));

    }

    class WorkerInformationAdapter extends CommonAdapter{

        public WorkerInformationAdapter(Context context, List mDatas) {
            super(context, mDatas, R.layout.item_teamwork_manager_group);
        }

        @Override
        public void convert(ViewHolder holder, Object item, int position) {
            holder.setText(R.id.item_group_name,"工程部");
            holder.setText(R.id.item_group_count,"20");
            holder.setItemClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent  intent = new Intent(mContext,WorkerInformationDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
