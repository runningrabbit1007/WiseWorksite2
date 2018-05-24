package com.sx.common_base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.common.base.image.ImageDisplayManager;
import com.sx.common_base.R;

/**
 * 图片轮播适配器
 */
public class NetworkImageHolderView implements Holder<String> {
    private View rootview;
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        rootview = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_goods_head_img, null);
        imageView = (ImageView) rootview.findViewById(R.id.head_img);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return rootview;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        ImageDisplayManager.getInstance().loadKeepScaleImage(imageView,data,R.drawable.default_img);
    }
}
