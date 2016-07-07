package com.example.testing.myapplication.module.animator;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/7/7 10:27
 * description:
 */
public class AnimatorFragment extends Fragment {

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animator, container, false);

        return view;
    }


    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ValueAnimator animator = ValueAnimator.ofFloat(0, 5F);
        animator.setDuration(300);
        //生成数列
        animator.setInterpolator(new LinearInterpolator());

        //转化为当前可用的距离
        animator.setEvaluator(new FloatEvaluator());

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override public void onAnimationUpdate(ValueAnimator animation) {

                float animatedFraction = animation.getAnimatedFraction();
                Object animatedValue = animation.getAnimatedValue();
                long duration = animation.getCurrentPlayTime();

                //LogUtil.d(duration + ", " + animatedFraction + ", " + animatedValue);
            }
        });

        animator.start();

    }

}
