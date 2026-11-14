package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f9200A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f9201A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f9202A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ View f9203ADYaiT;
    public final /* synthetic */ AzWtSf AMqCpz;

    public /* synthetic */ AcNBzu(AzWtSf azWtSf, AlLFFp alLFFp, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.f9200A2egSU = i;
        this.AMqCpz = azWtSf;
        this.f9201A4TApA = alLFFp;
        this.f9202A5SV6n = viewPropertyAnimator;
        this.f9203ADYaiT = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f9200A2egSU) {
            case 0:
                this.f9202A5SV6n.setListener(null);
                View view = this.f9203ADYaiT;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                AlLFFp alLFFp = this.f9201A4TApA;
                Dphsd2 dphsd2 = alLFFp.f9204A2egSU;
                AzWtSf azWtSf = this.AMqCpz;
                azWtSf.AYUAbz(dphsd2);
                azWtSf.f9224B3GDIM.remove(alLFFp.f9204A2egSU);
                azWtSf.B3GDIM();
                break;
            default:
                this.f9202A5SV6n.setListener(null);
                View view2 = this.f9203ADYaiT;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                AlLFFp alLFFp2 = this.f9201A4TApA;
                Dphsd2 dphsd22 = alLFFp2.f9205A4TApA;
                AzWtSf azWtSf2 = this.AMqCpz;
                azWtSf2.AYUAbz(dphsd22);
                azWtSf2.f9224B3GDIM.remove(alLFFp2.f9205A4TApA);
                azWtSf2.B3GDIM();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f9200A2egSU) {
            case 0:
                Dphsd2 dphsd2 = this.f9201A4TApA.f9204A2egSU;
                this.AMqCpz.getClass();
                break;
            default:
                Dphsd2 dphsd22 = this.f9201A4TApA.f9205A4TApA;
                this.AMqCpz.getClass();
                break;
        }
    }
}
