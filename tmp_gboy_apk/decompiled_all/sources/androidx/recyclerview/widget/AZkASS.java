package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f9191A2egSU = 1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Dphsd2 f9192A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ View f9193A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f9194ADYaiT;
    public final /* synthetic */ AzWtSf AMqCpz;

    public AZkASS(AzWtSf azWtSf, Dphsd2 dphsd2, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.AMqCpz = azWtSf;
        this.f9192A4TApA = dphsd2;
        this.f9194ADYaiT = viewPropertyAnimator;
        this.f9193A5SV6n = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f9191A2egSU) {
            case 1:
                this.f9193A5SV6n.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f9191A2egSU) {
            case 0:
                this.f9194ADYaiT.setListener(null);
                this.f9193A5SV6n.setAlpha(1.0f);
                AzWtSf azWtSf = this.AMqCpz;
                Dphsd2 dphsd2 = this.f9192A4TApA;
                azWtSf.AYUAbz(dphsd2);
                azWtSf.f9223B2KMhB.remove(dphsd2);
                azWtSf.B3GDIM();
                break;
            default:
                this.f9194ADYaiT.setListener(null);
                AzWtSf azWtSf2 = this.AMqCpz;
                Dphsd2 dphsd22 = this.f9192A4TApA;
                azWtSf2.AYUAbz(dphsd22);
                azWtSf2.f9221AzWtSf.remove(dphsd22);
                azWtSf2.B3GDIM();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f9191A2egSU) {
            case 0:
                this.AMqCpz.getClass();
                break;
            default:
                this.AMqCpz.getClass();
                break;
        }
    }

    public AZkASS(AzWtSf azWtSf, Dphsd2 dphsd2, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.AMqCpz = azWtSf;
        this.f9192A4TApA = dphsd2;
        this.f9193A5SV6n = view;
        this.f9194ADYaiT = viewPropertyAnimator;
    }
}
