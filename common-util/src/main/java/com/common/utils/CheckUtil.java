package com.common.utils;

import android.widget.EditText;

import java.util.Collection;
import java.util.Map;

/**
 * 空判断辅助类
 *
 * @author Jack
 * @date 2016/6/15
 */
public class CheckUtil {


    public static boolean isEmpty(CharSequence str) {
        return isNull(str) || str.length() == 0;
    }

    public static boolean isEmpty(Object[] os) {
        return isNull(os) || os.length == 0;
    }

    public static boolean isEmpty(Collection<?> l) {
        return isNull(l) || l.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> m) {
        return isNull(m) || m.isEmpty();
    }

    public static boolean isEmpty(EditText edt) {
        return isNull(edt) || edt.getText().toString().trim().equals("");
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

}
