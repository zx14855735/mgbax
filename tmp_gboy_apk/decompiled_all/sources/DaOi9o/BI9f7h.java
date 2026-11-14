package DaOi9o;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h extends BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ B25kr6.ADYaiT f2266A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BIYEnU f2267A4TApA;

    public BI9f7h(BIYEnU bIYEnU, B25kr6.ADYaiT aDYaiT) {
        this.f2267A4TApA = bIYEnU;
        this.f2266A2egSU = aDYaiT;
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        ((ArrayList) this.f2266A2egSU.get(this.f2267A4TApA.f2269AlLFFp)).remove(b4ZgIw);
        b4ZgIw.BJ7GGh(this);
    }
}
