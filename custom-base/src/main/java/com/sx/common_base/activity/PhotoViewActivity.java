package com.sx.common_base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sx.common_base.R;
import com.sx.common_base.ui.PhotoViewPager;

import java.util.ArrayList;

public class PhotoViewActivity extends Activity{
	private LinearLayout mRescoPhotoContainer;
	private TextView mInstructionsPhotoNumberTv;
	/****************************************/
	private ArrayList<String> mImageUrls;
	public static final String IMAGE_URL_LIST_KEY = "image_url_list_key";
	/****************************************/
	private int mCurrentPoint = 0;
	public static final String CURRENT_POINT_KEY = "CURRENT_POINT_KEY";
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        // 找到控件
        mRescoPhotoContainer = (LinearLayout) findViewById(R.id.resco_photo);
        mCurrentPoint = getIntent().getIntExtra(CURRENT_POINT_KEY, mCurrentPoint);
        mImageUrls = getIntent().getStringArrayListExtra(IMAGE_URL_LIST_KEY);
        mInstructionsPhotoNumberTv = (TextView) findViewById(R.id.instructions_photo_number);
		
        // 设置内容
        PhotoViewPager pager = new PhotoViewPager(this,mInstructionsPhotoNumberTv);
		pager.setUriList(mImageUrls);
		pager.setCurrentItem(mCurrentPoint);
		mRescoPhotoContainer.removeAllViews();
		mRescoPhotoContainer.addView(pager);
		
		
	}
}
