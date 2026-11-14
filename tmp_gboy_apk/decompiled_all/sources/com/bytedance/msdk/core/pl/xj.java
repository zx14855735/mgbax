package com.bytedance.msdk.core.pl;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final Map<String, InterfaceC0059xj> xj = A2egSU.BIYEnU();

    /* renamed from: com.bytedance.msdk.core.pl.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0059xj {
    }

    static {
        tkWKlC();
    }

    private static InterfaceC0059xj hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj.remove(str);
    }

    private static /* synthetic */ void tkWKlC() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hf(str);
    }

    public static void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hf(str);
    }
}
