package com.example.testing.myapplication.module.wandoujiaStyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.loadmoreRecyclerView.LoadingMoreScrollListener;

/**
 * author: baiiu
 * date: on 16/7/1 19:45
 * description:
 */
public class WandaojiaStyleFragment extends Fragment implements LoadingMoreScrollListener.OnLoadingMoreListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private ClickableTextAdapter mAdapter;
    private LoadingMoreScrollListener loadingMoreScrollListener;

    private int totallyY = 0;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        mAdapter = new ClickableTextAdapter(getContext(), 20, this);
        recyclerView.setAdapter(mAdapter);

        loadingMoreScrollListener = new LoadingMoreScrollListener();
        loadingMoreScrollListener.setOnLoadingMoreListener(this);
        recyclerView.addOnScrollListener(loadingMoreScrollListener);


        //ImageView viewById = (ImageView) view.findViewById(R.id.some_view);
        //viewById.setImageDrawable(new MyDrawable());

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

    @Override public void onClick(View v) {
        ClickableTextViewHolder holder = (ClickableTextViewHolder) v.getTag();

        startActivity(new Intent(getContext(), DetailActivity.class));

    }

}
