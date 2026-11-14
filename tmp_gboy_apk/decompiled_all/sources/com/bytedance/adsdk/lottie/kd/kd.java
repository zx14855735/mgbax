package com.bytedance.adsdk.lottie.kd;

import com.bytedance.adsdk.lottie.p;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static p xj = new u();

    static {
        UoJf();
    }

    private static /* synthetic */ void UoJf() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(String str) {
        xj.xj(str);
    }

    public static void xj(String str) {
    }

    public static void hf(String str, Throwable th) {
        xj.hf(str, th);
    }

    public static void xj(String str, Throwable th) {
        xj.xj(str, th);
    }
}
