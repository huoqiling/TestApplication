package com.example.testing.myapplication.module.bottomNavigation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * author: baiiu
 * date: on 16/5/23 20:06
 * description:
 */
public class BottomNavigation extends LinearLayout {
  public BottomNavigation(Context context) {
    this(context, null);
  }

  public BottomNavigation(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context);
  }

  private void init(Context context) {
    setOrientation(HORIZONTAL);
  }

  public void setBottomTab(MainTab[] mainTabs) {
    for (MainTab mainTab : mainTabs) {

      TextView textView = new TextView(getContext());
      textView.setText(mainTab.getText());
      textView.setCompoundDrawablesWithIntrinsicBounds(0, mainTab.getResourceId(), 0, 0);
      textView.setGravity(Gravity.CENTER);

      LayoutParams layoutParams = new LayoutParams(-2, -1);
      layoutParams.weight = 1;
      addView(textView, layoutParams);

      if (mainTab.isHasRedDot()) {
        new BadgeView(getContext()).attachTo(textView);
      }
    }
  }
}
