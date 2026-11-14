package MdiDtx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f5299A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f5300A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public long f5301A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public long f5302ADYaiT = 0;
    public long AMqCpz = 0;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public long f5303ARc23Z = 0;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public long f5304ASJ6gh = 0;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public long f5305AYUAbz = 0;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public long f5306AZOQYO = 0;

    /* renamed from: AZkASS, reason: collision with root package name */
    public long f5307AZkASS = 0;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public long f5308AaHO0E = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final byte[] f5309AcNBzu;

    public A2egSU(int i) {
        this.f5309AcNBzu = new byte[i];
    }

    public final int A2egSU(byte[] bArr, int i) {
        A4TApA.AYUAbz(this.f5299A2egSU, bArr, i);
        bArr[i + 4] = (byte) this.f5300A4TApA;
        bArr[i + 5] = (byte) this.f5301A5SV6n;
        int i2 = (int) this.f5302ADYaiT;
        bArr[i + 6] = (byte) (i2 >> 8);
        bArr[i + 7] = (byte) i2;
        A4TApA.AYUAbz(this.AMqCpz, bArr, i + 8);
        A4TApA.AYUAbz(this.f5303ARc23Z, bArr, i + 12);
        A4TApA.AYUAbz(this.f5304ASJ6gh, bArr, i + 16);
        A4TApA.AYUAbz(this.f5309AcNBzu.length, bArr, i + 20);
        return (i + 24) - i;
    }
}
