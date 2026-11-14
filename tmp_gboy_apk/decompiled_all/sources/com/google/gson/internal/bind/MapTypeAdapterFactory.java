package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ASJ6gh;
import com.google.gson.internal.AlLFFp;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final com.google.gson.internal.ARc23Z f12139AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final boolean f12140AlLFFp;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final TypeAdapter f12141A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final TypeAdapter f12142A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public final AlLFFp f12143A5SV6n;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, AlLFFp alLFFp) {
            this.f12141A2egSU = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f12142A4TApA = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f12143A5SV6n = alLFFp;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public final Object read2(Q2dWmT.A4TApA a4TApA) {
            int BChYOn2 = a4TApA.BChYOn();
            if (BChYOn2 == 9) {
                a4TApA.B3GDIM();
                return null;
            }
            Map map = (Map) this.f12143A5SV6n.AZkASS();
            TypeAdapter typeAdapter = this.f12142A4TApA;
            TypeAdapter typeAdapter2 = this.f12141A2egSU;
            if (BChYOn2 == 1) {
                a4TApA.A2egSU();
                while (a4TApA.AZOQYO()) {
                    a4TApA.A2egSU();
                    Object read2 = ((TypeAdapterRuntimeTypeWrapper) typeAdapter2).f12168A4TApA.read2(a4TApA);
                    if (map.put(read2, ((TypeAdapterRuntimeTypeWrapper) typeAdapter).f12168A4TApA.read2(a4TApA)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                    a4TApA.AMqCpz();
                }
                a4TApA.AMqCpz();
                return map;
            }
            a4TApA.A4TApA();
            while (a4TApA.AZOQYO()) {
                ASJ6gh.f12035A2egSU.getClass();
                if (a4TApA instanceof A4TApA) {
                    A4TApA a4TApA2 = (A4TApA) a4TApA;
                    a4TApA2.BV3sI0(5);
                    Map.Entry entry = (Map.Entry) ((Iterator) a4TApA2.BniPrB()).next();
                    a4TApA2.C2rE4F(entry.getValue());
                    a4TApA2.C2rE4F(new JsonPrimitive((String) entry.getKey()));
                } else {
                    int i = a4TApA.f7435B4ZgIw;
                    if (i == 0) {
                        i = a4TApA.ADYaiT();
                    }
                    if (i == 13) {
                        a4TApA.f7435B4ZgIw = 9;
                    } else if (i == 12) {
                        a4TApA.f7435B4ZgIw = 8;
                    } else {
                        if (i != 14) {
                            throw new IllegalStateException("Expected a name but was " + J3FDQU.A2egSU.BPw6Q8(a4TApA.BChYOn()) + a4TApA.AaHO0E());
                        }
                        a4TApA.f7435B4ZgIw = 10;
                    }
                }
                Object read22 = ((TypeAdapterRuntimeTypeWrapper) typeAdapter2).f12168A4TApA.read2(a4TApA);
                if (map.put(read22, ((TypeAdapterRuntimeTypeWrapper) typeAdapter).f12168A4TApA.read2(a4TApA)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read22);
                }
            }
            a4TApA.ARc23Z();
            return map;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                a5SV6n.AZOQYO();
                return;
            }
            MapTypeAdapterFactory mapTypeAdapterFactory = MapTypeAdapterFactory.this;
            TypeAdapter typeAdapter = this.f12142A4TApA;
            if (!mapTypeAdapterFactory.f12140AlLFFp) {
                a5SV6n.A5SV6n();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    a5SV6n.ASJ6gh(String.valueOf(entry.getKey()));
                    typeAdapter.write(a5SV6n, entry.getValue());
                }
                a5SV6n.ARc23Z();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.f12141A2egSU.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (z) {
                a5SV6n.A4TApA();
                while (i < arrayList.size()) {
                    a5SV6n.A4TApA();
                    ARc23Z.f12126BV3sI0.write(a5SV6n, (JsonElement) arrayList.get(i));
                    typeAdapter.write(a5SV6n, arrayList2.get(i));
                    a5SV6n.AMqCpz();
                    i++;
                }
                a5SV6n.AMqCpz();
                return;
            }
            a5SV6n.A5SV6n();
            while (i < arrayList.size()) {
                JsonElement jsonElement = (JsonElement) arrayList.get(i);
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        str = String.valueOf(asJsonPrimitive.getAsNumber());
                    } else if (asJsonPrimitive.isBoolean()) {
                        str = Boolean.toString(asJsonPrimitive.getAsBoolean());
                    } else {
                        if (!asJsonPrimitive.isString()) {
                            throw new AssertionError();
                        }
                        str = asJsonPrimitive.getAsString();
                    }
                } else {
                    if (!jsonElement.isJsonNull()) {
                        throw new AssertionError();
                    }
                    str = "null";
                }
                a5SV6n.ASJ6gh(str);
                typeAdapter.write(a5SV6n, arrayList2.get(i));
                i++;
            }
            a5SV6n.ARc23Z();
        }
    }

    public MapTypeAdapterFactory(com.google.gson.internal.ARc23Z aRc23Z, boolean z) {
        this.f12139AcNBzu = aRc23Z;
        this.f12140AlLFFp = z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Class ARc23Z2 = com.google.gson.internal.ADYaiT.ARc23Z(type);
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            com.google.gson.internal.ADYaiT.A4TApA(Map.class.isAssignableFrom(ARc23Z2));
            Type AYUAbz2 = com.google.gson.internal.ADYaiT.AYUAbz(type, ARc23Z2, com.google.gson.internal.ADYaiT.AMqCpz(type, ARc23Z2, Map.class));
            actualTypeArguments = AYUAbz2 instanceof ParameterizedType ? ((ParameterizedType) AYUAbz2).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new Adapter(gson, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? ARc23Z.f12101A5SV6n : gson.getAdapter(TypeToken.get(type2)), actualTypeArguments[1], gson.getAdapter(TypeToken.get(actualTypeArguments[1])), this.f12139AcNBzu.A2egSU(typeToken));
    }
}
