package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final com.google.gson.internal.ARc23Z f12138AcNBzu;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.ARc23Z aRc23Z) {
        this.f12138AcNBzu = aRc23Z;
    }

    public static TypeAdapter A2egSU(com.google.gson.internal.ARc23Z aRc23Z, Gson gson, TypeToken typeToken, PlKZ28.A4TApA a4TApA) {
        TypeAdapter treeTypeAdapter;
        Object AZkASS2 = aRc23Z.A2egSU(TypeToken.get(a4TApA.value())).AZkASS();
        if (AZkASS2 instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) AZkASS2;
        } else if (AZkASS2 instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) AZkASS2).create(gson, typeToken);
        } else {
            boolean z = AZkASS2 instanceof JsonSerializer;
            if (!z && !(AZkASS2 instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
            }
            treeTypeAdapter = new TreeTypeAdapter(z ? (JsonSerializer) AZkASS2 : null, AZkASS2 instanceof JsonDeserializer ? (JsonDeserializer) AZkASS2 : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !a4TApA.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        PlKZ28.A4TApA a4TApA = (PlKZ28.A4TApA) typeToken.getRawType().getAnnotation(PlKZ28.A4TApA.class);
        if (a4TApA == null) {
            return null;
        }
        return A2egSU(this.f12138AcNBzu, gson, typeToken, a4TApA);
    }
}
