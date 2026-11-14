package OO3awZ;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final double f6420A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final double f6421A4TApA;

    public AcNBzu(double d, double d2) {
        new HashMap();
        this.f6420A2egSU = d;
        this.f6421A4TApA = d2;
    }

    public static AcNBzu A2egSU(double d, double d2) {
        AaHO0E aaHO0E = new AaHO0E(d, d2);
        int i = 100;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                ADYaiT.A2egSU(aaHO0E.f6417A2egSU, aaHO0E.f6418A4TApA, i2);
                break;
            }
            int i3 = (i2 + i) / 2;
            int i4 = i3 + 1;
            boolean z = aaHO0E.A2egSU(i3) < aaHO0E.A2egSU(i4);
            if (aaHO0E.A2egSU(i3) >= aaHO0E.f6418A4TApA - 0.01d) {
                if (Math.abs(i2 - 50) < Math.abs(i - 50)) {
                    i = i3;
                } else {
                    if (i2 == i3) {
                        ADYaiT.A2egSU(aaHO0E.f6417A2egSU, aaHO0E.f6418A4TApA, i2);
                        break;
                    }
                    i2 = i3;
                }
            } else if (z) {
                i2 = i4;
            } else {
                i = i3;
            }
        }
        return new AcNBzu(d, d2);
    }
}
