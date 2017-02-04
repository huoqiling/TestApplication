package com.example.testing.myapplication.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    //private Paint mPaint;
    public MyDecoration() {

        //mPaint = new Paint();
        //mPaint.setColor(Color.parseColor("#1A000000"));
        //mPaint.setAntiAlias(true);
        //mPaint.setTextAlign(Paint.Align.CENTER);
        //mPaint.setTextSize(54);

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


    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int recyclerViewTop = parent.getPaddingTop();
        final int recyclerViewBottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = Math.max(recyclerViewTop, child.getBottom() + params.bottomMargin);
            final int bottom = Math.min(recyclerViewBottom, top + mDivider.getIntrinsicHeight());


            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    //public void drawVertical(Canvas canvas, RecyclerView parent) {
    //    final int left = parent.getPaddingLeft();
    //    final int right = parent.getWidth() - parent.getPaddingRight();
    //    final int recyclerViewTop = parent.getPaddingTop();
    //    final int recyclerViewBottom = parent.getHeight() - parent.getPaddingBottom();
    //    final int childCount = parent.getChildCount();
    //    for (int i = 0; i < childCount; i++) {
    //        final View child = parent.getChildAt(i);
    //        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
    //        final int top = Math.max(recyclerViewTop, child.getBottom() + params.bottomMargin);
    //        //final int bottom = Math.min(recyclerViewBottom, top + mDivider.getIntrinsicHeight());
    //        //mDivider.setBounds(left, top, right, bottom);
    //        //mDivider.draw(c);
    //
    //        canvas.save();
    //        canvas.rotate(-30);
    //
    //        LogUtil.d(left + ", " + top);
    //
    //        canvas.drawText("DecorationDraw", left, top, mPaint);
    //        canvas.restore();
    //
    //
    //    }
    //}


    // 设置分割线的size，距离
    @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }


    public static int getScollYDistance(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int position = layoutManager.findFirstVisibleItemPosition();
        View firstVisiableChildView = layoutManager.findViewByPosition(position);
        int itemHeight = firstVisiableChildView.getHeight();
        return (position) * itemHeight - firstVisiableChildView.getTop();
    }

    public void setScrollY(int scrollY) {
        this.mScrollY = scrollY;
    }
}
