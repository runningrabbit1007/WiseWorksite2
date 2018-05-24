package com.sx.common_base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.common.base.App;
import com.example.jacklyy.router.Router;
import com.example.jacklyy.router.RouterActions;

/**
 * Created by yonggege on 2017/8/2.
 */

public class OpenNativePageUtil {

    public static void open(Context context,String flag, String param){
        if(flag.equals(RouterActions.ACTION_LOGIN)) {
            /**用户登录*/
            try {
                Activity activity = (Activity) context;
//                Router.sharedRouter().openForResult(RouterActions.ACTION_LOGIN,getBundle(param),activity, ConstantValue.C1001);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
