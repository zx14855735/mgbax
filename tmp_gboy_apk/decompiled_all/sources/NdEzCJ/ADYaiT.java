package NdEzCJ;

import ADYaiT.CtFAbx;
import android.animation.TimeInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f6043A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f6044A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public TimeInterpolator f6045A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f6046ADYaiT;
    public int AMqCpz;

    public final TimeInterpolator A2egSU() {
        TimeInterpolator timeInterpolator = this.f6045A5SV6n;
        return timeInterpolator != null ? timeInterpolator : A2egSU.f6037A4TApA;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ADYaiT)) {
            return false;
        }
        ADYaiT aDYaiT = (ADYaiT) obj;
        if (this.f6043A2egSU == aDYaiT.f6043A2egSU && this.f6044A4TApA == aDYaiT.f6044A4TApA && this.f6046ADYaiT == aDYaiT.f6046ADYaiT && this.AMqCpz == aDYaiT.AMqCpz) {
            return A2egSU().getClass().equals(aDYaiT.A2egSU().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f6043A2egSU;
        long j2 = this.f6044A4TApA;
        return ((((A2egSU().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.f6046ADYaiT) * 31) + this.AMqCpz;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(ADYaiT.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f6043A2egSU);
        sb.append(" duration: ");
        sb.append(this.f6044A4TApA);
        sb.append(" interpolator: ");
        sb.append(A2egSU().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f6046ADYaiT);
        sb.append(" repeatMode: ");
        return CtFAbx.AZkASS("}\n", this.AMqCpz, sb);
    }
}
