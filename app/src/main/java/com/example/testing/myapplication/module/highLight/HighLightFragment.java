package com.example.testing.myapplication.module.highLight;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.testing.myapplication.R;

/**
 * auther: baiiu
 * time: 16/9/7 07 23:24
 * description:
 */
public class HighLightFragment extends Fragment {


    private String string05;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_highlight, container, false);

        TextView textView01 = (TextView) view.findViewById(R.id.text01);
        TextView textView02 = (TextView) view.findViewById(R.id.text02);
        TextView textView03 = (TextView) view.findViewById(R.id.text03);
        TextView textView04 = (TextView) view.findViewById(R.id.text04);
        textView05 = (TextView) view.findViewById(R.id.text05);
        TextView textView06 = (TextView) view.findViewById(R.id.text06);
        TextView textView07 = (TextView) view.findViewById(R.id.text07);
        String string01 = textView01.getText()
                .toString();
        String string02 = textView02.getText()
                .toString();
        String string03 = textView03.getText()
                .toString();
        String string04 = textView04.getText()
                .toString();
        string05 = textView05.getText()
                .toString();

        String string06 = textView06.getText()
                .toString();

        foregroundSizeTypeFaceUnderline(textView01, string01);
        foregroundSizeTypeFaceStrikeThrough(textView03, string03, textView04, string04);
        urlSpan(textView02, string02);
        backgroundSpanAndClickSpan(textView06, string06);
        SuperscriptAndSubscriptSpanSpan(textView07);

        textView05.postDelayed(runnable, 150);

        return view;
    }


    private void foregroundSizeTypeFaceUnderline(TextView textView01, String string01) {
        SpannableString spannableString01 = new SpannableString(string01);

        ForegroundColorSpan colorSpan01 = new ForegroundColorSpan(Color.parseColor("#0099FF"));
        spannableString01.setSpan(colorSpan01, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(5f);
        spannableString01.setSpan(sizeSpan01, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        StyleSpan styleSpan01 = new StyleSpan(Typeface.BOLD);
        spannableString01.setSpan(styleSpan01, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        UnderlineSpan underlineSpan02 = new UnderlineSpan();
        spannableString01.setSpan(underlineSpan02, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        textView01.setText(spannableString01);
    }

    // 上下标和布局有关系
    private void foregroundSizeTypeFaceStrikeThrough(TextView textView03, String string03, TextView textView04,
            String string04) {
        SpannableString spannableString03 = new SpannableString(string03);

        ForegroundColorSpan colorSpan03 = new ForegroundColorSpan(Color.parseColor("#EE0000"));
        spannableString03.setSpan(colorSpan03, 0, spannableString03.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(3f);
        spannableString03.setSpan(sizeSpan03, 1, spannableString03.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        StyleSpan styleSpan03 = new StyleSpan(Typeface.BOLD);
        spannableString03.setSpan(styleSpan03, 1, spannableString03.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView03.setText(spannableString03);


        SpannableString spannableString04 = new SpannableString(string04);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString04.setSpan(strikethroughSpan, 0, spannableString04.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView04.setText(spannableString04);
    }

    private void urlSpan(TextView textView02, String string02) {
        SpannableString spannableString02 = new SpannableString(string02);

        URLSpan urlSpan = new URLSpan("http://www.jianshu.com/users/dbae9ac95c78");
        textView02.setHighlightColor(Color.parseColor("#16646464"));
        spannableString02.setSpan(urlSpan, 9, spannableString02.length() - 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan colorSpan02 = new ForegroundColorSpan(Color.parseColor("#0099FF"));
        spannableString02.setSpan(colorSpan02, 9, spannableString02.length() - 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView02.setText(spannableString02);
        textView02.setMovementMethod(LinkMovementMethod.getInstance());
    }


    private void backgroundSpanAndClickSpan(TextView textView06, String string06) {
        SpannableString spannableString06 = new SpannableString(string06);
        ClickableSpan clickableSpan = new MyClickableSpan("123456789");
        ForegroundColorSpan colorSpan04 = new ForegroundColorSpan(Color.parseColor("#FFFFFF"));
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#0099EE"));
        spannableString06.setSpan(colorSpan04, 2, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString06.setSpan(clickableSpan, 2, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString06.setSpan(backgroundColorSpan, 2, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView06.setText(spannableString06);
        textView06.setMovementMethod(LinkMovementMethod.getInstance());
    }


    private void SuperscriptAndSubscriptSpanSpan(TextView textView07) {
        SpannableString spannableString07 = new SpannableString("22 + 32 = 13");
        SuperscriptSpan superscriptSpan01 = new SuperscriptSpan();
        SubscriptSpan superscriptSpan02 = new SubscriptSpan();
        spannableString07.setSpan(superscriptSpan01, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString07.setSpan(superscriptSpan02, 6, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        RelativeSizeSpan sizeSpan05 = new RelativeSizeSpan(0.5f);
        RelativeSizeSpan sizeSpan06 = new RelativeSizeSpan(0.5f);
        spannableString07.setSpan(sizeSpan05, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString07.setSpan(sizeSpan06, 6, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        textView07.setText(spannableString07);
    }

    private int position = 0;
    private TextView textView05;

    Runnable runnable = new Runnable() {
        @Override public void run() {
            SpannableString spannableString = new SpannableString(string05);

            RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.2f);
            spannableString.setSpan(sizeSpan, position, position + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            textView05.setText(spannableString);
            position++;
            if (position >= textView05.getText()
                    .toString()
                    .length()) {
                position = 0;
            }

            textView05.postDelayed(this, 150);
        }
    };

}
