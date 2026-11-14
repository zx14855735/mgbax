package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Dphsd2 f9195A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f9196A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ View f9197A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f9198ADYaiT;
    public final /* synthetic */ ViewPropertyAnimator AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f9199ARc23Z;

    public AaHO0E(AzWtSf azWtSf, Dphsd2 dphsd2, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f9199ARc23Z = azWtSf;
        this.f9195A2egSU = dphsd2;
        this.f9196A4TApA = i;
        this.f9197A5SV6n = view;
        this.f9198ADYaiT = i2;
        this.AMqCpz = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.f9196A4TApA;
        View view = this.f9197A5SV6n;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f9198ADYaiT != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.AMqCpz.setListener(null);
        AzWtSf azWtSf = this.f9199ARc23Z;
        Dphsd2 dphsd2 = this.f9195A2egSU;
        azWtSf.AYUAbz(dphsd2);
        azWtSf.f9222B25kr6.remove(dphsd2);
        azWtSf.B3GDIM();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f9199ARc23Z.getClass();
    }
}
