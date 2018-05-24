package com.sx.common_base.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2018/1/10.
 */

public class DensityUtils {

    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return px / density;
    }
}
