package com.example.testing.myapplication.module.stickyHeaderRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import java.util.Arrays;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/6/27 17:30
 * description:
 */
public class MyAdapter extends RecyclerView.Adapter<SimpleTextViewHolder> {

    private List<String> mList;
    private Context mContext;

    public MyAdapter(Context context) {
        mContext = context;
        mList = Arrays.asList(context.getResources()
                                      .getStringArray(R.array.arrays));
    }

    @Override public SimpleTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleTextViewHolder(mContext);
    }

    @Override public void onBindViewHolder(SimpleTextViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override public int getItemCount() {
        return mList.size();
    }
}
