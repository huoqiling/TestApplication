package com.example.testing.myapplication.module.fastscrooll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.loadmoreRecyclerView.SimpleTextAdapter;

/**
 * author: baiiu
 * date: on 16/7/6 14:49
 * description:
 */
public class FastScrollFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fastscroll, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new FastScrollLinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        SimpleTextAdapter mAdapter = new SimpleTextAdapter(getContext(), 500);
        recyclerView.setAdapter(mAdapter);


        view.findViewById(R.id.fast_top)
                .setOnClickListener(this);
        view.findViewById(R.id.fast_end)
                .setOnClickListener(this);


        return view;
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fast_top:
                recyclerView.smoothScrollToPosition(0);
                break;
            case R.id.fast_end:
                recyclerView.smoothScrollToPosition(10000);
                break;
        }
    }
}
