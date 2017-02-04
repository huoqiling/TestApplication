package com.example.testing.myapplication.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * author: baiiu
 * date: on 17/2/4 11:48
 * description:
 */

public class MyDrawable extends Drawable {
    Paint mPaint;

    public MyDrawable() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(54);
    }

    public void setTextAlign(boolean left){
        mPaint.setTextAlign(left ? Paint.Align.LEFT : Paint.Align.RIGHT);
    }

    @Override public void draw(@NonNull Canvas canvas) {
        Rect r = getBounds();
        //canvas.drawColor(Color.parseColor("#22000000"));

        canvas.save();
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        float ceil = (float) (Math.ceil(fm.descent - fm.ascent) / 2F);


        canvas.translate(ceil,0);
        canvas.rotate(-30, r.left, r.bottom);


        canvas.drawText("哈哈哈哈哈哈哈", r.left, r.bottom, mPaint);

        //LogUtil.d("myDrawable:::: " + r.top + ", " + r.bottom + ", " + r.toString());

        canvas.restore();
    }

    @Override public int getIntrinsicHeight() {
        return (int) (Math.sqrt(3) / 3 * getIntrinsicWidth() + 0.5F);

    }

    @Override public int getIntrinsicWidth() {
        return (int) (mPaint.measureText("DecorationDraw") + 0.5F);
    }

    @Override public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}
