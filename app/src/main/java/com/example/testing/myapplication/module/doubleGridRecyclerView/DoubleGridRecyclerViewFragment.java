package com.example.testing.myapplication.module.doubleGridRecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import java.util.ArrayList;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/6/3 14:32
 * description:
 */
public class DoubleGridRecyclerViewFragment extends Fragment {

  private RecyclerView mRecyclerView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_grid, container, false);
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    final GridLayoutManager gridLayoutManager =
        new GridLayoutManager(mRecyclerView.getContext(), 12);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
      @Override public int getSpanSize(int position) {

        int count = 4;

        if (position < 10) {
          count = position == 0 ? 12 : 4;
        } else {
          count = position == 0 ? 12 : 3;
        }

        return count;
      }
    });
    mRecyclerView.setLayoutManager(gridLayoutManager);

    List<String> list = new ArrayList<>();
    for (int i = 0; i < 100; ++i) {
      list.add("item " + i);
    }

    mRecyclerView.setAdapter(new GridAdapter(mRecyclerView.getContext(), list));
  }
}
