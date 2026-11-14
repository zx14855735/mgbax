package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements Animator.AnimatorListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f9488A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f9489A4TApA;

    public A4TApA(ADYaiT aDYaiT, A5SV6n a5SV6n) {
        this.f9489A4TApA = aDYaiT;
        this.f9488A2egSU = a5SV6n;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        ADYaiT aDYaiT = this.f9489A4TApA;
        A5SV6n a5SV6n = this.f9488A2egSU;
        aDYaiT.A2egSU(1.0f, a5SV6n, true);
        a5SV6n.f9499AaHO0E = a5SV6n.AMqCpz;
        a5SV6n.f9500AcNBzu = a5SV6n.f9494ARc23Z;
        a5SV6n.f9501AlLFFp = a5SV6n.f9495ASJ6gh;
        a5SV6n.A2egSU((a5SV6n.f9498AZkASS + 1) % a5SV6n.f9497AZOQYO.length);
        if (!aDYaiT.f9518B2KMhB) {
            aDYaiT.f9517B25kr6 += 1.0f;
            return;
        }
        aDYaiT.f9518B2KMhB = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (a5SV6n.f9502AmA8tU) {
            a5SV6n.f9502AmA8tU = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f9489A4TApA.f9517B25kr6 = 0.0f;
    }
}
