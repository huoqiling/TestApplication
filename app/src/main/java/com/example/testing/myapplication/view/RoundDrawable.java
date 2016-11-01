package com.example.testing.myapplication.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * author: baiiu
 * date: on 16/6/17 16:11
 * description:
 */
public class RoundDrawable extends Drawable {

    private Paint mPaint;
    private RectF rectF;
    private int mRadius;


    public RoundDrawable(@ColorInt int color, int radius, boolean stroke) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        if (stroke) {
            mPaint.setStyle(Paint.Style.STROKE);
        } else {
            mPaint.setStyle(Paint.Style.FILL);
        }
        mPaint.setColor(color);

        this.mRadius = radius;
    }

    public RoundDrawable(int color, int radius, boolean stroke, int strokeWidth) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        if (stroke) {
            mPaint.setStyle(Paint.Style.STROKE);
        } else {
            mPaint.setStyle(Paint.Style.FILL);
        }
        mPaint.setColor(color);
        mPaint.setStrokeWidth(strokeWidth);

        this.mRadius = radius;
    }


    @Override public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
    }

    @Override public void draw(Canvas canvas) {
        canvas.drawRoundRect(rectF, mRadius, mRadius, mPaint);
    }

    @Override public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}
