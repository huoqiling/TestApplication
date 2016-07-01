package com.example.testing.myapplication.module.bottomRecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/7/1 19:45
 * description:
 */
public class RecyclerViewFragment extends Fragment implements LoadingMoreScrollListener.OnLoadingMoreListener {

    private RecyclerView recyclerView;
    private SimpleTextAdapter mAdapter;
    private LoadingMoreScrollListener loadingMoreScrollListener;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SimpleTextAdapter(getContext(), 20);
        recyclerView.setAdapter(mAdapter);


        loadingMoreScrollListener = new LoadingMoreScrollListener();
        loadingMoreScrollListener.setOnLoadingMoreListener(this);
        recyclerView.addOnScrollListener(loadingMoreScrollListener);

        return view;
    }


    public void loadingMore() {
        recyclerView.postDelayed(new Runnable() {
            @Override public void run() {
                mAdapter.setCount(mAdapter.getItemCount() + 20);
                loadingMoreScrollListener.setLoading(true);
            }
        }, 1000);

    }

}
