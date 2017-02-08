package com.example.testing.myapplication.module.wandoujiaStyle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/6/27 17:38
 * description:
 */
public class ClickableTextViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;
    private View.OnClickListener mListener;

    public ClickableTextViewHolder(Context context, ViewGroup parent, View.OnClickListener listener) {
        super(LayoutInflater.from(context)
                      .inflate(R.layout.holder_simple_clickable, parent, false));

        itemView.setPadding(0, 100, 0, 100);
        textView = (TextView) itemView.findViewById(android.R.id.text1);
        this.mListener = listener;
    }

    public void bind(int position) {
        itemView.setTag(this);
        itemView.setOnClickListener(mListener);

        textView.setText("position: " + String.valueOf(position));

        //if (position % 2 == 0) {
        //    itemView.setBackgroundResource(android.R.color.darker_gray);
        //} else {
        //    itemView.setBackgroundResource(android.R.color.holo_purple);
        //}
    }

    public void bind(String text) {
        ((TextView) itemView).setText(text);
    }

}
