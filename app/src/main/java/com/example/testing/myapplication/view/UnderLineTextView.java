package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/9/23 10:23
 * description:
 */

public class UnderLineTextView extends TextView {

    private Paint mPaint;

    public UnderLineTextView(Context context) {
        this(context, null);
    }

    public UnderLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UnderLineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UnderLineTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Paint mPaint) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mPaint = mPaint;
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();

        canvas.drawLine(0, measuredHeight - 1, measuredWidth, measuredHeight, mPaint);
    }
}
