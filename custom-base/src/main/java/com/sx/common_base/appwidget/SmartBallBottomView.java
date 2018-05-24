
package com.sx.common_base.appwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;

import com.common.base.config.PreferencesManager;
import com.common.utils.CheckUtil;
import com.common.utils.LogUtils;
import com.common.utils.ViewUtil;
import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;
import com.sx.common_base.R;
import com.sx.common_base.R2;
import com.sx.common_base.listener.PageIndicator;
import com.sx.common_base.modle.ResourceVersionResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmartBallBottomView extends LinearLayout implements PageIndicator {
    private static final String TAG = "SmartBallBottomView";

    @BindView(R2.id.rb_main)
    SmartMallBtn mRbMain;

    @BindView(R2.id.rb_manager)
    SmartMallBtn mRbManager;

    @BindView(R2.id.rb_safety)
    SmartMallBtn mRbSafety;

    @BindView(R2.id.rb_setting)
    SmartMallBtn mRbSetting;


    @BindView(R2.id.main_radio)
    LinearLayout mMainRadio;




    private OnPageChangeListener mListener;

    // 设置几个底部点击的常量
    public static final int BOTTOM_POSITION_0 = 0;
    public static final int BOTTOM_POSITION_1 = 1;
    public static final int BOTTOM_POSITION_2 = 2;
    public static final int BOTTOM_POSITION_3 = 3;

    public boolean upgradeTitle = false;


    public SmartBallBottomView(Context context) {
        this(context, null);
    }

    public SmartBallBottomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmartBallBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        ViewUtil.getView(context, R.layout.bottom_view_project, this);
        ButterKnife.bind(this);

        initNumberBadgeView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SmartBallBottomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

//    public void setMessageRedotStatus(boolean isDisplay){
//        mRbMessage.setRedotStatus(isDisplay);
//    }
    private void initNumberBadgeView(Context context) {
//        mMessageTip = BadgeFactory.createCircle(context).setBadgeCount(1001).bind(mRbMessage).hide();
    }

    // 底部点击事件监听
    private BottomItemOnClickListener mBottomItemOnClickListener;

    public void setOnBottomOnClickListener(
            BottomItemOnClickListener bottomOnClickListener) {
        this.mBottomItemOnClickListener = bottomOnClickListener;
    }

    @OnClick({R2.id.rb_main, R2.id.rb_manager, R2.id.rb_safety, R2.id.rb_setting})
    public void onClick(View view) {

        int i = view.getId();
        if (i == R.id.rb_main) {
            setCurrentItem(BOTTOM_POSITION_0);
            if (mBottomItemOnClickListener != null) {
                mBottomItemOnClickListener.onBottomClick(BOTTOM_POSITION_0);
            }

        } else if (i == R.id.rb_manager) {
            setCurrentItem(BOTTOM_POSITION_1);
            if (mBottomItemOnClickListener != null) {
                mBottomItemOnClickListener.onBottomClick(BOTTOM_POSITION_1);
            }

        } else if (i == R.id.rb_safety) {
            if (mBottomItemOnClickListener != null) {
                /*if(!PreferencesManager.getInstance().isLogin()){
                    Router.sharedRouter().open(RouterActions.ACTION_LOGIN);
                }else {*/
                    setCurrentItem(BOTTOM_POSITION_2);
                    mBottomItemOnClickListener.onBottomClick(BOTTOM_POSITION_2);
//                }
            }

        }else if (i == R.id.rb_setting) {
            if (mBottomItemOnClickListener != null) {
               /* if(!PreferencesManager.getInstance().isLogin()){
                    Router.sharedRouter().open(RouterActions.ACTION_LOGIN);
                }else{*/
                    setCurrentItem(BOTTOM_POSITION_3);
                    mBottomItemOnClickListener.onBottomClick(BOTTOM_POSITION_3);
//                    setMessageRedotStatus(false);
//                }
            }
        }
    }


    public interface BottomItemOnClickListener {
        void onBottomClick(int position);

        void onInterceptClick(int position);
    }


    // 底部的单选按钮随着viewPager切换变化
    @Override
    public void onPageSelected(int position) {
        if (mListener != null) {
            mListener.onPageSelected(position);
        }

        setCurrentItem(position);


    }


    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        if (mListener != null) {
            mListener.onPageScrolled(arg0, arg1, arg2);
        }
    }

    @Override
    public void onPageScrollStateChanged(int position) {
        if (mListener != null) {
            mListener.onPageScrollStateChanged(position);
        }
    }

    @Override
    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(null);
        } else {
            throw new IllegalArgumentException("this the viewpager is null...");
        }
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void setViewPager(ViewPager view, int initialPosition) {
        setViewPager(view);
        setCurrentItem(initialPosition);
        LogUtils.d(TAG, "");
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        mListener = listener;
    }


    public void hide() {
        ViewPropertyAnimator animator = this.animate()
                .translationY(this.getHeight()).setDuration(200);
        animator.start();
    }

    public void show() {
        ViewPropertyAnimator animator = this.animate()
                .translationY(0).setDuration(200);
        animator.start();
    }

    @Override
    public void setCurrentItem(int position) {
        clearBottom();
        switch (position) {
            case 0:
                mRbMain.flushView(true);
                break;
            case 1:
                mRbManager.flushView(true);
                break;
            case 2:
                mRbSafety.flushView(true);
                break;
            case 3:
                mRbSetting.flushView(true);
                break;
        }
    }

    private void clearBottom() {
        mRbSetting.flushView(false);
        mRbSafety.flushView(false);
        mRbManager.flushView(false);
        mRbMain.flushView(false);
    }

    public List<ResourceVersionResult> resourceVersionResults;

    public void setResouce(List<ResourceVersionResult> pResourceVersionResults) {
        if (CheckUtil.isEmpty(pResourceVersionResults)) {
            return;
        }
        resourceVersionResults = pResourceVersionResults;
        upgradeTitle = true;
        ResourceVersionResult lResult = null;
        for (int i = 0; i < pResourceVersionResults.size(); i++) {
            lResult = pResourceVersionResults.get(i);
            switch (i) {
                case 0:
                    mRbMain.setModleData(lResult);
                    break;

                case 1:
                    mRbManager.setModleData(lResult);

                    break;
                case 2:
                    mRbSafety.setModleData(lResult);

                    break;
                case 3:
                    mRbSetting.setModleData(lResult);

                    break;


            }
        }


    }

    public String getText(int position) {
        if (resourceVersionResults != null) {
            return resourceVersionResults.get(position).getTitle();
        } else {
            return "";
        }
    }

}

