package com.example.testing.myapplication.module.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.random.RandomColorFragment;

/**
 * author: baiiu
 * date: on 16/6/20 11:16
 * description:
 */
public class TabFragment extends Fragment {


    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        CustomTabLayout customTabLayout = (CustomTabLayout) view.findViewById(R.id.customTabLayout);


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override public Fragment getItem(int position) {
                return new RandomColorFragment();
            }

            @Override public int getCount() {
                return 2;
            }
        });
        customTabLayout.setViewPager(viewPager);


        return view;
    }
}
