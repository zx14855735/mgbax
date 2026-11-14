package IssTRV;

import HSHyT0.AZkASS;
import ItGa5w.ARc23Z;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f4069A4TApA;

    public ADYaiT(Object obj) {
        ARc23Z.A5SV6n(obj, "Argument must not be null");
        this.f4069A4TApA = obj;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        messageDigest.update(this.f4069A4TApA.toString().getBytes(AZkASS.f3465A2egSU));
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof ADYaiT) {
            return this.f4069A4TApA.equals(((ADYaiT) obj).f4069A4TApA);
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return this.f4069A4TApA.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f4069A4TApA + '}';
    }
}
