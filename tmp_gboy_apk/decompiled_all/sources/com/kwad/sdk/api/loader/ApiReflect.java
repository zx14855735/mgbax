package com.kwad.sdk.api.loader;

import ADYaiT.CtFAbx;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ApiReflect {
    private final Class<?> axS;
    private final Object axT;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    public static class b {
        private b() {
        }
    }

    private ApiReflect(Class<?> cls) {
        this(cls, cls);
    }

    public static ApiReflect a(Class<?> cls) {
        return new ApiReflect(cls);
    }

    private static Class<?>[] c(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    private ApiReflect cA(String str) {
        try {
            Field cB = cB(str);
            return a(cB.getType(), cB.get(this.axT));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field cB(String str) {
        Class<?> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type == null);
            throw new ReflectException(e);
        }
    }

    public static ApiReflect cz(String str) {
        return a(forName(str));
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private ApiReflect h(String str, Object... objArr) {
        return a(str, c(objArr), objArr);
    }

    public static ApiReflect i(Object obj) {
        return new ApiReflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Object j(Object obj) {
        return obj instanceof ApiReflect ? ((ApiReflect) obj).get() : obj;
    }

    private Class<?> type() {
        return this.axS;
    }

    public final ApiReflect EW() {
        return b(new Object[0]);
    }

    public final ApiReflect b(String str, Object obj) {
        try {
            Field cB = cB(str);
            if ((cB.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(cB, cB.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            cB.set(this.axT, j(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public final ApiReflect cC(String str) {
        return h(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiReflect) {
            return this.axT.equals(((ApiReflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.axT;
    }

    public final int hashCode() {
        return this.axT.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.axT);
    }

    private ApiReflect(Class<?> cls, Object obj) {
        this.axS = cls;
        this.axT = obj;
    }

    private static ApiReflect a(Class<?> cls, Object obj) {
        return new ApiReflect(cls, obj);
    }

    public final <T> T get(String str) {
        return (T) cA(str).get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (java.lang.reflect.Modifier.isPublic(r0.getDeclaringClass().getModifiers()) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T extends java.lang.reflect.AccessibleObject> T a(T r2) {
        /*
            if (r2 != 0) goto L4
            r2 = 0
            return r2
        L4:
            boolean r0 = r2 instanceof java.lang.reflect.Member
            if (r0 == 0) goto L24
            r0 = r2
            java.lang.reflect.Member r0 = (java.lang.reflect.Member) r0
            int r1 = r0.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L24
            java.lang.Class r0 = r0.getDeclaringClass()
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
            if (r0 == 0) goto L24
            goto L2e
        L24:
            boolean r0 = r2.isAccessible()
            if (r0 != 0) goto L2e
            r0 = 1
            r2.setAccessible(r0)
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.ApiReflect.a(java.lang.reflect.AccessibleObject):java.lang.reflect.AccessibleObject");
    }

    public static class a {
        private static final Method axU;
        private static final Method axV;
        private static final Method axW;
        private static final Method axX;
        private static final Method axY;
        private static final Method axZ;
        private static final Method aya;
        private static final Method ayb;
        private static final Method ayc;
        private static final Method ayd;
        private static final Method aye;
        private static final Method ayf;
        private static final Method ayg;
        private static final Method ayh;

        static {
            try {
                axU = Class.class.getDeclaredMethod("forName", String.class);
                axV = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                axW = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                axX = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                axY = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                axZ = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                aya = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                ayb = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                ayc = Class.class.getDeclaredMethod("getField", String.class);
                ayd = Class.class.getDeclaredMethod("getFields", new Class[0]);
                aye = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                ayf = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                ayg = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                ayh = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        public static Field a(Class cls, String str) {
            try {
                return (Field) axW.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Field b(Class cls, String str) {
            try {
                return (Field) ayc.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) axY.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) aye.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) ayb.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Class forName(String str) {
            try {
                return (Class) axU.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) aya.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Method[] c(Class cls) {
            try {
                return (Method[]) axZ.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Method[] d(Class cls) {
            try {
                return (Method[]) ayf.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
    }

    private Method b(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        for (Method method : a.d(type)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.c(type)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("No similar method ", str, " with params ");
        B3GDIM2.append(Arrays.toString(clsArr));
        B3GDIM2.append(" could be found on type ");
        B3GDIM2.append(type());
        B3GDIM2.append(".");
        throw new NoSuchMethodException(B3GDIM2.toString());
    }

    public final ApiReflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.axT, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, clsArr), this.axT, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return a.d(type, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(type, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    public final ApiReflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    private ApiReflect b(Object... objArr) {
        return a(c(objArr), objArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != b.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private static ApiReflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static ApiReflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return i(obj);
            }
            return i(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }
}
