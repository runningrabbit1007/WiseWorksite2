package com.sx.common_base.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.activity.project_maneger.DwgChangeActivity;
import com.sx.common_base.activity.project_maneger.HinderDangerManagerActivity;
import com.sx.common_base.activity.project_maneger.MaterialPurchaseActivity;
import com.sx.common_base.activity.project_maneger.MaterialRctActivity;
import com.sx.common_base.activity.project_maneger.SafetyInspectionActivity;
import com.sx.common_base.activity.project_maneger.TeamWorkManagerActivity;
import com.sx.common_base.activity.project_maneger.UsingMaterialActivity;
import com.sx.common_base.activity.project_maneger.WorkerInformationActivity;
import com.sx.common_base.base.BaseRequestUrlFragment;
import com.sx.common_base.view.ButtonExtendM;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/10.
 */

public class ProjectManagerFragment extends BaseRequestUrlFragment{

    @BindView(R2.id.staff_safe_btn)
    ButtonExtendM staff_safe_btn;

    @BindView(R2.id.gotoDwgChange)
    ButtonExtendM gotoDwgChange;

    @BindView(R2.id.gotoHinderDangerManager)
    ButtonExtendM gotoHinderDangerManager;

    @BindView(R2.id.goToMaterialPurchase)
    ButtonExtendM goToMaterialPurchase;

    @BindView(R2.id.goToMaterialRct)
    ButtonExtendM goToMaterialRct;

    @BindView(R2.id.goToUsingMaterial)
    ButtonExtendM goToUsingMaterial;

    @BindView(R2.id.goToSafetyInspection)
    ButtonExtendM goToSafetyInspection;

    @BindView(R2.id.goToTeamWorkManager)
    ButtonExtendM goToTeamWorkManager;

    @BindView(R2.id.goToWorkerInformation)
    ButtonExtendM goToWorkerInformation;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_project_manager;
    }

    @Override
    public void initTitle() {
        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.dingwei))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("项目管理");
        mTitleBar.setLeftText("工地1号");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.setleftTextColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        gotoDwgChange.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DwgChangeActivity.class));
            }
        });

        gotoHinderDangerManager.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, HinderDangerManagerActivity.class));
            }
        });

        goToMaterialPurchase.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MaterialPurchaseActivity.class));
            }
        });

        goToMaterialRct.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MaterialRctActivity.class));
            }
        });

        goToUsingMaterial.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, UsingMaterialActivity.class));
            }
        });

        goToSafetyInspection.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, SafetyInspectionActivity.class));
            }
        });

        goToTeamWorkManager.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, TeamWorkManagerActivity.class));
            }
        });

        goToWorkerInformation.setOnClickListener(new ButtonExtendM.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, WorkerInformationActivity.class));
            }
        });
    }


}
