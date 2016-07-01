package com.example.testing.myapplication.module.stickyHeaderRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/6/27 17:38
 * description:
 */
public class SimpleTextViewHolder extends RecyclerView.ViewHolder {

    public SimpleTextViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context)
                      .inflate(android.R.layout.simple_list_item_1, parent, false));

        itemView.setPadding(0, 30, 0, 30);

    }

    public void bind(String text) {
        ((TextView) itemView).setText(text);
    }

}
