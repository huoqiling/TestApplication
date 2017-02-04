package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.example.testing.myapplication.util.ScreenUtil;
import com.example.testing.myapplication.util.UIUtil;

/**
 * author: baiiu
 * date: on 17/2/4 14:56
 * description:
 */

public class CanvasTestView extends View {
    private Paint mPaint;

    public CanvasTestView(Context context) {
        this(context, null);
    }

    public CanvasTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CanvasTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CanvasTestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(54);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(ScreenUtil.getScreenWidth(getContext()), Integer.MAX_VALUE);
    }

    @Override protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        int left_1 = UIUtil.dp(getContext(), 20);
        int left_2 = UIUtil.dp(getContext(), 20) + UIUtil.dp(getContext(), 150);

        int top = UIUtil.dp(getContext(), 20);

        for (int i = 0; i < 10; ++i) {
            int left = i % 2 == 0 ? left_1 : left_2;

            MyDrawable myDrawable = new MyDrawable();
            myDrawable.setBounds(left, top, left + myDrawable.getIntrinsicWidth(),
                                 top + myDrawable.getIntrinsicHeight());
            myDrawable.draw(canvas);

            if (i % 2 == 0) {
                top += UIUtil.dp(getContext(), 20) + myDrawable.getIntrinsicHeight();
            } else {
                top += UIUtil.dp(getContext(), 140) + myDrawable.getIntrinsicHeight();
            }

        }


        //canvas.save();
        //canvas.rotate(-30);
        //canvas.drawText("DecorationDraw", 200, 200, mPaint);
        //canvas.restore();

    }
}
