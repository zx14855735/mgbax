package D8MqeW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final long f2033A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final long f2034A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final long f2035A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final long f2036ADYaiT;
    public final long AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final float f2037ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f2038ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f2039AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public long f2040AZOQYO;

    public B3GDIM(long j, long j2, long j3, A2egSU a2egSU) {
        this.f2033A2egSU = j;
        this.f2034A4TApA = j2;
        this.f2035A5SV6n = j3;
        long CmUvjW2 = JrXYwF.A4TApA.CmUvjW(j, j2);
        long CmUvjW3 = JrXYwF.A4TApA.CmUvjW(j3, j2);
        float C4FrIb2 = JrXYwF.A4TApA.C4FrIb(CmUvjW2);
        float C4FrIb3 = JrXYwF.A4TApA.C4FrIb(CmUvjW3);
        if (C4FrIb2 <= 0.0f || C4FrIb3 <= 0.0f) {
            this.f2036ADYaiT = B25kr6.ARc23Z.A2egSU(0.0f, 0.0f);
            this.AMqCpz = B25kr6.ARc23Z.A2egSU(0.0f, 0.0f);
            this.f2037ARc23Z = 0.0f;
            this.f2038ASJ6gh = 0.0f;
            this.f2039AYUAbz = 0.0f;
        } else {
            long BTvldC2 = JrXYwF.A4TApA.BTvldC(CmUvjW2, C4FrIb2);
            this.f2036ADYaiT = BTvldC2;
            long BTvldC3 = JrXYwF.A4TApA.BTvldC(CmUvjW3, C4FrIb3);
            this.AMqCpz = BTvldC3;
            float f = a2egSU.f2009A2egSU;
            this.f2037ARc23Z = f;
            this.f2038ASJ6gh = a2egSU.f2010A4TApA;
            float BV3sI02 = JrXYwF.A4TApA.BV3sI0(BTvldC2, BTvldC3);
            float f2 = 1;
            float f3 = B7CMnp.f2045A4TApA;
            float sqrt = (float) Math.sqrt(f2 - (BV3sI02 * BV3sI02));
            this.f2039AYUAbz = ((double) sqrt) > 0.001d ? ((BV3sI02 + f2) * f) / sqrt : 0.0f;
        }
        this.f2040AZOQYO = B25kr6.ARc23Z.A2egSU(0.0f, 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static D8MqeW.A4TApA A4TApA(float r16, float r17, long r18, long r20, long r22, long r24, long r26, float r28) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D8MqeW.B3GDIM.A4TApA(float, float, long, long, long, long, long, float):D8MqeW.A4TApA");
    }

    public final float A2egSU(float f) {
        float A5SV6n2 = A5SV6n();
        float f2 = this.f2038ASJ6gh;
        if (f > A5SV6n2) {
            return f2;
        }
        float f3 = this.f2039AYUAbz;
        if (f > f3) {
            return ((f - f3) * f2) / (A5SV6n() - f3);
        }
        return 0.0f;
    }

    public final float A5SV6n() {
        return (1 + this.f2038ASJ6gh) * this.f2039AYUAbz;
    }
}
