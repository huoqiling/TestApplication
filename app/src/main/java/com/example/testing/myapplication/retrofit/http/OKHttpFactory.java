package com.example.testing.myapplication.retrofit.http;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * author: baiiu
 * date: on 16/5/16 16:43
 * description:
 */
enum OKHttpFactory {

  INSTANCE;

  private final OkHttpClient okHttpClient;

  private static final int TIMEOUT_READ = 25;
  private static final int TIMEOUT_CONNECTION = 25;

  OKHttpFactory() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    okHttpClient = new OkHttpClient.Builder()
        //打印请求log
        .addInterceptor(interceptor)

        //失败重连
        .retryOnConnectionFailure(true)

        //time out
        .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)

        .build();
  }

  public OkHttpClient getOkHttpClient() {
    return okHttpClient;
  }
}
