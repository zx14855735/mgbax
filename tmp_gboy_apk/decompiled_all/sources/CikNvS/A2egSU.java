package CikNvS;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1783A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1784A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f1785A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f1786ADYaiT;
    public long AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public long f1787ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public long f1788ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f1789AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f1790AZOQYO;

    public final float A2egSU(long j) {
        if (j < this.AMqCpz) {
            return 0.0f;
        }
        long j2 = this.f1788ASJ6gh;
        if (j2 < 0 || j < j2) {
            return ASJ6gh.A4TApA((j - r0) / this.f1783A2egSU, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.f1789AYUAbz;
        return (ASJ6gh.A4TApA((j - j2) / this.f1790AZOQYO, 0.0f, 1.0f) * f) + (1.0f - f);
    }
}
