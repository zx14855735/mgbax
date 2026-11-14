package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements WildcardType, Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Type f12028AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Type f12029AlLFFp;

    public A5SV6n(Type[] typeArr, Type[] typeArr2) {
        ADYaiT.A4TApA(typeArr2.length <= 1);
        ADYaiT.A4TApA(typeArr.length == 1);
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            ADYaiT.A5SV6n(typeArr[0]);
            this.f12029AlLFFp = null;
            this.f12028AcNBzu = ADYaiT.A2egSU(typeArr[0]);
            return;
        }
        typeArr2[0].getClass();
        ADYaiT.A5SV6n(typeArr2[0]);
        ADYaiT.A4TApA(typeArr[0] == Object.class);
        this.f12029AlLFFp = ADYaiT.A2egSU(typeArr2[0]);
        this.f12028AcNBzu = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && ADYaiT.ADYaiT(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f12029AlLFFp;
        return type != null ? new Type[]{type} : ADYaiT.f12030A2egSU;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f12028AcNBzu};
    }

    public final int hashCode() {
        Type type = this.f12029AlLFFp;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f12028AcNBzu.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f12029AlLFFp;
        if (type != null) {
            return "? super " + ADYaiT.AZOQYO(type);
        }
        Type type2 = this.f12028AcNBzu;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + ADYaiT.AZOQYO(type2);
    }
}
