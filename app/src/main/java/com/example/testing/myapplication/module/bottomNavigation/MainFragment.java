package com.example.testing.myapplication.module.bottomNavigation;

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
 * date: on 16/5/23 19:57
 * description:
 */
public class MainFragment extends Fragment {

  private ViewPager viewPager;
  private BottomNavigation navigation;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_bottom_navigation, container, false);
    viewPager = (ViewPager) view.findViewById(R.id.viewPager);
    navigation = (BottomNavigation) view.findViewById(R.id.navigation);
    return view;
  }

  @Override public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    viewPager.setAdapter(new MainPagerAdapter(getActivity().getSupportFragmentManager()));
    navigation.setBottomTab(MainTab.values(), 0);
    navigation.setTabRed(MainTab.DISCOVER, 2);
    navigation.setTabRed(MainTab.ME, 2);
    navigation.setOnTabSelectedListener(new BottomNavigation.OnTabSelectedListener() {
      @Override public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
      }
    });

    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {
        navigation.setSelection(position);
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
  }
}
