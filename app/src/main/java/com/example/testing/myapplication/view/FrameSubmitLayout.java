package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/9/23 11:53
 * description:
 */
public class FrameSubmitLayout extends FrameLayout {

    public FrameSubmitLayout(Context context) {
        super(context);
    }

    public FrameSubmitLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrameSubmitLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FrameSubmitLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) getChildAt(0);
        int left = (int) textView.getPaint()
                .measureText(textView.getText()
                                     .toString());

        View child = getChildAt(1);
        MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
        layoutParams.leftMargin = left + textView.getPaddingLeft() + 20;
        child.setLayoutParams(layoutParams);
    }

}
