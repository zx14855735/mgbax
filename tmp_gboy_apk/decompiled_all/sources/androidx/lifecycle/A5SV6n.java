package androidx.lifecycle;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f8970A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Method f8971A4TApA;

    public A5SV6n(int i, Method method) {
        this.f8970A2egSU = i;
        this.f8971A4TApA = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A5SV6n)) {
            return false;
        }
        A5SV6n a5SV6n = (A5SV6n) obj;
        return this.f8970A2egSU == a5SV6n.f8970A2egSU && this.f8971A4TApA.getName().equals(a5SV6n.f8971A4TApA.getName());
    }

    public final int hashCode() {
        return this.f8971A4TApA.getName().hashCode() + (this.f8970A2egSU * 31);
    }
}
