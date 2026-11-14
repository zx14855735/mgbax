package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class TypeAdapters$33 implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Class f12175AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Class f12176AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ TypeAdapter f12177AmA8tU;

    public TypeAdapters$33(Class cls, Class cls2, TypeAdapter typeAdapter) {
        this.f12175AcNBzu = cls;
        this.f12176AlLFFp = cls2;
        this.f12177AmA8tU = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        if (rawType == this.f12175AcNBzu || rawType == this.f12176AlLFFp) {
            return this.f12177AmA8tU;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f12176AlLFFp.getName() + "+" + this.f12175AcNBzu.getName() + ",adapter=" + this.f12177AmA8tU + "]";
    }
}
