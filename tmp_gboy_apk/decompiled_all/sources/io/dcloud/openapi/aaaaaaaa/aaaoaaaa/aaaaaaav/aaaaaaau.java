package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class aaaaaaau {
    private final String aaaaaaa0;
    private final Class aaaaaaaa;
    private final Class[] aaaaaaao;

    public aaaaaaau(Class cls, String str, Class... clsArr) {
        this.aaaaaaaa = cls;
        this.aaaaaaa0 = str;
        this.aaaaaaao = clsArr;
    }

    public Object aaaaaaa0(Object obj, Object... objArr) {
        Method aaaaaaaa = aaaaaaaa((Class) obj.getClass());
        if (aaaaaaaa == null) {
            return null;
        }
        try {
            return aaaaaaaa.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public boolean aaaaaaaa(Object obj) {
        return aaaaaaaa((Class) obj.getClass()) != null;
    }

    public Object aaaaaaac(Object obj, Object... objArr) {
        try {
            return aaaaaaaa(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object aaaaaaao(Object obj, Object... objArr) {
        try {
            return aaaaaaa0(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object aaaaaaaa(Object obj, Object... objArr) {
        Method aaaaaaaa = aaaaaaaa((Class) obj.getClass());
        if (aaaaaaaa == null) {
            throw new AssertionError("Method " + this.aaaaaaa0 + " not supported for object " + obj);
        }
        try {
            return aaaaaaaa.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + aaaaaaaa);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    private Method aaaaaaaa(Class cls) {
        Class cls2;
        String str = this.aaaaaaa0;
        if (str == null) {
            return null;
        }
        Method aaaaaaaa = aaaaaaaa(cls, str, this.aaaaaaao);
        if (aaaaaaaa == null || (cls2 = this.aaaaaaaa) == null || cls2.isAssignableFrom(aaaaaaaa.getReturnType())) {
            return aaaaaaaa;
        }
        return null;
    }

    private static Method aaaaaaaa(Class cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
