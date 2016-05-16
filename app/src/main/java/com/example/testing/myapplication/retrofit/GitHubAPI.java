package com.example.testing.myapplication.retrofit;

import com.example.testing.myapplication.bean.NewsColumns;
import com.example.testing.myapplication.bean.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * author: baiiu
 * date: on 16/5/16 14:40
 * description: github的API
 */
public interface GitHubAPI {

  @GET("users/{user}") Call<User> userInfo(@Path("user") String user);

  @GET Call<NewsColumns> newsColumns(@Url String url);
}
