package DaOi9o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Cd8JRx extends AnimatorListenerAdapter implements B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ViewGroup f2293A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final View f2294A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final View f2295A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f2296ADYaiT = true;
    public final /* synthetic */ CkXcdM AMqCpz;

    public Cd8JRx(CkXcdM ckXcdM, ViewGroup viewGroup, View view, View view2) {
        this.AMqCpz = ckXcdM;
        this.f2293A2egSU = viewGroup;
        this.f2294A4TApA = view;
        this.f2295A5SV6n = view2;
    }

    @Override // DaOi9o.B7CMnp
    public final void A2egSU(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
    }

    @Override // DaOi9o.B7CMnp
    public final void A4TApA() {
    }

    @Override // DaOi9o.B7CMnp
    public final void A5SV6n(B4ZgIw b4ZgIw) {
        if (this.f2296ADYaiT) {
            AYUAbz();
        }
    }

    @Override // DaOi9o.B7CMnp
    public final void ADYaiT(B4ZgIw b4ZgIw) {
        throw null;
    }

    @Override // DaOi9o.B7CMnp
    public final void AMqCpz() {
    }

    @Override // DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
    }

    @Override // DaOi9o.B7CMnp
    public final void ASJ6gh(B4ZgIw b4ZgIw) {
    }

    public final void AYUAbz() {
        this.f2295A5SV6n.setTag(2131297877, null);
        this.f2293A2egSU.getOverlay().remove(this.f2294A4TApA);
        this.f2296ADYaiT = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AYUAbz();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f2293A2egSU.getOverlay().remove(this.f2294A4TApA);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f2294A4TApA;
        if (view.getParent() == null) {
            this.f2293A2egSU.getOverlay().add(view);
        } else {
            this.AMqCpz.cancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            View view = this.f2295A5SV6n;
            View view2 = this.f2294A4TApA;
            view.setTag(2131297877, view2);
            this.f2293A2egSU.getOverlay().add(view2);
            this.f2296ADYaiT = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        AYUAbz();
    }
}
