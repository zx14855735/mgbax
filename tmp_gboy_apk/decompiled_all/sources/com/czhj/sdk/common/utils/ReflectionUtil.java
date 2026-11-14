package com.czhj.sdk.common.utils;

import com.czhj.sdk.common.utils.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ReflectionUtil {

    public static class MethodBuilder {

        /* renamed from: a, reason: collision with root package name */
        private final Object f10609a;
        private final String b;
        private Class<?> c;
        private final List<Class<?>> d;
        private final List<Object> e;
        private boolean f;
        private boolean g;

        public MethodBuilder(Class cls, String str) {
            Preconditions.NoThrow.checkNotNull(str);
            this.g = true;
            this.f10609a = null;
            this.b = str;
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.c = cls;
        }

        public <T> MethodBuilder addParam(Class<T> cls, T t) {
            Preconditions.NoThrow.checkNotNull(cls);
            this.d.add(cls);
            this.e.add(t);
            return this;
        }

        public Object execute() {
            Method declaredMethodWithTraversal = ReflectionUtil.getDeclaredMethodWithTraversal(this.c, this.b, (Class[]) this.d.toArray(new Class[this.d.size()]));
            if (this.f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            return declaredMethodWithTraversal.invoke(this.g ? null : this.f10609a, this.e.toArray());
        }

        public MethodBuilder(Object obj, String str) {
            Preconditions.NoThrow.checkNotNull(str);
            this.f10609a = obj;
            this.b = str;
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.c = obj != null ? obj.getClass() : null;
        }
    }

    public static Method getDeclaredMethodWithTraversal(Class<?> cls, String str, Class<?>... clsArr) {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(clsArr);
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static List<Method> getMethodWithTraversal(Class<?> cls) {
        Preconditions.NoThrow.checkNotNull(cls);
        try {
            return Arrays.asList(cls.getMethods());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> getPrivateFields(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        HashMap hashMap = new HashMap(declaredFields.length);
        for (Field field : declaredFields) {
            hashMap.put(field.getName(), field.getType().getName());
        }
        return hashMap;
    }
}
