package D8MqeW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A4TApA f2023A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f2024A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f2025A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f2026ADYaiT;
    public final /* synthetic */ AmA8tU AMqCpz;

    public AlLFFp(AmA8tU amA8tU, A4TApA a4TApA, float f, float f2) {
        RXb0Sz.ARc23Z.AMqCpz(a4TApA, "cubic");
        this.AMqCpz = amA8tU;
        this.f2023A2egSU = a4TApA;
        if (f2 < f) {
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
        }
        AaHO0E aaHO0E = amA8tU.f2027AcNBzu;
        aaHO0E.getClass();
        this.f2024A4TApA = Float.intBitsToFloat((int) (aaHO0E.A2egSU(a4TApA, Float.POSITIVE_INFINITY) & 4294967295L));
        this.f2025A5SV6n = f;
        this.f2026ADYaiT = f2;
    }

    public final R8Rbcg.A4TApA A2egSU(float f) {
        float f2 = this.f2025A5SV6n;
        float f3 = this.f2026ADYaiT;
        if (f2 > f3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
        }
        if (f < f2) {
            f = f2;
        } else if (f > f3) {
            f = f3;
        }
        float f4 = (f - f2) / (f3 - f2);
        AmA8tU amA8tU = this.AMqCpz;
        AaHO0E aaHO0E = amA8tU.f2027AcNBzu;
        float f5 = f4 * this.f2024A4TApA;
        aaHO0E.getClass();
        A4TApA a4TApA = this.f2023A2egSU;
        RXb0Sz.ARc23Z.AMqCpz(a4TApA, "c");
        float intBitsToFloat = Float.intBitsToFloat((int) (aaHO0E.A2egSU(a4TApA, f5) >> 32));
        if (0.0f > intBitsToFloat || intBitsToFloat > 1.0f) {
            throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1");
        }
        R8Rbcg.A4TApA ADYaiT2 = a4TApA.ADYaiT(intBitsToFloat);
        return new R8Rbcg.A4TApA(new AlLFFp(amA8tU, (A4TApA) ADYaiT2.f7826AcNBzu, this.f2025A5SV6n, f), new AlLFFp(amA8tU, (A4TApA) ADYaiT2.f7827AlLFFp, f, this.f2026ADYaiT));
    }

    public final String toString() {
        return "MeasuredCubic(outlineProgress=[" + this.f2025A5SV6n + " .. " + this.f2026ADYaiT + "], size=" + this.f2024A4TApA + ", cubic=" + this.f2023A2egSU + ')';
    }
}
