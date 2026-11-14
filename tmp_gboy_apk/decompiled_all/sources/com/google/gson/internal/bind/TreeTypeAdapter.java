package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final JsonSerializer f12156A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final JsonDeserializer f12157A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Gson f12158A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final TypeToken f12159ADYaiT;
    public final TypeAdapterFactory AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final NGepWW.A2egSU f12160ARc23Z = new NGepWW.A2egSU(18, this);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public TypeAdapter f12161ASJ6gh;

    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public final TypeToken f12162AcNBzu;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public final boolean f12163AlLFFp;

        /* renamed from: AmA8tU, reason: collision with root package name */
        public final Class f12164AmA8tU;

        /* renamed from: AzWtSf, reason: collision with root package name */
        public final JsonSerializer f12165AzWtSf;

        /* renamed from: B25kr6, reason: collision with root package name */
        public final JsonDeserializer f12166B25kr6;

        public SingleTypeFactory(Object obj, TypeToken typeToken, boolean z, Class cls) {
            JsonSerializer jsonSerializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f12165AzWtSf = jsonSerializer;
            JsonDeserializer jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.f12166B25kr6 = jsonDeserializer;
            com.google.gson.internal.ADYaiT.A4TApA((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.f12162AcNBzu = typeToken;
            this.f12163AlLFFp = z;
            this.f12164AmA8tU = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            TypeToken typeToken2 = this.f12162AcNBzu;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.f12163AlLFFp && typeToken2.getType() == typeToken.getRawType()) : this.f12164AmA8tU.isAssignableFrom(typeToken.getRawType())) {
                return new TreeTypeAdapter(this.f12165AzWtSf, this.f12166B25kr6, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f12156A2egSU = jsonSerializer;
        this.f12157A4TApA = jsonDeserializer;
        this.f12158A5SV6n = gson;
        this.f12159ADYaiT = typeToken;
        this.AMqCpz = typeAdapterFactory;
    }

    public static TypeAdapterFactory A2egSU(TypeToken typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory A4TApA(TypeToken typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static TypeAdapterFactory A5SV6n(Class cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(Q2dWmT.A4TApA a4TApA) {
        TypeToken<T> typeToken = this.f12159ADYaiT;
        JsonDeserializer jsonDeserializer = this.f12157A4TApA;
        if (jsonDeserializer != null) {
            JsonElement ASJ6gh2 = com.google.gson.internal.ADYaiT.ASJ6gh(a4TApA);
            if (ASJ6gh2.isJsonNull()) {
                return null;
            }
            return jsonDeserializer.deserialize(ASJ6gh2, typeToken.getType(), this.f12160ARc23Z);
        }
        TypeAdapter<T> typeAdapter = this.f12161ASJ6gh;
        if (typeAdapter == null) {
            typeAdapter = this.f12158A5SV6n.getDelegateAdapter(this.AMqCpz, typeToken);
            this.f12161ASJ6gh = typeAdapter;
        }
        return typeAdapter.read2(a4TApA);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
        TypeToken<T> typeToken = this.f12159ADYaiT;
        JsonSerializer jsonSerializer = this.f12156A2egSU;
        if (jsonSerializer != null) {
            if (obj == null) {
                a5SV6n.AZOQYO();
                return;
            } else {
                ARc23Z.f12126BV3sI0.write(a5SV6n, jsonSerializer.serialize(obj, typeToken.getType(), this.f12160ARc23Z));
                return;
            }
        }
        TypeAdapter<T> typeAdapter = this.f12161ASJ6gh;
        if (typeAdapter == null) {
            typeAdapter = this.f12158A5SV6n.getDelegateAdapter(this.AMqCpz, typeToken);
            this.f12161ASJ6gh = typeAdapter;
        }
        typeAdapter.write(a5SV6n, obj);
    }
}
