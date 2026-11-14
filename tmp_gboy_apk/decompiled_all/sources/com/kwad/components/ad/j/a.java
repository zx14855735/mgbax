package com.kwad.components.ad.j;

import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    private View BT;
    private Button BU;
    private Button BV;
    private View Ha;
    private Runnable LY;
    private boolean LZ = false;
    private Animator ku;

    public a(View view) {
        this.Ha = view;
        initView();
    }

    private static Animator d(View view, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(A2egSU.A4TApA(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.BU = (Button) this.Ha.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.BV = (Button) this.Ha.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.BT = this.Ha.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void jf() {
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.BT.getHeight();
        int width = this.BT.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.ku == null) {
            Animator a2 = a(this.BV, this.BU, width, height, 1600L, 200L);
            this.ku = a2;
            a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.j.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.LZ) {
                        return;
                    }
                    if (a.this.LY == null) {
                        a.this.LY = new Runnable() { // from class: com.kwad.components.ad.j.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bw.a(a.this.LY, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.ku.isStarted());
        if (!this.ku.isStarted()) {
            com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.ku.start();
        }
        this.LZ = false;
    }

    public final void lk() {
        nP();
    }

    public final void nP() {
        Animator animator = this.ku;
        if (animator != null) {
            animator.cancel();
            this.ku.removeAllListeners();
            this.LZ = true;
        }
        Runnable runnable = this.LY;
        if (runnable != null) {
            bw.c(runnable);
            this.LY = null;
        }
    }

    public final void nQ() {
        this.LZ = true;
    }

    private static Animator a(final View view, View view2, int i, int i2, long j, long j2) {
        Animator d = d(view, 200L);
        float f = i;
        float f2 = i2;
        Animator a2 = a(view2, f, f2, 200L);
        a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.j.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator d2 = d(view2, 200L);
        Animator a3 = a(view, f, f2, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(d, a2, ofFloat, d2, a3);
        return animatorSet;
    }

    private static Animator a(final View view, float f, final float f2, long j) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(A2egSU.A4TApA(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.j.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3 * floatValue;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = (floatValue / f5) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f6);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f4;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }
}
