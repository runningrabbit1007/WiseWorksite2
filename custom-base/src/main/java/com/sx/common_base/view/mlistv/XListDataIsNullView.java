package com.sx.common_base.view.mlistv;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

import com.common.utils.GeneralUtil;
import com.sx.common_base.R;

import java.util.ArrayList;

public class XListDataIsNullView extends RelativeLayout implements
		OnClickListener, OnScrollListener {
	private Context mContext;
//	private FloatingActionButton mGotoTopIv;
	private XListView mXlv;
	private FloatingActionButton mAttachButton;
	private int lastVisibleItemPosition;
	private boolean isUp = false;
	private LinearLayout mDataIsNullView;
	private int mViewHeight = 0;

	public XListDataIsNullView(Context context) {
		this(context, null);
	}

	public XListDataIsNullView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public XListDataIsNullView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		initLayout();
	}

	/**
	 * 初始化布局
	 */
	private void initLayout() {
		View rootView = GeneralUtil.getView(mContext,
				R.layout.ui_xlistview_should_null, this);
		mXlv = (XListView) rootView.findViewById(R.id.id_xlv);
//		mGotoTopIv = (FloatingActionButton) rootView
//				.findViewById(R.id.goto_top);
//		mGotoTopIv.setScrollToMiddleShow();
//		mGotoTopIv.setOnClickListener(this);
//		mGotoTopIv.attachToListView(mXlv);
		mXlv.setOnScrollListener(this);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (mViewHeight == 0) {
			mViewHeight = MeasureSpec.getSize(heightMeasureSpec);
			AbsListView.LayoutParams params = new AbsListView.LayoutParams(
					LayoutParams.MATCH_PARENT, mViewHeight);
			if(mDataIsNullView != null)
			mDataIsNullView.setLayoutParams(params);
		}
	}

	public void setXListViewListener(XListView.IXListViewListener listener) {
		mXlv.setXListViewListener(listener);
	}

	public void onLoad(ArrayList<?> listData) {
		mXlv.onLoad(listData);
	}

	public void onLoad() {
		mXlv.onLoad();
	}

	public void hideFooter() {
		mXlv.setPullLoadEnable(false);
	}

	public void onLoad(ArrayList<?> listData, int page) {
		if (page == 1) {
			if (listData == null || listData.size() == 0) {
				dataIsNull();
			} else {
				dataIsNotNull();
			}
		}
		mXlv.onLoad(listData);
	}

	private void dataIsNotNull() {
//		mGotoTopIv.setVisibility(View.VISIBLE);
		mXlv.removeHeaderView(mDataIsNullView);
		mXlv.showFooter();
	}

	public void setAdapter(ListAdapter adapter) {
		mXlv.setAdapter(adapter);
		if (adapter.getCount() <= 0) {
			dataIsNull();
		}
	}

	// 这里还有一个优化问题
	public void dataIsNull() {
//		mGotoTopIv.setVisibility(View.GONE);
		addHeaderView();
		mXlv.hideFooter();
	}

	private void addHeaderView() {
		if(mDataIsNullView != null){
			mXlv.removeHeaderView(mDataIsNullView);
			mDataIsNullView.removeAllViews();
			mDataIsNullView = null;
		}
		// 没有数据的时候列表的显示
		mDataIsNullView = new LinearLayout(mContext);
		mDataIsNullView.setGravity(Gravity.CENTER);
		// 图片
		ImageView nullImage = new ImageView(mContext);
		nullImage.setImageResource(R.drawable.null_image);
		mDataIsNullView.addView(nullImage);
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(
				LayoutParams.MATCH_PARENT, mViewHeight);
		mDataIsNullView.setLayoutParams(params);
		mXlv.addHeaderView(mDataIsNullView);
	}

	/**
	 * 设置是否可以下拉刷新
	 */
	public void setOnRefreshIsAvailable(boolean available) {
		mXlv.setOnRefreshIsAvailable(available);
	}

	public int getFirstVisiblePosition() {
		return mXlv.getFirstVisiblePosition();
	}

	@Override
	public void onClick(View v) {
		mXlv.setSelection(0);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {

		if (mAttachButton != null) {
			if (firstVisibleItem > lastVisibleItemPosition) {
				// 向上滑动
				if (!isUp) {
					// 如果之前本来是向下滑动，那么isUp = true 调用show();
					mAttachButton.hide();
					isUp = true;
				}
			}
			if (firstVisibleItem < lastVisibleItemPosition) {
				// 向下滑动
				if (isUp) {
					// 如果之前本来是向上滑动，那么isUp = false 调用hide();
					isUp = false;
					mAttachButton.show();
				}
			}
			if (firstVisibleItem == lastVisibleItemPosition) {
				return;
			}
			lastVisibleItemPosition = firstVisibleItem;
		}
	}

	public void attachFloatingActionButton(FloatingActionButton button) {
		this.mAttachButton = button;
	}
	
	public XListView getXListView() {
		return mXlv;
	}
}
