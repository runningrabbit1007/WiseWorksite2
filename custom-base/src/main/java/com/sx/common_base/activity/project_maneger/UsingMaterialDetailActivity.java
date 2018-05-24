package com.sx.common_base.activity.project_maneger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.base.BaseRequestUrlActivity;

import butterknife.BindView;

public class UsingMaterialDetailActivity extends BaseRequestUrlActivity {

    @BindView(R2.id.main_title_one_desc)
    TextView main_title_one_desc;

    @BindView(R2.id.main_title_two_desc)
    TextView main_title_two_desc;

    @BindView(R2.id.first_section_one_desc)
    TextView first_section_one_desc;

    @BindView(R2.id.first_section_two_desc)
    TextView first_section_two_desc;

    @BindView(R2.id.first_section_three_desc)
    TextView first_section_three_desc;

    @BindView(R2.id.first_section_four_desc)
    TextView first_section_four_desc;

    @BindView(R2.id.first_section_four_ll)
    LinearLayout first_section_four_ll;

    @BindView(R2.id.first_section_six_ll)
    LinearLayout first_section_six_ll;

    @BindView(R2.id.first_section_five_ll)
    LinearLayout first_section_five_ll;


    @BindView(R2.id.second_section_one_desc)
    TextView second_section_one_desc;


    @BindView(R2.id.second_section_two_desc)
    TextView second_section_two_desc;


    @BindView(R2.id.second_section_three_desc)
    TextView second_section_three_desc;


    @BindView(R2.id.second_section_four_desc)
    TextView second_section_four_desc;


    @BindView(R2.id.second_section_five_desc)
    TextView second_section_five_desc;

    @BindView(R2.id.grid_view_image_desc)
    TextView grid_view_image_desc;


    @Override
    public int getContentViewId() {
        return R.layout.activity_detail_model;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("使用详情");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

    }

    @Override
    public void initView() {

        main_title_one_desc.setText("基本信息");
        main_title_two_desc.setText("物料详情");

        first_section_one_desc.setText("接收人员：");
        first_section_two_desc.setText("经办人员：");
        first_section_three_desc.setText("提货时间：");

        first_section_four_ll.setVisibility(View.GONE);
        first_section_five_ll.setVisibility(View.GONE);
        first_section_six_ll.setVisibility(View.GONE);

        second_section_one_desc.setText("物料名称：");
        second_section_two_desc.setText("物料规格：");
        second_section_three_desc.setText("供 应 商：");
        second_section_four_desc.setText("提货数量：");
        second_section_five_desc.setText("备    注");

        grid_view_image_desc.setText("附件：");


    }

    @Override
    public void initData() {

    }
}
