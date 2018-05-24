package com.sx.common_base.listScreen;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.common.utils.GeneralUtil;
import com.sx.common_base.R;

import java.util.ArrayList;

/**
 * 
 * ============================================================
 * 
 * project name : TiantianFangFu
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * QQ ：240336124
 * 
 * version : 1.0
 * 
 * date created : On July, 2015
 * 
 * description :
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class ListPopuScreenMenuView extends LinearLayout implements
		OnClickListener, AnimationListener {
	private Context mContext;
	// 顶部菜单布局
	private LinearLayout mTabMenuView;
	// 内容都放在这里面
	private FrameLayout mMenuContainerView;
	// 遮罩半透明View，点击可关闭HuiDropDownMenu
	private View mMaskView;
	// 遮罩颜色
	private int mMaskColor = 0x88888888;
	// menu的高度
	protected int mMenuContainerHeight = 0;
	// 当期tab点击的位置
	protected int mCurrentPosition = -1;
	// 菜单是否打开
	protected boolean mMenuIsOpen = false;
	// 头部子View的集合
	protected ArrayList<View> mTabViews;
	// 动画是否正在执行
	private boolean mAnimationExcute = false;

	private MenuBaseAdapter mAdapter;
	private MenuObserver mObserver;
	// 是否需要添加分割线
	private boolean mIsAddLine = false;
	private float mTabMenuHeight = 40;
	// 异常信息捕捉
	private ExceptionLisenter mLisenter;

	public ListPopuScreenMenuView(Context context) {
		this(context, null);
	}

	public ListPopuScreenMenuView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ListPopuScreenMenuView(Context context, AttributeSet attrs,
                                  int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		initAttribute(attrs);
		initLayout();
	}

	/**
	 * 初始化自定义属性
	 */
	private void initAttribute(AttributeSet attrs) {
		TypedArray types = mContext.obtainStyledAttributes(attrs,
				R.styleable.ListPopuScreenMenuView);
		mIsAddLine = types.getBoolean(
				R.styleable.ListPopuScreenMenuView_isLine, mIsAddLine);
		mTabMenuHeight = types.getDimension(
				R.styleable.ListPopuScreenMenuView_menu_tab_height,
				GeneralUtil.dip2px(mContext, mTabMenuHeight));
		types.recycle();
	}

	private void initLayout() {
		// 垂直排列
		setOrientation(VERTICAL);

		// 初始化tabMenuView并添加到tabMenuView
		mTabMenuView = new LinearLayout(mContext);
		LayoutParams params = new LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, (int) mTabMenuHeight);
		mTabMenuView.setLayoutParams(params);
		mTabMenuView.setOrientation(HORIZONTAL);
		mTabMenuView.setBackgroundResource(R.drawable.menu_tab_bg);
		mTabMenuView.setBackgroundColor(getResources().getColor(R.color.white));
		mTabMenuView.setGravity(Gravity.CENTER_VERTICAL);
		addView(mTabMenuView);

		// 中间部分包括阴影和menu内容
		FrameLayout mMiddleView = new FrameLayout(mContext);
		mMiddleView.setLayoutParams(new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT));
		addView(mMiddleView);

		// 初始化遮罩半透明View
		mMaskView = new View(getContext());
		mMaskView.setBackgroundColor(mMaskColor);
		mMaskView.setOnClickListener(this);
		mMiddleView.addView(mMaskView);
		mMaskView.setVisibility(GONE);

		// 初始化containerView并将其添加到HuiDropDownMenu
		mMenuContainerView = new FrameLayout(mContext);
		mMiddleView.addView(mMenuContainerView);
		mMenuContainerView.setBackgroundColor(Color.WHITE);
		mMenuContainerView.setVisibility(GONE);

		mTabViews = new ArrayList<>();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mMenuContainerHeight = MeasureSpec.getSize(heightMeasureSpec) * 75 / 100;
		if (mMenuContainerHeight != 0 && mMenuContainerView.getHeight() <= 0) {
			// 高度占整个父View的75%
			mMenuContainerView.getLayoutParams().height = mMenuContainerHeight;
		}
	}

	/**
	 * 打开菜单
	 * 
	 * @param tabView
	 * @param position
	 */
	private void openMenu(View tabView, int position) {
		mMenuIsOpen = true;
		mMenuContainerView.setVisibility(View.VISIBLE);
		mMaskView.setVisibility(VISIBLE);
		Animation menuInAnimation = AnimationUtils.loadAnimation(getContext(),
				R.anim.dd_menu_in);
		menuInAnimation.setAnimationListener(this);
		Animation maskInAnimation = AnimationUtils.loadAnimation(getContext(),
				R.anim.dd_mask_in);

		mMenuContainerView.setAnimation(menuInAnimation);
		mMaskView.setAnimation(maskInAnimation);
		overrideOpenMenu(tabView, position);
	}

	/**
	 * 关闭菜单
	 */
	public void closeMenu(View tabView) {
		if(mAnimationExcute){
			return;
		}
		
		mMenuIsOpen = false;

		mMenuContainerView.setVisibility(View.GONE);
		mMaskView.setVisibility(GONE);

		Animation menuOutAnimation = AnimationUtils.loadAnimation(getContext(),
				R.anim.dd_menu_out);
		Animation maskOutAnimation = AnimationUtils.loadAnimation(getContext(),
				R.anim.dd_mask_out);
		menuOutAnimation.setAnimationListener(this);
		mMenuContainerView.setAnimation(menuOutAnimation);
		mMaskView.setAnimation(maskOutAnimation);

		overrideCloseMenu(tabView);

	}

	@Override
	public void onClick(View v) {
		if(mCurrentPosition == -1){
			return;
		}
		
		if (mMaskView == v) {
			closeMenu(mTabViews.get(mCurrentPosition));
		}
	}

	/**
	 * 头部点击
	 */
	private void tabClick(int position, View tabView) {
		if (mCurrentPosition == position) {
			closeMenu(tabView);
		} else {
			if (mCurrentPosition == -1) {
				mMenuContainerView.getChildAt(position).setVisibility(VISIBLE);
				openMenu(tabView, position);
			} else {
				exchangeLayout(position);
			}
			mCurrentPosition = position;
		}
	}

	/**
	 * 改变显示布局
	 */
	private void exchangeLayout(int position) {
		mMenuContainerView.getChildAt(position).setVisibility(VISIBLE);
		mMenuContainerView.getChildAt(mCurrentPosition).setVisibility(GONE);
		overrideExchangeLayout(mTabViews.get(position),
				mTabViews.get(mCurrentPosition), position, mCurrentPosition);
	}

	/**
	 * 关闭菜单:子类可以覆盖该方法用于改变显示状态
	 * 
	 * @param tabView
	 */
	protected void overrideCloseMenu(View tabView) {
		if (mAdapter != null)
			mAdapter.overrideCloseMenu(tabView);
	}

	/**
	 * 改变布局：
	 * 
	 * @param cureentView
	 *            当前点击的View
	 * @param oldView
	 *            之前的View
	 */
	protected void overrideExchangeLayout(View cureentView, View oldView,
			int currentPostion, int oldPosition) {
		if (mAdapter != null)
			mAdapter.overrideExchangeLayout(cureentView, oldView,
					currentPostion, oldPosition);
	}

	/**
	 * 打开菜单：子类可以覆盖该方法用于改变显示状态
	 */
	protected void overrideOpenMenu(View tabView, int position) {
		if (mAdapter != null)
			mAdapter.overrideOpenMenu(tabView, position);
	}

	/**
	 * 添加头部View
	 */
	public void addTabViews(ArrayList<View> tabViews) {
		for (View tabView : tabViews) {
			addTabView(tabView);
		}
	}

	/**
	 * 添加Tab头部
	 * 
	 * @param tabView
	 */
	public void addTabView(View tabView) {
		tabView.setTag(mTabViews.size());

		LayoutParams tabParams = new LayoutParams(0,
				LayoutParams.WRAP_CONTENT);
		tabParams.weight = 1;
		tabView.setLayoutParams(tabParams);

		mTabMenuView.addView(tabView);

		mTabViews.add(tabView);

		switchTabViewClick(tabView);
	}

	private void switchTabViewClick(final View tabView) {
		tabView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mAnimationExcute)
					return;

				int clickPosition = (int) tabView.getTag();

				try {
					tabClick(clickPosition, tabView);
				} catch (Exception e) {
					mAdapter.exception(clickPosition, mCurrentPosition);
					if (mLisenter != null) {
						mLisenter.exception(clickPosition, mCurrentPosition);
					}
				}
			}
		});
	}

	/**
	 * 添加菜单View
	 */
	public void addMenuView(View menuView) {
		LinearLayout menuContainer = new LinearLayout(mContext);
		menuContainer.setOrientation(LinearLayout.VERTICAL);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
		params.weight = 1;
		menuView.setLayoutParams(params);
		menuContainer.addView(menuView);

		// 在下面添加一张图片
		ImageView image = new ImageView(mContext);
		FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);
		image.setLayoutParams(imageParams);

		image.setBackgroundResource(R.drawable.menu_bottom_icon);
		menuContainer.addView(image);

		mMenuContainerView.addView(menuContainer);
		menuContainer.setVisibility(GONE);
	}

	public void addMenuViews(ArrayList<View> menuViews) {
		for (View menuView : menuViews) {
			addMenuView(menuView);
		}
	}

	/**
	 * 动画开始执行
	 */
	@Override
	public void onAnimationStart(Animation animation) {
		mAnimationExcute = true;
	}

	/**
	 * 动画结束
	 */
	@Override
	public void onAnimationEnd(Animation animation) {
		mAnimationExcute = false;
		if (!mMenuIsOpen) {
			View menuView = mMenuContainerView.getChildAt(mCurrentPosition);
			if (menuView != null)
				menuView.setVisibility(GONE);
			mCurrentPosition = -1;
		}
	}

	/**
	 * 动画重复
	 */
	@Override
	public void onAnimationRepeat(Animation animation) {
		mAnimationExcute = true;
	}

	/**
	 * 设置View适配器
	 */
	public void setAdapter(MenuBaseAdapter adapter) {
		if (adapter == null) {
			throw new NullPointerException("adapter is null...");
		}
		if (mAdapter != null) {
			this.mAdapter = null;
			this.mTabMenuView.removeAllViews();
			this.mMenuContainerView.removeAllViews();
		}

		mAdapter = adapter;

		if (mObserver == null) {
			mObserver = new MenuObserver() {
				@Override
				public void closeScreenMenu(View tabView) {
					closeMenu(tabView);
				}
			};
		}

		mAdapter.registerDataSetObserver(mObserver);

		// 添加Tab
		int count = mAdapter.getCount();
		for (int index = 0; index < count; index++) {
			View childTabView = mAdapter.getTabView(index, mTabMenuView, this);

			if (childTabView != null) {
				addTabView(childTabView);
				if (mIsAddLine && index != count - 1) {
					View lineView = new View(mContext);
					LayoutParams params = new LayoutParams(1,
							LayoutParams.MATCH_PARENT);
					params.topMargin = GeneralUtil.dip2px(mContext, 10);
					params.bottomMargin = GeneralUtil.dip2px(mContext, 10);
					lineView.setLayoutParams(params);
					lineView.setBackgroundColor(Color.parseColor("#EBEBEB"));
					mTabMenuView.addView(lineView);
				}
			}

			try {
				View childMenuView = mAdapter.getMenuView(index,
						mMenuContainerView, this);
				if (childMenuView != null) {
					addMenuView(childMenuView);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public interface ExceptionLisenter {
		void exception(int cureentPosition, int oldPosition);
	}
}
