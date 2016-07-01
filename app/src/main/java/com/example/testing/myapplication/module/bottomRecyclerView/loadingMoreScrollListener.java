package com.example.testing.myapplication.module.bottomRecyclerView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * author: baiiu
 * date: on 16/7/1 20:06
 * description:
 */
public class LoadingMoreScrollListener extends RecyclerView.OnScrollListener {
    private boolean isLoading = true;
    private OnLoadingMoreListener mListener;

    @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int itemCount = layoutManager.getItemCount();
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();


        //最后一个可见时加载数据
        if (isLoading && dy > 0 && (lastVisibleItemPosition + 3 >= itemCount)) {
            isLoading = false;
            if (mListener != null) {
                mListener.loadingMore();
            }
        }
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public interface OnLoadingMoreListener {
        void loadingMore();
    }

    public void setOnLoadingMoreListener(OnLoadingMoreListener loadingMoreListener) {
        this.mListener = loadingMoreListener;
    }
}