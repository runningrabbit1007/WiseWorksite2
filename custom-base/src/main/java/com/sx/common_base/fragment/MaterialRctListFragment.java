package com.sx.common_base.fragment;

import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.adapter.MaterialPurchaseAdapter;
import com.sx.common_base.adapter.MaterialRctAdapter;
import com.sx.common_base.base.BaseRequestUrlFragment;
import com.sx.common_base.view.mlistv.XListDataIsNullView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/11.
 */

public class MaterialRctListFragment extends BaseRequestUrlFragment {

    private int orderFlag = 0;

    @BindView(R2.id.contact_list_view)
    XListDataIsNullView mlistView;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_material_rct_list;
    }

    @Override
    public void initTitle() {

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

        mlistView.setAdapter(new MaterialRctAdapter(mContext,strings));


    }

    public void setId(int id) {
        this.orderFlag = id;
    }

}
