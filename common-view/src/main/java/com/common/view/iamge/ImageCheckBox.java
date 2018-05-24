package com.common.view.iamge;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.common.view.R;


/**
 * 自定义单选框
 */
public class ImageCheckBox extends ImageView implements OnClickListener{
    //选中的状态(默认是不选择)
    private boolean mStatus = false;
    //是否可以点击(默认可以)
    private boolean clickable = true;
    //选择状态的资源id
    private int mSelectedImageResId;
    //没有选择状态的资源id
    private int mUnSelectedImageResId;

    //------------接口回调-------------
    private StatusChangeListener mStatusChangeListener;

    public interface StatusChangeListener{
        void onChange(ImageCheckBox view, boolean checked);
    }

    public ImageCheckBox(Context context){
        this(context, null);
    }

    public ImageCheckBox(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public ImageCheckBox(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ImageCheckBox);
        mSelectedImageResId = array.getResourceId(R.styleable.ImageCheckBox_checkedBackground, 0);
        if(mSelectedImageResId == 0){
            throw new RuntimeException("check box selected background is null");
        }
        mUnSelectedImageResId = array.getResourceId(R.styleable.ImageCheckBox_unCheckedBackground, 0);
        if(mUnSelectedImageResId == 0){
            throw new RuntimeException("check box unselected background is null");
        }
        mStatus = array.getBoolean(R.styleable.ImageCheckBox_normalStatus, mStatus);
        flushView(mStatus);
        if(mStatus){
            this.setImageResource(mSelectedImageResId);
        }else{
            this.setImageResource(mUnSelectedImageResId);
        }
        clickable = array.getBoolean(R.styleable.ImageCheckBox_isCanClick, clickable);
        array.recycle();
        if(clickable){
            setOnClickListener(this);
        }
    }

    /**
     * 刷新页面状态
     */
    private void flushView(boolean status){
        if(mStatus){
            this.setImageResource(mSelectedImageResId);
        }else{
            this.setImageResource(mUnSelectedImageResId);
        }
        if(mStatusChangeListener != null){
            mStatusChangeListener.onChange(this, mStatus);
        }
    }

    /**
     * 设置是否选中
     */
    public void setChecked(boolean checked){
        this.mStatus = checked;
        flushView(mStatus);
    }

    /**
     * 设置是否选中
     */
    public void setChecked(int type) {
        if (type == 1) {
            this.mStatus = true;
            this.setImageResource(mSelectedImageResId);
        } else {
            this.mStatus = false;
            this.setImageResource(mUnSelectedImageResId);
        }
    }

    /**
     * 得到选择状态
     */
    public boolean getChecked(){
        return mStatus;
    }

    /**
     * 监听状态改变
     */
    public void setOnStatusChangeListener(StatusChangeListener statusChangeListener){
        this.mStatusChangeListener = statusChangeListener;
    }

    @Override
    public void onClick(View v){
        mStatus = !mStatus;
        flushView(mStatus);
    }

    public void setAttachClickView(View view){
        view.setOnClickListener(this);
    }
}
