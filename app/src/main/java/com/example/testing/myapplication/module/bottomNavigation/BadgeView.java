/*
 * BadgeView.java
 * BadgeView
 * 
 * Copyright (c) 2012 Stefan Jauker.
 * https://github.com/kodex83/BadgeView
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.testing.myapplication.module.bottomNavigation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class BadgeView extends TextView {

  private boolean mHideOnNull = true;

  public BadgeView(Context context) {
    this(context, null);
  }

  public BadgeView(Context context, AttributeSet attrs) {
    this(context, attrs, android.R.attr.textViewStyle);
  }

  public BadgeView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    init();
  }

  private void init() {
    if (!(getLayoutParams() instanceof LayoutParams)) {
      LayoutParams layoutParams =
          new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
              Gravity.RIGHT | Gravity.TOP);
      setLayoutParams(layoutParams);
    }

    // set default font
    setTextColor(Color.WHITE);
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
    setPadding(dip2Px(5), dip2Px(1), dip2Px(5), dip2Px(1));

    // set default background
    setBackground(9, Color.parseColor("#d3321b"));

    setGravity(Gravity.CENTER);

    // default values
    setHideOnNull(true);
    setBadgeCount(0);
  }

  public void setBackground(int dipRadius, int badgeColor) {
    int radius = dip2Px(dipRadius);
    float[] radiusArray =
        new float[] { radius, radius, radius, radius, radius, radius, radius, radius };

    RoundRectShape roundRect = new RoundRectShape(radiusArray, null, null);
    ShapeDrawable bgDrawable = new ShapeDrawable(roundRect);
    bgDrawable.getPaint().setColor(badgeColor);
    setBackgroundDrawable(bgDrawable);
  }

  /**
   * @return Returns true if view is hidden on badge value 0 or null;
   */
  public boolean isHideOnNull() {
    return mHideOnNull;
  }

  /**
   * @param hideOnNull the hideOnNull to set
   */
  public void setHideOnNull(boolean hideOnNull) {
    mHideOnNull = hideOnNull;
    setText(getText());
  }

  /*
   * (non-Javadoc)
   *
   * @see android.widget.TextView#setText(java.lang.CharSequence, android.widget.TextView.BufferType)
   */
  @Override public void setText(CharSequence text, BufferType type) {
    if (isHideOnNull() && (text == null || text.toString().equalsIgnoreCase("0"))) {
      setVisibility(View.GONE);
    } else {
      setVisibility(View.VISIBLE);
    }
    super.setText(text, type);
  }

  public void setBadgeCount(int count) {
    setText(String.valueOf(count));
  }

  public void setBadgeGravity(int gravity) {
    LayoutParams params = (LayoutParams) getLayoutParams();
    params.gravity = gravity;
    setLayoutParams(params);
  }

  public void setBadgeMargin(int dipMargin) {
    setBadgeMargin(dipMargin, dipMargin, dipMargin, dipMargin);
  }

  public void setBadgeMargin(int leftDipMargin, int topDipMargin, int rightDipMargin,
      int bottomDipMargin) {
    LayoutParams params = (LayoutParams) getLayoutParams();
    params.leftMargin = dip2Px(leftDipMargin);
    params.topMargin = dip2Px(topDipMargin);
    params.rightMargin = dip2Px(rightDipMargin);
    params.bottomMargin = dip2Px(bottomDipMargin);
    setLayoutParams(params);
  }

  /**
   * 创造Container,包裹TextView
   */
  public View attachTo(View target) {
    if (target == null) {
      return null;
    }

    //alone self
    if (getParent() != null) {
      ((ViewGroup) getParent()).removeView(this);
    }

    // use a new Framelayout container for adding badge

    FrameLayout badgeContainer = new FrameLayout(getContext());

    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = Gravity.CENTER;
    badgeContainer.addView(target, layoutParams);
    badgeContainer.addView(this);

    return badgeContainer;
  }

  /*
   * converts dip to px
   */
  private int dip2Px(float dip) {
    return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
  }
}
