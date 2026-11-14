package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class TypeAdapters$32 implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Class f12173AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ TypeAdapter f12174AlLFFp;

    public TypeAdapters$32(Class cls, TypeAdapter typeAdapter) {
        this.f12173AcNBzu = cls;
        this.f12174AlLFFp = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        if (typeToken.getRawType() == this.f12173AcNBzu) {
            return this.f12174AlLFFp;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f12173AcNBzu.getName() + ",adapter=" + this.f12174AlLFFp + "]";
    }
}
