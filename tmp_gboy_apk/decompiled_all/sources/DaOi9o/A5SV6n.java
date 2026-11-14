package DaOi9o;

import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f2203A2egSU = false;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ViewGroup f2204A4TApA;

    public A5SV6n(ViewGroup viewGroup) {
        this.f2204A4TApA = viewGroup;
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void A4TApA() {
        com.bumptech.glide.A5SV6n.DXuj49(this.f2204A4TApA, false);
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void A5SV6n(B4ZgIw b4ZgIw) {
        com.bumptech.glide.A5SV6n.DXuj49(this.f2204A4TApA, false);
        this.f2203A2egSU = true;
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void AMqCpz() {
        com.bumptech.glide.A5SV6n.DXuj49(this.f2204A4TApA, true);
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        if (!this.f2203A2egSU) {
            com.bumptech.glide.A5SV6n.DXuj49(this.f2204A4TApA, false);
        }
        b4ZgIw.BJ7GGh(this);
    }
}
