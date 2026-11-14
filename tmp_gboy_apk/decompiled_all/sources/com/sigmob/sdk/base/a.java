package com.sigmob.sdk.base;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum a {
    COMPANION,
    ENDCARD,
    VIDEO_CLICK,
    TEMPLATE,
    PREVIEW,
    DRIFT,
    LAND_PAGE,
    AD,
    MOTION;

    static {
        wfBM();
    }

    private static /* synthetic */ void wfBM() {
        char[] charArray = "VZX\u001bRTXP\u001bWZL\u001bF]PYY\u001b\u007f[\\wG\\QRP".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '5');
        }
        String str = new String(charArray);
        char[] charArray2 = "VY\\[\\A".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '5');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
