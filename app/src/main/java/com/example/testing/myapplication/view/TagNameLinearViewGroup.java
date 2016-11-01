package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/10/28 14:50
 * description:
 */
public class TagNameLinearViewGroup extends ViewGroup {

    private int mTagColor;
    private String mTagName;

    public TagNameLinearViewGroup(Context context) {
        this(context, null);
    }

    public TagNameLinearViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TagNameLinearViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TagNameLinearViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TagNameLinearViewGroup);
        mTagName = a.getString(R.styleable.TagNameLinearViewGroup_tagName);
        mTagColor = a.getColor(R.styleable.TagNameLinearViewGroup_tagColor, Color.WHITE);
        a.recycle();
    }

    public void setTagContent(String content) {
        
    }


    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {


    }

}
