package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ReflectiveGenericLifecycleObserver implements B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f9053AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final A4TApA f9054AlLFFp;

    public ReflectiveGenericLifecycleObserver(B7CMnp b7CMnp) {
        this.f9053AcNBzu = b7CMnp;
        ADYaiT aDYaiT = ADYaiT.f8972A5SV6n;
        Class<?> cls = b7CMnp.getClass();
        A4TApA a4TApA = (A4TApA) aDYaiT.f8973A2egSU.get(cls);
        this.f9054AlLFFp = a4TApA == null ? aDYaiT.A2egSU(cls, null) : a4TApA;
    }

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
        HashMap hashMap = this.f9054AlLFFp.f8968A2egSU;
        List list = (List) hashMap.get(alLFFp);
        B7CMnp b7CMnp = this.f9053AcNBzu;
        A4TApA.A2egSU(list, b9tovu, alLFFp, b7CMnp);
        A4TApA.A2egSU((List) hashMap.get(AlLFFp.ON_ANY), b9tovu, alLFFp, b7CMnp);
    }
}
