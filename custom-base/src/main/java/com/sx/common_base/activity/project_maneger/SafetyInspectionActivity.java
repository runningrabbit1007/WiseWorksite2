package com.sx.common_base.activity.project_maneger;

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
import com.sx.common_base.adapter.SafetyInspectionAdapter;
import com.sx.common_base.adapter.UsingMaterialAdapter;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.common_base.view.mlistv.XListDataIsNullView;

import java.util.ArrayList;

import butterknife.BindView;


/**
 *
 * 安全巡检-main
 *
 */

public class SafetyInspectionActivity extends BaseRequestUrlActivity {

    @BindView(R2.id.contact_list_view)
    XListDataIsNullView mlistView;



    @Override
    public int getContentViewId() {
        return R.layout.activity_hinder_danger_manager;
    }

    @Override
    public void initTitle() {

        final TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setRightImgVB1(new ViewBean(R.drawable.common_back))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("安全巡检");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线
        mTitleBar.setRightImageClick1(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,SafetyInspectionDetailAddActivity.class);
                mContext.startActivity(intent);
            }
        });


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

        mlistView.setAdapter(new SafetyInspectionAdapter(mContext,strings));

    }
}
