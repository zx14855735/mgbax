package DaOi9o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends AnimatorListenerAdapter implements B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final View f2217A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f2218A4TApA = false;

    public ARc23Z(View view) {
        this.f2217A2egSU = view;
    }

    @Override // DaOi9o.B7CMnp
    public final void A2egSU(B4ZgIw b4ZgIw) {
    }

    @Override // DaOi9o.B7CMnp
    public final void A4TApA() {
        View view = this.f2217A2egSU;
        view.setTag(2131298124, Float.valueOf(view.getVisibility() == 0 ? BpkvW3.f2284A2egSU.ADYaiT(view) : 0.0f));
    }

    @Override // DaOi9o.B7CMnp
    public final void A5SV6n(B4ZgIw b4ZgIw) {
    }

    @Override // DaOi9o.B7CMnp
    public final void ADYaiT(B4ZgIw b4ZgIw) {
        throw null;
    }

    @Override // DaOi9o.B7CMnp
    public final void AMqCpz() {
        this.f2217A2egSU.setTag(2131298124, null);
    }

    @Override // DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        throw null;
    }

    @Override // DaOi9o.B7CMnp
    public final void ASJ6gh(B4ZgIw b4ZgIw) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        BpkvW3.f2284A2egSU.AaHO0E(this.f2217A2egSU, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f2217A2egSU;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f2218A4TApA = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.f2218A4TApA;
        View view = this.f2217A2egSU;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        ADYaiT.BmvVmW bmvVmW = BpkvW3.f2284A2egSU;
        bmvVmW.AaHO0E(view, 1.0f);
        bmvVmW.getClass();
    }
}
