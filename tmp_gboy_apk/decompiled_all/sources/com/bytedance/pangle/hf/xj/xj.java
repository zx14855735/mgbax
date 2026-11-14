package com.bytedance.pangle.hf.xj;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static Map<String, Field> xj = new HashMap();
    private static Map<String, Method> hf = new HashMap();
    private static Map<String, Constructor> w = new HashMap();
    private static Map<String, Class> u = new HashMap();

    static {
        try {
            FieldUtils.writeField(hf.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    private static String hf(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    public static Field xj(Class<?> cls, String str) {
        Field field;
        String hf2 = hf(cls, str);
        synchronized (xj) {
            field = xj.get(hf2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field xj2 = hf.xj(cls, str);
            if (xj2 == null) {
                return xj2;
            }
            synchronized (xj) {
                xj.put(hf2, xj2);
            }
            return xj2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper".concat("getField " + cls.getName() + "#" + str + " failed !!!"), th);
            return null;
        }
    }

    private static String hf(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static Method xj(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String hf2 = hf(cls, str, clsArr);
        synchronized (hf) {
            method = hf.get(hf2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method xj2 = hf.xj(cls, str, clsArr);
            if (xj2 == null) {
                return xj2;
            }
            synchronized (hf) {
                hf.put(hf2, xj2);
            }
            return xj2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper".concat("getMethod " + cls.getName() + "#" + str + " failed !!!"), th);
            return null;
        }
    }

    public static Constructor xj(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String hf2 = hf(cls, "clinit", clsArr);
        synchronized (w) {
            constructor = w.get(hf2);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor xj2 = hf.xj(cls, clsArr);
            if (xj2 == null) {
                return xj2;
            }
            synchronized (w) {
                w.put(hf2, xj2);
            }
            return xj2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper".concat("getConstructor " + cls.getName() + " failed !!!"), th);
            return null;
        }
    }
}
