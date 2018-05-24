package com.sx.common_base.listScreen;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public abstract class MenuBaseAdapter {
	// 观察者模式
	private MenuObserver mObservable;

    public void registerDataSetObserver(MenuObserver observer) {
    	mObservable = observer;
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
    	mObservable = null;
    }

	/**
	 * 关闭菜单:子类可以覆盖该方法用于改变显示状态
	 * @param tabView
	 */
	public abstract void overrideCloseMenu(View tabView);

	/**
	 * 改变布局：
	 * @param cureentView 当前点击的View
	 * @param oldView 之前的View
	 */
	public abstract void overrideExchangeLayout(View cureentView, View oldView,int currentPostion,int oldPosition);

	/**
	 * 打开菜单：子类可以覆盖该方法用于改变显示状态
	 */
	public abstract void overrideOpenMenu(View tabView,int position);

	/**
	 * 得到多少条
	 */
	public abstract int getCount();

	/**
	 * 得到菜单的内容
	 */
	public abstract View getMenuView(int position,FrameLayout menuContainerView,ListPopuScreenMenuView parent);
	
	/**
	 * 得到Table的内容
	 */
	public abstract View getTabView(int position,LinearLayout tabContainerView,ListPopuScreenMenuView parent);
	
	/**
	 * 界面加载完毕
	 */
	public void viewInflateSuccess(){
		
	}
	
	/**
	 * 关闭筛选菜单菜单
	 */
	public void closeScreenMenu(View tabView){
		mObservable.closeScreenMenu(tabView);
	}

	public void exception(int clickPosition, int mCurrentPosition) {
		
	}
}
