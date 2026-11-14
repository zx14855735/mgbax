package HZUvgL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZkASS f3659A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f3660A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Class f3661A5SV6n;

    public AZOQYO(AZkASS aZkASS) {
        this.f3659A2egSU = aZkASS;
    }

    @Override // HZUvgL.AlLFFp
    public final void A2egSU() {
        this.f3659A2egSU.A4TApA(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AZOQYO) {
            AZOQYO azoqyo = (AZOQYO) obj;
            if (this.f3660A4TApA == azoqyo.f3660A4TApA && this.f3661A5SV6n == azoqyo.f3661A5SV6n) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f3660A4TApA * 31;
        Class cls = this.f3661A5SV6n;
        return i + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f3660A4TApA + "array=" + this.f3661A5SV6n + '}';
    }
}
