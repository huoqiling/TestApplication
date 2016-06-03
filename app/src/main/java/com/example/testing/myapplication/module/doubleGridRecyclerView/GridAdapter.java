package com.example.testing.myapplication.module.doubleGridRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/6/3 14:39
 * description:
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.TextViewHolder> {
  private static final int type_text = 0;
  private static final int type_title = 1;

  private final LayoutInflater inflater;
  private List<String> mList;

  public GridAdapter(Context context, List<String> list) {
    inflater = LayoutInflater.from(context);
    mList = list;
  }

  @Override public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
    return new TextViewHolder(view);
  }

  @Override public void onBindViewHolder(TextViewHolder holder, int position) {
    int itemViewType = getItemViewType(position);
    switch (itemViewType) {
      case type_text:
        holder.textView.setText("title");
        break;
      case type_title:
        holder.textView.setText("item");
        break;
    }
  }

  @Override public int getItemCount() {
    return mList.size();
  }

  @Override public int getItemViewType(int position) {
    if (position == 0) {
      return type_title;
    }

    return type_text;
  }

  public static class TextViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public TextViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView;
      textView.setGravity(Gravity.CENTER);
    }
  }
}
