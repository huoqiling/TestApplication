package com.example.testing.myapplication.module.highLight;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.example.testing.myapplication.util.LogUtil;

/**
 * auther: baiiu
 * time: 16/9/24 24 09:13
 * description:
 */

public class MyClickableSpan extends ClickableSpan {
    private String content;

    public MyClickableSpan(String content) {
        this.content = content;
    }

    @Override public void updateDrawState(TextPaint ds) {
        ds.setUnderlineText(false);
    }

    @Override public void onClick(View widget) {
        LogUtil.d("点击了: " + content);
    }
}