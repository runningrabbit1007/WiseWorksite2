package com.sx.common_base.activity.project_maneger;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.base.activity.BaseFragment;
import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.base.BaseRequestUrlActivity;
import com.sx.common_base.base.BaseRequestUrlFragmentActivity;
import com.sx.common_base.fragment.MaterialRctListFragment;
import com.sx.common_base.view.MyTabLayout;
import com.sx.common_base.view.mlistv.XListDataIsNullView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 物料签收- main
 */


public class MaterialRctActivity extends BaseRequestUrlFragmentActivity {

    @BindView(R2.id.tabs)
    MyTabLayout tabLayout;
    @BindView(R2.id.vp_view)
    ViewPager viewPager;
    private List<BaseFragment> listFragment;
    private List titles;


    @Override
    public int getContentViewId() {
        return R.layout.activity_material_rct;
    }

    @Override
    public void initTitle() {

        TitleModule module = TitleModuleBuilder.builder
                .setLeftImgVB1(new ViewBean(R.drawable.common_back))
                .setRightImgVB1(new ViewBean(R.drawable.common_back))
                .createTitleModule();
        mSearchTitleBar.setModel(module);
        mSearchTitleBar.setSerchGone();
        mSearchTitleBar.setRigthImage1Visibility(View.VISIBLE);
        mSearchTitleBar.setBackgroundResource(R.color.text_main_color);
        mSearchTitleBar.setRightImageClick1(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,MaterialRctAddActivity.class);
                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public void initView() {

        listFragment = new ArrayList<>();
        titles = new ArrayList();
        titles.add(0,"全部");
        titles.add(1,"未签收");
        titles.add(2,"已签收");
        titles.add(3,"未通过");

    }

    @Override
    public void initData() {
            showView();
    }

    private void showView() {
        for (int i = 0; i < titles.size(); i++) {
            MaterialRctListFragment checkOrderFragment = new MaterialRctListFragment();
            checkOrderFragment.setId(i);
            listFragment.add(checkOrderFragment);
        }

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return listFragment.get(position);
            }

            @Override
            public int getCount() {
                return listFragment.size();
            }

            @Override

            public CharSequence getPageTitle(int position) {

                return titles.get(position).toString();
            }
        });

        viewPager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(viewPager, true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 方案二：页面选中时才去加载数据
                BaseFragment fragment = listFragment.get(position);
                fragment.initData();
//                showFragment(listFragment.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
