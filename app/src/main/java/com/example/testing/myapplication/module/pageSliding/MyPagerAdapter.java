package com.example.testing.myapplication.module.pageSliding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/11/4 15:45
 * description:
 */
public class MyPagerAdapter extends PagerAdapter {
    private Context context;

    public MyPagerAdapter(Context context) {
        this.context = context;
    }

    @Override public int getCount() {
        return 10;
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override public Object instantiateItem(ViewGroup container, int position) {
        View view = onCreateView(position);
        container.addView(view);
        return view;
    }

    @Override public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @NonNull private View onCreateView(int position) {
        TextView textView = new TextView(context);
        textView.setTextSize(22);
        textView.setGravity(Gravity.CENTER);
        textView.setText(String.valueOf(position));
        return textView;
    }

    @Override public CharSequence getPageTitle(int position) {
        return "位置" + position;
    }
}
