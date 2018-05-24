package com.common.base.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.common.base.App;
import com.common.base.R;
import com.common.base.config.PreferencesManager;
import com.common.base.http.netdector.NetStateChangeObserver;
import com.common.base.http.netdector.NetStateChangeReceiver;
import com.common.base.http.netdector.NetworkType;
import com.common.base.http.netdector.NetworkUtils;
import com.common.base.widget.titlebar.CommonTitleBarSearch;
import com.common.utils.LogUtils;
import com.common.base.widget.titlebar.CommonTitleBar;
import com.common.utils.KeyBoardUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 基础Fragment
 */
public abstract class BaseFragment extends Fragment implements BaseInterface, NetStateChangeObserver {
    /**
     * Fragment运行时的Context
     */
    protected BaseFragmentActivity mContext;

    /**
     * 全局头部栏
     */
    protected CommonTitleBar mTitleBar;

    /**
     * 全局头部栏（搜索）
     */
    protected CommonTitleBarSearch mSearchTitleBar;
    /**
     * Fragment根View
     */
    protected View rootView;

    public String TAG = "";

    public  String local;


    protected boolean isVisible = false;//当前Fragment是否可见
    protected boolean isInitView = false;//是否与View建立起映射关系

    private Unbinder unbinder;

    public boolean isFirstLoad() {
        return isFirstLoad;
    }

    public BaseFragment setFirstLoad(boolean pFirstLoad) {
        isFirstLoad = pFirstLoad;
        return this;
    }

    protected boolean isFirstLoad = true;//是否是第一次加载数据

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = (BaseFragmentActivity) context;
    }

    /**
     * TODO 重写父类方法，完成绑定界面布局，注解界面
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     * @see Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogUtils.d(TAG,"onCreateView() called with: ");
        rootView = inflater.inflate(getContentViewId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        isInitView = true;
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent ev) {
                if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                    View v = mContext.getCurrentFocus();
                    if (KeyBoardUtil.isShouldHideKeyboard(v, ev)) {
                        KeyBoardUtil.hideKeyboard(v.getWindowToken(), mContext);
                    }
                }
                return false;
            }
        });
        return rootView;
    }


    public void setTitle(String title) {
        try {
            mTitleBar.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mSearchTitleBar.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * TODO 重写父类方法，完成初始化类的工作，调用 initView();requestServiceHook();initData();
     *
     * @param savedInstanceState
     * @see Fragment#onActivityCreated(Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TAG = this.getClass().getSimpleName();
//        LogUtil.d(TAG, "onActivityCreated() called with: ");
        // 统一头部
        try {
            mTitleBar = findTitleBar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mSearchTitleBar = findTitleBarSerch();
        } catch (Exception e) {
            e.printStackTrace();
        }

        initTitle();

        initView();

        lazyLoad();
    }

    /**
     * TODO 通过findViewById得到全局顶部栏实例
     *
     * @return GeneralTitleBar
     */
    protected CommonTitleBar findTitleBar() {
        return (CommonTitleBar) getContentView().findViewById(R.id.title_bar);
    }

    /**
     * TODO 通过findViewById得到全局顶部栏实例
     *
     * @return GeneralTitleBar
     */
    protected CommonTitleBarSearch findTitleBarSerch() {
        return (CommonTitleBarSearch) getContentView().findViewById(R.id.search_title_bar);
    }



    /**
     * TODO 获取Fragment当前布局实例
     *
     * @return View 返回View的实例
     */
    public View getContentView() {
        return rootView;
    }




    /**
     * 通过键值对形式保存信息到本地
     *
     * @param key    键值
     * @param object
     */
    protected void saveParam(String key, Object object) {
        PreferencesManager.getInstance().saveParam(key, object);
    }

    /**
     * 通过键值获取本地存储的信息
     *
     * @param key
     * @return Object
     */
    protected String getString(String key) {
        return (String) PreferencesManager.getInstance().getParam(key, "");
    }

    /**
     * 显示一个Toast
     *
     * @param msg 需要显示的内容
     */
    protected void showToast(String msg) {
        App.toast(msg);
    }

    /**
     * 进入下一个activity并且带一个动画效果
     *
     * @param intent 跳转Activity的意图
     */
    protected final void enterNextActivity(Intent intent) {
        mContext.startActivity(intent);
        enterBeginAnimation();
    }

    /**
     * 进入下一个activity并且带一个动画效果
     *
     * @param clazz 目标Activity的Class实例
     */
    protected final void enterNextActivity(Class<?> clazz) {
        Intent intent = new Intent(mContext, clazz);
        mContext.startActivity(intent);
        enterBeginAnimation();
    }

    /**
     * 进入下一个activity并且带一个动画效果,有附带的数据
     *
     * @param clazz  clazz 目标Activity的Class实例
     * @param bundle Bundle数据实例
     */
    protected final void enterNextActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
        enterBeginAnimation();
    }

    /**
     * 跳转Acticity时自定义的动画
     */
    protected void enterBeginAnimation() {
        mContext.overridePendingTransition(R.anim.tran_in,
                R.anim.tran_out);
    }






    @Override
    public void onDestroy() {
        eventDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {

        try {
            unbinder.unbind();
        } catch (Exception pE) {
        }

        super.onDestroyView();
    }

    /**
     * TODO 进入下一个activity带有requsetCode，并且带一个动画效果
     *
     * @param intent
     * @param requestCode void
     */
    protected final void enterNextActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
        enterBeginAnimation();
    }

    /**
     * 在这里实现Fragment数据的缓加载.
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //        LogUtil.e(TAG, "setUserVisibleHint() called with: ");
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        if (mContext == null) {
            return;
        }
        lazyLoad();
    }

    protected void lazyLoad() {
        //		if (isFirstLoad) {
        //			LogUtil.d("第一次加载 " + " isInitView  " + isInitView + "  isVisible  " + isVisible + "   " + this.getClass().getSimpleName());
        //		} else {
        //			LogUtil.d("不是第一次加载" + " isInitView  " + isInitView + "  isVisible  " + isVisible + "   " + this.getClass().getSimpleName());
        //		}
        if (!isFirstLoad || !isVisible || !isInitView) {
            //			LogUtil.d("不加载" + "   " + this.getClass().getSimpleName());
            return;
        }
        isFirstLoad = false;
        //		LogUtil.d("完成数据第一次加载");
        initData();
    }

    protected void onInvisible() {
    }


    @Override
    public void onStart() {
        super.onStart();
        //        LogUtil.e(TAG, "onStart() called with: ");
    }

    private void eventRegister(){
        // 在要接收消息的页面的OnCreate()中注册EventBus
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eventDestroy(){
        // 在OnDestroy()方法中解注册EventBus
        try {
            EventBus.getDefault().unregister(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO 判断是否有网络，没有网络弹一个toast，返回布尔值
     *
     * @return boolean
     */
    public final boolean isHaveNet() {
        return NetworkUtils.isConnected(App.INSTANCE);
    }


    /**
     * 获取网络类型
     * @return
     */
    public NetworkType getNetType() {
        return NetworkUtils.getNetworkType(App.INSTANCE);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (needRegisterNetworkChangeObserver()) {
            NetStateChangeReceiver.unregisterObserver(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (needRegisterNetworkChangeObserver()) {
            NetStateChangeReceiver.registerObserver(this);
        }
    }



    /**
     * 是否需要注册网络变化的Observer,如果不需要监听网络变化,则返回false;否则返回true.默认返回false
     */
    protected boolean needRegisterNetworkChangeObserver() {
        return true;
    }

    @Override
    public void onNetDisconnected() {
        showToast("网络无连接,请检查网络连接");
    }

    @Override
    public void onNetConnected(NetworkType networkType) {
    }

    /**
     * 用户是否登陆 (不用跳转)
     *
     * @return false 没有登陆，true 已登陆
     */
    protected final boolean isLogin() {
        return PreferencesManager.getInstance().isLogin();
    }
}
