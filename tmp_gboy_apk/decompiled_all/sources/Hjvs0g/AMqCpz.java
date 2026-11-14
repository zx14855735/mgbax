package Hjvs0g;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3714A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f3715A4TApA;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f3714A2egSU = i;
        this.f3715A4TApA = obj;
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        switch (this.f3714A2egSU) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new BChYOn(new IssTRV.ADYaiT(bArr), new B2KMhB(bArr, 1, (Hdahpu.AZOQYO) this.f3715A4TApA));
            case 1:
                return new BChYOn(new IssTRV.ADYaiT(obj), new HSr46Q.A5SV6n(1, obj.toString(), (Hdahpu.AZOQYO) this.f3715A4TApA));
            default:
                File file = (File) obj;
                return new BChYOn(new IssTRV.ADYaiT(file), new HSr46Q.A5SV6n(2, file, (Hdahpu.AZOQYO) this.f3715A4TApA));
        }
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        switch (this.f3714A2egSU) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }
}
