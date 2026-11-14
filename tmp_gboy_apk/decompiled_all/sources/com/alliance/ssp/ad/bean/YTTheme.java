package com.alliance.ssp.ad.bean;

import A5SV6n.A2egSU;
import java.lang.reflect.Method;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum YTTheme {
    LIGHT,
    NIGHT,
    FOLLOW_SYSTEM;

    static {
        fMqJz();
    }

    private static /* synthetic */ void fMqJz() {
        char[] charArray = "r~|?vp|t?s~h?byt}}?[\u007fxScxuvt".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 17);
        }
        String str = new String(charArray);
        char[] charArray2 = "r}x\u007fxe".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 17);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
