package PCV8se;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU extends ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AYUAbz f7079AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final float f7080AlLFFp;

    public AmA8tU(AYUAbz aYUAbz, float f) {
        this.f7079AcNBzu = aYUAbz;
        this.f7080AlLFFp = f;
    }

    @Override // PCV8se.ASJ6gh
    public final boolean A2egSU() {
        this.f7079AcNBzu.getClass();
        return true;
    }

    @Override // PCV8se.ASJ6gh
    public final void A4TApA(float f, float f2, float f3, BJ7GGh bJ7GGh) {
        this.f7079AcNBzu.A4TApA(f, f2 - this.f7080AlLFFp, f3, bJ7GGh);
    }
}
