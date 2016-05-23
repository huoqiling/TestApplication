package com.example.testing.myapplication.module.bottomNavigation;

import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/5/23 20:11
 * description:
 */
public enum MainTab {

  PROJECT(0, "项目", R.mipmap.ic_launcher, false),
  DISCOVER(1, "发现", R.mipmap.ic_launcher, false),
  MESSAGE(2, "消息", R.mipmap.ic_launcher, false),
  ME(3, "我的", R.mipmap.ic_launcher, false);

  private int position;
  private String text;
  private int resourceId;
  private boolean hasRedDot;

  MainTab(int position, String text, int resourceId, boolean hasRedDot) {
    this.position = position;
    this.text = text;
    this.resourceId = resourceId;
    this.hasRedDot = hasRedDot;
  }

  public int getPosition() {
    return position;
  }

  public String getText() {
    return text;
  }

  public int getResourceId() {
    return resourceId;
  }

  public boolean isHasRedDot() {
    return hasRedDot;
  }
}
