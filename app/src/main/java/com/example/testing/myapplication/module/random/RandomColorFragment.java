package com.example.testing.myapplication.module.random;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import java.util.ArrayList;
import java.util.List;

/**
 * auther: baiiu
 * time: 16/6/15 15 23:17
 * description:
 */
public class RandomColorFragment extends Fragment {

    List<Card> mList;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            Card card = new Card();
            card.position = i;
            card.color = RandomColorGenerator.getRandomColor();
            mList.add(card);
        }
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_random, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RandomAdapter(getContext(), mList));

        return view;
    }
}
