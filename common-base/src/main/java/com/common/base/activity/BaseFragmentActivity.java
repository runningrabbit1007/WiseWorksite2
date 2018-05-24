package com.common.base.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.common.base.App;
import com.common.base.R;
import com.common.base.config.PreferencesManager;
import com.common.base.http.netdector.NetStateChangeObserver;
import com.common.base.http.netdector.NetStateChangeReceiver;
import com.common.base.http.netdector.NetworkType;
import com.common.base.http.netdector.NetworkUtils;
import com.common.base.AppManagerUtil;
import com.common.base.widget.titlebar.CommonTitleBarSearch;
import com.common.utils.LogUtils;
import com.common.base.widget.titlebar.CommonTitleBar;
import com.common.utils.KeyBoardUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;


/**
 * 基础FragmentActivity
 */
public abstract class BaseFragmentActivity extends FragmentActivity implements BaseInterface, RequestInterface, NetStateChangeObserver {
	protected CommonTitleBar mTitleBar;
	public Context mContext;
	public String TAG = "";

	/**
	 * 全局头部栏2
	 */
	protected CommonTitleBarSearch mSearchTitleBar;

	/**
	 * TODO  Activity生命周期方法，固定模式完成Activity初始化，初始化的内容包括:加入Activity管理器，加载布局，注解，初始化顶部栏，初始化界面，初始化数据访问，初始化数据
	 * @param savedInstanceState 
	 * @see FragmentActivity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//捕获日志
		AppManagerUtil.instance().addActivity(this);

		TAG = this.getClass().getSimpleName();
		mContext = this;
		// 设置布局主布局
		int contentViewId = getContentViewId();
		if (contentViewId == 0) {
			throw new IllegalArgumentException("get content view id is zero!");
		}
		setContentView(contentViewId);

		ButterKnife.bind(this);

		try {
			mTitleBar = findTitleBar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			mSearchTitleBar = findTitleBarTowSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		initTitle();
		initView();
		initData();


	}





	
	/** 
	 * TODO 通过findViewById得到全局顶部栏实例
	 * @return GeneralTitleBar
	 */
	protected CommonTitleBar findTitleBar() {
		return (CommonTitleBar) this.findViewById(R.id.title_bar);
	}

	protected CommonTitleBarSearch findTitleBarTowSearch() {
		return (CommonTitleBarSearch) this.findViewById(R.id.search_title_bar);
	}
	/** 
	 * TODO 显示一个Toast
	 * @param msg 需要显示的内容
	 */
	protected final void showToast(String msg) {
		App.toast(msg);
	}

//
//	/** 
//	 * 通过键值对形式保存信息到本地
//	 * @param key 键值
//	 * @param obj object类型
//	 */
//	protected final void cacheObject(String key, Object obj) {
//		PreferencesUtil.getInstance(this).saveParam(key, obj);
//	}
//	
	/** 
	 * TODO 通过键值对形式保存信息到本地,此处所有类型都可以保存，其中obj不是基本数据类型的话则保存用Base64处理之后的字符串
	 * @param key 键值
	 * @param obj object类型
	 */
	protected final void saveParam(String key, Object obj) {
		PreferencesManager.getInstance().saveParam(key, obj);
	}

	/** 
	 * TODO 通过键值获取本地存储的信息，defaultObject是基本数据类型的值
	 * @param key 键值
	 * @param defaultObject 
	 * @return Object
	 */
	protected final Object getParam(String key,Object defaultObject) {
		return PreferencesManager.getInstance().getParam(key, defaultObject);
	}
	
	
	/** 
	 * TODO 通过键值获取非基本数据类型的本地数据
	 * @param key 键值
	 * @return Object
	 */
	protected final Object getObject(String key) {
		return PreferencesManager.getInstance().getObject(key);
	}


	/** 
	 * TODO 进入下一个activity并且带一个动画效果
	 * @param intent 跳转Activity的意图
	 */
	protected final void enterNextActivity(Intent intent) {
		startActivity(intent);
		enterBeginAnimation();
	}

	/** 
	 * TODO 进入下一个activity并且带一个动画效果
	 * @param clazz 目标Activity的Class实例
	 */
	protected final void enterNextActivity(Class<?> clazz) {
		Intent intent = new Intent(this, clazz);
		startActivity(intent);
		enterBeginAnimation();
	}

	/** 
	 * TODO 进入下一个activity并且带一个动画效果,有附带的数据
	 * @param clazz clazz 目标Activity的Class实例
	 * @param bundle Bundle数据实例
	 */
	protected final void enterNextActivity(Class<?> clazz, Bundle bundle) {
		Intent intent = new Intent(this, clazz);
		intent.putExtras(bundle);
		startActivity(intent);
		enterBeginAnimation();
	}

	/**
	 * TODO 进入下一个activity并且带一个动画效果
	 * @param intent 跳转Activity的意图
	 */
	protected final void enterNextActivityForResult(Intent intent,int pCode) {
		startActivityForResult(intent,pCode);
		enterBeginAnimation();
	}

	/**
	 * TODO 进入下一个activity并且带一个动画效果
	 * @param clazz 目标Activity的Class实例
	 */
	protected final void enterNextActivityForResult(Class<?> clazz,int pCode) {
		Intent intent = new Intent(this, clazz);
		startActivityForResult(intent,pCode);
		enterBeginAnimation();
	}

	/**
	 * TODO 进入下一个activity并且带一个动画效果,有附带的数据
	 * @param clazz clazz 目标Activity的Class实例
	 * @param bundle Bundle数据实例
	 */
	protected final void enterNextActivityForResult(Class<?> clazz, Bundle bundle,int pCode) {
		Intent intent = new Intent(this, clazz);
		intent.putExtras(bundle);
		startActivityForResult(intent,pCode);
		enterBeginAnimation();
	}

	/**
	 * TODO 跳转Acticity时自定义的动画
	 */
	protected final void enterBeginAnimation() {
		overridePendingTransition(R.anim.tran_in, R.anim.tran_out);
	}

	/**
	 * TODO 监听返回键，从Activity管理器中finish这个Activity实例
	 * @see android.app.Activity#onBackPressed() 
	 */
	@Override
	public void onBackPressed() {
		localFinish();
	}
	

	
	/** 
	 * TODO 监听Activity实例finishing时隐藏软键盘，否则可能报错
	 * @see android.app.Activity#finish() 
	 */
	@Override
	public void finish() {
		try {
			KeyBoardUtil.hideSoftInputFromWindow(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.finish();
	}
	

	/**  
	 * TODO 监听Activity被销毁时，调用系统回收，提高性能
	 * @see android.app.Activity#onDestroy() 
	 */
	@Override
	protected void onDestroy() {
		LogUtils.e(this.getClass().getSimpleName() + ":destroy");
		eventDestroy();
		System.gc();
		super.onDestroy();
	}
	
    /** 
     * TODO 通过泛型来简化findViewById
     * @param id 资源id
     * @return T 继承View的控件实例
     */
    @SuppressWarnings("unchecked")
	protected final <T extends View> T getViewById(int id) {
        try {
            return (T) findViewById(id);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }



	public void eventRegister(){
		// 在要接收消息的页面的OnCreate()中注册EventBus
		try {
			if (!EventBus.getDefault().isRegistered(this)){
				EventBus.getDefault().register(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventDestroy(){
		// 在OnDestroy()方法中解注册EventBus
		try {
			if (EventBus.getDefault().isRegistered(this)){
				EventBus.getDefault().unregister(this);
			}
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
	@Override
	public NetworkType getNetType() {
		return NetworkUtils.getNetworkType(App.INSTANCE);
	}


	@Override
	protected void onStop() {
		super.onStop();
		if (needRegisterNetworkChangeObserver()) {
			NetStateChangeReceiver.unregisterObserver(this);
		}
	}

	@Override
	protected void onResume() {
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
	}

	@Override
	public void onNetConnected(NetworkType networkType) {
	}


	protected void localFinish() {
		AppManagerUtil.instance().finishActivity(this);
	}
}
