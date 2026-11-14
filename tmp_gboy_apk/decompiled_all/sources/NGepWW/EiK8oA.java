package NGepWW;

import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EiK8oA implements NUY5pn.AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final EicXu4 f5830A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final NSK3xo.ARc23Z f5831A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public NUY5pn.C4FrIb f5832A5SV6n = null;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Set f5833ADYaiT = null;
    public boolean AMqCpz = false;

    public EiK8oA(EicXu4 eicXu4, NSK3xo.ARc23Z aRc23Z, D8cQ8b d8cQ8b) {
        this.f5830A2egSU = eicXu4;
        this.f5831A4TApA = aRc23Z;
    }

    public final void A2egSU(NOd7IU.A2egSU a2egSU) {
        EdhSi6 edhSi6 = (EdhSi6) this.f5830A2egSU.f5842B25kr6.get(null);
        NUY5pn.AYUAbz.A2egSU(edhSi6.f5821A2egSU.f5844B3GDIM);
        ((NUY5pn.BJ7GGh) edhSi6.f5823A5SV6n).AYUAbz();
        edhSi6.A4TApA(a2egSU);
    }

    @Override // NUY5pn.AmA8tU
    public final void A4TApA(NOd7IU.A2egSU a2egSU) {
        this.f5830A2egSU.f5844B3GDIM.post(new MOpbMP.A2egSU(this, 16, a2egSU));
    }
}
