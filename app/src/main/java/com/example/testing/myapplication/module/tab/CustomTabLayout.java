package com.example.testing.myapplication.module.tab;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/6/20 11:17
 * description:
 */
public class CustomTabLayout extends LinearLayout {

    private ViewPager mViewPager;
    private TextView tv_recommend;
    private TextView tv_all;

    public CustomTabLayout(Context context) {
        this(context, null);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.layout_tab_custom, this);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        tv_recommend = (TextView) findViewById(R.id.tv_recommend);
        tv_all = (TextView) findViewById(R.id.tv_all);
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null
                || viewPager.getAdapter() == null
                || viewPager.getAdapter()
                .getCount() != 2) {
            throw new IllegalStateException("sth wrong");
        }

        this.mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override public void onPageSelected(int position) {
                if (position == 0) {
                    tv_recommend.setTextColor(Color.WHITE);
                    tv_all.setTextColor(Color.GRAY);
                } else {
                    tv_recommend.setTextColor(Color.GRAY);
                    tv_all.setTextColor(Color.WHITE);
                }
            }
        });
    }

}
