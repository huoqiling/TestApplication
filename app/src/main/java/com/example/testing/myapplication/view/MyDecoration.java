package com.example.testing.myapplication.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import com.example.testing.myapplication.util.LogUtil;
import com.example.testing.myapplication.util.UIUtil;

/**
 * author: baiiu
 * date: on 17/1/18 14:14
 * description:
 */

public class MyDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int mScrollY;

    public MyDecoration() {
        mDivider = new MyDrawable();
    }


    // 1、画分割线
    @Override public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        //canvas.rotate(-30);
        //canvas.drawText("DecorationDraw", x, y, mPaint);
        //canvas.rotate(30);

        //drawVertical(canvas, parent);

    }


    @Override public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);

        //drawVertical(canvas, parent);

        /*
         * 跟着滑动是因为bounds在不停的变化，就是top
         */

        //清除之前画的
        canvas.drawColor(Color.WHITE);


        int left_1 = UIUtil.dp(parent.getContext(), 20);

        int top = UIUtil.dp(parent.getContext(), 20) - mScrollY;


        LogUtil.d("top: " + mScrollY);

        int itemCount = parent.getAdapter()
                .getItemCount();
        for (int i = 0; i < itemCount; ++i) {
            int left = i % 2 == 0 ? left_1
                    : parent.getMeasuredWidth() - mDivider.getIntrinsicWidth() - UIUtil.dp(parent.getContext(), 20);


            mDivider.setBounds(left, top, parent.getMeasuredWidth(), top + mDivider.getIntrinsicHeight());
            mDivider.draw(canvas);

            if (i % 2 == 0) {
                top += UIUtil.dp(parent.getContext(), 20) + mDivider.getIntrinsicHeight();
            } else {
                top += UIUtil.dp(parent.getContext(), 140) + mDivider.getIntrinsicHeight();
            }
        }

    }

    public void setScrollY(int scrollY) {
        this.mScrollY = scrollY;
    }
}
