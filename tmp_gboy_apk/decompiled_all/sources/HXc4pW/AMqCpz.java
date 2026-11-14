package HXc4pW;

import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements HSHyT0.AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HSHyT0.AZkASS f3500A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HSHyT0.AZkASS f3501A5SV6n;

    public AMqCpz(HSHyT0.AZkASS aZkASS, HSHyT0.AZkASS aZkASS2) {
        this.f3500A4TApA = aZkASS;
        this.f3501A5SV6n = aZkASS2;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        this.f3500A4TApA.A2egSU(messageDigest);
        this.f3501A5SV6n.A2egSU(messageDigest);
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof AMqCpz) {
            AMqCpz aMqCpz = (AMqCpz) obj;
            if (this.f3500A4TApA.equals(aMqCpz.f3500A4TApA) && this.f3501A5SV6n.equals(aMqCpz.f3501A5SV6n)) {
                return true;
            }
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return this.f3501A5SV6n.hashCode() + (this.f3500A4TApA.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f3500A4TApA + ", signature=" + this.f3501A5SV6n + '}';
    }
}
