package com.sx.common_base.activity;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.KeyEvent;

import com.common.base.AppManagerUtil;
import com.common.base.widget.titlebar.TitleModule;
import com.common.base.widget.titlebar.TitleModuleBuilder;
import com.common.base.widget.titlebar.ViewBean;
import com.common.utils.ToastUtil;
import com.common.view.viewpager.SwitchScrollableViewPager;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.appwidget.SmartBallBottomView;
import com.sx.common_base.base.BaseRequestUrlFragmentActivity;
import com.sx.common_base.fragment.IndexFragment;
import com.sx.common_base.fragment.ProjectManagerFragment;
import com.sx.common_base.fragment.SafetyProductionFragment;
import com.sx.common_base.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProjectMainActivity extends BaseRequestUrlFragmentActivity implements SmartBallBottomView.BottomItemOnClickListener{

    // 按一次退出按钮后等待2000毫秒如果再按即程序退出
    private long waitTime = 2000;
    private long touchTime = 0;
    private List<Fragment> fragments = new ArrayList();
    @BindView(R2.id.viewPager)
    SwitchScrollableViewPager mViewPager;
    @BindView(R2.id.view_smart_bar)
    SmartBallBottomView mViewSmartBar;


    @Override
    public int getContentViewId() {
        return R.layout.activity_project_main;
    }

    @Override
    public void initTitle() {



    }

    @Override
    public void initView() {

        mViewSmartBar.setOnBottomOnClickListener(this);
        mViewSmartBar.setViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(4);

    }

    @Override
    public void initData() {


        fragments.add(new IndexFragment());
        fragments.add( new ProjectManagerFragment());
        fragments.add(new SafetyProductionFragment());
        fragments.add(new SettingFragment());

        mViewPager.setScrollable(false);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

        int page = getIntent().getIntExtra("page",0);
        mViewPager.setCurrentItem(page);


    }

    @Override
    public void onBottomClick(int position) {
        mViewPager.setCurrentItem(position, false);
    }

    @Override
    public void onInterceptClick(int position) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                ToastUtil.showToast(mContext,"再按一次退出");
                touchTime = currentTime;
            } else {
                AppManagerUtil.instance().AppExit(mContext);
            }
            return false;
        }
        return false;
    }

}
