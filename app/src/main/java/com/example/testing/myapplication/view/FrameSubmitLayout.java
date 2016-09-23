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
    private TextView mTextView;

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
        mTextView = (TextView) getChildAt(0);
    }

    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        View view = getChildAt(1);
        int textWidth = (int) mTextView.getPaint()
                .measureText(mTextView.getText()
                                     .toString());
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = textWidth + mTextView.getPaddingLeft() + 20;
        view.setLayoutParams(layoutParams);
    }

}
