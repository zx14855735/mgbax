package androidx.recyclerview.widget;

import com.kuaishou.weapon.p0.t;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f9160A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9161A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Object f9162A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9163ADYaiT;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof A2egSU)) {
                return false;
            }
            A2egSU a2egSU = (A2egSU) obj;
            int i = this.f9160A2egSU;
            if (i != a2egSU.f9160A2egSU) {
                return false;
            }
            if (i != 8 || Math.abs(this.f9163ADYaiT - this.f9161A4TApA) != 1 || this.f9163ADYaiT != a2egSU.f9161A4TApA || this.f9161A4TApA != a2egSU.f9163ADYaiT) {
                if (this.f9163ADYaiT != a2egSU.f9163ADYaiT || this.f9161A4TApA != a2egSU.f9161A4TApA) {
                    return false;
                }
                Object obj2 = this.f9162A5SV6n;
                if (obj2 != null) {
                    if (!obj2.equals(a2egSU.f9162A5SV6n)) {
                        return false;
                    }
                } else if (a2egSU.f9162A5SV6n != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f9160A2egSU * 31) + this.f9161A4TApA) * 31) + this.f9163ADYaiT;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i = this.f9160A2egSU;
        sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : t.w : "add");
        sb.append(",s:");
        sb.append(this.f9161A4TApA);
        sb.append("c:");
        sb.append(this.f9163ADYaiT);
        sb.append(",p:");
        sb.append(this.f9162A5SV6n);
        sb.append("]");
        return sb.toString();
    }
}
