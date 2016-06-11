package com.example.testing.myapplication.mvp_variant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: baiiu
 * date: on 16/5/13 10:35
 * description:
 */
public interface IViewDelegate {
  void onCreate(LayoutInflater inflater, ViewGroup container);

  View getRootView();

  void init();
}
