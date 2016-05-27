package com.example.testing.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //getSupportFragmentManager().beginTransaction()
    //    .add(android.R.id.content, new MainFragment(), "mainFragemnt")
    //    .commit();

    //getSupportFragmentManager().beginTransaction().add(new RetrofitFragment(), "retrofit").commit();
    //okHttp();
  }

  public void onClick(View view) {
    Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
  }

  private void okHttp() {
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
