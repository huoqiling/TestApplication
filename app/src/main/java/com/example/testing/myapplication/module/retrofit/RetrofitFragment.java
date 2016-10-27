package com.example.testing.myapplication.module.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.example.testing.myapplication.bean.GankIODay;
import com.example.testing.myapplication.bean.GankIOHistory;
import com.example.testing.myapplication.bean.Repo;
import com.example.testing.myapplication.bean.User;
import com.example.testing.myapplication.retrofit.http.ApiFactory;
import com.example.testing.myapplication.util.LogUtil;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * auther: baiiu
 * time: 16/5/16 16 22:43
 * description:
 */
public class RetrofitFragment extends Fragment {

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        normalGet();
        //getWithParams();
        //post();

        //anotherUrl();
        //getOneDay();
    }

    private void normalGet() {
        HashMap<String, String> map = new HashMap<>();
        //map.put("key", "呵呵呵");
        //map.put("key1", "呵呵呵");
        //map.put("key2", "呵呵呵");
        //map.put("key3", "呵呵呵");
        //LogUtil.d(map.toString());

        Call<User> userCall = ApiFactory.INSTANCE.gitHubAPI()
                .userInfo("baiiu", map);

        userCall.enqueue(new Callback<User>() {
            @Override public void onResponse(Call<User> call, Response<User> response) {
                User body = response.body();
                LogUtil.d(body == null ? "body == null" : body.toString());
            }

            @Override public void onFailure(Call<User> call, Throwable t) {
                if (call.isCanceled()) {
                    LogUtil.d("the call is canceled , " + toString());
                } else {
                    LogUtil.e(t.toString());
                }
            }
        });

        //userCall.cancel();
    }

    private void getWithParams() {
        ApiFactory.INSTANCE.gitHubAPI()
                .listRepos("baiiu")
                .enqueue(new Callback<List<Repo>>() {
                    @Override public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        List<Repo> body = response.body();
                        LogUtil.d(body == null ? "body == null" : body.toString());
                    }

                    @Override public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }
                });
    }

    private void post() {
        ApiFactory.INSTANCE.gitHubAPI()
                .createUser(new User())
                .enqueue(new Callback<User>() {
                    @Override public void onResponse(Call<User> call, Response<User> response) {
                        User body = response.body();
                        LogUtil.d(body == null ? "body == null" : body.toString());
                    }

                    @Override public void onFailure(Call<User> call, Throwable t) {
                        LogUtil.d(t.toString());
                    }
                });
    }

    private void anotherUrl() {
        String s = "http://gank.io/api/day/history";
        ApiFactory.INSTANCE.gitHubAPI()
                .gankIOHistory(s)
                .enqueue(new Callback<GankIOHistory>() {
                    @Override public void onResponse(Call<GankIOHistory> call, Response<GankIOHistory> response) {
                        GankIOHistory body = response.body();
                        LogUtil.d(body == null ? "body == null" : body.toString());
                    }

                    @Override public void onFailure(Call<GankIOHistory> call, Throwable t) {
                        LogUtil.e("anotherUrl ," + t.toString());
                    }
                });
    }

    private void getOneDay() {
        String s = "http://gank.io/api/day/2015/08/07";
        ApiFactory.INSTANCE.gitHubAPI()
                .getOneDay(s)
                .enqueue(new Callback<GankIODay>() {
                    @Override public void onResponse(Call<GankIODay> call, Response<GankIODay> response) {
                        GankIODay body = response.body();
                        LogUtil.d(body == null ? "body == null" : body.toString());
                    }

                    @Override public void onFailure(Call<GankIODay> call, Throwable t) {
                        LogUtil.e("getOneDay ," + t.toString());
                    }
                });
    }
}
