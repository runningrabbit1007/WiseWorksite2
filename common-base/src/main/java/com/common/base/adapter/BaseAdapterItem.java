package com.common.base.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import kale.adapter.item.AdapterItem;


/**
 * @author Kale
 * @date 2016/1/25
 */
public abstract class BaseAdapterItem<T> implements AdapterItem<T> {
        protected Context mContext;
        protected View root;

    @Override
    public void bindViews(View root) {
        this.root = root;
        this.mContext = root.getContext();


        bindViews();

    }

    /**
     * 方法中可以使用{@link #getView(int)}来代替{@link View#findViewById(int)}
     */
    protected abstract void bindViews();

    public View getRoot() {
        return root;
    }

    public final <E extends View> E getView(int id) {
        try {
            return (E) root.findViewById(id);
        } catch (ClassCastException ex) {
            Log.e("BaseAdapterItem", "Could not cast View to concrete class.", ex);
            throw ex;
        }
    }
}
