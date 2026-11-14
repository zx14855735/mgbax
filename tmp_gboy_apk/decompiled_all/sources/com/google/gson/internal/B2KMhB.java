package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB extends B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Method f12064A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f12065A4TApA;

    public B2KMhB(Object obj, Method method) {
        this.f12064A2egSU = method;
        this.f12065A4TApA = obj;
    }

    @Override // com.google.gson.internal.B9tovu
    public final Object A4TApA(Class cls) {
        B9tovu.A2egSU(cls);
        return this.f12064A2egSU.invoke(this.f12065A4TApA, cls);
    }
}
