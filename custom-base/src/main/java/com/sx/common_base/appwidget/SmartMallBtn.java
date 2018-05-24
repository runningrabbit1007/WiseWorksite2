package com.sx.common_base.appwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.common.utils.CheckUtil;
import com.common.utils.ViewUtil;
import com.sx.common_base.R;
import com.sx.common_base.modle.ResourceVersionResult;
//import com.ffu365.custom.R;
//import com.ffu365.custom.modle.ResourceVersionResult;

/**
 * Created by edz on 2016/12/8.
 * 此处给smartbtn设置数据model，针对该业务
 */

public class SmartMallBtn extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;
    //选中的状态(默认是不选择)
    private boolean mStatus = false;
    //选择状态的资源id
    private int mSelectedImageResId;
    //没有选择状态的资源id
    private int mUnSelectedImageResId;

    private String mSelectedImageUrl = "";

    private String mUnSelectedImageUrl = "";

    //文字颜色-选中
    private int mSelectColor;
    //文字颜色-未选中
    private int mUnSelectColor;

    //文字内容
    private String mContent;
    //红点
    private TextView redDot;


    public SmartMallBtn(Context context) {
        this(context, null);
    }

    public SmartMallBtn(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmartMallBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        if (attrs != null) {
            setCustomAttributes(attrs);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SmartMallBtn(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
        if (attrs != null) {
            setCustomAttributes(attrs);
        }
    }

    private void initView() {
        ViewUtil
                .getView(getContext(), R.layout.layout_smart_btn, this);
        mImageView = (ImageView) findViewById(R.id.img);
        mTextView = (TextView) findViewById(R.id.tv);
        redDot = (TextView) findViewById(R.id.red_dot);
//        BadgeFactory.createCircle(getContext()).setBadgeCount(1001).bind(mImageView);

    }

    public void setRedotStatus(boolean isDisplay){
        if(isDisplay){
            redDot.setVisibility(View.VISIBLE);
        }else{
            redDot.setVisibility(View.GONE);
        }
    }

    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs,
                R.styleable.SmartBtn);

        mSelectedImageResId = array.getResourceId(R.styleable.SmartBtn_checkedResource, 0);
        if (mSelectedImageResId == 0) {
            throw new RuntimeException("check box selected background is null");
        }
        mUnSelectedImageResId = array.getResourceId(R.styleable.SmartBtn_unCheckedResource, 0);
        if (mUnSelectedImageResId == 0) {
            throw new RuntimeException("check box unselected background is null");
        }
        mSelectColor = array.getColor(R.styleable.SmartBtn_selectColor, getResources().getColor(R.color.c282828));
        mUnSelectColor = array.getColor(R.styleable.SmartBtn_unSelectColor, getResources().getColor(R.color.c282828));
        mTextView.setTextColor(mUnSelectColor);

        mStatus = array.getBoolean(R.styleable.SmartBtn_smartNormalStatus, false);
        flushView(mStatus);

        int contentRes = array.getResourceId(R.styleable.SmartBtn_textContent, 0);
        boolean isDisplay = array.getBoolean(R.styleable.SmartBtn_redDot,false);
        if(isDisplay){
            redDot.setVisibility(View.VISIBLE);
        }else{
            redDot.setVisibility(View.GONE);
        }
        if (contentRes != 0) {
            mContent = getResources().getString(contentRes);
            mTextView.setText(mContent);
        } else {
            mContent = array.getString(R.styleable.SmartBtn_textContent);
            mTextView.setText(mContent == null ? "app" : mContent);
        }


        array.recycle();
    }


    /**
     * 刷新页面状态
     */
    public void flushView(boolean status) {
//        LogUtil.d("flushView() called with: mSelectedImageUrl == " + mSelectedImageUrl
//                + "\nmSelectedImageResId == " + mSelectedImageResId
//                + "\nmSelectColor == " + mSelectColor
//                + "\nmUnSelectColor == " + mUnSelectColor
//                + "\nmUnSelectedImageUrl == " + mUnSelectedImageUrl
//                + "\nmUnSelectedImageResId == " + mUnSelectedImageResId
//        );

        if (status) {
            if (!CheckUtil.isEmpty(mSelectedImageUrl)) {
                Glide.with(getContext()).load(mSelectedImageUrl)
                        .crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .override(DensityUtil.dip2px(getContext(), 20), DensityUtil.dip2px(getContext(), 20)).skipMemoryCache(false)
                        .into(mImageView);
//                ImageDisplayManager.getInstance().loadImage(mImageView, mSelectedImageUrl, mSelectedImageResId, mSelectedImageResId);
            } else {
                mImageView.setImageResource(mSelectedImageResId);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    mTextView.setTextColor(mSelectColor);
                } catch (Resources.NotFoundException pE) {
                    pE.printStackTrace();
                }
            } else {

                try {
                    mTextView.setTextColor(mSelectColor);
                } catch (Resources.NotFoundException pE) {
                    pE.printStackTrace();
                }

            }

        } else {
            if (!CheckUtil.isEmpty(mUnSelectedImageUrl)) {

                Glide.with(getContext()).load(mUnSelectedImageUrl)
                        .crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .override(DensityUtil.dip2px(getContext(), 20), DensityUtil.dip2px(getContext(), 20)).skipMemoryCache(false)
                        .into(mImageView);
//                ImageDisplayManager.getInstance().loadImage(mImageView, mUnSelectedImageUrl, mUnSelectedImageResId, mUnSelectedImageResId);
            } else {
                mImageView.setImageResource(mUnSelectedImageResId);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                try {
                    mTextView.setTextColor(mUnSelectColor);
                } catch (Resources.NotFoundException pE) {
                    pE.printStackTrace();
                }
            } else {

                try {
                    mTextView.setTextColor(mUnSelectColor);
                } catch (Resources.NotFoundException pE) {
                    pE.printStackTrace();
                }


            }

        }
        if (mSmartBtnStatusChangeListener != null) {
            mSmartBtnStatusChangeListener.onChange(mStatus);
        }
    }

    //------------接口回调-------------
    private SmartBtnStatusChangeListener mSmartBtnStatusChangeListener;


    public interface SmartBtnStatusChangeListener {
        void onChange(boolean checked);
    }

    /**
     * 监听状态改变
     */
    public void setOnStatusChangeListener(SmartBtnStatusChangeListener statusChangeListener) {
        this.mSmartBtnStatusChangeListener = statusChangeListener;
    }


    public SmartMallBtn setSelectColor(int pSelectColor) {
        mSelectColor = pSelectColor;
        return this;
    }

    public SmartMallBtn setUnSelectColor(int pUnSelectColor) {
        mUnSelectColor = pUnSelectColor;
        return this;
    }

    public SmartMallBtn setContent(String pContent) {
        mContent = pContent;
        mTextView.setText(mContent);
        return this;
    }

    public SmartMallBtn setSelectedImageUrl(String pSelectedImageUrl) {
        mSelectedImageUrl = pSelectedImageUrl;
        return this;
    }

    public SmartMallBtn setUnSelectedImageUrl(String pUnSelectedImageUrl) {
        mUnSelectedImageUrl = pUnSelectedImageUrl;
        return this;
    }

    public void setModleData(ResourceVersionResult pModleData){
        setContent(pModleData.getTitle());
        try {
            setSelectColor(Color.parseColor(pModleData.getAfterTitleColour()));
            setSelectColor(Color.parseColor(pModleData.getBeforeTitleColour()));
        } catch (Exception pE) {
            pE.printStackTrace();
        }
        setSelectedImageUrl(pModleData.getActiveUrl());
        setUnSelectedImageUrl(pModleData.getIconUrl());

        flushView(mStatus);
    }

}
