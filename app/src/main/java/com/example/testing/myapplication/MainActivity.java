package com.example.testing.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.testing.myapplication.fragments.RetrofitFragment;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportFragmentManager().beginTransaction().add(new RetrofitFragment(), "retrofit").commit();

    //String url = "https://api.github.com/users/baiiu";
    //OkHttpUtils.get().url(url).build().execute(new StringCallback() {
    //  @Override public void onError(Call call, Exception e) {
    //    LogUtil.d(e.toString());
    //  }
    //
    //  @Override public void onResponse(String response) {
    //    LogUtil.d(response);
    //  }
    //});
  }
}
