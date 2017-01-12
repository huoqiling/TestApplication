package com.example.testing.myapplication.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 17/1/12 20:55
 * description:
 */
public class LikeView extends ImageView {
    private static final OvershootInterpolator OVERSHOOT_INTERPOLATOR = new OvershootInterpolator(4);
    private static final long sBounceDuration = 500;

    private boolean isFavorite;

    public LikeView(Context context) {
        this(context, null);
    }

    public LikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LikeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LikeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        setImageResource(R.drawable.level_favorite);
    }


    public final void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
        updateFavoriteButton();
    }


    private void updateFavoriteButton() {
        float startBounce, endBounce;

        if (isFavorite) {
            //收藏
            startBounce = 0.2f;
            endBounce = 1.0f;
            getDrawable().setLevel(1);
        } else {
            //取消收藏
            getDrawable().setLevel(0);
            startBounce = 1.3f;
            endBounce = 1.0f;
        }

        ObjectAnimator bounceAnimX = ObjectAnimator.ofFloat(this, "scaleX", startBounce, endBounce);
        bounceAnimX.setDuration(sBounceDuration);
        bounceAnimX.setInterpolator(OVERSHOOT_INTERPOLATOR);


        ObjectAnimator bounceAnimY = ObjectAnimator.ofFloat(this, "scaleY", startBounce, endBounce);
        bounceAnimY.setDuration(sBounceDuration);
        bounceAnimY.setInterpolator(OVERSHOOT_INTERPOLATOR);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(bounceAnimX, bounceAnimY);

        animatorSet.start();
    }


}
