package com.example.testing.myapplication.module.bottomRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.example.testing.myapplication.module.stickyHeaderRecyclerView.SimpleTextViewHolder;

/**
 * author: baiiu
 * date: on 16/7/1 19:47
 * description:
 */
public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextViewHolder> {

    private Context mContext;
    private int mCount;

    public SimpleTextAdapter(Context context, int count) {
        mContext = context;
        mCount = count;
    }

    @Override public SimpleTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleTextViewHolder(mContext, parent);
    }

    @Override public void onBindViewHolder(SimpleTextViewHolder holder, int position) {
        holder.bind("position: " + position);
    }

    @Override public int getItemCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
        notifyDataSetChanged();
    }


}
