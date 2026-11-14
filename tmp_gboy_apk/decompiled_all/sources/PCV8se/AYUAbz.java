package PCV8se;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz extends ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final float f7020AcNBzu;

    public AYUAbz(float f) {
        this.f7020AcNBzu = f - 0.001f;
    }

    @Override // PCV8se.ASJ6gh
    public final void A4TApA(float f, float f2, float f3, BJ7GGh bJ7GGh) {
        double d = this.f7020AcNBzu;
        float sqrt = (float) ((Math.sqrt(2.0d) * d) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(d, 2.0d) - Math.pow(sqrt, 2.0d));
        bJ7GGh.ADYaiT(f2 - sqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + sqrt2, 270.0f, 0.0f);
        bJ7GGh.A5SV6n(f2, (float) (-((Math.sqrt(2.0d) * d) - d)));
        bJ7GGh.A5SV6n(f2 + sqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + sqrt2);
    }
}
