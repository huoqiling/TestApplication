package com.example.testing.myapplication.module.random;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * auther: baiiu
 * time: 16/6/15 15 23:30
 * description:
 */
public class TextViewHolder extends RecyclerView.ViewHolder {

    public TextViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(Card card) {
        TextView textView = (TextView) itemView;
        textView.setText(String.valueOf(card.position));
        textView.setBackgroundColor(card.color);

    }
}
