package com.sx.wiseworksite.adapter;

import android.content.Context;
import android.view.View;

import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;
import com.sx.common_base.listScreen.adapter.CommonAdapter;
import com.sx.common_base.listScreen.adapter.ViewHolder;
import com.sx.wiseworksite.R;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */

public class ProjectListAdapter extends CommonAdapter {
    public ProjectListAdapter(Context context, List mDatas) {
        super(context, mDatas, R.layout.item_project_list);
    }

    @Override
    public void convert(ViewHolder holder, Object item, int position) {
        holder.setOnClickListener(R.id.project_list_item, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面去
                Router.sharedRouter().open(RouterActions.ACTION_PROJECT_MAIN);

            }
        });
    }
}
