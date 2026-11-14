package com.bytedance.sdk.component.w.hf.xj.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class u<T> {
    private final String hf;
    private final Class[] w;
    private final Class<?> xj;

    public u(Class<?> cls, String str, Class... clsArr) {
        this.xj = cls;
        this.hf = str;
        this.w = clsArr;
    }

    public Object hf(T t, Object... objArr) {
        try {
            return xj(t, objArr);
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

    public Object u(T t, Object... objArr) {
        try {
            return w(t, objArr);
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

    public Object w(T t, Object... objArr) {
        Method xj = xj(t.getClass());
        if (xj != null) {
            try {
                return xj.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(xj)));
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.hf + " not supported for object " + t);
    }

    public boolean xj(T t) {
        return xj(t.getClass()) != null;
    }

    public Object xj(T t, Object... objArr) {
        Method xj = xj(t.getClass());
        if (xj == null) {
            return null;
        }
        try {
            return xj.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    private Method xj(Class<?> cls) {
        Class<?> cls2;
        String str = this.hf;
        if (str == null) {
            return null;
        }
        Method xj = xj(cls, str, this.w);
        if (xj == null || (cls2 = this.xj) == null || cls2.isAssignableFrom(xj.getReturnType())) {
            return xj;
        }
        return null;
    }

    private static Method xj(Class<?> cls, String str, Class[] clsArr) {
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
