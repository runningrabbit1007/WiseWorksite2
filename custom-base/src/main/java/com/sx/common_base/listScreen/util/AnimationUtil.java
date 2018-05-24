package com.sx.common_base.listScreen.util;


import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.common.utils.GeneralUtil;
//import com.ffu365.custom.listScreen.enumeration.AnimationWay;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.sx.common_base.listScreen.enumeration.AnimationWay;


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
 * version : 1.0
 * 
 * date created : On July, 2015
 * 
 * description : 技术的工具类
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class AnimationUtil implements Animator.AnimatorListener {
	// 动画是否正在执行
	private boolean mAnimateIsExcute = false;
	// 插值器
	private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
	// 动画执行的默认时间
	private int mTranslateDurationMillis = 300;

	public void toggleMenu(View excuteView, AnimationWay animationWay,
						   boolean toggle, boolean isAnimate) {
		// 测量View
		GeneralUtil.measureView(excuteView);

		if (mAnimateIsExcute) {
			// 如果动画正在执行，那么不做处理
			return;
		}

		int translationDistance = 0;

		switch (animationWay) {
		case LONGITUDINAL:
			// 纵向
			translationDistance = excuteView.getHeight() == 0 ? excuteView
					.getMeasuredHeight() : excuteView.getHeight();
			translationDistance = toggle ? 0 : translationDistance;
			if (isAnimate) {
				ViewPropertyAnimator.animate(excuteView)
						.setInterpolator(mInterpolator)
						.setDuration(mTranslateDurationMillis)
						.translationY(-translationDistance).setListener(this);
			} else {
				ViewHelper.setTranslationY(excuteView, -translationDistance);
			}
			break;
		case TRANSVERSE:
			// 横向
			translationDistance = excuteView.getWidth() == 0 ? excuteView
					.getMeasuredWidth() : excuteView.getWidth();
			translationDistance = toggle ? 0 : translationDistance;

			if (isAnimate) {
				ViewPropertyAnimator.animate(excuteView)
						.setInterpolator(mInterpolator)
						.setDuration(mTranslateDurationMillis)
						.translationX(translationDistance).setListener(this);
			} else {
				ViewHelper.setTranslationX(excuteView, translationDistance);
			}
			break;
		default:
			break;

		}

	}
	
	public void toggleMenu(View excuteView, AnimationWay animationWay,
			boolean toggle, boolean isAnimate,int size) {
		switch (animationWay) {
		case LONGITUDINAL:
			if (isAnimate) {
				ViewPropertyAnimator.animate(excuteView)
						.setInterpolator(mInterpolator)
						.setDuration(mTranslateDurationMillis)
						.translationY(-size).setListener(this);
			} else {
				ViewHelper.setTranslationY(excuteView, -size);
			}
			break;
		case TRANSVERSE:
			if (isAnimate) {
				ViewPropertyAnimator.animate(excuteView)
						.setInterpolator(mInterpolator)
						.setDuration(mTranslateDurationMillis)
						.translationX(size).setListener(this);
			} else {
				ViewHelper.setTranslationX(excuteView, size);
			}
			break;
		default:
			break;
		}

	}

	public int getTranslateDurationMillis() {
		return mTranslateDurationMillis;
	}

	public void setTranslateDurationMillis(int translateDurationMillis) {
		this.mTranslateDurationMillis = translateDurationMillis;
	}

	@Override
	public void onAnimationStart(Animator animation) {
		mAnimateIsExcute = true;
	}

	@Override
	public void onAnimationEnd(Animator animation) {
		mAnimateIsExcute = false;
	}

	@Override
	public void onAnimationCancel(Animator animation) {
		mAnimateIsExcute = false;
	}

	@Override
	public void onAnimationRepeat(Animator animation) {
		mAnimateIsExcute = true;
	}

}
