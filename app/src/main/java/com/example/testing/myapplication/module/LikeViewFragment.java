package com.example.testing.myapplication.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testing.myapplication.R;
import com.example.testing.myapplication.view.LikeView;

/**
 * author: baiiu
 * date: on 17/1/12 21:01
 * description:
 */
public class LikeViewFragment extends Fragment {

    private LikeView likeView;
    private boolean isLike;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_like_view, container, false);
        likeView = (LikeView) view.findViewById(R.id.likeView);

        view.findViewById(R.id.bt_like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLike = !isLike;
                likeView.setFavorite(isLike);
            }
        });

        return view;
    }
}
