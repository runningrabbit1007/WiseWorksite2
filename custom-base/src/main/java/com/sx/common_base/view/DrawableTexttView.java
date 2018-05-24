package com.sx.common_base.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.base.image.ImageDisplayManager;
import com.sx.common_base.R;
import com.sx.common_base.listener.DrawableTextviewListener;

/**
 * Created by yonggege on 2017/10/28.
 */

public class DrawableTexttView extends LinearLayout {
    private Context context;
    private View view;
    private TextView textView;
    private ImageView imageView;
    private LinearLayout drawableLayout;
    private boolean isUp = false;
    private int colorId = Color.parseColor("#FF7200");
    private int defaultId = Color.parseColor("#333333");
    private DrawableTextviewListener listener;

    public DrawableTexttView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }


    private void initView(){
        view = LayoutInflater.from(context).inflate(R.layout.item_drawable_textview,null);
        textView = (TextView) view.findViewById(R.id.textView);
        imageView = (ImageView) view.findViewById(R.id.img);
        drawableLayout = (LinearLayout) view.findViewById(R.id.drawable_layout);
           ImageDisplayManager.getInstance().loadKeepScaleImage(imageView,R.drawable.img_default_sort);
        drawableLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextColor(colorId);
                if(isUp){
                    //设置向下
                    ImageDisplayManager.getInstance().loadKeepScaleImage(imageView,R.drawable.img_sort_down);
                    isUp = false;
                }else {
                    ImageDisplayManager.getInstance().loadKeepScaleImage(imageView,R.drawable.img_sort_up);
                    isUp = true;
                }
                listener.select(isUp);
            }
        });
        addView(view);
    }

    public void setInit(String text,DrawableTextviewListener listener){
        textView.setText(text);
        this.listener = listener;
    }

    private void setTextColor(int colorId){
        textView.setTextColor(colorId);
    }

    public void setDefault(){
        ImageDisplayManager.getInstance().loadCircleImage(imageView,R.drawable.img_default_sort);
        setTextColor(defaultId);
    }

}
