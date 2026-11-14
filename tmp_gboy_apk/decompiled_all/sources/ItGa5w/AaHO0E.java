package ItGa5w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Class f4088A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Class f4089A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Class f4090A5SV6n;

    public AaHO0E() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AaHO0E aaHO0E = (AaHO0E) obj;
        return this.f4088A2egSU.equals(aaHO0E.f4088A2egSU) && this.f4089A4TApA.equals(aaHO0E.f4089A4TApA) && AlLFFp.A2egSU(this.f4090A5SV6n, aaHO0E.f4090A5SV6n);
    }

    public final int hashCode() {
        int hashCode = (this.f4089A4TApA.hashCode() + (this.f4088A2egSU.hashCode() * 31)) * 31;
        Class cls = this.f4090A5SV6n;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f4088A2egSU + ", second=" + this.f4089A4TApA + '}';
    }

    public AaHO0E(Class cls, Class cls2, Class cls3) {
        this.f4088A2egSU = cls;
        this.f4089A4TApA = cls2;
        this.f4090A5SV6n = cls3;
    }
}
