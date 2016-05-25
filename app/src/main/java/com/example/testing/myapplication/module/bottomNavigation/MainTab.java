package com.example.testing.myapplication.module.bottomNavigation;

import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/5/23 20:11
 * description:
 */
public enum MainTab {

  PROJECT("项目", R.drawable.level_main_tab, false),
  DISCOVER("发现", R.drawable.level_main_tab, true),
  MESSAGE("消息", R.drawable.level_main_tab, false),
  ME("我的", R.drawable.level_main_tab, true);

  private String text;
  private int resourceId;
  private boolean hasRedDot;

  MainTab(String text, int resourceId, boolean hasRedDot) {
    this.text = text;
    this.resourceId = resourceId;
    this.hasRedDot = hasRedDot;
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
