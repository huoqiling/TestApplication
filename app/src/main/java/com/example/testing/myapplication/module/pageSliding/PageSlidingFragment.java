package com.example.testing.myapplication.module.pageSliding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/11/4 15:43
 * description:
 */
public class PageSlidingFragment extends Fragment {

    private PagerSlidingTabStrip tabIndicator;
    private ViewPager viewPager;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_sliding, container, false);
        tabIndicator = (PagerSlidingTabStrip) view.findViewById(R.id.tabIndicator);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        return view;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager.setAdapter(new MyPagerAdapter(getContext()));
        tabIndicator.setViewPager(viewPager);
    }
}
