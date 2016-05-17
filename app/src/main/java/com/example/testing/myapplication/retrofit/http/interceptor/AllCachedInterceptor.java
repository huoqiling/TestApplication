package com.example.testing.myapplication.retrofit.http.interceptor;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author: baiiu
 * date: on 16/5/17 15:14
 * description: 所有请求先读缓存,1分钟内不刷新
 */
public class AllCachedInterceptor implements Interceptor {

  @Override public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    /*
      自己设置的请求头中没有设置Cache-Control的话就添加

      //自己请求头中添加特定header
      @Headers("Cache-Control: max-age=640000")
      @GET("users/{user}") Call<User> userInfo(@Path("user") String user);
     */
    String cacheControl = request.cacheControl().toString();

    if (TextUtils.isEmpty(cacheControl)) {
      cacheControl = "public, max-age=60 * 3";
    }

    Response response = chain.proceed(request);

    //设置response的Cache-Control,设置缓存时间
    return response.newBuilder()
        .header("Cache-Control", cacheControl)
        .removeHeader("Pragma")
        .build();
  }
}
