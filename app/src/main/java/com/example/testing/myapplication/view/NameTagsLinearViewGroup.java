package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.bean.Sign;
import com.example.testing.myapplication.util.CommonUtil;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/10/27 11:36
 * description:
 */
public class NameTagsLinearViewGroup extends ViewGroup {
    public static final int MIN_WIDTH = 500;

    public NameTagsLinearViewGroup(Context context) {
        super(context);
    }

    public NameTagsLinearViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NameTagsLinearViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NameTagsLinearViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    public void setListSigns(String name, List<Sign> list) {
        removeAllViews();

        if (!TextUtils.isEmpty(name)) {
            TextView textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(15);
            @ColorInt int color = getResources().getColor(R.color.promptcolor_969fa9);
            textView.setTextColor(color);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setText(name);

            char[] chars = { '\u2026' };
            float measureText = textView.getPaint()
                    .measureText("哈哈哈哈哈哈哈哈" + new String(chars));

            //LogUtil.d("measureText: " + measureText);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
            params.rightMargin = 9;
            addView(textView, params);
        }

        if (CommonUtil.isEmpty(list)) {
            return;
        }

        for (Sign sign : list) {
            if (sign == null) {
                continue;
            }

            if (TextUtils.isEmpty(sign.name)) {
                continue;
            }

            try {
                TextView textView = new TextView(getContext());
                textView.setText(sign.name);
                textView.setBackgroundDrawable(new ColorDrawable(Color.parseColor(sign.color)));
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(10);
                textView.setSingleLine();
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setPadding(9, 0, 9, 0);
                textView.setGravity(Gravity.CENTER);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, 45);
                params.leftMargin = 15;
                addView(textView, params);
            } catch (Exception e) {
                //LogUtil.e(e.toString());
            }
        }
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 为wrap_content时，该宽度总是和父控件宽度一致
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int childTotalWidth = 0;
        int childMaxHeight = 0;
        int tagsTotalWidth = 0;//标签所占用位置+nameTextView.rightMargin

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            if (child == null || child.getVisibility() == GONE) {
                continue;
            }

            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            childTotalWidth += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;

            if (i == 0) {
                tagsTotalWidth += lp.rightMargin;
            } else {
                tagsTotalWidth += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }

            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            childMaxHeight = Math.max(childMaxHeight, childHeight);
        }


        if (childTotalWidth > widthSize) {
            TextView nameTextView = (TextView) getChildAt(0);
            int nameTextSpaceWidth = widthSize - tagsTotalWidth;//名字可用空间

            /*
                有三种情况：名字特别长 或者 标签特别长 或者 标签名字都特别长
             */
            if (nameTextSpaceWidth < MIN_WIDTH) {
                //标签占用了名字的空间
                nameTextView.setMinWidth(MIN_WIDTH);
            } else {
                nameTextView.setMaxWidth(nameTextSpaceWidth);
            }
        }

        //LogUtil.d(
        //        widthSize + ", " + childTotalWidth + ", " + heightSize + ", " + childMaxHeight + ", " + tagsTotalWidth);

        setMeasuredDimension(

                widthMode == MeasureSpec.EXACTLY ? widthSize : Math.min(childTotalWidth, widthSize) +
                        getPaddingLeft() + getPaddingRight(),

                heightMode == MeasureSpec.EXACTLY ? heightSize : childMaxHeight + getPaddingTop() + getPaddingBottom()

        );
    }


    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int childLeft = getPaddingLeft(); //child距离左边
        int parentCanUsedWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        final int height = b - t;

        int childTop;//居中
        int childCount = getChildCount();
        int i = 0;

        for (; i < childCount; i++) {
            View child = getChildAt(i);

            if (child == null || child.getVisibility() == GONE) {
                continue;
            }

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            int childHeight = child.getMeasuredHeight();
            childTop = (height - childHeight) / 2 + lp.topMargin - lp.bottomMargin;
            childLeft += lp.leftMargin;

            int nextNodeToLeft = child.getMeasuredWidth();

            //LogUtil.d(childLeft + ", " + nextNodeToLeft + ", " + parentCanUsedWidth);

            if (childLeft + nextNodeToLeft > parentCanUsedWidth) {
                break;
            }

            setChildFrame(child, childLeft, childTop, child.getMeasuredWidth(), childHeight);
            childLeft += child.getMeasuredWidth() + lp.rightMargin;

        }

        //LogUtil.d(i + ", " + childCount + ", " + getChildCount());
    }

    private void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
    }

}
