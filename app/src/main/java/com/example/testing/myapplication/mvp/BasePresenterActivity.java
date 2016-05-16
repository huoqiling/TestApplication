package com.example.testing.myapplication.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author: baiiu
 * date: on 16/5/13 10:39
 * description: 使用时候继承这个
 */
public abstract class BasePresenterActivity<V extends IViewDelegate> extends AppCompatActivity {
  protected V viewDelegate;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
      viewDelegate = getVuClass().newInstance();
      viewDelegate.onCreate(getLayoutInflater(), null);
      setContentView(viewDelegate.getRootView());
      viewDelegate.init();
      initOnCreate();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  protected void initOnCreate() {

  }

  protected abstract Class<V> getVuClass();
}
