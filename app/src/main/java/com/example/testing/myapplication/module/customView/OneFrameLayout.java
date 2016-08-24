package com.example.testing.myapplication.module.customView;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/8/22 20:29
 * description:
 */
public class OneFrameLayout extends FrameLayout {

    public OneFrameLayout(Context context) {
        this(context, null);
    }

    public OneFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OneFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OneFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
    }

    public static int dp(int dp) {
        return dp * 3;
        //return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources()
        //        .getDisplayMetrics()) + 0.5F);
    }

    private String mName;
    private List<String> mTags;
    private boolean isMatch;

    //name开头,tags之后,match贴边.该控件match_parent
    public void setListSigns(String name, List<String> tags, boolean match) {
        //addName(name);

        this.mName = name;
        this.mTags = tags;
        this.isMatch = match;

        if (!TextUtils.isEmpty(mName)) {
            addName(mName);
        }


        if (mTags != null && !mTags.isEmpty()) {
            for (int i = 0, size = mTags.size(); i < size; ++i) {
                String s = mTags.get(i);
                addTag(s);
            }
        }


        if (isMatch) {
            addMatch();
        }

        requestLayout();
    }

    private void addName(String name) {
        TextView textView = new TextView(getContext());
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(17);
        textView.setTextColor(Color.BLUE);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText(name);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = Gravity.START | Gravity.LEFT;
        addView(textView, params);
    }


    private void addMatch() {
        TextView textView = new TextView(getContext());
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(17);
        textView.setTextColor(Color.BLACK);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("匹配");

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = Gravity.END | Gravity.RIGHT;
        addView(textView, params);
    }

    private void addTag(String name) {
        TextView textView = new TextView(getContext());
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(17);
        textView.setTextColor(Color.CYAN);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText(name);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        addView(textView, params);
    }

    //忽略padding,tags间距15dp
    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        int childCount = getChildCount();

        int tagsToLeft;//摆放tags开头的位置,在名字右边,如果有的话
        int tagsToRight;//tags占位最大,在match左边,如果有的话

        if (TextUtils.isEmpty(mName)) {
            tagsToLeft = 0;
        } else {
            tagsToLeft = getChildAt(0).getMeasuredWidth() + dp(15);
        }

        if (isMatch) {
            tagsToRight = getMeasuredWidth() - getChildAt(childCount - 1).getMeasuredWidth();
        } else {
            tagsToRight = getMeasuredWidth();
        }


        //开始layout这些tags
        for (int i = tagsToLeft == 0 ? 0 : 1; i < (isMatch ? childCount - 1 : childCount); i++) {

            View child = getChildAt(i);

            int measuredWidth = child.getMeasuredWidth();

            if (tagsToLeft + measuredWidth + dp(15) > tagsToRight) {
                child.setVisibility(GONE);
                continue;
            }

            child.layout(tagsToLeft, top, tagsToLeft + measuredWidth, bottom);
            tagsToLeft += (measuredWidth + dp(15));
        }

    }
}
