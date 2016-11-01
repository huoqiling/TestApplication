package com.example.testing.myapplication.module.itemDecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author: baiiu
 * date: on 16/11/1 14:40
 * description:
 */
public class GridItemDecoration extends RecyclerView.ItemDecoration {

    @Override public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        // super.getItemOffsets(outRect, view, parent, state);
        //outRect.set(50, 50, 50, 50);
        int position = parent.getChildLayoutPosition(view);
        //LogUtil.d("getItemOffsets: " + position);

        if (position % 3 == 0) {
            outRect.set(45, 15, 15, 15);
        } else if (position % 3 == 1) {
            outRect.set(15, 15, 15, 15);
        } else {
            outRect.set(15, 15, 45, 15);
        }

    }
}
