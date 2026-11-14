package com.kwad.components.ad.feed.widget;

import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.s.x;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e extends FrameLayout {

    /* renamed from: if, reason: not valid java name */
    private View f3if;
    private ImageView ig;
    private Animator ih;
    private com.kwad.sdk.widget.d ij;

    public e(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator cA() {
        View view = this.f3if;
        if (view == null || this.ig == null || this.f3if.getHeight() + view.getWidth() == 0 || this.ig.getHeight() + this.ig.getWidth() == 0) {
            return null;
        }
        Animator cB = cB();
        Animator a2 = a(this.ig, 100L, 16.0f);
        Animator cC = cC();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(cB, a2, cC);
        return animatorSet;
    }

    private Animator cB() {
        Animator c = c(this.f3if, com.kwad.sdk.c.a.a.a(getContext(), 128.0f));
        Animator c2 = c(this.ig, com.kwad.sdk.c.a.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(c, c2);
        return animatorSet;
    }

    private Animator cC() {
        Animator g = g(this.f3if);
        Animator g2 = g(this.ig);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(g, g2);
        return animatorSet;
    }

    private Animator g(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.o.m.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.f3if = findViewById(R.id.ksad_feed_shake_bg);
        this.ig = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.d dVar) {
        this.ij = dVar;
    }

    private e(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animator c(final View view, int i) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.h(view, e.this.ij);
            }
        });
        return animatorSet;
    }

    private e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        init(context);
    }

    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
            this.ih = null;
        }
        this.ig.post(new bg() { // from class: com.kwad.components.ad.feed.widget.e.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                e eVar = e.this;
                eVar.ih = eVar.cA();
                if (e.this.ih == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                } else {
                    e.this.ih.addListener(animatorListenerAdapter);
                    e.this.ih.start();
                }
            }
        });
    }

    private Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        Interpolator A4TApA2 = A2egSU.A4TApA(0.22f, 0.59f, 0.36f, 1.0f);
        this.ig.setPivotX(view.getWidth());
        this.ig.setPivotY(view.getHeight());
        Animator a2 = x.a(view, A4TApA2, 100L, 16.0f);
        Animator a3 = x.a(view, A4TApA2, 100L, 16.0f);
        Animator a4 = x.a(view, A4TApA2, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a2, a3, a4);
        return animatorSet;
    }
}
