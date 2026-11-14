package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShakeButton extends Button {
    private ValueAnimator xj;

    public ShakeButton(Context context) {
        super(context);
    }

    private void xj() {
        ValueAnimator valueAnimator = this.xj;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.xj.removeAllListeners();
            this.xj.removeAllUpdateListeners();
            this.xj = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.xj = ofFloat;
        ofFloat.setDuration(1300L);
        this.xj.setInterpolator(new LinearInterpolator());
        this.xj.setRepeatCount(-1);
        this.xj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShakeButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                ShakeButton.this.setRotation((float) (Math.cos(animatedFraction * 10.0f * 3.141592653589793d) * (1.0f - animatedFraction) * 6.0f));
            }
        });
        this.xj.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShakeButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationEnd(animator);
                ShakeButton.this.setRotation(6.0f);
            }
        });
        this.xj.start();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xj();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.xj;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.xj.removeAllListeners();
            this.xj.removeAllUpdateListeners();
            this.xj = null;
        }
    }
}
