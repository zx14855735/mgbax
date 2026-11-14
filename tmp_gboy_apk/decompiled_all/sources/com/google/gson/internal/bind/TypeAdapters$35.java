package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class TypeAdapters$35 implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Class f12179AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ TypeAdapter f12180AlLFFp;

    public TypeAdapters$35(Class cls, TypeAdapter typeAdapter) {
        this.f12179AcNBzu = cls;
        this.f12180AlLFFp = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        final Class<?> rawType = typeToken.getRawType();
        if (this.f12179AcNBzu.isAssignableFrom(rawType)) {
            return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters$35.1
                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public final Object read2(Q2dWmT.A4TApA a4TApA) {
                    Object read2 = TypeAdapters$35.this.f12180AlLFFp.read2(a4TApA);
                    if (read2 != null) {
                        Class cls = rawType;
                        if (!cls.isInstance(read2)) {
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read2.getClass().getName());
                        }
                    }
                    return read2;
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
                    TypeAdapters$35.this.f12180AlLFFp.write(a5SV6n, obj);
                }
            };
        }
        return null;
    }

    public final String toString() {
        return "Factory[typeHierarchy=" + this.f12179AcNBzu.getName() + ",adapter=" + this.f12180AlLFFp + "]";
    }
}
