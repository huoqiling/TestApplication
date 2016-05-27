package com.example.testing.myapplication.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.util.CommonUtil;
import com.example.testing.myapplication.util.LogUtil;

/**
 * author: baiiu
 * date: on 16/5/27 11:46
 * description:
 */
public class Avatar extends FrameLayout {

  //圆角
  private static final int ROUND_RADIUS = 30;

  //描边
  private static final int STROKE_WIDTH = 1;

  private ImageView mImageView;
  private TextView mTextView;

  private Paint mPaint;
  private Paint mStrokePaint;

  public Avatar(Context context) {
    this(context, null);
  }

  public Avatar(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public Avatar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public Avatar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context);
  }

  private void init(Context context) {
    inflate(context, R.layout.layout_avatar, this);
    setWillNotDraw(false);

    mStrokePaint = new Paint();
    mStrokePaint.setAntiAlias(true);
    mStrokePaint.setStyle(Paint.Style.STROKE);
    mStrokePaint.setColor(getResources().getColor(R.color.color_e7e7e7));

    //调整strokeWidth的话宽度修改为FILL
    //mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));

  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    mImageView = (ImageView) findViewById(R.id.company_avatar);
    mTextView = (TextView) findViewById(R.id.company_name);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int widthSize = MeasureSpec.getSize(widthMeasureSpec);

    int resultSize;

    if (widthMode == MeasureSpec.EXACTLY) {
      resultSize = widthSize + STROKE_WIDTH;
    } else {
      resultSize = (int) (getResources().getDisplayMetrics().density * 30) + STROKE_WIDTH;
    }

    setMeasuredDimension(resultSize, resultSize);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    LogUtil.d(getMeasuredWidth() + ",  " + getMeasuredHeight());

    RectF rect = new RectF();

    //描边
    rect.left = 0;
    rect.top = 0;
    rect.right = getMeasuredWidth();
    rect.bottom = getMeasuredHeight();
    canvas.drawRoundRect(rect, ROUND_RADIUS, ROUND_RADIUS, mStrokePaint);

    //头像
    if (mPaint != null) {
      rect.left = rect.left + STROKE_WIDTH;
      rect.top = rect.top + STROKE_WIDTH;
      rect.right = rect.right - STROKE_WIDTH;
      rect.bottom = rect.bottom - STROKE_WIDTH;
      canvas.drawRoundRect(rect, ROUND_RADIUS, ROUND_RADIUS, mPaint);
    }
  }

  public void setAvatar(String avatar) {

    if (CommonUtil.isEmpty(avatar)) {
      mTextView.setVisibility(VISIBLE);
      mImageView.setVisibility(GONE);

      //文本
      setText(avatar);

      mPaint = new Paint();
      mPaint.setColor(Color.WHITE);
      mPaint.setStyle(Paint.Style.FILL);
      mPaint.setAntiAlias(true);

      postInvalidate();
    } else {
      mTextView.setVisibility(GONE);
      mImageView.setVisibility(VISIBLE);
    }
  }

  public void setText(String text) {
    String name = text;
    if (text.length() > 2) {
      name = text.substring(0, 2);
    }

    mTextView.setText(name);
  }
}
