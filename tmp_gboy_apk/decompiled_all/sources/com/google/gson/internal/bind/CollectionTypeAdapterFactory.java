package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.AlLFFp;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final com.google.gson.internal.ARc23Z f12132AcNBzu;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final TypeAdapter f12133A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final AlLFFp f12134A4TApA;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, AlLFFp alLFFp) {
            this.f12133A2egSU = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f12134A4TApA = alLFFp;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public final Object read2(Q2dWmT.A4TApA a4TApA) {
            if (a4TApA.BChYOn() == 9) {
                a4TApA.B3GDIM();
                return null;
            }
            Collection collection = (Collection) this.f12134A4TApA.AZkASS();
            a4TApA.A2egSU();
            while (a4TApA.AZOQYO()) {
                collection.add(((TypeAdapterRuntimeTypeWrapper) this.f12133A2egSU).f12168A4TApA.read2(a4TApA));
            }
            a4TApA.AMqCpz();
            return collection;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
            Collection collection = (Collection) obj;
            if (collection == null) {
                a5SV6n.AZOQYO();
                return;
            }
            a5SV6n.A4TApA();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f12133A2egSU.write(a5SV6n, it.next());
            }
            a5SV6n.AMqCpz();
        }
    }

    public CollectionTypeAdapterFactory(com.google.gson.internal.ARc23Z aRc23Z) {
        this.f12132AcNBzu = aRc23Z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        com.google.gson.internal.ADYaiT.A4TApA(Collection.class.isAssignableFrom(rawType));
        Type AYUAbz2 = com.google.gson.internal.ADYaiT.AYUAbz(type, rawType, com.google.gson.internal.ADYaiT.AMqCpz(type, rawType, Collection.class));
        if (AYUAbz2 instanceof WildcardType) {
            AYUAbz2 = ((WildcardType) AYUAbz2).getUpperBounds()[0];
        }
        Class cls = AYUAbz2 instanceof ParameterizedType ? ((ParameterizedType) AYUAbz2).getActualTypeArguments()[0] : Object.class;
        return new Adapter(gson, cls, gson.getAdapter(TypeToken.get(cls)), this.f12132AcNBzu.A2egSU(typeToken));
    }
}
