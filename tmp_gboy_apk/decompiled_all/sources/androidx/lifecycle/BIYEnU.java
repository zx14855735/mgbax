package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BIYEnU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final HashMap f8993A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final HashMap f8994A4TApA = new HashMap();

    static {
        OqknZ();
    }

    public static void A2egSU(Constructor constructor, B7CMnp b7CMnp) {
        try {
            RXb0Sz.ARc23Z.ADYaiT(constructor.newInstance(b7CMnp), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static final String A4TApA(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int indexOf = str.indexOf(".", 0);
        if (indexOf >= 0) {
            int length = str.length();
            if (length < 0) {
                throw new OutOfMemoryError();
            }
            StringBuilder sb2 = new StringBuilder(length);
            do {
                sb2.append((CharSequence) str, i, indexOf);
                sb2.append("_");
                i = indexOf + 1;
                if (indexOf >= str.length()) {
                    break;
                }
                indexOf = str.indexOf(".", i);
            } while (indexOf > 0);
            sb2.append((CharSequence) str, i, str.length());
            str = sb2.toString();
            RXb0Sz.ARc23Z.ADYaiT(str, "toString(...)");
        }
        return ADYaiT.CtFAbx.B25kr6(sb, str, "_LifecycleAdapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int A5SV6n(Class cls) {
        Constructor constructor;
        boolean z;
        int i = 1;
        HashMap hashMap = f8993A2egSU;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r4 != null ? r4.getName() : "";
                RXb0Sz.ARc23Z.ADYaiT(name, "fullPackage");
                if (name.length() != 0) {
                    RXb0Sz.ARc23Z.ADYaiT(canonicalName, "name");
                    canonicalName = canonicalName.substring(name.length() + 1);
                    RXb0Sz.ARc23Z.ADYaiT(canonicalName, "this as java.lang.String).substring(startIndex)");
                }
                RXb0Sz.ARc23Z.ADYaiT(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String A4TApA2 = A4TApA(canonicalName);
                if (name.length() != 0) {
                    A4TApA2 = name + '.' + A4TApA2;
                }
                constructor = Class.forName(A4TApA2).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap hashMap2 = f8994A4TApA;
            if (constructor != null) {
                hashMap2.put(cls, RD2OKB.AZkASS.A5SV6n(constructor));
            } else {
                ADYaiT aDYaiT = ADYaiT.f8972A5SV6n;
                HashMap hashMap3 = aDYaiT.f8974A4TApA;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                hashMap3.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            }
                            if (((BmvVmW) declaredMethods[i2].getAnnotation(BmvVmW.class)) != null) {
                                aDYaiT.A2egSU(cls, declaredMethods);
                                z = true;
                                break;
                            }
                            i2++;
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && B7CMnp.class.isAssignableFrom(superclass)) {
                        RXb0Sz.ARc23Z.ADYaiT(superclass, "superclass");
                        if (A5SV6n(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            RXb0Sz.ARc23Z.A4TApA(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    RXb0Sz.ARc23Z.ADYaiT(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length2) {
                            Class<?> cls2 = interfaces[i3];
                            if (cls2 != null && B7CMnp.class.isAssignableFrom(cls2)) {
                                RXb0Sz.ARc23Z.ADYaiT(cls2, "intrface");
                                if (A5SV6n(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(cls2);
                                RXb0Sz.ARc23Z.A4TApA(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i3++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        hashMap.put(cls, Integer.valueOf(i));
        return i;
    }

    private static /* synthetic */ void OqknZ() {
        char[] charArray = " ¬®í¤¢®¦í¡¬ºí°«¦¯¯í\u0089\u00adª\u0081±ª§¤¦".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 195);
        }
        String str = new String(charArray);
        char[] charArray2 = " ¯ª\u00adª·".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 195);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
