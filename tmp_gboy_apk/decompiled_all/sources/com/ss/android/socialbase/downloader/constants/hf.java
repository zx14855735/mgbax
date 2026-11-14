package com.ss.android.socialbase.downloader.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum hf {
    BYTE_INVALID_RETRY_STATUS_NONE,
    BYTE_INVALID_RETRY_STATUS_RESTART,
    BYTE_INVALID_RETRY_STATUS_DOWNLOADING,
    BYTE_INVALID_RETRY_STATUS_DOWNLOADED;

    static {
        hGPLc();
    }

    private static /* synthetic */ void hGPLc() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
