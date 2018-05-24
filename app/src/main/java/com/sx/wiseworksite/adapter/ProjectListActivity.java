package com.sx.wiseworksite.adapter;

import android.graphics.Color;
import android.widget.ListView;

import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.common_base.view.mlistv.XListDataIsNullView;
import com.sx.wiseworksite.R;

import java.util.ArrayList;

import butterknife.BindView;

public class ProjectListActivity extends BaseRequestUrlActivity {


    @BindView(R.id.contact_list_view)
    XListDataIsNullView mlistView;

    private ProjectListAdapter mAdapter;



    @Override
    public int getContentViewId() {
        return R.layout.activity_project_list;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setTitleVB(new ViewBean(R.string.app_name))
                .createTitleModule();
        mTitleBar.setModel(module);
        mTitleBar.setTitle("项目");
        mTitleBar.setBackgroundResource(R.color.c1884FF);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.hiddenGrayLine();//隐藏灰线

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        getProjectList();

    }

    private void  getProjectList(){
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            strings.add("");
        }

        mlistView.setAdapter(new ProjectListAdapter(mContext,strings));
    }
}
