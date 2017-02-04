package com.example.testing.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * author: baiiu
 * date: on 17/1/18 11:32
 * description:
 */

public class PaintRecyclerView extends RecyclerView {

    private Paint mPaint;

    public PaintRecyclerView(Context context) {
        this(context, null);
        init(context);
    }

    public PaintRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PaintRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(22);
    }


    @Override public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("哈哈哈哈", 100, 100, mPaint);

    }
}
