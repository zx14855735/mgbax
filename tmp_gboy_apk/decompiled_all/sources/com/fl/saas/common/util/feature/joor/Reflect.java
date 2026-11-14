package com.fl.saas.common.util.feature.joor;

import ADYaiT.CtFAbx;
import AmA8tU.A2egSU;
import com.fl.saas.common.util.feature.Predicate;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Reflect {
    private final Object object;
    private final Class<?> type;

    public static class NULL {
        private NULL() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (java.lang.reflect.Modifier.isPublic(r0.getDeclaringClass().getModifiers()) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T extends java.lang.reflect.AccessibleObject> T accessible(T r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.common.util.feature.joor.Reflect.accessible(java.lang.reflect.AccessibleObject):java.lang.reflect.AccessibleObject");
    }

    private Method exactMethod(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return type.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return type.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private Field field0(String str) {
        Class<?> type = type();
        try {
            return (Field) accessible(type.getField(str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(type.getDeclaredField(str));
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

    private static Class<?> forName(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static <T> T initValue(Class<T> cls) {
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Double.TYPE) {
            return (T) Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        return null;
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != NULL.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static Reflect on(Class<?> cls) {
        return onClass(cls);
    }

    public static Reflect onClass(Class<?> cls) {
        return new Reflect(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private Method similarMethod(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        for (Method method : type.getMethods()) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : type.getDeclaredMethods()) {
                if (isSimilarSignature(method2, str, clsArr)) {
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

    private static Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    private static Object unwrap(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    public static <T> Class<T> wrapper(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public <P> P as(Class<P> cls) {
        return (P) as(cls, new Class[0]);
    }

    public Reflect call(String str) {
        return call(str, new Object[0]);
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.object.equals(((Reflect) obj).get());
        }
        return false;
    }

    public Reflect field(String str) {
        try {
            Field field0 = field0(str);
            return on(field0.getType(), field0.get(this.object));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((this.type != this.object) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        return linkedHashMap;
    }

    public List<Reflect> filterMethod(Predicate<Method> predicate, A2egSU a2egSU) {
        ArrayList arrayList = new ArrayList();
        Class<?> type = type();
        do {
            try {
                for (Method method : type.getDeclaredMethods()) {
                    Method method2 = (Method) accessible(method);
                    if (predicate.test(method2)) {
                        arrayList.add(on(method2, this.object, a2egSU == null ? new Object[0] : (Object[]) a2egSU.apply(method2)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            type = type.getSuperclass();
        } while (type != null);
        return arrayList;
    }

    public Reflect findFirstField(Predicate<Field> predicate) {
        Class<?> type = type();
        do {
            try {
                for (Field field : type.getDeclaredFields()) {
                    if (predicate.test(field)) {
                        return on(((Field) accessible(field)).get(this.object));
                    }
                }
                type = type.getSuperclass();
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        } while (type != null);
        throw new ReflectException();
    }

    public Reflect findFirstFieldByReflect(Predicate<Reflect> predicate) {
        Class<?> type = type();
        do {
            try {
                for (Field field : type.getDeclaredFields()) {
                    Field field2 = (Field) accessible(field);
                    Object obj = field2.get(this.object);
                    Reflect on = obj == null ? on(field2.getType(), (Object) null) : on(obj);
                    if (predicate.test(on)) {
                        return on;
                    }
                }
                type = type.getSuperclass();
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        } while (type != null);
        throw new ReflectException();
    }

    public <T> T get() {
        return (T) this.object;
    }

    public void handleAnntion() {
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String str, Object obj) {
        try {
            Field field0 = field0(str);
            if ((field0.getModifiers() & 16) == 16) {
                try {
                    Field declaredField = Field.class.getDeclaredField("modifiers");
                    declaredField.setAccessible(true);
                    declaredField.setInt(field0, field0.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            field0.set(this.object, unwrap(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public String toString() {
        return String.valueOf(this.object);
    }

    public Class<?> type() {
        return this.type;
    }

    private Reflect(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    private static Class<?> forName(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Reflect on(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect onClass(String str) {
        return onClass(forName(str));
    }

    public <P> P as(Class<P> cls, Class<?>... clsArr) {
        final boolean z = this.object instanceof Map;
        InvocationHandler invocationHandler = new InvocationHandler() { // from class: com.fl.saas.common.util.feature.joor.Reflect.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                try {
                    return Reflect.on((Class<?>) Reflect.this.type, Reflect.this.object).call(name, objArr).get();
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) Reflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(Reflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(Reflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(Reflect.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        };
        Class[] clsArr2 = new Class[clsArr.length + 1];
        clsArr2[0] = cls;
        System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), clsArr2, invocationHandler);
    }

    public Reflect call(String str, Object... objArr) {
        Class<?>[] types = types(objArr);
        try {
            try {
                return on(exactMethod(str, types), this.object, objArr);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        } catch (NoSuchMethodException unused) {
            return on(similarMethod(str, types), this.object, objArr);
        }
    }

    public Reflect create(Object... objArr) {
        Class<?>[] types = types(objArr);
        try {
            return on(type().getDeclaredConstructor(types), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), types)) {
                    return on(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public <T> T get(String str) {
        return (T) field(str).get();
    }

    public static Reflect on(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static Reflect onClass(String str, ClassLoader classLoader) {
        return onClass(forName(str, classLoader));
    }

    @Deprecated
    public static Reflect on(String str) {
        return onClass(str);
    }

    @Deprecated
    public static Reflect on(String str, ClassLoader classLoader) {
        return onClass(str, classLoader);
    }

    private static Reflect on(Constructor<?> constructor, Object... objArr) {
        try {
            return on(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Reflect on(Method method, Object obj, Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return on(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return on(obj);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }
}
