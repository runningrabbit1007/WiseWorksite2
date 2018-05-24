package com.common.utils.string;

import android.text.TextUtils;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.common.utils.AnimationUtil;
import com.common.utils.GeneralUtil;
import com.common.utils.R;
import com.common.utils.ToastUtil;

/**
 * Created by jacklyy on 2017/7/12.
 */

public class EditCheckUtil {
    /**
     * 检测其是否是一个电话号码
     *
     * @return true 是电话号码,false 不是电话号码
     */
    public static boolean checkIsPhone(EditText editText) {
        // 先判断是否为空
        if (isEmpty(editText)) {
            AnimationUtil.startShakeAnimation(editText);
            ToastUtil.showToast(editText.getContext(),"请输入您的手机号码");
            return false;
        }
        boolean isPhone = GeneralUtil.judgePhoneQual(getTextByTrim(editText));
        if (!isPhone) {
            startAnimationOfshake(editText);
            ToastUtil.showToast(editText.getContext(),"请输入正确的手机号码");
        }
        return isPhone;
    }
    /**
     * The animation of the edit text by shake
     */
    public static void startAnimationOfshake(EditText mEditText) {
        Animation shake = AnimationUtils
                .loadAnimation(mEditText.getContext(), R.anim.shake_x);
        mEditText.startAnimation(shake);
        mEditText.requestFocus();
    }

    /**
     * @description edit text whether empty
     * @return
     */
    public static boolean isEmpty(EditText mEditText) {
        return TextUtils.isEmpty(getTextByTrim(mEditText));
    }

    /**
     * @description Get the content of the edit text (remove Spaces)
     * @return
     */
    public static String getTextByTrim(EditText mEditText) {
        return mEditText.getText().toString().trim();
    }
}
