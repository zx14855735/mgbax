package com.bytedance.sdk.component.p.kd.xj;

import com.bytedance.sdk.component.p.kd.xj.xj.c;
import com.bytedance.sdk.component.p.kd.xj.xj.f;
import com.bytedance.sdk.component.p.kd.xj.xj.kd;
import com.bytedance.sdk.component.p.kd.xj.xj.u;
import com.bytedance.sdk.component.p.kd.xj.xj.w;
import com.bytedance.sdk.component.p.kd.xj.xj.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static final Map<Class, xj> xj;

    static {
        HashMap hashMap = new HashMap();
        xj = hashMap;
        y yVar = new y();
        f fVar = new f();
        c cVar = new c();
        com.bytedance.sdk.component.p.kd.xj.xj.hf hfVar = new com.bytedance.sdk.component.p.kd.xj.xj.hf();
        u uVar = new u();
        kd kdVar = new kd();
        com.bytedance.sdk.component.p.kd.xj.xj.xj xjVar = new com.bytedance.sdk.component.p.kd.xj.xj.xj();
        w wVar = new w();
        hashMap.put(Integer.class, yVar);
        hashMap.put(Integer.TYPE, yVar);
        hashMap.put(Short.class, fVar);
        hashMap.put(Short.TYPE, fVar);
        hashMap.put(Long.class, cVar);
        hashMap.put(Long.TYPE, cVar);
        hashMap.put(Byte.class, hfVar);
        hashMap.put(Byte.TYPE, hfVar);
        hashMap.put(Double.class, uVar);
        hashMap.put(Double.TYPE, uVar);
        hashMap.put(Float.class, kdVar);
        hashMap.put(Float.TYPE, kdVar);
        hashMap.put(Boolean.class, xjVar);
        hashMap.put(Boolean.TYPE, xjVar);
        hashMap.put(Character.class, wVar);
        hashMap.put(Character.TYPE, wVar);
        NHjP();
    }

    private static /* synthetic */ void NHjP() {
        char[] charArray = "\u000f\u0003\u0001B\u000b\r\u0001\tB\u000e\u0003\u0015B\u001f\u0004\t\u0000\u0000B&\u0002\u0005.\u001e\u0005\b\u000b\t".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'l');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000f\u0000\u0005\u0002\u0005\u0018".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'l');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(Object obj, Field field, Object obj2) {
        Object xj2;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            xj2 = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            xj2 = xj(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, xj2);
        } catch (Throwable unused2) {
        }
    }

    public static void xj(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            xj(obj, field, obj2);
        }
    }

    public static Object xj(Class cls, Object obj) {
        String valueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return valueOf;
        }
        xj xjVar = xj.get(cls);
        return xjVar == null ? obj : xjVar.xj(cls, valueOf);
    }
}
