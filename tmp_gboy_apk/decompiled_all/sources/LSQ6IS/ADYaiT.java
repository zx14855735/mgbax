package LSQ6IS;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends A4TApA {
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f4845ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f4846ASJ6gh;

    public ADYaiT(int i, int i2) {
        this.AMqCpz = i;
        this.f4845ARc23Z = i2;
    }

    @Override // LSQ6IS.A4TApA
    public final int A2egSU(float f, float f2) {
        boolean z = this.f4846ASJ6gh;
        int i = this.f4845ARc23Z;
        int i2 = this.AMqCpz;
        if (!z) {
            return f < 0.0f ? i2 : i;
        }
        if (f >= 0.2f) {
            i2 = 0;
        }
        return f > -0.2f ? i2 | i : i2;
    }
}
