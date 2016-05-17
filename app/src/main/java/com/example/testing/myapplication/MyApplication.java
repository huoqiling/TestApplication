package com.example.testing.myapplication;

import android.app.Application;
import com.facebook.stetho.Stetho;

/**
 * author: baiiu
 * date: on 16/5/17 15:39
 * description:
 */
public class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
