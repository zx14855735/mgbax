package OO3awZ;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final double f6387A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final double f6388A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final double f6389A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final double f6390ADYaiT;

    public A4TApA(double d, double d2, double d3, double d4) {
        this.f6387A2egSU = d;
        this.f6388A4TApA = d2;
        this.f6389A5SV6n = d3;
        this.f6390ADYaiT = d4;
    }

    public final double A2egSU(double d) {
        if (d <= -1.0d) {
            return this.f6387A2egSU;
        }
        if (d < 0.0d) {
            return A2egSU.AZkASS(this.f6387A2egSU, this.f6388A4TApA, (d - (-1.0d)) / 1.0d);
        }
        if (d < 0.5d) {
            return A2egSU.AZkASS(this.f6388A4TApA, this.f6389A5SV6n, (d - 0.0d) / 0.5d);
        }
        if (d >= 1.0d) {
            return this.f6390ADYaiT;
        }
        return A2egSU.AZkASS(this.f6389A5SV6n, this.f6390ADYaiT, (d - 0.5d) / 0.5d);
    }
}
