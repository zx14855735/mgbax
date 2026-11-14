package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FragmentFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B25kr6.AzWtSf f8967A2egSU = new B25kr6.AzWtSf();

    static {
        xoyr();
    }

    public static Class A4TApA(ClassLoader classLoader, String str) {
        B25kr6.AzWtSf azWtSf = f8967A2egSU;
        B25kr6.AzWtSf azWtSf2 = (B25kr6.AzWtSf) azWtSf.get(classLoader);
        if (azWtSf2 == null) {
            azWtSf2 = new B25kr6.AzWtSf();
            azWtSf.put(classLoader, azWtSf2);
        }
        Class cls = (Class) azWtSf2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        azWtSf2.put(str, cls2);
        return cls2;
    }

    public static Class A5SV6n(ClassLoader classLoader, String str) {
        try {
            return A4TApA(classLoader, str);
        } catch (ClassCastException e) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    private static /* synthetic */ void xoyr() {
        char[] charArray = "èäæ¥ìêæî¥éäò¥øãîçç¥ÁåâÉùâïìî".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 139);
        }
        String str = new String(charArray);
        char[] charArray2 = "èçâåâÿ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 139);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public Fragment A2egSU(ClassLoader classLoader, String str) {
        try {
            return (Fragment) A5SV6n(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }
}
