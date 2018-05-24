package com.common.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class FileTools {
	
    /**
     * ��ʼ��Ϣ��ʾ����
     * */
    public static final int startDownloadMeg = 1;

    /**
     * ������Ϣ��ʾ����
     * */
    public static final int updateDownloadMeg = 2;

    /**
     * �����Ϣ��ʾ����
     * */
    public static final int endDownloadMeg = 3;
    /**
     * ��ȡ�ļ�ʧ����ʾ����
     * */
    public static final int errorDownloadMeg = 4;

	/**
	 * ����SDcard״̬
	 * 
	 * @return boolean
	 */
	public static boolean checkSDCard() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
	}

	public static String setMkdir(Context context) {
		String filePath;
		if (checkSDCard()) {
			filePath = Environment.getExternalStorageDirectory()
					+ File.separator + "ffu365/apk";
		} else {
			filePath = context.getCacheDir().getAbsolutePath() + File.separator
					+ "ffu365/apk";
		}
		File file = new File(filePath);
		if (!file.exists()) {
			boolean b = file.mkdirs();
		} else {
		}
		return filePath;
	}

	/**
	 * �õ��ļ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getFileName() {
		String name = "/upgrade.apk";

		return name;
	}

	public static String getFilePath(Context context) {
		String path = null;
		try {
			path = setMkdir(context) + getFileName();
		} catch (Exception e) {
		}
		return path;
	}

}
