package com.example.testing.myapplication.module.itemAnimator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.loadmoreRecyclerView.SimpleTextAdapter;

/**
 * author: baiiu
 * date: on 16/7/8 10:21
 * description:
 */
public class ItemAnimatorFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SimpleTextAdapter mAdapter;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemanimator, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new SimpleTextAdapter(getContext(), 20);
        recyclerView.setAdapter(mAdapter);

        view.findViewById(R.id.add)
                .setOnClickListener(this);
        view.findViewById(R.id.delete)
                .setOnClickListener(this);

        return view;
    }


    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                mAdapter.addOne(3);
                break;
            case R.id.delete:
                mAdapter.deleteOne(4);
                break;
        }
    }
}
