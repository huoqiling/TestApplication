package com.example.testing.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.testing.myapplication.bean.NewsColumns;
import com.example.testing.myapplication.bean.User;
import com.example.testing.myapplication.retrofit.http.ApiFactory;
import com.example.testing.myapplication.util.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ApiFactory.INSTANCE.gitHubAPI().userInfo("baiiu").enqueue(new Callback<User>() {
      @Override public void onResponse(Call<User> call, Response<User> response) {
        LogUtil.d(response.body().toString());
      }

      @Override public void onFailure(Call<User> call, Throwable t) {

      }
    });

    String s = "https://rong.36kr.com/api/mobi/news/columns?version=4";
    ApiFactory.INSTANCE.gitHubAPI().newsColumns(s).enqueue(new Callback<NewsColumns>() {
      @Override public void onResponse(Call<NewsColumns> call, Response<NewsColumns> response) {
        LogUtil.d(response.body().data.column.get(0).toString());
        LogUtil.d(call.request().method());
      }

      @Override public void onFailure(Call<NewsColumns> call, Throwable t) {
        LogUtil.e(t.toString());
      }
    });
  }
}
