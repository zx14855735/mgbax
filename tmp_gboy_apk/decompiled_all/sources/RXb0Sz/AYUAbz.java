package RXb0Sz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AYUAbz implements A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Class f7891A2egSU;

    public AYUAbz(Class cls) {
        ARc23Z.AMqCpz(cls, "jClass");
        this.f7891A2egSU = cls;
    }

    @Override // RXb0Sz.A5SV6n
    public final Class A2egSU() {
        return this.f7891A2egSU;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AYUAbz) {
            return ARc23Z.A2egSU(this.f7891A2egSU, ((AYUAbz) obj).f7891A2egSU);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7891A2egSU.hashCode();
    }

    public final String toString() {
        return this.f7891A2egSU.toString() + " (Kotlin reflection is not available)";
    }
}
