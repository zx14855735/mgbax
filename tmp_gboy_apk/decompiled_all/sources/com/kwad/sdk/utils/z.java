package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;
import android.app.Application;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.oaid.helpers.OaidJavaCalls;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class z {
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP;
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;
    private static Map<String, Method> sMethodCache;
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;

    public static class a<T> {
        public final Class<? extends T> aKK;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_MAP = hashMap;
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> hashMap2 = new HashMap<>();
        sPrimitiveToWrapperMap = hashMap2;
        Class<?> cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        Class<?> cls2 = Byte.TYPE;
        hashMap.put(Byte.class, cls2);
        Class<?> cls3 = Character.TYPE;
        hashMap.put(Character.class, cls3);
        Class<?> cls4 = Short.TYPE;
        hashMap.put(Short.class, cls4);
        Class<?> cls5 = Integer.TYPE;
        hashMap.put(Integer.class, cls5);
        Class<?> cls6 = Float.TYPE;
        hashMap.put(Float.class, cls6);
        Class<?> cls7 = Long.TYPE;
        hashMap.put(Long.class, cls7);
        Class<?> cls8 = Double.TYPE;
        hashMap.put(Double.class, cls8);
        hashMap.put(cls, cls);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        hashMap.put(cls5, cls5);
        hashMap.put(cls6, cls6);
        hashMap.put(cls7, cls7);
        hashMap.put(cls8, cls8);
        hashMap2.put(cls, Boolean.class);
        hashMap2.put(cls2, Byte.class);
        hashMap2.put(cls3, Character.class);
        hashMap2.put(cls4, Short.class);
        hashMap2.put(cls5, Integer.class);
        hashMap2.put(cls7, Long.class);
        hashMap2.put(cls8, Double.class);
        hashMap2.put(cls6, Float.class);
        hashMap2.put(Void.TYPE, Void.class);
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Application EX() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean RR() {
        return (sForNameMethod == null || sGetDeclaredMethod == null || sGetFieldMethod == null) ? false : true;
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            wrapToRuntime(th);
        }
    }

    public static <T> T as(String str, String str2) {
        try {
            return (T) at(str, str2);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static <T> T at(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static void b(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    @Deprecated
    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) {
        return (T) getAccessibleMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    @Deprecated
    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(cls, str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) {
        return (T) getAccessibleMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static boolean classExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static <T> T d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    private static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("in new get method from cache: key：", key, " method:");
            B3GDIM2.append(method.getName());
            com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, B3GDIM2.toString());
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method);
                    com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, "in new get method:" + method.getName());
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static <T> T f(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    private static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("in new get method from cache: key：", key, " method:");
            B3GDIM2.append(method.getName());
            com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, B3GDIM2.toString());
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method == null) {
                try {
                    for (Method method2 : cls.getDeclaredMethods()) {
                        if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z = true;
                                for (int i = 0; i < clsArr.length; i++) {
                                    if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    method = method2;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method);
                    com.kwad.sdk.core.d.c.d(OaidJavaCalls.TAG, "in new get method:" + method.getName());
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) f(obj, str);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.toString());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    @Deprecated
    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).aKK;
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((a) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T hk(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = sPrimitiveToWrapperMap.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = sPrimitiveToWrapperMap.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    private static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = k(parameterTypes[i]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object k(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static <T> T newInstance(String str, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    private static void wrapToRuntime(Throwable th) {
        if (!com.kwad.library.a.a.oy.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        } else {
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static <T> T newInstanceOrThrow(String str, Object... objArr) {
        return (T) newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T f(Object obj, String str, Object... objArr) {
        return (T) e(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(cls, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    private static Method a(String str, String str2, Class[] clsArr) {
        Method method = null;
        if (RR()) {
            try {
                try {
                    Method method2 = (Method) sGetDeclaredMethod.invoke((Class) sForNameMethod.invoke(null, str), str2, clsArr);
                    try {
                        method2.setAccessible(true);
                        return method2;
                    } catch (Throwable th) {
                        th = th;
                        method = method2;
                        wrapToRuntime(th);
                        th.printStackTrace();
                        return method;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return method;
    }

    public static Object a(Object obj, String str, String str2) {
        try {
            Method a2 = a(str, str2, (Class[]) null);
            if (a2 != null) {
                return a2.invoke(obj, null);
            }
        } catch (Throwable th) {
            wrapToRuntime(th);
            th.printStackTrace();
        }
        return null;
    }

    public static Object a(String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method a2 = a(str, str2, clsArr);
            if (a2 != null) {
                return a2.invoke(null, objArr);
            }
        } catch (Throwable th) {
            wrapToRuntime(th);
            th.printStackTrace();
        }
        return null;
    }
}
