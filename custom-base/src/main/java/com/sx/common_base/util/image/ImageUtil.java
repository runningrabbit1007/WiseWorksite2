package com.sx.common_base.util.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;

import com.common.utils.image.ImageUtilOption;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * ============================================================
 * 
 * copyright ZENG　HUI (c) 2014
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On November 24, 2014 9:14:37
 * 
 * description : Pictures of tools
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
@SuppressLint("NewApi")
public class ImageUtil {
	/**
	 *            data into base64 format data
	 * @param compress
	 *            Compression ratio
	 */
	@SuppressLint("NewApi")
	public static String getBase64Str(int compress, Bitmap bitmap) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 50, out);
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buffer = out.toByteArray();
		String photoData = new String(Base64.encodeToString(buffer,
				Base64.DEFAULT));
		return photoData;
	}

	/**
	 * Images into a 64 - bit of a string
	 */
	public static String bitToBase64(Bitmap bitmap) {
		ByteArrayOutputStream out = null;
		try {
			out = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
			out.flush();
			out.close();
			byte[] imgBytes = out.toByteArray();
			return Base64.encodeToString(imgBytes, Base64.DEFAULT);
		} catch (Exception e) {
			return null;
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * According to the path for the Bitmap
	 */
	public static Bitmap getBitmap(Context context, String fileImageUrl) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		return BitmapFactory.decodeFile(fileImageUrl, options);
	}

	/**
	 * Get bitmap by file is bitmap factory to decode
	 * 
	 * @param file
	 *            Image file
	 * @return
	 */
	public static Bitmap getBtimapByFile(File file) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
	}

	/**
	 * 
	 * @param bitmap
	 *            the original image
	 * @param newHeight
	 *            Compressed into a new level, but the quality and the aspect
	 *            ratio unchanged
	 * @return
	 */
	public static Bitmap getBitmapByHeight(Bitmap bitmap, int newHeight) {
		Bitmap newBitmap = null;
		float width = bitmap.getWidth();
		float height = bitmap.getHeight();

		float newWidth = (width * newHeight) / height;
		float scaleWidth = newHeight / height;
		float scaleHeight = newWidth / width;
		// create matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);
		// recreate the new Bitmap
		newBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) width,
				(int) height, matrix, true);
		if (newBitmap != bitmap) {
			bitmap.recycle();
			bitmap = null;
		}
		return newBitmap;
	}

	/**
	 * 
	 * @param bitmap
	 *            the original image
	 *            Compressed into a new level, but the quality and the aspect
	 *            ratio unchanged
	 * @return
	 */
	public static Bitmap getBitmapByWidth(Bitmap bitmap, int newWidth) {
		Bitmap newBitmap = null;
		float width = bitmap.getWidth();

		if (width < newWidth) {
			return bitmap;
		}

		float height = bitmap.getHeight();

		float newHeight = (height * newWidth) / width;
		float scaleWidth = newHeight / height;
		float scaleHeight = newWidth / width;
		// create matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);

		// recreate the new Bitmap
		newBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) width,
				(int) height, matrix, true);
		if (newBitmap != bitmap) {
			bitmap.recycle();
			bitmap = null;
		}
		return newBitmap;
	}

	/**
	 * base64转为bitmap
	 * 
	 * @param base64Data
	 * @return
	 */
	@SuppressLint("NewApi")
	public static Bitmap base64ToBitmap(String base64Data) {
		byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
		return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	}

	public static void saveBitmapToFile(Bitmap bitmap, File file) {
		if (file.exists()) {
			file.delete();
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			// 第二个参数 是压缩率，如果不压缩是100，表示压缩率为0
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {

			}

		}
	}

	/**
	 * 根据Uri获取图片绝对路径，解决Android4.4以上版本Uri转换
	 *
	 * @param imageUri
	 * @author yaoxing
	 * @date 2014-10-12
	 */
	@TargetApi(19)
	public static String getImageAbsolutePathByUri(Activity context,
			Uri imageUri) {
		if (context == null || imageUri == null)
			return null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT
				&& DocumentsContract.isDocumentUri(context, imageUri)) {
			if (isExternalStorageDocument(imageUri)) {
				String docId = DocumentsContract.getDocumentId(imageUri);
				String[] split = docId.split(":");
				String type = split[0];
				if ("primary".equalsIgnoreCase(type)) {
					return Environment.getExternalStorageDirectory() + "/"
							+ split[1];
				}
			} else if (isDownloadsDocument(imageUri)) {
				String id = DocumentsContract.getDocumentId(imageUri);
				Uri contentUri = ContentUris.withAppendedId(
						Uri.parse("content://downloads/public_downloads"),
						Long.valueOf(id));
				return getDataColumn(context, contentUri, null, null);
			} else if (isMediaDocument(imageUri)) {
				String docId = DocumentsContract.getDocumentId(imageUri);
				String[] split = docId.split(":");
				String type = split[0];
				Uri contentUri = null;
				if ("image".equals(type)) {
					contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
				} else if ("video".equals(type)) {
					contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
				} else if ("audio".equals(type)) {
					contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
				}
				String selection = MediaStore.Images.Media._ID + "=?";
				String[] selectionArgs = new String[] { split[1] };
				return getDataColumn(context, contentUri, selection,
						selectionArgs);
			}
		} // MediaStore (and general)
		else if ("content".equalsIgnoreCase(imageUri.getScheme())) {
			// Return the remote address
			if (isGooglePhotosUri(imageUri))
				return imageUri.getLastPathSegment();
			return getDataColumn(context, imageUri, null, null);
		}
		// File
		else if ("file".equalsIgnoreCase(imageUri.getScheme())) {
			return imageUri.getPath();
		}
		return null;
	}

	public static String getDataColumn(Context context, Uri uri,
			String selection, String[] selectionArgs) {
		Cursor cursor = null;
		String column = MediaStore.Images.Media.DATA;
		String[] projection = { column };
		try {
			cursor = context.getContentResolver().query(uri, projection,
					selection, selectionArgs, null);
			if (cursor != null && cursor.moveToFirst()) {
				int index = cursor.getColumnIndexOrThrow(column);
				return cursor.getString(index);
			}
		} finally {
			if (cursor != null)
				cursor.close();
		}
		return null;
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is ExternalStorageProvider.
	 */
	public static boolean isExternalStorageDocument(Uri uri) {
		return "com.android.externalstorage.documents".equals(uri
				.getAuthority());
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is DownloadsProvider.
	 */
	public static boolean isDownloadsDocument(Uri uri) {
		return "com.android.providers.downloads.documents".equals(uri
				.getAuthority());
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is MediaProvider.
	 */
	public static boolean isMediaDocument(Uri uri) {
		return "com.android.providers.media.documents".equals(uri
				.getAuthority());
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is Google Photos.
	 */
	public static boolean isGooglePhotosUri(Uri uri) {
		return "com.google.android.apps.photos.content".equals(uri
				.getAuthority());
	}


	private static ImageUtilOption mImageOption;
	private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageUtil configuration can not be initialized with null";

	public static void init(ImageUtilOption option) {
		if (option == null) {
			throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
		}
		mImageOption = null;
		mImageOption = option;
	}

	public static ImageUtilOption getImageOption() {
		if (mImageOption == null) {
			synchronized (ImageUtilOption.class) {
				if (mImageOption == null) {
					mImageOption = new ImageUtilOption();
				}
			}
		}
		return mImageOption;
	}

	/**
	 * Cut out pictures call system of cutting function
	 */
	public static void startPhotoZoom(Context context, Uri uri, int requestCode) {
		// Call the Android system comes with a picture clipping page
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// set crop is true
		intent.putExtra("crop", "true");
		// aspectX aspectY (Is wide high proportion)
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY (Is wide high cut images)
		// intent.putExtra("outputX", 180);
		// intent.putExtra("outputY", 180);
		intent.putExtra("return-data", true);
		((Activity) context).startActivityForResult(intent, requestCode);
	}

	/**
	 * Cut out pictures call system of cutting function
	 */
	public static void startRandomPhotoZoom(Context context, Uri uri,
			int requestCode) {
		// Call the Android system comes with a picture clipping page
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// set crop is true
		intent.putExtra("crop", "true");
		// outputX outputY (Is wide high cut images)
		// intent.putExtra("outputX", 180);
		// intent.putExtra("outputY", 180);
		intent.putExtra("return-data", true);
		((Activity) context).startActivityForResult(intent, requestCode);
	}

	/**
	 * Cut out pictures call system of cutting function
	 */
	public static void startPhotoZoom(Context context, Uri uri,
			int requestCode, int aspectX, int aspectY) {
		// Call the Android system comes with a picture clipping page
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// set crop is true
		intent.putExtra("crop", "true");
		// aspectX aspectY (Is wide high proportion)
		intent.putExtra("aspectX", aspectX);
		intent.putExtra("aspectY", aspectY);
		// outputX outputY (Is wide high cut images)
		// intent.putExtra("outputX", 180);
		// intent.putExtra("outputY", 180);
		intent.putExtra("return-data", true);
		((Activity) context).startActivityForResult(intent, requestCode);
	}

	/**
	 * Cut out pictures call system of cutting function
	 */
	public static void startPhotoZoomSafe(Context context, Uri uri,
			int requestCode, int aspectX, int aspectY, Uri tempUri) {
		// Call the Android system comes with a picture clipping page
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// set crop is true
		intent.putExtra("crop", "true");
		// aspectX aspectY (Is wide high proportion)
		intent.putExtra("aspectX", aspectX);
		intent.putExtra("aspectY", aspectY);
		// outputX outputY (Is wide high cut images)
//		intent.putExtra("scale", true);
//		 intent.putExtra("outputX", 800);
//		 intent.putExtra("outputY", 400);
		// TODO 修该参数设置
		intent.putExtra("return-data", false);
		intent.putExtra(MediaStore.EXTRA_OUTPUT,tempUri);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		((Activity) context).startActivityForResult(intent, requestCode);
	}
}
