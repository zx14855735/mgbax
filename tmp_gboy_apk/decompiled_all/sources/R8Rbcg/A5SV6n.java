package R8Rbcg;

import RXb0Sz.ARc23Z;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n implements Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Throwable f7828AcNBzu;

    public A5SV6n(Throwable th) {
        this.f7828AcNBzu = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof A5SV6n) {
            return ARc23Z.A2egSU(this.f7828AcNBzu, ((A5SV6n) obj).f7828AcNBzu);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7828AcNBzu.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f7828AcNBzu + ')';
    }
}
