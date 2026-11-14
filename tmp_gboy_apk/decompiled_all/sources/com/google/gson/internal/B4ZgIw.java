package com.google.gson.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw extends B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Method f12068A2egSU;

    public B4ZgIw(Method method) {
        this.f12068A2egSU = method;
    }

    @Override // com.google.gson.internal.B9tovu
    public final Object A4TApA(Class cls) {
        B9tovu.A2egSU(cls);
        return this.f12068A2egSU.invoke(null, cls, Object.class);
    }
}
