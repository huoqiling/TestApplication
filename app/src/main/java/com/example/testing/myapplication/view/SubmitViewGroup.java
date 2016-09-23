package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/9/23 15:44
 * description:
 */
public class SubmitViewGroup extends ViewGroup {
    public SubmitViewGroup(Context context) {
        super(context);
    }

    public SubmitViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SubmitViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SubmitViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int childWidth = 0;
        int childHeight = 0;

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            int measuredWidth = childView.getMeasuredWidth();
            int measuredHeight = childView.getMeasuredHeight();
            MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();

            childWidth += measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin;
            childHeight += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? widthSize : childWidth,
                             (heightMode == MeasureSpec.EXACTLY) ? heightSize : childHeight);

    }

    //@Override protected void onDraw(Canvas canvas) {
    //    super.onDraw(canvas);
    //
    //}

    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
        TextView childOne = (TextView) getChildAt(0);
        childOne.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());

        int textWidth = (int) childOne.getPaint()
                .measureText(childOne.getText()
                                     .toString());

        View childTwo = getChildAt(1);

        int toLeft = textWidth + childOne.getPaddingLeft() + 20;
        childTwo.layout(toLeft, 0, getMeasuredWidth() - 200, childTwo.getMeasuredHeight());

    }

}
