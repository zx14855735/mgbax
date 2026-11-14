package PWr3nF;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f7294A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f7295A4TApA;

    public /* synthetic */ A5SV6n(ADYaiT aDYaiT, int i) {
        this.f7294A2egSU = i;
        this.f7295A4TApA = aDYaiT;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f7294A2egSU) {
            case 1:
                this.f7295A4TApA.f7350A4TApA.AYUAbz(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f7294A2egSU) {
            case 0:
                this.f7295A4TApA.f7350A4TApA.AYUAbz(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
