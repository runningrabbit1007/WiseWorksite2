package com.common.base;

import android.app.Activity;
import android.content.Context;

import com.common.utils.CheckUtil;
import com.common.utils.LogUtils;

import java.util.Stack;

/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/11/14
 * Desc   :  application tools The activity of the management class, used
 * for storage and shut off the activity, exit the program
 */
public class AppManagerUtil {

    private static Stack<Activity> activityStack;
    private static AppManagerUtil instance;

    private AppManagerUtil(){
    }

    /**
     * A single instance
     */
    public static AppManagerUtil instance(){
        if(instance == null){
            synchronized(AppManagerUtil.class){
                if(instance == null){
                    instance = new AppManagerUtil();
                }
            }
        }
        return instance;
    }

    /**
     * The Activity is added to the stack
     */
    public void addActivity(Activity activity){
        if(activityStack == null){
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * Gets the current Activity (stack last pressed into)
     */
    public Activity currentActivity(){
        if (CheckUtil.isEmpty(activityStack)) {
            return null;
        }
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * The last of the finish of the current Activity (stack into)
     */
    public void finishActivity(){
        if (CheckUtil.isEmpty(activityStack)) {
            return;
        }
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * The finish of the specified Activity
     */
    public void finishActivity(Activity activity){
        if (CheckUtil.isEmpty(activityStack)) {
            return;
        }
        if(activity != null){
            activityStack.remove(activity);
            activity.finish();
            activity.overridePendingTransition(R.anim.tran_pre_in,
                    R.anim.tran_pre_out);
            activity = null;
        }
    }

    /**
     * End of the specified class name of the Activity
     */
    public void finishActivity(Class<?> cls){
        if (CheckUtil.isEmpty(activityStack)) {
            return;
        }
        for(Activity activity : activityStack){
            if (activity == null) {
                return;
            }
            if(activity.getClass().equals(cls)){
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * Finish all the Activity
     */
    public void finishAllActivity(){
        LogUtils.d("finishAllActivity() called with: ");

        for(int i = 0, size = activityStack.size(); i < size; i++){
            if(null != activityStack.get(i)){
                LogUtils.d("activity" + activityStack.get(i).getClass().getSimpleName());

                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * Finish all except login
     */
    public void finishAllExceptLogin(Activity exceptActivity){
        for (int i = 0; i < activityStack.size(); i++) {
            if(null != activityStack.get(i)){
                if(activityStack.get(i) != exceptActivity){
                    finishActivity(activityStack.get(i));
                }
            }
        }
    }

    /**
     * Exit the application
     */
    public void AppExit(Context context){
        LogUtils.d("AppExit() called with: ");

        finishAllActivity();
//        MobclickAgent.onKillProcess(context);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }

    /**
     * 是否包含某个Activity
     */
    public boolean needOpenMainActivity(){
        if(activityStack != null){
            return activityStack.size() <= 1;
        }
        return false;
    }
}