package com.fl.saas.common.util;

import android.text.TextUtils;
import com.fl.saas.common.util.feature.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ReflectUtils {
    public static <T> T callMethodByName(Object obj, String str, Object... objArr) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Class<?>[] parameterTypes = getParameterTypes(objArr);
                Method method = null;
                for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Method method2 = declaredMethods[i];
                            Class<?>[] parameterTypes2 = method2.getParameterTypes();
                            if (str.equals(method2.getName()) && objArr.length == parameterTypes2.length) {
                                if (objArr.length != 0) {
                                    for (int i2 = 0; i2 < parameterTypes.length && parameterTypes[i2] == getWrapperClass(parameterTypes2[i2]); i2++) {
                                    }
                                }
                                method = method2;
                            }
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (method != null) {
                        break;
                    }
                }
                if (method == null) {
                    return null;
                }
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return (T) method.invoke(obj, objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static <T> List<T> findAll(Class<?> cls, AmA8tU.A2egSU a2egSU, Predicate<? super T> predicate) {
        ArrayList arrayList = new ArrayList();
        if (cls != null) {
            while (cls != null) {
                for (ADYaiT.A4TApA a4TApA : (List) a2egSU.apply(cls)) {
                    if (predicate == null || predicate.test(a4TApA)) {
                        arrayList.add(a4TApA);
                    }
                }
                cls = cls.getSuperclass();
            }
        }
        return arrayList;
    }

    public static List<Field> findAllField(Class<?> cls) {
        return findAll(cls, (AmA8tU.A2egSU) new com.fl.saas.base.manager.loader.ADYaiT(10), (Predicate) new com.fl.saas.base.manager.loader.ADYaiT(11));
    }

    public static List<Method> findAllMethods(Class<?> cls) {
        return findAll(cls, (AmA8tU.A2egSU) new com.fl.saas.base.manager.loader.ADYaiT(12), (Predicate) new com.fl.saas.base.manager.loader.ADYaiT(13));
    }

    public static List<Method> findMethodsByPredicate(Class<?> cls, Predicate<Method> predicate) {
        ArrayList arrayList = new ArrayList();
        if (cls != null && predicate != null) {
            while (cls != null) {
                Method[] methods = cls.getMethods();
                if (methods != null) {
                    for (Method method : methods) {
                        if (predicate.test(method)) {
                            arrayList.add(method);
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
        }
        return arrayList;
    }

    public static List<Method> findMethodsByType(Class<?> cls, Class<?> cls2) {
        return findMethodsByPredicate(cls, new ASJ6gh(1, cls2));
    }

    public static Field getField(Class<?> cls, String str) {
        Field field = null;
        if (cls != null && !TextUtils.isEmpty(str)) {
            while (cls != null) {
                try {
                    field = cls.getDeclaredField(str);
                    field.setAccessible(true);
                    break;
                } catch (NoSuchFieldException | SecurityException e) {
                    e.printStackTrace();
                    cls = cls.getSuperclass();
                }
            }
        }
        return field;
    }

    public static <T> T getFieldByCondition(Object obj, AmA8tU.A2egSU a2egSU) {
        if (obj != null && a2egSU != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (Boolean.TRUE.equals(a2egSU.apply(field))) {
                    try {
                        field.setAccessible(true);
                        return (T) field.get(obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static Object getFieldRecursionValue(Object obj, String... strArr) {
        if (obj == null || strArr == null || strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            if (obj == null || TextUtils.isEmpty(str)) {
                return null;
            }
            obj = getSuperFieldValue(obj, str);
        }
        return obj;
    }

    public static Object getFieldValue(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Field declaredField = obj.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T getFieldValueByCondition(Object obj, AmA8tU.A2egSU a2egSU) {
        T t;
        if (obj != null && a2egSU != null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        t = (T) field.get(obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (Boolean.TRUE.equals(a2egSU.apply(t))) {
                        return t;
                    }
                }
            }
        }
        return null;
    }

    public static <T> T getFieldValueByType(Object obj, Class<T> cls) {
        if (obj == null || cls == null) {
            return null;
        }
        return (T) getFieldByCondition(obj, new ASJ6gh(0, cls));
    }

    public static <T> T getFieldValueByTypeName(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) getFieldByCondition(obj, new ASJ6gh(3, str));
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            Class<?> cls = obj.getClass();
            if (cls.isPrimitive()) {
                if (obj instanceof Integer) {
                    cls = Integer.TYPE;
                } else if (obj instanceof Long) {
                    cls = Long.TYPE;
                } else if (obj instanceof Double) {
                    cls = Double.TYPE;
                } else if (obj instanceof Float) {
                    cls = Float.TYPE;
                } else if (obj instanceof Boolean) {
                    cls = Boolean.TYPE;
                } else if (obj instanceof Short) {
                    cls = Short.TYPE;
                } else if (obj instanceof Byte) {
                    cls = Byte.TYPE;
                } else if (obj instanceof Character) {
                    cls = Character.TYPE;
                }
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static <T> List<T> getStaticFinalValues(Class<?> cls, Class<T> cls2) {
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.getType() == cls2) {
                try {
                    field.setAccessible(true);
                    arrayList.add(field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static Object getSuperFieldValue(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                }
            }
        }
        return null;
    }

    public static Class<?> getWrapperClass(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : cls == Integer.TYPE ? Integer.class : cls == Long.TYPE ? Long.class : cls == Double.TYPE ? Double.class : cls == Float.TYPE ? Float.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$findAllField$2(Class cls) {
        return Arrays.asList(cls.getDeclaredFields());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllField$3(Field field) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$findAllMethods$4(Class cls) {
        return Arrays.asList(cls.getDeclaredMethods());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllMethods$5(Method method) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findMethodsByType$6(Class cls, Method method) {
        return method.getReturnType() == cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$getFieldValueByType$1(Class cls, Field field) {
        return Boolean.valueOf(field.getType() == cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$getFieldValueByTypeName$0(String str, Field field) {
        return Boolean.valueOf(TextUtils.equals(field.getType().getSimpleName(), str));
    }

    public static <T> List<T> findAll(Object obj, AmA8tU.A2egSU a2egSU, Predicate<? super T> predicate) {
        return obj == null ? new ArrayList() : findAll(obj.getClass(), a2egSU, (Predicate) predicate);
    }

    public static List<Field> findAllField(Object obj) {
        return obj == null ? new ArrayList() : findAllField(obj.getClass());
    }

    public static List<Method> findAllMethods(Object obj) {
        return obj == null ? new ArrayList() : findAllMethods(obj.getClass());
    }

    public static List<Method> findMethodsByType(Object obj, Class<?> cls) {
        return (obj == null || cls == null) ? new ArrayList() : findMethodsByType(obj.getClass(), cls);
    }

    public static Field getField(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return getField(obj.getClass(), str);
    }
}
