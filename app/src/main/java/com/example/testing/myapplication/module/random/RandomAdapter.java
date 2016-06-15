package com.example.testing.myapplication.module.random;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;

/**
 * auther: baiiu
 * time: 16/6/15 15 23:28
 * description:
 */
public class RandomAdapter extends RecyclerView.Adapter<TextViewHolder> {

    private Context mContext;
    private List<Card> mList;
    private final LayoutInflater inflater;

    public RandomAdapter(Context context, List<Card> mList) {
        mContext = context;
        this.mList = mList;

        inflater = LayoutInflater.from(mContext);
    }

    @Override public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextViewHolder(inflater.inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override public int getItemCount() {
        return mList.size();
    }

}
