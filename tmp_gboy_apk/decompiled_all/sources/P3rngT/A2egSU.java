package P3rngT;

import IQ76hF.AmA8tU;
import android.graphics.Typeface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Typeface f6933A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AmA8tU f6934A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f6935A5SV6n;

    public A2egSU(AmA8tU amA8tU, Typeface typeface) {
        this.f6933A2egSU = typeface;
        this.f6934A4TApA = amA8tU;
    }

    @Override // P3rngT.ARc23Z
    public final void A2egSU(int i) {
        if (this.f6935A5SV6n) {
            return;
        }
        Oay4Bh.A5SV6n a5SV6n = (Oay4Bh.A5SV6n) this.f6934A4TApA.f3956AlLFFp;
        if (a5SV6n.AcNBzu(this.f6933A2egSU)) {
            a5SV6n.AZkASS(false);
        }
    }

    @Override // P3rngT.ARc23Z
    public final void A4TApA(Typeface typeface, boolean z) {
        if (this.f6935A5SV6n) {
            return;
        }
        Oay4Bh.A5SV6n a5SV6n = (Oay4Bh.A5SV6n) this.f6934A4TApA.f3956AlLFFp;
        if (a5SV6n.AcNBzu(typeface)) {
            a5SV6n.AZkASS(false);
        }
    }
}
