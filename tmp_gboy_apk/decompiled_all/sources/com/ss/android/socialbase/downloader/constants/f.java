package com.ss.android.socialbase.downloader.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum f {
    RUN_STATUS_NONE,
    RUN_STATUS_PAUSE,
    RUN_STATUS_CANCELED,
    RUN_STATUS_ERROR,
    RUN_STATUS_END_RIGHT_NOW,
    RUN_STATUS_RETRY_DELAY,
    RUN_STATUS_WAITING_ASYNC_HANDLER,
    RUN_STATUS_END_FOR_FILE_EXIST,
    RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;

    static {
        zofuM();
    }

    private static /* synthetic */ void zofuM() {
        char[] charArray = "ÿóñ²ûýñù²þóå²ïôùðð²ÖòõÞîõøûù".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 156);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÿðõòõè".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 156);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
