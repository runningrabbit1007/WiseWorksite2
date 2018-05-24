package com.sx.common_base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * 
 * ============================================================
 * 
 * copyright ：ZENG HUI (c) 2014
 * 
 * author : HUI
 * 
 * version ：1.0
 * 
 * date created ： On January 31, 2015 下午1:44:49
 * 
 * description ： circular image view
 * 
 * revision history ：
 * 
 * 
 * ============================================================
 * 
 */
public class CircularImageView extends android.support.v7.widget.AppCompatImageView {

	private final float density = getContext().getResources()
			.getDisplayMetrics().density;
	private float roundness;

	private final int roundedCorner = 10;

	public CircularImageView(Context context) {
		super(context);
		init();
	}

	public CircularImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	@Override
	public void draw(Canvas canvas) {
		final Bitmap composedBitmap;
		final Bitmap originalBitmap;
		final Canvas composedCanvas;
		final Canvas originalCanvas;
		final Paint paint;
		final int height;
		final int width;

		width = getWidth();

		height = getHeight();

		if(width>0 && height>0) {
			composedBitmap = Bitmap.createBitmap(width, height,
					Bitmap.Config.ARGB_8888);
			originalBitmap = Bitmap.createBitmap(width, height,
					Bitmap.Config.ARGB_8888);


		composedCanvas = new Canvas(composedBitmap);
		originalCanvas = new Canvas(originalBitmap);



		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.BLACK);

		super.draw(originalCanvas);

		composedCanvas.drawARGB(0, 0, 0, 0);

		composedCanvas.drawRoundRect(new RectF(0, 0, width, height),
				this.roundness, this.roundness, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));

		composedCanvas.drawBitmap(originalBitmap, 0, 0, paint);

		canvas.drawBitmap(composedBitmap, 0, 0, new Paint());
		}
	}

	public float getRoundness() {
		return this.roundness / this.density;
	}

	public void setRoundness(float roundness) {
		this.roundness = this.roundedCorner * roundness * this.density;
	}

	private void init() {
		setRoundness(5);
	}
}
