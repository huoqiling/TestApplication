package com.example.testing.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.example.testing.myapplication.util.LogUtil;

public class MyService extends Service {
    public MyService() {
    }

    @Override public IBinder onBind(Intent intent) {
        return null;
    }

    @Override public void onCreate() {
        super.onCreate();
        LogUtil.d("onCreate");
    }

    @Override public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtil.d("onStart");
    }

    @Override public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy");
    }
}
