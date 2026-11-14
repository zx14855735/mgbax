package HSHyT0;

import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU implements AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ItGa5w.A5SV6n f3470A4TApA = new ItGa5w.A5SV6n();

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            ItGa5w.A5SV6n a5SV6n = this.f3470A4TApA;
            if (i >= a5SV6n.f1011AmA8tU) {
                return;
            }
            ((AlLFFp) a5SV6n.ARc23Z(i)).update(a5SV6n.AZkASS(i), messageDigest);
            i++;
        }
    }

    public final Object A5SV6n(AlLFFp alLFFp) {
        ItGa5w.A5SV6n a5SV6n = this.f3470A4TApA;
        return a5SV6n.containsKey(alLFFp) ? a5SV6n.get(alLFFp) : alLFFp.f3466A2egSU;
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof AmA8tU) {
            return this.f3470A4TApA.equals(((AmA8tU) obj).f3470A4TApA);
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return this.f3470A4TApA.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f3470A4TApA + '}';
    }
}
