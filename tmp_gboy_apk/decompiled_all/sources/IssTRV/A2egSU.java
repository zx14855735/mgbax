package IssTRV;

import HSHyT0.AZkASS;
import ItGa5w.AlLFFp;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f4065A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AZkASS f4066A5SV6n;

    public A2egSU(int i, AZkASS aZkASS) {
        this.f4065A4TApA = i;
        this.f4066A5SV6n = aZkASS;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        this.f4066A5SV6n.A2egSU(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4065A4TApA).array());
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof A2egSU) {
            A2egSU a2egSU = (A2egSU) obj;
            if (this.f4065A4TApA == a2egSU.f4065A4TApA && this.f4066A5SV6n.equals(a2egSU.f4066A5SV6n)) {
                return true;
            }
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        return AlLFFp.ASJ6gh(this.f4065A4TApA, this.f4066A5SV6n);
    }
}
