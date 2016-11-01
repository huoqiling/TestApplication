package com.example.testing.myapplication.module.itemDecoration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.loadmoreRecyclerView.SimpleTextAdapter;

/**
 * author: baiiu
 * date: on 16/11/1 14:31
 * description:
 */
public class ItemDecorationFragment extends Fragment {

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_decoration, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.addItemDecoration(new GridItemDecoration());
        recyclerView.setAdapter(new SimpleTextAdapter(getContext(), 30));

        return view;
    }

}
