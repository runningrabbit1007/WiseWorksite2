package com.sx.common_base.listScreen.adapter.annotation;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


import com.sx.common_base.util.NetManagerUtil;

import java.lang.reflect.Method;

/**
 * 
 * ============================================================
 * 
 * project name :
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On October, 2015
 * 
 * description : adapter事件注解绑定工具
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class AdapterUtil {
	/**
	 * @param context： 上下文
	 * @param object： 方法所在类
	 * @param rootView： Adapter 条目根View
	 * @param itemObject：条目对象
	 * @param viewpageItemObj：viewpage条目对象
	 */
	public static void inject(Context context, Object object, View rootView,
			Object itemObject, Object viewpageItemObj) {
		// 1.CommAdapter中的注解

		// 拿类
		Class<?> adapterClass = object.getClass();

		// 通过反射拿方法集合
		Method[] AdapterMethods = adapterClass.getDeclaredMethods();

		if (AdapterMethods != null && AdapterMethods.length > 0) {
			for (Method method : AdapterMethods) {

				AdapterOnItemClick adapterOnItemClick = method
						.getAnnotation(AdapterOnItemClick.class);
				if (adapterOnItemClick != null) {
					setViewOnclick(object, rootView, method, itemObject);
					continue;
				}

				AdapterOnClick adapterClick = method
						.getAnnotation(AdapterOnClick.class);
				if (adapterClick != null) {
					int[] ids = adapterClick.value();
					for (int i = 0; i < ids.length; i++) {
						View view = rootView.findViewById(ids[i]);
						if (view != null) {
							setViewOnclick(object, view, method,
									itemObject);
						}
					}
				}
			}
		}

		// 2.拿viewPagerItem中的注解
		if (viewpageItemObj != null) {
			// 拿类
			Class<?> viewpageItemObjClass = viewpageItemObj.getClass();
			// 通过反射拿方法集合
			Method[] viewpageItemObjMethods = viewpageItemObjClass
					.getDeclaredMethods();
			if (viewpageItemObjMethods != null
					&& viewpageItemObjMethods.length > 0) {
				for (Method method : viewpageItemObjMethods) {
					AdapterOnItemClick adapterOnItemClick = method
							.getAnnotation(AdapterOnItemClick.class);
					if (adapterOnItemClick != null) {
						setViewOnclick(viewpageItemObj, rootView, method,
								itemObject);
						continue;
					}

					AdapterOnClick adapterClick = method
							.getAnnotation(AdapterOnClick.class);
					if (adapterClick != null) {
						int[] ids = adapterClick.value();
						for (int i = 0; i < ids.length; i++) {
							View view = rootView.findViewById(ids[i]);
							if (view != null) {
								setViewOnclick(viewpageItemObj, view, method,
										itemObject);
							}
						}
					}
				}
			}
			return;
		}

		// 3.Activity中注解
		// 拿类
		Class<?> activityClass = context.getClass();
		// 通过反射拿方法集合
		Method[] activityMethods = activityClass.getDeclaredMethods();

		if (activityMethods != null && activityMethods.length > 0) {
			for (Method method : activityMethods) {
				AdapterOnItemClick adapterOnItemClick = method
						.getAnnotation(AdapterOnItemClick.class);
				if (adapterOnItemClick != null) {
					setViewOnclick(context, rootView, method, itemObject);
					continue;
				}

				AdapterOnClick adapterClick = method
						.getAnnotation(AdapterOnClick.class);
				if (adapterClick != null) {
					int[] ids = adapterClick.value();
					for (int i = 0; i < ids.length; i++) {
						View view = rootView.findViewById(ids[i]);
						if (view != null) {
							setViewOnclick(context, view, method,
									itemObject);
						}
					}
				}
			}
		}
	}

	private static void setViewOnclick(Object cotent, View view, Method method,
			Object itemObject) {
		// 是否需要检测网络    这个地方注释了
//		CheckNet checkNet = method.getAnnotation(CheckNet.class);
//		view.setOnClickListener(new DeclaredOnClickListener(cotent, view,
//				method, checkNet != null, itemObject));
	}

	/**
	 * An implementation of OnClickListener that attempts to lazily load a named
	 * click handling method from a parent or ancestor context.
	 */
	private static class DeclaredOnClickListener implements OnClickListener {
		private final View mHostView;
		private Method mMethod;
		private Object mHandler;
		// 是否检测网络
		private final boolean mIsCheckNet;
		private Object mItemObject;

		public DeclaredOnClickListener(Object handler, View hostView,
				Method method, boolean isCheckNet, Object itemObject) {
			this.mHandler = handler;
			this.mHostView = hostView;
			this.mMethod = method;
			this.mIsCheckNet = isCheckNet;
			this.mItemObject = itemObject;
		}

		@Override
		public void onClick(View v) {
			if (mIsCheckNet) {
				// 需要检测网络
				if (!NetManagerUtil.pingNetIsUsable(mHostView.getContext())) {
					// 网络不可用
					Toast.makeText(mHostView.getContext(), "亲,您的网络不太给力噢~",
							Toast.LENGTH_LONG).show();
					return;
				}
			}

			if (mMethod != null) {
				// 忽略访问权限，可以执行私有的也可以执行父类的
				mMethod.setAccessible(true);
			}

			try {
				mMethod.invoke(mHandler);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					mMethod.invoke(mHandler, v);
				} catch (Exception e2) {
					e2.printStackTrace();
					try {
						mMethod.invoke(mHandler, mItemObject);
					} catch (Exception e3) {
						e3.printStackTrace();
						try {
							mMethod.invoke(mHandler, v, mItemObject);
						} catch (Exception e4) {
							e4.printStackTrace();
							try {
								mMethod.invoke(mHandler, mItemObject, v);
							} catch (Exception e5) {
								throw new IllegalStateException(
										"Could not execute about " + mMethod.getName()
												+ " method", e);
							}
						}
					}
				}
			}
		}
	}
}
