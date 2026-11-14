package HZUvgL;

import android.graphics.Bitmap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZkASS f3674A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f3675A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Bitmap.Config f3676A5SV6n;

    public AzWtSf(AZkASS aZkASS) {
        this.f3674A2egSU = aZkASS;
    }

    @Override // HZUvgL.AlLFFp
    public final void A2egSU() {
        this.f3674A2egSU.A4TApA(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AzWtSf) {
            AzWtSf azWtSf = (AzWtSf) obj;
            if (this.f3675A4TApA == azWtSf.f3675A4TApA && ItGa5w.AlLFFp.A2egSU(this.f3676A5SV6n, azWtSf.f3676A5SV6n)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f3675A4TApA * 31;
        Bitmap.Config config = this.f3676A5SV6n;
        return i + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return B25kr6.A5SV6n(this.f3675A4TApA, this.f3676A5SV6n);
    }
}
