package com.ss.android.socialbase.downloader.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum xj {
    ASYNC_HANDLE_NONE,
    ASYNC_HANDLE_WAITING,
    ASYNC_HANDLE_RESTART,
    ASYNC_HANDLE_DOWNLOADING,
    ASYNC_HANDLE_DOWNLOADED;

    static {
        doZElJ();
    }

    private static /* synthetic */ void doZElJ() {
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
