package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d extends FrameLayout {
    private int count;
    private ImageView hW;
    private ImageView hX;
    private ImageView hY;
    private Animator hZ;
    private Animator ia;
    private Animation ib;
    private Animation ic;

    public d(Context context) {
        this(context, null);
    }

    private void B(Context context) {
        com.kwad.sdk.o.m.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.hW = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.hX = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.hY = (ImageView) findViewById(R.id.ksad_hand);
    }

    private void cz() {
        this.hZ = e(this.hY);
        this.ia = f(this.hY);
        this.ib = a(this.hW, 0.45f, com.kwad.sdk.c.a.a.a(getContext(), 34.0f));
        this.ic = a(this.hX, 0.5f, com.kwad.sdk.c.a.a.a(getContext(), 50.0f));
        this.hZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.hW.startAnimation(d.this.ib);
                d.this.hX.startAnimation(d.this.ic);
                d.this.ia.start();
            }
        });
        this.ia.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.hZ.start();
            }
        });
    }

    public static /* synthetic */ int f(d dVar) {
        int i = dVar.count;
        dVar.count = i + 1;
        return i;
    }

    public final void cx() {
        cz();
        this.hZ.start();
    }

    public final void cy() {
        Animator animator = this.hZ;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.ia;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.ib;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.ic;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private d(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animation a(final View view, float f, int i) {
        float a2 = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, 0.0f);
        float f2 = i / a2;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.widget.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return animationSet;
    }

    private Animator e(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.sigmob.sdk.base.common.a.B, 0.0f, -10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private Animator f(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.sigmob.sdk.base.common.a.B, -10.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.count = 0;
        B(context);
    }
}
