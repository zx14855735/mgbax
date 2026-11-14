package com.sigmob.sdk.downloader.core.cause;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum a {
    COMPLETED,
    ERROR,
    CANCELED,
    FILE_BUSY,
    SAME_TASK_BUSY,
    PRE_ALLOCATE_FAILED;

    static {
        dich();
    }

    private static /* synthetic */ void dich() {
        char[] charArray = "ØÔÖ\u0095ÜÚÖÞ\u0095ÙÔÂ\u0095ÈÓÞ××\u0095ñÕÒùÉÒßÜÞ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 187);
        }
        String str = new String(charArray);
        char[] charArray2 = "Ø×ÒÕÒÏ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 187);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
