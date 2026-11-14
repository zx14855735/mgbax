package NGepWW;

import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DUi7mC implements NSK3xo.AZkASS, NSK3xo.AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final NSK3xo.AYUAbz f5734A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public DV2E8K f5735A4TApA;

    public DUi7mC(NSK3xo.AYUAbz aYUAbz) {
        this.f5734A2egSU = aYUAbz;
    }

    @Override // NSK3xo.AZkASS
    public final void A2egSU(Bundle bundle) {
        NUY5pn.AYUAbz.A5SV6n(this.f5735A4TApA, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.f5735A4TApA.A2egSU(bundle);
    }

    @Override // NSK3xo.AaHO0E
    public final void A4TApA(NOd7IU.A2egSU a2egSU) {
        NUY5pn.AYUAbz.A5SV6n(this.f5735A4TApA, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.f5735A4TApA.ADYaiT(a2egSU, this.f5734A2egSU);
    }

    @Override // NSK3xo.AZkASS
    public final void a(int i) {
        NUY5pn.AYUAbz.A5SV6n(this.f5735A4TApA, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        this.f5735A4TApA.a(i);
    }
}
