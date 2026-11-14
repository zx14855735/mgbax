package com.kwad.components.core.proxy.launchdialog;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum DetectEventType {
    USER_CONFIRM,
    USER_CANCEL;

    static {
        PGKng();
    }

    private static /* synthetic */ void PGKng() {
        char[] charArray = "UY[\u0018QW[S\u0018TYO\u0018E^SZZ\u0018|X_tD_RQS".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '6');
        }
        String str = new String(charArray);
        char[] charArray2 = "UZ_X_B".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '6');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
