package com.fl.saas.common.util;

import com.fl.saas.common.util.feature.BiConsumer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ReflectHelper {
    private static final String ANDROID = "android.";
    public static final String HM_PREFIX = "com.hm.";
    private static final String JAVA = "java.";
    public static final String MS_PREFIX = "com.ms.";
    public static final String SM_PREFIX = "com.sm.";
    public static final String WK_PREFIX = "com.jinbeig.wkad.";
    public static final String YD_PREFIX = "com.fl.";

    public static void copyFields(Object obj, Object obj2) {
        Map<String, Field> fields = getFields(obj.getClass());
        Map<String, Field> fields2 = getFields(obj2.getClass());
        for (Field field : fields.values()) {
            Field field2 = fields2.get(field.getName());
            if (field2 != null && field2.getType().equals(field.getType())) {
                field.setAccessible(true);
                field2.setAccessible(true);
                try {
                    field2.set(obj2, field.get(obj));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Map<String, Field> getFields(Class<?> cls) {
        HashMap hashMap = new HashMap();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                hashMap.put(field.getName(), field);
            }
            cls = cls.getSuperclass();
            if (isFinish(cls)) {
                cls = null;
            }
        }
        return hashMap;
    }

    public static Class<?> getGenericType(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        try {
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                return (Class) actualTypeArguments[0];
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Method> getMethods(Class<?> cls, boolean z) {
        HashMap hashMap = new HashMap();
        while (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                hashMap.put(method.getName(), method);
            }
            cls = (z && isFinish(cls)) ? cls.getSuperclass() : null;
        }
        return hashMap;
    }

    public static <T extends Annotation> T getSupperAnnotations(Class<T> cls, Class<?> cls2) {
        T t = (T) cls2.getAnnotation(cls);
        if (t != null) {
            return t;
        }
        Class<? super Object> superclass = cls2.getSuperclass();
        if (isFinish(superclass)) {
            return null;
        }
        return (T) getSupperAnnotations(cls, superclass);
    }

    private static boolean isFinish(Class<?> cls) {
        if (cls == null) {
            return true;
        }
        String name = cls.getName();
        return (name.startsWith(YD_PREFIX) || name.startsWith(MS_PREFIX) || name.startsWith(HM_PREFIX) || name.startsWith(SM_PREFIX) || name.startsWith(WK_PREFIX)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$proxyInterface$0(Map map, BiConsumer biConsumer, Map map2, Object obj, Object obj2, Method method, Object[] objArr) {
        String name = method.getName();
        Method method2 = (Method) map.get(name);
        if (biConsumer != null && map2.get(name) != null) {
            biConsumer.accept(method, objArr);
        }
        return method2.invoke(obj, objArr);
    }

    public static <T> T proxyInterface(Class<T> cls, final Object obj, final BiConsumer<Method, Object[]> biConsumer) {
        if (obj == null) {
            return null;
        }
        Class<?> cls2 = obj.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        final Map<String, Method> methods = getMethods(cls2, false);
        final Map<String, Method> methods2 = getMethods(cls, false);
        return (T) Proxy.newProxyInstance(classLoader, cls.isInterface() ? new Class[]{cls} : cls.getInterfaces(), new InvocationHandler() { // from class: com.fl.saas.common.util.ARc23Z
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                Object lambda$proxyInterface$0;
                lambda$proxyInterface$0 = ReflectHelper.lambda$proxyInterface$0(methods, biConsumer, methods2, obj, obj2, method, objArr);
                return lambda$proxyInterface$0;
            }
        });
    }
}
