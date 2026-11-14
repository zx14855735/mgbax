package com.bytedance.pangle.fragment;

import B25kr6.AzWtSf;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.api.y;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class xj {
    public static void xj(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((AzWtSf) xj(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field xj = xj(Fragment.class, "sClassMap");
            if (xj != null) {
                ((AzWtSf) xj.get(null)).put(cls.getName(), cls);
                return;
            }
            Class xj2 = xj("androidx.fragment.app.FragmentFactory");
            if (xj2 == null) {
                return;
            }
            Field xj3 = xj(xj2, "sClassMap");
            if (xj3 != null) {
                ((AzWtSf) xj3.get(null)).put(cls.getName(), cls);
                return;
            }
            Field xj4 = xj(xj2, "sClassCacheMap");
            if (xj4 != null) {
                AzWtSf azWtSf = (AzWtSf) xj4.get(null);
                AzWtSf azWtSf2 = new AzWtSf();
                azWtSf2.put(cls.getName(), cls);
                azWtSf.put(cls.getClassLoader(), azWtSf2);
            }
        } catch (Exception e) {
            y.xj(e);
        }
    }

    private static Field xj(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class xj(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
