/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sx.common_base.util.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.common.utils.LogUtils;
import com.sx.common_base.listScreen.adapter.annotation.AdapterOnClick;
import com.sx.common_base.listScreen.adapter.annotation.AdapterOnItemClick;
import com.sx.common_base.util.NetManagerUtil;
import com.sx.common_base.util.view.annotation.DialogOnClick;
import com.sx.common_base.util.view.annotation.ExcuteMethod;
//import com.ffu365.custom.listScreen.adapter.annotation.AdapterOnClick;
//import com.ffu365.custom.listScreen.adapter.annotation.AdapterOnItemClick;
//import com.ffu365.custom.util.NetManagerUtil;
//import com.ffu365.custom.util.view.annotation.DialogOnClick;
//import com.ffu365.custom.util.view.annotation.ExcuteMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import butterknife.OnClick;

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
 * description : 注解工具
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
public class ViewUtils {

	private ViewUtils() {
	}

	public static void inject(View view) {
		injectObject(view, new ViewFinder(view));
	}

	public static void inject(Activity activity) {
		injectObject(activity, new ViewFinder(activity));
	}

	public static void inject(Object handler, View view) {
		injectObject(handler, new ViewFinder(view));
	}

	public static void inject(Object handler, Activity activity) {
		injectObject(handler, new ViewFinder(activity));
	}

	private static void injectObject(Object handler, ViewFinder finder) {

		Class<?> handlerType = handler.getClass();

		// inject view
		// 注入View , 遍历所有属性，注解在一定的程度上会影响性能
		Field[] fields = handlerType.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			for (Field field : fields) {
				ViewById viewInject = field.getAnnotation(ViewById.class);
				if (viewInject != null) {
					try {
						View view = finder.findViewById(viewInject.value());
						if (view != null) {
							field.setAccessible(true);
							field.set(handler, view);
						}
					} catch (Throwable e) {
						LogUtils.e(e.getMessage(), e);
					}
				}
			}
		}

		// inject event
		// 注入事件
		Method[] methods = handlerType.getDeclaredMethods();
		if (methods != null && methods.length > 0) {
			for (Method method : methods) {
				// 新加入一种方式,在任意方法上加OnClick点击注解
				OnClick onClick = method.getAnnotation(OnClick.class);
				if (onClick != null) {
					int[] ids = onClick.value();
					for (int i = 0; i < ids.length; i++) {
						View view = finder.findViewById(ids[i]);
						if (view != null) {
							// 是否需要检测网络
							CheckNet checkNet = method
									.getAnnotation(CheckNet.class);
							view.setOnClickListener(new DeclaredOnClickListener(
									handler, view, method, checkNet != null,
									null));
						}
					}
				}
			}
		}

	}

	/**
	 *            上下文
	 *            CommAdapter
	 * @param rootView
	 */
	public static void inject(Object container, View rootView, Object itemObject) {
		// 拿类
		Class<?> adapterClass = container.getClass();

		// 通过反射拿方法集合
		Method[] AdapterMethods = adapterClass.getDeclaredMethods();

		if (AdapterMethods != null && AdapterMethods.length > 0) {
			for (Method method : AdapterMethods) {
				DialogOnClick dialogOnClick = method
						.getAnnotation(DialogOnClick.class);
				if (dialogOnClick != null) {
					int[] ids = dialogOnClick.value();
					for (int i = 0; i < ids.length; i++) {
						View view = rootView.findViewById(ids[i]);
						if (view != null) {
							// 是否需要检测网络
							CheckNet checkNet = method
									.getAnnotation(CheckNet.class);
							view.setOnClickListener(new DeclaredOnClickListener(
									container, view, method, checkNet != null,
									itemObject));
						}
					}
				}
			}
		}
	}

	/**
	 * @param context
	 *            ： 上下文
	 * @param object
	 *            ： 方法所在类
	 * @param rootView
	 *            ： Adapter 条目根View
	 * @param itemObject
	 *            ：条目对象
	 * @param viewpageItemObj
	 *            ：viewpage条目对象
	 */
	public static void inject(Context context, Object object, View rootView,
			Object itemObject, Object viewpageItemObj) {

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
							setViewOnclick(object, view, method, itemObject);
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
							setViewOnclick(context, view, method, itemObject);
						}
					}
				}
			}
		}
	}

	private static void setViewOnclick(Object cotent, View view, Method method,
			Object itemObject) {
		// 是否需要检测网络
		CheckNet checkNet = method.getAnnotation(CheckNet.class);
		view.setOnClickListener(new DeclaredOnClickListener(cotent, view,
				method, checkNet != null, itemObject));
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

				try {
					mMethod.invoke(mHandler);
				} catch (Exception e) {
					try {
						mMethod.invoke(mHandler, v);
					} catch (Exception e2) {
						try {
							mMethod.invoke(mHandler, mItemObject);
						} catch (Exception e3) {
							try {
								mMethod.invoke(mHandler, v, mItemObject);
							} catch (Exception e4) {
								try {
									mMethod.invoke(mHandler, mItemObject, v);
								} catch (Exception e5) {
									throw new IllegalStateException(
											"Could not execute about "
													+ mMethod.getName()
													+ " method", e);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 执行某个类中特定的方法
	 */
	public static final void excuteSpecificMethod(Object container,
			Object paramObj) {
		Class<?> containerClass = container.getClass();

		Method[] methods = containerClass.getDeclaredMethods();

		for (Method method : methods) {
			ExcuteMethod excuteMethod = method
					.getAnnotation(ExcuteMethod.class);
			if (excuteMethod != null) {
				method.setAccessible(true);
				try {
					// 先执行没有参数的
					method.invoke(container);
				} catch (Exception e) {
					try {
						// 执行有参数的
						method.invoke(container, paramObj.getClass());
					} catch (Exception e1) {
						// 抛出异常
						throw new RuntimeException("no excute this "
								+ method.getName() + " at " + container+" param is "+paramObj);
					}
				}
				break;
			}
		}
	}
}
