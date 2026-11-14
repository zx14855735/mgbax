package com.google.gson.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Map f12060A2egSU;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        Class cls = Boolean.TYPE;
        hashMap.put(cls, Boolean.class);
        hashMap2.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(cls2, Byte.class);
        hashMap2.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(cls3, Character.class);
        hashMap2.put(Character.class, cls3);
        Class cls4 = Double.TYPE;
        hashMap.put(cls4, Double.class);
        hashMap2.put(Double.class, cls4);
        Class cls5 = Float.TYPE;
        hashMap.put(cls5, Float.class);
        hashMap2.put(Float.class, cls5);
        Class cls6 = Integer.TYPE;
        hashMap.put(cls6, Integer.class);
        hashMap2.put(Integer.class, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(cls7, Long.class);
        hashMap2.put(Long.class, cls7);
        Class cls8 = Short.TYPE;
        hashMap.put(cls8, Short.class);
        hashMap2.put(Short.class, cls8);
        Class cls9 = Void.TYPE;
        hashMap.put(cls9, Void.class);
        hashMap2.put(Void.class, cls9);
        f12060A2egSU = Collections.unmodifiableMap(hashMap);
        Collections.unmodifiableMap(hashMap2);
        cszb();
    }

    private static /* synthetic */ void cszb() {
        char[] charArray = "\u0092\u009e\u009cß\u0096\u0090\u009c\u0094ß\u0093\u009e\u0088ß\u0082\u0099\u0094\u009d\u009dß»\u009f\u0098³\u0083\u0098\u0095\u0096\u0094".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 241);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0092\u009d\u0098\u009f\u0098\u0085".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 241);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
