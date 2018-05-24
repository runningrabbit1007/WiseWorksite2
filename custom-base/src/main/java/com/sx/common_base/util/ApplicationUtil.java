package com.sx.common_base.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.util.DisplayMetrics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 
 * ============================================================
 * 
 * copyright ：ZENG HUI 2014
 * 
 * author : HUI
 * 
 * version ：1.0
 * 
 * date created ： On November 20, 2014 9:30:34
 * 
 * description ： application tools 1.get application package name
 * getApplicationName(Context context); 2.clean external cache
 * cleanExternalCache(Context context); 3.get version code
 * getVersionCode(Context context);
 * 
 * revision history ：
 * 
 * ============================================================
 * 
 */
public class ApplicationUtil {
	/**
	 * get application package name
	 * 
	 * @return
	 */
	public static String getApplicationName(Context context) {
		PackageManager packageManager = null;
		ApplicationInfo applicationInfo = null;
		try {
			packageManager = context.getApplicationContext()
					.getPackageManager();
			applicationInfo = packageManager.getApplicationInfo(
					context.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			applicationInfo = null;
		}
		String applicationName = (String) packageManager
				.getApplicationLabel(applicationInfo);
		return applicationName;
	}

	/**
	 * Get the width of the screen height with a point spread
	 */
	public static Point getScreenWidthHeight(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		Activity activity = (Activity) context;
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels; // Get the width
		int height = dm.heightPixels; // Get the high
		return new Point(width, height);
	}

	/**
	 * @param get
	 *            version name
	 * 
	 * @return
	 */
	public static String getVersionName(Context context) {
		try {
			PackageInfo pi = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			return pi.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The assets under the copy a file to the file
	 */
	public static void copyFile(String fileName, Context context,
			String AssetsName) throws Exception {
		File file = new File(fileName);
		if (!file.exists()) {
			AssetManager am = context.getAssets();
			InputStream is = am.open(AssetsName);
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			is.close();
			fos.close();
		}
	}
}
