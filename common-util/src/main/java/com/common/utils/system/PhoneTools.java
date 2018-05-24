package com.common.utils.system;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

public class PhoneTools {

	/**
	 * 获取手机号码
	 * @param context
	 * @return
	 */
	public static String getPhoneNum(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getLine1Number();
	}
	
	/**
	 * 获取设备ID
	 * @param context
	 * @return
	 */
	public static String getDeviceid(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}
	
	/**
	 * 获取IMEI
	 * @param context
	 * @return
	 */
	public static String getImei(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getSimSerialNumber();
	}

	/**
	 * 获取IMSI
	 * @param context
	 * @return
	 */
	public static String getImsi(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getSubscriberId();
	}

	/**
	 * 是否是小米系统
	 *
	 * @return
	 */
	public static boolean isMIUI() {
		String name = Build.MANUFACTURER;
		return name.equals("Xiaomi");
	}
}
