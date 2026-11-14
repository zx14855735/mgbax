package com.google.gson.internal.bind;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.AlLFFp;
import com.google.gson.internal.Excluder;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final com.google.gson.internal.ARc23Z f12147AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final FieldNamingStrategy f12148AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Excluder f12149AmA8tU;

    public static final class Adapter<T> extends TypeAdapter<T> {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final AlLFFp f12150A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final LinkedHashMap f12151A4TApA;

        public Adapter(AlLFFp alLFFp, LinkedHashMap linkedHashMap) {
            this.f12150A2egSU = alLFFp;
            this.f12151A4TApA = linkedHashMap;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public final Object read2(Q2dWmT.A4TApA a4TApA) {
            if (a4TApA.BChYOn() == 9) {
                a4TApA.B3GDIM();
                return null;
            }
            Object AZkASS2 = this.f12150A2egSU.AZkASS();
            try {
                a4TApA.A4TApA();
                while (a4TApA.AZOQYO()) {
                    AMqCpz aMqCpz = (AMqCpz) this.f12151A4TApA.get(a4TApA.B25kr6());
                    if (aMqCpz != null && aMqCpz.f12093A5SV6n) {
                        Object read2 = aMqCpz.f12095ARc23Z.read2(a4TApA);
                        if (read2 != null || !aMqCpz.f12098AZOQYO) {
                            aMqCpz.f12094ADYaiT.set(AZkASS2, read2);
                        }
                    }
                    a4TApA.BPw6Q8();
                }
                a4TApA.ARc23Z();
                return AZkASS2;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
            if (obj == null) {
                a5SV6n.AZOQYO();
                return;
            }
            a5SV6n.A5SV6n();
            try {
                for (AMqCpz aMqCpz : this.f12151A4TApA.values()) {
                    boolean z = aMqCpz.f12092A4TApA;
                    Field field = aMqCpz.f12094ADYaiT;
                    if (z && field.get(obj) != obj) {
                        a5SV6n.ASJ6gh(aMqCpz.f12091A2egSU);
                        Object obj2 = field.get(obj);
                        boolean z2 = aMqCpz.AMqCpz;
                        TypeAdapter typeAdapter = aMqCpz.f12095ARc23Z;
                        (z2 ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(aMqCpz.f12096ASJ6gh, typeAdapter, aMqCpz.f12097AYUAbz.getType())).write(a5SV6n, obj2);
                    }
                }
                a5SV6n.ARc23Z();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.ARc23Z aRc23Z, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f12147AcNBzu = aRc23Z;
        this.f12148AlLFFp = fieldNamingStrategy;
        this.f12149AmA8tU = excluder;
    }

    public final boolean A2egSU(Field field, boolean z) {
        Class<?> type = field.getType();
        Excluder excluder = this.f12149AmA8tU;
        if (excluder.A4TApA(type, z) || (excluder.f12071AlLFFp & field.getModifiers()) != 0) {
            return false;
        }
        if (excluder.f12070AcNBzu != -1.0d) {
            PlKZ28.ADYaiT aDYaiT = (PlKZ28.ADYaiT) field.getAnnotation(PlKZ28.ADYaiT.class);
            PlKZ28.AMqCpz aMqCpz = (PlKZ28.AMqCpz) field.getAnnotation(PlKZ28.AMqCpz.class);
            if (aDYaiT != null && aDYaiT.value() > excluder.f12070AcNBzu) {
                return false;
            }
            if (aMqCpz != null && aMqCpz.value() <= excluder.f12070AcNBzu) {
                return false;
            }
        }
        if (field.isSynthetic()) {
            return false;
        }
        if (excluder.f12073AzWtSf) {
            PlKZ28.A2egSU a2egSU = (PlKZ28.A2egSU) field.getAnnotation(PlKZ28.A2egSU.class);
            if (a2egSU == null) {
                return false;
            }
            if (z) {
                if (!a2egSU.serialize()) {
                    return false;
                }
            } else if (!a2egSU.deserialize()) {
                return false;
            }
        }
        if (!excluder.f12072AmA8tU) {
            Class<?> type2 = field.getType();
            if (type2.isMemberClass() && (type2.getModifiers() & 8) == 0) {
                return false;
            }
        }
        Class<?> type3 = field.getType();
        if (!Enum.class.isAssignableFrom(type3) && (type3.isAnonymousClass() || type3.isLocalClass())) {
            return false;
        }
        List list = z ? excluder.f12074B25kr6 : excluder.f12075B2KMhB;
        if (list.isEmpty()) {
            return true;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipField(fieldAttributes)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    @Override // com.google.gson.TypeAdapterFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.TypeAdapter create(com.google.gson.Gson r27, com.google.gson.reflect.TypeToken r28) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }
}
