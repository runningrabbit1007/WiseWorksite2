package com.common.view.iamge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


public class CircleImageView extends ImageView {

	public CircleImageView(Context context) {
		super(context);
	}

	public CircleImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public void setImageBitmap(Bitmap bm) {
		// 将Bitmap转为圆形drawable
		CircleImageDrawable drawable = new CircleImageDrawable(bm);
		setImageDrawable(drawable);
	}




	@Override
	public void setBackground(Drawable background) {
		// 如果想在布局xml代码中设置方形背景图片，可以在这里做处理，可以先将drawable转为bitmap，但是也没必要处理，直接放一个圆形的背景图片即可
		super.setBackground(background);
	}

	public class CircleImageDrawable extends Drawable {

		private Paint mPaint;
		private int mWidth;
		private Bitmap mBitmap;

		public CircleImageDrawable(Bitmap bitmap) {
			mBitmap = bitmap;
			BitmapShader bitmapShader = new BitmapShader(bitmap,
					TileMode.CLAMP, TileMode.CLAMP);
			mPaint = new Paint();
			mPaint.setAntiAlias(true);
			mPaint.setShader(bitmapShader);
			mWidth = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
		}

		@Override
		public void draw(Canvas canvas) {
			canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2, mPaint);
		}

		@Override
		public int getIntrinsicWidth() {
			return mWidth;
		}

		@Override
		public int getIntrinsicHeight() {
			return mWidth;
		}

		@Override
		public void setAlpha(int alpha) {
			mPaint.setAlpha(alpha);
		}

		@Override
		public void setColorFilter(ColorFilter cf) {
			mPaint.setColorFilter(cf);
		}

		@Override
		public int getOpacity() {
			return PixelFormat.TRANSLUCENT;
		}

	}
}
