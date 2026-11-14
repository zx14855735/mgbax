package DaOi9o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CcAIMM extends AnimatorListenerAdapter implements B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final View f2288A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f2289A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ViewGroup f2290A5SV6n;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f2292ARc23Z = false;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f2291ADYaiT = true;

    public CcAIMM(View view, int i) {
        this.f2288A2egSU = view;
        this.f2289A4TApA = i;
        this.f2290A5SV6n = (ViewGroup) view.getParent();
        AYUAbz(true);
    }

    @Override // DaOi9o.B7CMnp
    public final void A2egSU(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
    }

    @Override // DaOi9o.B7CMnp
    public final void A4TApA() {
        AYUAbz(false);
        if (this.f2292ARc23Z) {
            return;
        }
        BpkvW3.A4TApA(this.f2288A2egSU, this.f2289A4TApA);
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
        AYUAbz(true);
        if (this.f2292ARc23Z) {
            return;
        }
        BpkvW3.A4TApA(this.f2288A2egSU, 0);
    }

    @Override // DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
    }

    @Override // DaOi9o.B7CMnp
    public final void ASJ6gh(B4ZgIw b4ZgIw) {
    }

    public final void AYUAbz(boolean z) {
        ViewGroup viewGroup;
        if (!this.f2291ADYaiT || this.AMqCpz == z || (viewGroup = this.f2290A5SV6n) == null) {
            return;
        }
        this.AMqCpz = z;
        com.bumptech.glide.A5SV6n.DXuj49(viewGroup, z);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2292ARc23Z = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f2292ARc23Z) {
            BpkvW3.A4TApA(this.f2288A2egSU, this.f2289A4TApA);
            ViewGroup viewGroup = this.f2290A5SV6n;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        AYUAbz(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            BpkvW3.A4TApA(this.f2288A2egSU, 0);
            ViewGroup viewGroup = this.f2290A5SV6n;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        if (!this.f2292ARc23Z) {
            BpkvW3.A4TApA(this.f2288A2egSU, this.f2289A4TApA);
            ViewGroup viewGroup = this.f2290A5SV6n;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        AYUAbz(false);
    }
}
