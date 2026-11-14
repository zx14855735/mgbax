package com.sigmob.sdk.downloader.core.cause;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum b {
    INFO_DIRTY,
    FILE_NOT_EXIST,
    OUTPUT_STREAM_NOT_SUPPORT,
    RESPONSE_ETAG_CHANGED,
    RESPONSE_PRECONDITION_FAILED,
    RESPONSE_CREATED_RANGE_NOT_FROM_0,
    RESPONSE_RESET_RANGE_NOT_FROM_0,
    CONTENT_LENGTH_CHANGED;

    static {
        mRYLQx();
    }

    private static /* synthetic */ void mRYLQx() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
