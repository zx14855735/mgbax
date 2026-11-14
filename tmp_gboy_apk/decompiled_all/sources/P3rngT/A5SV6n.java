package P3rngT;

import BTvldC.B2KMhB;
import android.graphics.Typeface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f6936A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f6937A4TApA;

    public A5SV6n(AMqCpz aMqCpz, ARc23Z aRc23Z) {
        this.f6937A4TApA = aMqCpz;
        this.f6936A2egSU = aRc23Z;
    }

    @Override // BTvldC.B2KMhB
    public final void A4TApA(int i) {
        this.f6937A4TApA.f6954AmA8tU = true;
        this.f6936A2egSU.A2egSU(i);
    }

    @Override // BTvldC.B2KMhB
    public final void A5SV6n(Typeface typeface) {
        AMqCpz aMqCpz = this.f6937A4TApA;
        aMqCpz.f6956B25kr6 = Typeface.create(typeface, aMqCpz.f6945ADYaiT);
        aMqCpz.f6954AmA8tU = true;
        this.f6936A2egSU.A4TApA(aMqCpz.f6956B25kr6, false);
    }
}
