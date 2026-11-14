package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM extends B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Method f12066A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f12067A4TApA;

    public B3GDIM(int i, Method method) {
        this.f12066A2egSU = method;
        this.f12067A4TApA = i;
    }

    @Override // com.google.gson.internal.B9tovu
    public final Object A4TApA(Class cls) {
        B9tovu.A2egSU(cls);
        return this.f12066A2egSU.invoke(null, cls, Integer.valueOf(this.f12067A4TApA));
    }
}
