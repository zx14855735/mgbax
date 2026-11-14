package com.bytedance.adsdk.lottie;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class hf {
    static final int[] xj = new int[0];
    static final long[] hf = new long[0];
    static final Object[] w = new Object[0];

    static {
        WzkGI();
    }

    private static /* synthetic */ void WzkGI() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int xj(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }
}
