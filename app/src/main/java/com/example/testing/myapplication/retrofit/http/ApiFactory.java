package com.example.testing.myapplication.retrofit.http;

import com.example.testing.myapplication.retrofit.GitHubAPI;

/**
 * author: baiiu
 * date: on 16/5/16 17:42
 * description:
 */
public enum ApiFactory {
  INSTANCE;

  private final GitHubAPI gitHubAPI;

  ApiFactory() {
    gitHubAPI = RetrofitClient.INSTANCE.getRetrofit().create(GitHubAPI.class);
  }

  public GitHubAPI gitHubAPI() {
    return gitHubAPI;
  }
}
