package HwAeAU;

import CASmeH.ASJ6gh;
import HSHyT0.AlLFFp;
import HSHyT0.AmA8tU;
import HSHyT0.AzWtSf;
import HSHyT0.B25kr6;
import HXc4pW.BTvldC;
import I3HV03.ARc23Z;
import I3HV03.B2KMhB;
import I3HV03.B4ZgIw;
import I3HV03.BJ7GGh;
import android.graphics.ImageDecoder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n implements B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BJ7GGh f3801A2egSU = BJ7GGh.A2egSU();

    @Override // HSHyT0.B25kr6
    public final /* bridge */ /* synthetic */ BTvldC A2egSU(Object obj, int i, int i2, AmA8tU amA8tU) {
        return A5SV6n(ASJ6gh.ADYaiT(obj), i, i2, amA8tU);
    }

    @Override // HSHyT0.B25kr6
    public final /* bridge */ /* synthetic */ boolean A4TApA(Object obj, AmA8tU amA8tU) {
        ASJ6gh.BIYEnU(obj);
        return true;
    }

    public final BTvldC A5SV6n(ImageDecoder.Source source, int i, int i2, AmA8tU amA8tU) {
        HSHyT0.A2egSU a2egSU = (HSHyT0.A2egSU) amA8tU.A5SV6n(B4ZgIw.f3832ARc23Z);
        B2KMhB b2KMhB = (B2KMhB) amA8tU.A5SV6n(B2KMhB.f3830ARc23Z);
        AlLFFp alLFFp = B4ZgIw.f3835AZOQYO;
        return ADYaiT(source, new A4TApA(this, i, i2, amA8tU.A5SV6n(alLFFp) != null && ((Boolean) amA8tU.A5SV6n(alLFFp)).booleanValue(), a2egSU, b2KMhB, (AzWtSf) amA8tU.A5SV6n(B4ZgIw.f3833ASJ6gh)));
    }

    public abstract ARc23Z ADYaiT(ImageDecoder.Source source, A4TApA a4TApA);
}
