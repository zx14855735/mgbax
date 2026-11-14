package com.ss.android.socialbase.downloader.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum y {
    MAIN,
    SUB,
    NOTIFICATION;

    static {
        RnMcUZ();
    }

    private static /* synthetic */ void RnMcUZ() {
        char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'P');
        }
        String str = new String(charArray);
        char[] charArray2 = "3<9>9$".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'P');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
