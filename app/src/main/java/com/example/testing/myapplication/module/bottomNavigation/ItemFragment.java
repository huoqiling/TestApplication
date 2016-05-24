package com.example.testing.myapplication.module.bottomNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/5/24 10:10
 * description:
 */
public class ItemFragment extends Fragment {

  public static ItemFragment instance(int position) {
    ItemFragment itemFragment = new ItemFragment();
    Bundle bundle = new Bundle();
    bundle.putString("position", String.valueOf(position));
    itemFragment.setArguments(bundle);
    return itemFragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    TextView textView = new TextView(getContext());
    textView.setText(getArguments().getString("position"));
    textView.setTextSize(22);
    textView.setGravity(Gravity.CENTER);
    return textView;
  }
}
