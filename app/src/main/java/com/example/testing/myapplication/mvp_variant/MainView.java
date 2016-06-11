package com.example.testing.myapplication.mvp_variant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/5/13 10:53
 * description:
 */
public class MainView implements IViewDelegate, View.OnClickListener {
  View mRootView;
  private Button button;
  private TextView textView;

  @Override public void onCreate(LayoutInflater inflater, ViewGroup container) {
    mRootView = inflater.inflate(R.layout.activity_main, container, false);

    button = (Button) mRootView.findViewById(R.id.button);
    textView = (TextView) mRootView.findViewById(R.id.textView);
  }

  @Override public View getRootView() {
    return mRootView;
  }

  @Override public void init() {
    button.setOnClickListener(this);
  }

  public void showText(String msg) {
    textView.setText(msg);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.button:
        showText("哈哈哈点击了");
        break;
    }
  }
}
