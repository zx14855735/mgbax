package OO3awZ;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final double f6417A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final double f6418A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f6419A5SV6n = new HashMap();

    public AaHO0E(double d, double d2) {
        this.f6417A2egSU = d;
        this.f6418A4TApA = d2;
    }

    public final double A2egSU(int i) {
        HashMap hashMap = this.f6419A5SV6n;
        if (hashMap.get(Integer.valueOf(i)) == null) {
            hashMap.put(Integer.valueOf(i), Double.valueOf(ADYaiT.A2egSU(this.f6417A2egSU, 200.0d, i).f6400A4TApA));
        }
        return ((Double) hashMap.get(Integer.valueOf(i))).doubleValue();
    }
}
