package CNPG0E;

import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f1610A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f1611A4TApA;

    public A4TApA(Object obj, Object obj2) {
        this.f1610A2egSU = obj;
        this.f1611A4TApA = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A4TApA)) {
            return false;
        }
        A4TApA a4TApA = (A4TApA) obj;
        return Objects.equals(a4TApA.f1610A2egSU, this.f1610A2egSU) && Objects.equals(a4TApA.f1611A4TApA, this.f1611A4TApA);
    }

    public final int hashCode() {
        Object obj = this.f1610A2egSU;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f1611A4TApA;
        return (obj2 != null ? obj2.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f1610A2egSU + " " + this.f1611A4TApA + "}";
    }
}
