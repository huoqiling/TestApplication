package com.example.testing.myapplication.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * 获得屏幕相关的辅助类
 */
public class ScreenUtil {
    private ScreenUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // @formatter:off
    /**
     * 获得屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕高度
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获得状态栏的高度
     */
    private static int mStatusHeight = -1;

    public static int getStatusHeight(Context context) {

        if (mStatusHeight != -1) {
            return mStatusHeight;
        }


        try {
            //            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            //            Object object = clazz.newInstance();
            //            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            //            mStatusHeight = context.getResources().getDimensionPixelSize(height);
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                mStatusHeight = context.getResources().getDimensionPixelSize(resourceId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mStatusHeight;
    }


    private static int mActionBarHeight = -1;

    public static int getActionBarHeight(Context context) {

        if (mActionBarHeight != -1) {
            return mActionBarHeight;
        }

        TypedArray typedArray = context.obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        mActionBarHeight = (int) typedArray.getDimension(0, 0);
        typedArray.recycle();

        return mActionBarHeight;
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        Bitmap bmp = view.getDrawingCache();
        if (bmp == null) {
            return null;
        }

        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Bitmap bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, bmp.getWidth(), bmp.getHeight() - statusBarHeight);
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);

        return bp;
    }

    /**
     * 已绘制出来，不需要自己测量
     */
    @Nullable  public static Bitmap createBitmapWhenMeasured(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();


        // 这种方法drawingCache可能为null
        //Bitmap drawingCache = view.getDrawingCache();
        //if(drawingCache == null){
        //    return null;
        //}
        //Bitmap bitmap = Bitmap.createBitmap(drawingCache, 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        //
        //view.setDrawingCacheEnabled(false);
        //view.destroyDrawingCache();



        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        //画背景，避免为黑色
        Drawable bgDrawable = view.getBackground();

        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }

        view.draw(canvas);

        return bitmap;
    }

    // @formatter:on

}