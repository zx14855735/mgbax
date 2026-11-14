package com.bytedance.sdk.component.p.y;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends hf {
    private xj() {
    }

    public static xj xj() {
        if (hf.xj != null) {
            return hf.xj;
        }
        synchronized (xj.class) {
            try {
                if (hf.xj != null) {
                    return hf.xj;
                }
                xj xjVar = new xj();
                hf.xj = xjVar;
                return xjVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public com.bytedance.sdk.component.p.xj.xj.xj xj(com.bytedance.sdk.component.p.xj.xj.xj xjVar) {
        try {
            Class<?> cls = xjVar.getClass();
            if (cls.isAnnotationPresent(com.bytedance.sdk.component.p.hf.hf.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.p.hf.hf) cls.getAnnotation(com.bytedance.sdk.component.p.hf.hf.class)).xj())) {
                return (com.bytedance.sdk.component.p.xj.xj.xj) cls.newInstance();
            }
            return xjVar;
        } catch (Throwable unused) {
            return xjVar;
        }
    }

    public void xj(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.p.hf.hf.class)) {
            xj(obj, map, cls);
        }
    }

    private static void xj(Object obj, Map<String, Object> map, Class<?> cls) {
        com.bytedance.sdk.component.p.hf.xj xjVar;
        for (Field field : xj(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.p.hf.xj.class) && (xjVar = (com.bytedance.sdk.component.p.hf.xj) field.getAnnotation(com.bytedance.sdk.component.p.hf.xj.class)) != null) {
                field.setAccessible(true);
                String xj = xjVar.xj();
                if (TextUtils.isEmpty(xj)) {
                    xj = com.bytedance.sdk.component.p.f.xj.xj(field.getName(), true);
                }
                if (!TextUtils.isEmpty(xj)) {
                    com.bytedance.sdk.component.p.kd.xj.hf.xj(obj, map, field, xj);
                }
            }
        }
    }

    public static Field[] xj(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
