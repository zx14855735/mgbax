package com.sigmob.sdk.nativead;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f13600a;
    private ae b;
    private ae c;
    private long d;

    public af(ViewGroup viewGroup, ae aeVar, ae aeVar2, long j) {
        this.f13600a = viewGroup;
        this.b = aeVar;
        this.c = aeVar2;
        this.d = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f13600a.getLayoutParams();
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f13600a.setLayoutParams(layoutParams);
    }

    public void a() {
        final int i = 0;
        final int i2 = 1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13600a, "x", this.b.a(), this.c.a());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13600a, "y", this.b.b(), this.c.b());
        ValueAnimator ofInt = ValueAnimator.ofInt(this.b.c(), this.c.c());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.b.d(), this.c.d());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.sigmob.sdk.nativead.A4TApA

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ af f13573A4TApA;

            {
                this.f13573A4TApA = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        this.f13573A4TApA.b(valueAnimator);
                        break;
                    default:
                        this.f13573A4TApA.a(valueAnimator);
                        break;
                }
            }
        });
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.sigmob.sdk.nativead.A4TApA

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ af f13573A4TApA;

            {
                this.f13573A4TApA = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        this.f13573A4TApA.b(valueAnimator);
                        break;
                    default:
                        this.f13573A4TApA.a(valueAnimator);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt, ofInt2);
        animatorSet.setDuration(this.d);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f13600a.getLayoutParams();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f13600a.setLayoutParams(layoutParams);
    }
}
