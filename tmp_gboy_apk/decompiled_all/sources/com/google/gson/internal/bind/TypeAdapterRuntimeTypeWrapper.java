package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Gson f12167A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final TypeAdapter f12168A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Type f12169A5SV6n;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f12167A2egSU = gson;
        this.f12168A4TApA = typeAdapter;
        this.f12169A5SV6n = type;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(Q2dWmT.A4TApA a4TApA) {
        return this.f12168A4TApA.read2(a4TApA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
        ?? r0 = this.f12169A5SV6n;
        Class<?> cls = (obj == null || !(r0 == Object.class || (r0 instanceof TypeVariable) || (r0 instanceof Class))) ? r0 : obj.getClass();
        TypeAdapter<T> typeAdapter = this.f12168A4TApA;
        if (cls != r0) {
            TypeAdapter<T> adapter = this.f12167A2egSU.getAdapter(TypeToken.get((Type) cls));
            if (!(adapter instanceof ReflectiveTypeAdapterFactory.Adapter) || (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                typeAdapter = adapter;
            }
        }
        typeAdapter.write(a5SV6n, obj);
    }
}
