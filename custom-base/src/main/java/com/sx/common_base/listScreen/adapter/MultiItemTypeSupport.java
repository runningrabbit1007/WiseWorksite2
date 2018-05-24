package com.sx.common_base.listScreen.adapter;
/**
 * 支持多布局接口
 */
public interface MultiItemTypeSupport<T> {
	int getLayoutId(int position, T item);
}
