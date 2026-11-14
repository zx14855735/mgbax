package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final ADYaiT f8972A5SV6n = new ADYaiT();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f8973A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f8974A4TApA = new HashMap();

    static {
        iDUmDd();
    }

    public static void A4TApA(HashMap hashMap, A5SV6n a5SV6n, AlLFFp alLFFp, Class cls) {
        AlLFFp alLFFp2 = (AlLFFp) hashMap.get(a5SV6n);
        if (alLFFp2 == null || alLFFp == alLFFp2) {
            if (alLFFp2 == null) {
                hashMap.put(a5SV6n, alLFFp);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + a5SV6n.f8971A4TApA.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + alLFFp2 + ", new value " + alLFFp);
    }

    private static /* synthetic */ void iDUmDd() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final A4TApA A2egSU(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f8973A2egSU;
        if (superclass != null) {
            A4TApA a4TApA = (A4TApA) hashMap2.get(superclass);
            if (a4TApA == null) {
                a4TApA = A2egSU(superclass, null);
            }
            hashMap.putAll(a4TApA.f8969A4TApA);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            A4TApA a4TApA2 = (A4TApA) hashMap2.get(cls2);
            if (a4TApA2 == null) {
                a4TApA2 = A2egSU(cls2, null);
            }
            for (Map.Entry entry : a4TApA2.f8969A4TApA.entrySet()) {
                A4TApA(hashMap, (A5SV6n) entry.getKey(), (AlLFFp) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            BmvVmW bmvVmW = (BmvVmW) method.getAnnotation(BmvVmW.class);
            if (bmvVmW != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!B9tovu.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                AlLFFp value = bmvVmW.value();
                if (parameterTypes.length > 1) {
                    if (!AlLFFp.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != AlLFFp.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                A4TApA(hashMap, new A5SV6n(i, method), value, cls);
                z = true;
            }
        }
        A4TApA a4TApA3 = new A4TApA(hashMap);
        hashMap2.put(cls, a4TApA3);
        this.f8974A4TApA.put(cls, Boolean.valueOf(z));
        return a4TApA3;
    }
}
