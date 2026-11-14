package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements ParameterizedType, Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Type f12025AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Type f12026AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Type[] f12027AmA8tU;

    public A4TApA(Type type, Type type2, Type... typeArr) {
        int i = 0;
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z = true;
            boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z2) {
                z = false;
            }
            ADYaiT.A4TApA(z);
        }
        this.f12025AcNBzu = type == null ? null : ADYaiT.A2egSU(type);
        this.f12026AlLFFp = ADYaiT.A2egSU(type2);
        this.f12027AmA8tU = (Type[]) typeArr.clone();
        while (true) {
            Type[] typeArr2 = this.f12027AmA8tU;
            if (i >= typeArr2.length) {
                return;
            }
            typeArr2[i].getClass();
            ADYaiT.A5SV6n(this.f12027AmA8tU[i]);
            Type[] typeArr3 = this.f12027AmA8tU;
            typeArr3[i] = ADYaiT.A2egSU(typeArr3[i]);
            i++;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && ADYaiT.ADYaiT(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f12027AmA8tU.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f12025AcNBzu;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f12026AlLFFp;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f12027AmA8tU) ^ this.f12026AlLFFp.hashCode();
        Type type = this.f12025AcNBzu;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f12027AmA8tU;
        StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
        sb.append(ADYaiT.AZOQYO(this.f12026AlLFFp));
        if (typeArr.length == 0) {
            return sb.toString();
        }
        sb.append("<");
        sb.append(ADYaiT.AZOQYO(typeArr[0]));
        for (int i = 1; i < typeArr.length; i++) {
            sb.append(", ");
            sb.append(ADYaiT.AZOQYO(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
