package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final TypeAdapterFactory f12129A5SV6n = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            Type type = typeToken.getType();
            boolean z = type instanceof GenericArrayType;
            if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type genericComponentType = z ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(genericComponentType)), com.google.gson.internal.ADYaiT.ARc23Z(genericComponentType));
        }
    };

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Class f12130A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final TypeAdapter f12131A4TApA;

    static {
        WAaRsj();
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.f12131A4TApA = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f12130A2egSU = cls;
    }

    private static /* synthetic */ void WAaRsj() {
        char[] charArray = "Û×Õ\u0096ßÙÕÝ\u0096Ú×Á\u0096ËÐÝÔÔ\u0096òÖÑúÊÑÜßÝ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 184);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÛÔÑÖÑÌ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 184);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(Q2dWmT.A4TApA a4TApA) {
        if (a4TApA.BChYOn() == 9) {
            a4TApA.B3GDIM();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a4TApA.A2egSU();
        while (a4TApA.AZOQYO()) {
            arrayList.add(((TypeAdapterRuntimeTypeWrapper) this.f12131A4TApA).f12168A4TApA.read2(a4TApA));
        }
        a4TApA.AMqCpz();
        Object newInstance = Array.newInstance((Class<?>) this.f12130A2egSU, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
        if (obj == null) {
            a5SV6n.AZOQYO();
            return;
        }
        a5SV6n.A4TApA();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f12131A4TApA.write(a5SV6n, Array.get(obj, i));
        }
        a5SV6n.AMqCpz();
    }
}
