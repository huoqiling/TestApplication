package com.example.testing.myapplication.module.badgeView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/8/15 15:34
 * description:
 */
public class BadgeViewFragment extends Fragment {

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_badge, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);


        BadgeView badgeView = new BadgeView(getContext());
        badgeView.setBadgeCount(42);
        badgeView.setTargetView(textView);

        return view;
    }
}
