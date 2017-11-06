package com.example.lorence.vel1.ui.views;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lorence.vel1.R;

/**
 * Created by lorence on 06/11/2017.
 * @Run: CircleLoading.java
 * => Done
 *
 * @Run: https://stackoverflow.com/questions/22779422/custom-view-extending-relative-layout
 * => Done
 *
 * @Run: https://github.com/tommybuonomo/andrui/blob/master/loading-animations/circleloadingsample/circleloading/src/main/java/com/tbuonomo/circleloading/CircleLoading.java
 *
 */

public class CircleLoading extends RelativeLayout{

    /**
     * @Run: https://www.google.com.vn/search?q=inner+and+outer+photoshop&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjr0KqAuqnXAhWLGZQKHWv6BrkQ_AUICigB&biw=1855&bih=966
     * => Understand: Done
     */
    private static final int DEFAULT_DURATION = 500;
    private static final int DEFAULT_INNER_ALPHA = 255;
    private static final int DEFAULT_OUTER_ALPHA = 120;

    public CircleLoading(Context context) {
        super(context);
    }

    public CircleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     *
     * @Run: https://developer.android.com/reference/android/util/AttributeSet.html
     * => READ: Done
     * @Run: https://www.google.com.vn/search?biw=1855&bih=966&tbm=isch&sa=1&ei=VxQAWojAIsiH8wWR8ZSQDg&q=attributeset+android+demo&oq=attributeset+android+demo&gs_l=psy-ab.3...31819.32736.0.33040.6.6.0.0.0.0.108.520.3j3.6.0....0...1.1.64.psy-ab..0.2.212...0i24k1.0.fqWLLdX0LkI#imgrc=6KykW3ej477Z6M:
     * => Watch: DEMO
     * @Run: ...
     */
    public CircleLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * @Run: https://stackoverflow.com/questions/1470867/creating-custom-imageview
     * => Done
     */
    @SuppressLint("AppCompatCustomView")
    static class OuterCircle extends ImageView {

        public OuterCircle(Context context) {
            super(context);
            setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.outer_circle));
        }
    }

    @SuppressLint("AppCompatCustomView")
    static class InnerCircle extends ImageView {

        public InnerCircle(Context context) {
            super(context);
            setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.inner_circle));
        }
    }


    private void init(Context context, AttributeSet attrs) {
        OuterCircle mOuterCircle = null;
        InnerCircle mInnerCircle = null;

        /*
         * @Run: https://stackoverflow.com/questions/4585808/difference-between-declare-styleable-and-style
         * => Create style with name and format and value. => Array contains styles.
         */

        if (attrs != null) {
            @SuppressLint("Recycle") TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CircleLoading);
            int outerColor = a.getColor(R.styleable.CircleLoading_outerColor, -1); // Default value is returned -1
            int outerAlpha = a.getInt(R.styleable.CircleLoading_outerAlpha, -1); // Default value is returned -1
            if (outerColor != -1) {
                setUpCircleColors(mOuterCircle,
                        outerColor,
                        outerAlpha == -1 || outerAlpha < 0 || outerAlpha > 255 ?
                                DEFAULT_OUTER_ALPHA : outerAlpha);
            }

            int innerColor = a.getColor(R.styleable.CircleLoading_innerColor, -1);
            int innerAlpha = a.getInt(R.styleable.CircleLoading_innerAlpha, -1);
            if (innerColor != -1) {
                setUpCircleColors(mInnerCircle, innerColor,
                        innerAlpha == -1 || innerAlpha < 0 || innerAlpha > 255 ?
                                DEFAULT_INNER_ALPHA : innerAlpha);
            }

            int duration = a.getInt(R.styleable.CircleLoading_animationDuration, -1);
            setUpAnimators(duration == -1 || duration < 0 ? DEFAULT_DURATION : duration);

        }

    }

    private void setUpCircleColors(ImageView circle, int color, int alpha) {
        GradientDrawable gradientDrawable = (GradientDrawable) circle.getDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setAlpha(alpha);
    }

    private AnimatorSet mCircleAnimator;

    private void setUpAnimators(int duration) {
        AnimatorSet outerAnimatorSet = createCircleAnimation(mOuterCircle, true);
        AnimatorSet innerAnimatorSet = createCircleAnimation(mInnerCircle, false);
        outerAnimatorSet.setDuration(duration);
        innerAnimatorSet.setDuration(duration);

        mCircleAnimator = new AnimatorSet();
        mCircleAnimator.playTogether(outerAnimatorSet, innerAnimatorSet);

        mCircleAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mCircleAnimator.start();
            }
        });
    }

}
