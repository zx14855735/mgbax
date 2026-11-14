package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private static float f13299a = 0.0f;
    private static final int b = 1700;
    private j c;
    private j d;
    private j e;

    public i(Context context) {
        super(context);
        a();
    }

    private void a() {
        f13299a = Dips.dipsToIntPixels(6.0f, getContext());
        j jVar = new j(getContext());
        this.c = jVar;
        addView(jVar, new ViewGroup.LayoutParams(-1, -1));
        j jVar2 = new j(getContext());
        this.d = jVar2;
        addView(jVar2, new ViewGroup.LayoutParams(-1, -1));
        j jVar3 = new j(getContext());
        this.e = jVar3;
        jVar3.a(true);
        addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        a(this.c, 0);
        a(this.d, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void a(final j jVar, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jVar, "translationY", 0.0f, Dips.dipsToIntPixels(-30.0f, getContext()));
        ofFloat.setDuration(1700L);
        long j = i;
        ofFloat.setStartDelay(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(jVar, "alpha", 1.0f, 0.1f);
        ofFloat2.setDuration(1700L);
        ofFloat2.setStartDelay(j);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(f13299a, Dips.dipsToIntPixels(1.0f, getContext()));
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.i.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                jVar.setLineWidth(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat3.setDuration(1360L);
        ofFloat3.setStartDelay(j + 340);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.i.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
