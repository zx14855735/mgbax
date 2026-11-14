package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements GenericArrayType, Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Type f12024AcNBzu;

    public A2egSU(Type type) {
        this.f12024AcNBzu = ADYaiT.A2egSU(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && ADYaiT.ADYaiT(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f12024AcNBzu;
    }

    public final int hashCode() {
        return this.f12024AcNBzu.hashCode();
    }

    public final String toString() {
        return ADYaiT.AZOQYO(this.f12024AcNBzu) + "[]";
    }
}
