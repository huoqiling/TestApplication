package com.example.testing.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: baiiu
 * date: on 16/5/4 17:23
 * description:
 */
public class PaintStrokeView extends View {

  private Paint paint;
  private Paint anotherPaint;

  public PaintStrokeView(Context context) {
    this(context, null);
  }

  public PaintStrokeView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public PaintStrokeView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
    paint = new Paint();
    paint.setColor(Color.BLUE);
    paint.setStyle(Paint.Style.STROKE);
    paint.setAntiAlias(true);
    paint.setStrokeWidth(20);

    anotherPaint = new Paint();
    anotherPaint.setColor(Color.RED);
    anotherPaint.setStyle(Paint.Style.STROKE);
    anotherPaint.setAntiAlias(true);
    anotherPaint.setStrokeWidth(1);

  }

  @Override protected void onDraw(Canvas canvas) {
    canvas.drawCircle(500, 500, 300, paint);



    canvas.drawCircle(500, 500, 300, anotherPaint);

  }
}
