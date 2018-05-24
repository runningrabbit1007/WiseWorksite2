package com.sx.common_base.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sx.common_base.R;


/**
 * Created by yonggege on 2017/10/19.
 */

public class StarShowView extends LinearLayout{

    private int mImageWidth = 25;  //图片设置默认的宽度
    private int mImageHeight = 25; //图片设置默认的高度

    private int mMargin = 5;   //图片之间默认的margin
    private int mStarNum = 5;  //星星默认的个数

    private int mDefaultImageId = R.drawable.img_star_unselect;
    private int mClickImageId = R.drawable.img_star_select;
    public StarShowView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.removeAllViews(); //清空所有view
        for (int i = 0; i < mStarNum; i++) {
            setImageBack(mDefaultImageId);
        }
    }

    public void setShowNum(int starNum){
        this.removeAllViews(); //清空所有view
        for (int i = 0; i < starNum; i++) {
            setImageBack(mClickImageId);
        }
        if(starNum < mStarNum){
            for(int i=0;i<mStarNum-starNum;i++){
                setImageBack(mDefaultImageId);
            }
        }
    }

    private void setImageBack(int ImageId){
        ImageView imageView = new ImageView(getContext());
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mImageWidth, mImageHeight);
        layoutParams.leftMargin = mMargin;
        layoutParams.rightMargin = mMargin;
        imageView.setLayoutParams(layoutParams);
        this.addView(imageView);
        imageView.setImageResource(ImageId);
    }
}
