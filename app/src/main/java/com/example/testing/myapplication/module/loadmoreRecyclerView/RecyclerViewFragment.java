package com.example.testing.myapplication.module.loadmoreRecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.util.LogUtil;
import com.example.testing.myapplication.view.MyDecoration;

/**
 * author: baiiu
 * date: on 16/7/1 19:45
 * description:
 */
public class RecyclerViewFragment extends Fragment implements LoadingMoreScrollListener.OnLoadingMoreListener {

    private RecyclerView recyclerView;
    private SimpleTextAdapter mAdapter;
    private LoadingMoreScrollListener loadingMoreScrollListener;

    private int totallyY = 0;
    private MyDecoration myDecoration;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        myDecoration = new MyDecoration();
        recyclerView.addItemDecoration(myDecoration);


        mAdapter = new SimpleTextAdapter(getContext(), 20);
        recyclerView.setAdapter(mAdapter);


        loadingMoreScrollListener = new LoadingMoreScrollListener();
        loadingMoreScrollListener.setOnLoadingMoreListener(this);
        recyclerView.addOnScrollListener(loadingMoreScrollListener);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                totallyY += dy;
                myDecoration.setScrollY(totallyY);
                LogUtil.d("totallyY: " + totallyY);
            }
        });

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

}
