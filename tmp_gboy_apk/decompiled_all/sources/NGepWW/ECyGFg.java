package NGepWW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ECyGFg {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f5777A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final boolean f5778A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final NSK3xo.AcNBzu f5779A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final EH1KK8 f5780ADYaiT;

    public ECyGFg(EH1KK8 eh1kk8, ADYaiT aDYaiT, boolean z, NSK3xo.AcNBzu acNBzu) {
        this.f5780ADYaiT = eh1kk8;
        this.f5777A2egSU = aDYaiT;
        this.f5778A4TApA = z;
        this.f5779A5SV6n = acNBzu;
    }

    public final void A2egSU(NSK3xo.AmA8tU amA8tU) {
        NSK3xo.A4TApA a4TApA = (NSK3xo.A4TApA) amA8tU;
        EH1KK8 eh1kk8 = this.f5780ADYaiT;
        NCeV4Q.B3GDIM.A2egSU(eh1kk8.f5794BJ7GGh).AMqCpz();
        if (a4TApA.f5926AlLFFp <= 0) {
            EwN40Z ewN40Z = eh1kk8.f5792BI9f7h;
            if (ewN40Z != null && ewN40Z.d()) {
                eh1kk8.ASJ6gh();
                eh1kk8.AaHO0E();
            }
        }
        this.f5777A2egSU.A2egSU(a4TApA);
        if (this.f5778A4TApA) {
            this.f5779A5SV6n.ASJ6gh();
        }
    }
}
