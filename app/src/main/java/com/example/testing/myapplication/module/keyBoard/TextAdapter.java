package com.example.testing.myapplication.module.keyBoard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * auther: baiiu
 * time: 16/9/7 07 06:46
 * description:
 */
public class TextAdapter extends BaseAdapter {
    private Context mContext;

    public TextAdapter(Context context) {
        mContext = context;
    }

    @Override public int getCount() {
        return 20;
    }

    @Override public String getItem(int position) {
        return "item " + position;
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setText(getItem(position));
        return textView;
    }
}
