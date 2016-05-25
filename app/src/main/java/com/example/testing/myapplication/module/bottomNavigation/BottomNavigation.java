package com.example.testing.myapplication.module.bottomNavigation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.testing.myapplication.util.LogUtil;

/**
 * author: baiiu
 * date: on 16/5/23 20:06
 * description:
 */
public class BottomNavigation extends LinearLayout implements View.OnClickListener {
  private OnTabSelectedListener onTabSelectedListener;

  private int lastPosition = -1;

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

  public void setBottomTab(MainTab[] mainTabs, int selectedPosition) {
    generateTabs(mainTabs);
    setSelection(selectedPosition);
  }

  private void generateTabs(MainTab[] mainTabs) {
    for (int i = 0; i < mainTabs.length; ++i) {

      MainTab mainTab = mainTabs[i];

      /*
        create View
       */
      TextView textView = new TextView(getContext());
      textView.setText(mainTab.getText());
      textView.setCompoundDrawablesWithIntrinsicBounds(0, mainTab.getResourceId(), 0, 0);
      textView.setGravity(Gravity.CENTER);

      //添加小红点
      View view = mainTab.isHasRedDot() ? new BadgeView(getContext()).attachTo(textView) : textView;

      /*
        add View
       */
      view.setOnClickListener(this);
      view.setTag(i);

      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1);
      layoutParams.gravity = Gravity.CENTER;
      addView(view, layoutParams);
    }
  }

  public void setTabRed(MainTab mainTab, int count) {
    if (!mainTab.isHasRedDot()) {
      return;
    }

    MainTab[] values = MainTab.values();
    int position = 0;
    do {
      if (mainTab == values[position]) {
        break;
      }
      position++;
    } while (position < values.length);

    LogUtil.d(position);

    ((BadgeView) ((ViewGroup) getChildAt(position)).getChildAt(1)).setBadgeCount(count);
  }

  @Override public void onClick(View v) {
    // TODO: 16/5/24 可以全部改为MainTab,你应该去思考用哪种好
    int tag = (int) v.getTag();
    setSelection(tag);
    if (onTabSelectedListener != null) {
      onTabSelectedListener.onTabSelected(tag);
    }
  }

  public interface OnTabSelectedListener {
    void onTabSelected(int position);
  }

  public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
    this.onTabSelectedListener = onTabSelectedListener;
  }

  public void setSelection(int position) {
    if (position == lastPosition) {
      return;
    }

    getChildTextView(position).setSelected(true);

    if (lastPosition != -1) {
      getChildTextView(lastPosition).setSelected(false);
    }

    lastPosition = position;
  }

  private TextView getChildTextView(int position) {
    View childAt = getChildAt(position);

    //单一TextView
    if (childAt instanceof TextView) {
      return (TextView) childAt;
    } else {
      return (TextView) ((ViewGroup) childAt).getChildAt(0);
    }
  }

  @Override protected Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("parcelable", super.onSaveInstanceState());
    bundle.putInt("lastPosition", lastPosition);
    return bundle;
  }

  @Override protected void onRestoreInstanceState(Parcelable state) {
    if (state instanceof Bundle) {
      Bundle bundle = (Bundle) state;
      lastPosition = bundle.getInt("lastPosition");
      state = bundle.getParcelable("parcelable");
    }
    super.onRestoreInstanceState(state);
  }
}
