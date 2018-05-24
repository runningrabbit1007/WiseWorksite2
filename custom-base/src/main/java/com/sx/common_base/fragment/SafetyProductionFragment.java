package com.sx.common_base.fragment;

import android.graphics.Color;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.adapter.DwgChangeAdapter;
import com.sx.common_base.adapter.SafetyMsgAdapter;
import com.sx.common_base.base.BaseRequestUrlFragment;
import com.sx.common_base.view.ImplantGridView;
import com.sx.common_base.view.ImplantListView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/10.
 */

public class SafetyProductionFragment extends BaseRequestUrlFragment {

    @BindView(R2.id.listview)
    ImplantListView listview;

    @BindView(R2.id.id_grid_xgv)
    ImplantGridView gridView;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_safety_production;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .setLeftImgVB1(new ViewBean(R.drawable.dingwei))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("安全生产");
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

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            strings.add("");
        }

        listview.setAdapter(new SafetyMsgAdapter(mContext,strings));

    }
}
