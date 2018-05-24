package com.sx.common_base.util.image;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * ============================================================
 * 
 * project name : TiantianFangFu
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * QQ ：240336124
 * 
 * version : 1.0
 * 
 * date created : On July, 2015
 * 
 * description :
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
@SuppressLint("NewApi")
public class BitmapUtil {

	private static String TAG = "BitmapUtil";

	/**
	 * 根据图片路径和图片大小获得一张位图，bitmap实际大小是size*size
	 * 
	 * @param filePath
	 *            图片路径
	 * @param size
	 *            width * height
	 * @return 缩略图
	 */
	public static Bitmap createImageThumbnail(String filePath, int size) {
		Bitmap bitmap = null;
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, opts);

		opts.inSampleSize = computeSampleSize(opts, -1, size);
		opts.inJustDecodeBounds = false;

		try {
			bitmap = BitmapFactory.decodeFile(filePath, opts);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bitmap;
	}

	/**
	 * Byte[]转Bitmap
	 */
	public static Bitmap bytes2Bitmap(byte[] data) {
		return BitmapFactory.decodeByteArray(data, 0, data.length);
	}

	/**
	 * Bitmap转Byte[]
	 */
	public static byte[] bitmap2Bytes(Bitmap bitmap) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		return baos.toByteArray();
	}

	/**
	 * Bitmap转Drawable
	 */
	@SuppressWarnings("deprecation")
	public static Drawable bitmap2Drawable(Bitmap bitmap) {
		return new BitmapDrawable(bitmap);
	}

	/**
	 * 得到bitmap的大小
	 */
	@SuppressLint("NewApi")
	public static int getBitmapSize(Bitmap bitmap) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // API 19
			return bitmap.getAllocationByteCount();
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {// API
																			// 12
			return bitmap.getByteCount();
		}
		// 在低版本中用一行的字节x高度
		return bitmap.getRowBytes() * bitmap.getHeight(); // earlier version
	}

	/**
	 * Drawable转Bitmap
	 */
	public static Bitmap drawable2Bitmap(Drawable drawable) {
		BitmapDrawable bd = (BitmapDrawable) drawable;
		return bd.getBitmap();
	}

	/**
	 * TODO 将两个bitmap对象整合并保存为一张图片
	 * 
	 * @param background
	 * @param foreground
	 * @return Bitmap
	 */
	public Bitmap combineBitmap(Bitmap background, Bitmap foreground) {
		// 第一张图片的宽高
		int bgWidth = background.getWidth();
		int bgHeight = background.getHeight();
		// 第二章图片的宽高
		int fgWidth = foreground.getWidth();
		int fgHeight = foreground.getHeight();
		// 创建一个新的bitmao 高度等于两张高度的总和 用来竖列拼接
		Bitmap newmap = Bitmap.createBitmap(bgWidth, bgHeight + fgHeight,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(newmap);
		// 画上第一张图片
		canvas.drawBitmap(background, 0, 0, null);
		// 从第一张图片的下边开始画入第二张图片
		canvas.drawBitmap(foreground, 0, bgHeight, null);
		return newmap;
	}

	/**
	 * TODO Bitmap旋转一定角度
	 * 
	 * @param b
	 * @param degrees
	 * @return Bitmap
	 */
	public static Bitmap rotate(Bitmap b, int degrees) {
		if (degrees != 0 && b != null) {
			Matrix m = new Matrix();
			m.setRotate(degrees, (float) b.getWidth() / 2,
					(float) b.getHeight() / 2);
			try {
				Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(),
						b.getHeight(), m, true);
				return b2;// 正常情况下返回旋转角度的图
			} catch (OutOfMemoryError ex) {
				return b;// 内存溢出返回原图
			} finally {
				b.recycle();// 释放资源
			}
		}
		return b;
	}

	/**
	 * TODO 将图片存储到sdcard中
	 * 
	 * @param targetBitmap
	 * @param ImageName
	 *            no need ".jpg"
	 * @param path
	 * @param quality
	 *            void
	 */
	public static void storeImageToSDCARD(Bitmap targetBitmap,
			String ImageName, String path, int quality) {

		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		File imagefile = new File(file, ImageName + ".jpg");

		if (quality < 0 || quality > 100) {
			quality = 80;
		}

		try {
			imagefile.createNewFile();
			FileOutputStream fos = new FileOutputStream(imagefile);
			targetBitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取缩放的size
	 * 
	 * @param options
	 * @param minSideLength
	 * @param maxNumOfPixels
	 * @return
	 */
	public static int computeSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		int initialSize = computeInitialSampleSize(options, minSideLength,
				maxNumOfPixels);
		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}
		return roundedSize;
	}

	private static int computeInitialSampleSize(BitmapFactory.Options options,
			int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;
		maxNumOfPixels = maxNumOfPixels * maxNumOfPixels;
		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
				Math.floor(w / minSideLength), Math.floor(h / minSideLength));
		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}
		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			return 1;
		} else if (minSideLength == -1) {
			return lowerBound;
		} else {
			return upperBound;
		}
	}

	/**
	 * 从View获取Bitmap
	 * 
	 * @param view
	 *            View
	 * @return Bitmap
	 */
	public static Bitmap getBitmapFromView(View view) {
		Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		view.layout(view.getLeft(), view.getTop(), view.getRight(),
				view.getBottom());
		view.draw(canvas);
		return bitmap;
	}

	/**
	 * TODO 从View的Draw缓存中获取Bitmap
	 * 
	 * @param view
	 * @return Bitmap
	 */
	public static Bitmap getBitmapFromViewDraw(View view) {
		view.destroyDrawingCache();
		view.measure(View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
				.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
		view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
		view.setDrawingCacheEnabled(true);
		Bitmap bitmap = view.getDrawingCache(true);
		return bitmap;
	}

	/**
	 * TODO 给Bitmap 画一个圆角
	 * 
	 * @param bitmap
	 * @param roundPx
	 * @return Bitmap
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
		if (bitmap == null) {
			return bitmap;
		}
		try {
			Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
					bitmap.getHeight(), Config.ARGB_8888);
			Canvas canvas = new Canvas(output);
			final int color = 0xff424242;
			final Paint paint = new Paint();
			final Rect rect = new Rect(0, 0, bitmap.getWidth(),
					bitmap.getHeight());
			final RectF rectF = new RectF(rect);
			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
			paint.setColor(color);
			canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bitmap, rect, rect, paint);
			return output;
		} catch (OutOfMemoryError e) {
			// TODO: handle exception
			System.gc();
			return null;
		}
	}

	/**
	 * 把资源图片便会得到一个灰色的Drawable
	 */
	public static Drawable toGrayscale(Drawable drawable) {
		drawable.mutate();
		ColorMatrix cm = new ColorMatrix();
		cm.setSaturation(0);
		ColorMatrixColorFilter cf = new ColorMatrixColorFilter(cm);
		drawable.setColorFilter(cf);
		return drawable;
	}

	public static void compressImageFile(int compressWidth, int compressHeight,
			int compressQuality, Uri originUri, Uri compressUri) {
		int minSideLength = 0;
		int size = 0;
		int quality = 0;

		if (compressWidth != -1 && compressHeight != -1) {
			minSideLength = compressWidth > compressHeight ? compressHeight
					: compressWidth;
			size = compressWidth * compressHeight;
		}
		if (compressWidth == -1 && compressHeight != -1) {
			minSideLength = compressHeight;
			size = compressHeight * compressHeight;
		}
		if (compressWidth != -1 && compressHeight == -1) {
			minSideLength = compressWidth;
			size = compressWidth * compressWidth;
		}
		if (compressWidth == -1 && compressHeight == -1) {
			minSideLength = 800;
			size = 800 * 800;
		}

		if (compressQuality < 0 || compressQuality > 100) {
			quality = 80;
		} else {
			quality = compressQuality;
		}

		Bitmap bitmap = null;
		OutputStream out = null;
		try {
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(originUri.getPath(), options);
			// Calculate inSampleSize

			options.inSampleSize = computeSampleSize(options, minSideLength,
					size);
			// Decode bitmap with inSampleSize set
			options.inJustDecodeBounds = false;
			bitmap = BitmapFactory.decodeFile(originUri.getPath(), options);
			File compressFile = new File(compressUri.getPath());
			if (!compressFile.exists()) {
				boolean result = compressFile.createNewFile();
				Log.d(TAG, "Target " + compressUri
						+ " not exist, create a new one " + result);
			}
			out = new FileOutputStream(compressFile);
			boolean result = bitmap.compress(Bitmap.CompressFormat.JPEG,
					quality, out);
			Log.d(TAG, "Compress bitmap " + (result ? "succeed" : "failed"));
		} catch (Exception e) {
			Log.e(TAG, "compressInputStreamToOutputStream", e);
		} finally {
			if (bitmap != null)
				bitmap.recycle();
			try {
				if (out != null)
					out.close();
			} catch (IOException ignore) {

			}
		}
	}

	public static void compressImageFile(int minSideLength,
			int compressQuality, Uri originUri, Uri compressUri) {
		compressImageFile(minSideLength, minSideLength, compressQuality,
				originUri, compressUri);
	}

	public static void compressImageFile(int minSideLength,
			 Uri originUri, Uri compressUri) {
		compressImageFile(minSideLength, minSideLength, -1,
				originUri, compressUri);
	}
	
	public static void compressImageFile(
			 Uri originUri, Uri compressUri) {
		compressImageFile(-1, -1, -1,
				originUri, compressUri);
	}
	
	/**
	 * TODO 等比例压缩图片
	 * 
	 * @param bitmap
	 *            bitmap 实例；
	 * @param screenWidth
	 *            新的宽度
	 * @param screenHight
	 *            新的高度
	 * @return Bitmap
	 */
	public static Bitmap getBitmap(Bitmap bitmap, int screenWidth,
			int screenHight) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();

		Matrix matrix = new Matrix();
		float scale = (float) screenWidth / w;
		float scale2 = (float) screenHight / h;

		// 取比例小的值 可以把图片完全缩放在屏幕内
		scale = scale < scale2 ? scale : scale2;

		// 都按照宽度scale 保证图片不变形.根据宽度来确定高度
		matrix.postScale(scale, scale);
		// w,h是原图的属性.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}

	/**
	 * TODO 等比例缩放图片
	 * 
	 * @param bitmap
	 *            bitmap 实例；
	 * @param newLength
	 *            新的宽度或高度
	 * @param isWidth
	 *            是为宽度，不是为高度
	 * @return Bitmap
	 */
	public static Bitmap getBitmap(Bitmap bitmap, int newLength, boolean isWidth) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();

		Matrix matrix = new Matrix();
		float scale = -1;
		if (isWidth) {

			scale = (float) newLength / w;
		} else {
			scale = (float) newLength / h;
		}

		// 都按照宽度scale 保证图片不变形.根据宽度来确定高度
		matrix.postScale(scale, scale);
		// w,h是原图的属性.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}

	public static Bitmap watermarkBitmap(Bitmap src, Bitmap watermark,
			String title) {
		if (src == null) {
			return null;
		}
		int w = src.getWidth();
		int h = src.getHeight();
		// 需要处理图片太大造成的内存超过的问题,这里我的图片很小所以不写相应代码了
		Bitmap newb = Bitmap.createBitmap(w, h, Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
		Canvas cv = new Canvas(newb);
		cv.drawBitmap(src, 0, 0, null);// 在 0，0坐标开始画入src
		Paint paint = new Paint();
		// 加入图片
		if (watermark != null) {
			int ww = watermark.getWidth();
			int wh = watermark.getHeight();
			paint.setAlpha(50);
			cv.drawBitmap(watermark, w - ww + 5, h - wh + 5, paint);// 在src的右下角画入水印
		}
		// 加入文字
		if (title != null) {
			String familyName = "宋体";
			Typeface font = Typeface.create(familyName, Typeface.BOLD);
			TextPaint textPaint = new TextPaint();
			textPaint.setColor(Color.RED);
			textPaint.setTypeface(font);
			textPaint.setTextSize(22);
			// 这里是自动换行的
			StaticLayout layout = new StaticLayout(title, textPaint, w,
					Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
			layout.draw(cv);
			// 文字就加左上角算了
			// cv.drawText(title,0,40,paint);
		}
		cv.save(Canvas.ALL_SAVE_FLAG);// 保存
		cv.restore();// 存储
		return newb;
	}

}
