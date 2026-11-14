package R8Rbcg;

import RXb0Sz.ARc23Z;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA implements Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f7826AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f7827AlLFFp;

    public A4TApA(Object obj, Object obj2) {
        this.f7826AcNBzu = obj;
        this.f7827AlLFFp = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A4TApA)) {
            return false;
        }
        A4TApA a4TApA = (A4TApA) obj;
        return ARc23Z.A2egSU(this.f7826AcNBzu, a4TApA.f7826AcNBzu) && ARc23Z.A2egSU(this.f7827AlLFFp, a4TApA.f7827AlLFFp);
    }

    public final int hashCode() {
        Object obj = this.f7826AcNBzu;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f7827AlLFFp;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f7826AcNBzu + ", " + this.f7827AlLFFp + ')';
    }
}
