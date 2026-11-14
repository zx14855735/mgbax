package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class g {
    private static final List<String> ayp;

    public static class a extends DexClassLoader {
        private final ClassLoader ayq;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.ayq = classLoader;
            classLoader.getClass();
        }

        private static boolean cD(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("com.kwad.sdk.api") || str.startsWith("com.kwad.sdk.liteapi");
        }

        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) {
            if (cD(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = super.loadClass(str, z);
            } catch (ClassNotFoundException unused2) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException unused3) {
                return findLoadedClass;
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        ayp = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
        wUIdcP();
    }

    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (b.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }

    private static /* synthetic */ void wUIdcP() {
        char[] charArray = "{wu6\u007fyu}6zwa6kp}tt6RvqZjq|\u007f}".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 24);
        }
        String str = new String(charArray);
        char[] charArray2 = "{tqvql".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 24);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
