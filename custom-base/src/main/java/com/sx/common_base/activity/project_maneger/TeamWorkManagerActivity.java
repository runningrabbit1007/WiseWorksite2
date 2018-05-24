package com.sx.common_base.activity.project_maneger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.adapter.TeamWorkManagerAdapter;
import com.sx.common_base.base.BaseRequestUrlActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 *
 * 施工团队管理-main
 *
 */

public class TeamWorkManagerActivity extends BaseRequestUrlActivity {

    @BindView(R2.id.exListView)
    ExpandableListView exListView;


    @Override
    public int getContentViewId() {
        return R.layout.activity_team_work_manager;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("施工团队管理");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线


    }

    @Override
    public void initView() {
        List<String> groups = new ArrayList<>();
        groups.add("项目经理");
        groups.add("技术员");
        Map<String, List<String>> children = new HashMap<>();
        List<String> children_one = new ArrayList<>();
        children_one.add("阿伦");
        children_one.add("阿伦");
        children_one.add("阿伦");

        List<String> children_two= new ArrayList<>();
        children_two.add("阿伦");
        children_two.add("阿伦");
        children_two.add("阿伦");


        children.put("项目经理",children_one);
        children.put("技术员",children_two);
        exListView.setAdapter(new TeamWorkManagerAdapter(groups,children,mContext));

    }

    @Override
    public void initData() {

    }
}
