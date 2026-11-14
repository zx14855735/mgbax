package com.ss.android.socialbase.downloader.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum c {
    DELAY_RETRY_NONE,
    DELAY_RETRY_WAITING,
    DELAY_RETRY_DOWNLOADING,
    DELAY_RETRY_DOWNLOADED;

    static {
        lqBYzOk();
    }

    private static /* synthetic */ void lqBYzOk() {
        char[] charArray = "\u000b\u0007\u0005F\u000f\t\u0005\rF\n\u0007\u0011F\u001b\u0000\r\u0004\u0004F\"\u0006\u0001*\u001a\u0001\f\u000f\r".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'h');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000b\u0004\u0001\u0006\u0001\u001c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'h');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
