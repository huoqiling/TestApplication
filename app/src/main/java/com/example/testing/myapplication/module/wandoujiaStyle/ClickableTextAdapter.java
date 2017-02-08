package com.example.testing.myapplication.module.wandoujiaStyle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: baiiu
 * date: on 16/7/1 19:47
 * description:
 */
public class ClickableTextAdapter extends RecyclerView.Adapter<ClickableTextViewHolder> {

    private Context mContext;
    private int mCount;
    private View.OnClickListener mListener;

    public ClickableTextAdapter(Context context, int count,View.OnClickListener listener) {
        mContext = context;
        mCount = count;
        this.mListener = listener;
    }

    @Override public ClickableTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClickableTextViewHolder(mContext, parent,mListener);
    }

    @Override public void onBindViewHolder(ClickableTextViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override public int getItemCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        notifyItemRangeInserted(this.mCount, 20);
        this.mCount = mCount;
    }

    public void addOne(int position) {
        notifyItemInserted(position);
        ++this.mCount;
    }

    public void deleteOne(int position) {
        notifyItemRemoved(position);
        --this.mCount;
    }


}
