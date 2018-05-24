package com.common.utils.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

import com.common.utils.system.DensityUtil;


/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/8/22
 * Desc   : 一个参数选择Dialog
 */
public abstract class SelectOneParamDialog implements OnTouchListener,
        OnDismissListener, OnClickListener {
    protected TextView mProxyView;
    protected DialogFactory mDialog;
    protected Context mContext;
    protected OnDialogListener mListener;

    public SelectOneParamDialog(Context context, TextView proxyView) {
        this.mContext = context;
        this.mProxyView = proxyView;
        if (proxyView != null) {
            mProxyView.setOnTouchListener(this);
        }
    }

    private void initDialog() {
        mDialog = new DialogFactory(mContext, getLayoutId()) {
            @Override
            public void convert(DialogViewHolder view) {
                convertView(view);
            }
        };
        // 宽度为全屏，高度为屏幕的65%
        mDialog.setWidthAndHeight(getDialogWidth(), getDialogHeight())
                .fromBottom();
        mDialog.setDialogDismissListener(this);
    }



    public void showDialog() {
        if (mDialog == null) {
            initDialog();
        }
        mDialog.showDialog();
    }

    protected abstract int getDialogWidth();

    protected abstract int getDialogHeight();

    protected abstract void convertView(DialogViewHolder view);

    protected abstract int getLayoutId();

    // According to the motion event to judge single click
    private long mFingerDown, mFingerUp;
    private int mFingerDownY, mFingerUpY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            // finger down time - up time and distance y scope of [-10,10] to judge
            // whether the click
            case MotionEvent.ACTION_DOWN:
                mFingerDown = System.currentTimeMillis();
                mFingerDownY = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                mFingerUp = System.currentTimeMillis();
                mFingerUpY = (int) event.getY();
                long distanceTime = mFingerUp - mFingerDown;
                int distanceY = mFingerUpY - mFingerDownY;

                // The scope of [-10,10] -> single click
                boolean yJudge = distanceY <= DensityUtil.dip2px(mContext, 10)
                        && distanceY >= DensityUtil.dip2px(mContext, -10);
                if (yJudge || distanceTime <= 100) {
                    showDialog();
                }
                break;
        }
        return true;
    }

    public void cancelDialog() {
        mDialog.cancelDialog();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (mDialog!= null) {
            mDialog.cancelDialog();
        }
    }

    public void setOnDialogListener(OnDialogListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {

    }
}
