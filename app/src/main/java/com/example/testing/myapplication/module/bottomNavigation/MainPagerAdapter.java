package com.example.testing.myapplication.module.bottomNavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * author: baiiu
 * date: on 16/5/24 10:09
 * description:
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
  public MainPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    return ItemFragment.instance(position);
  }

  @Override public int getCount() {
    return 4;
  }
}
