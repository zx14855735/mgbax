package com.czhj.sdk.common.models;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum AdStatus {
    AdStatusNone,
    AdStatusLoading,
    AdStatusReady,
    AdStatusPlaying,
    AdStatusClick,
    AdStatusClose;

    static {
        yNNViJ();
    }

    private static /* synthetic */ void yNNViJ() {
        char[] charArray = "êæä§îèäì§ëæð§úáìåå§ÃçàËûàíîì".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 137);
        }
        String str = new String(charArray);
        char[] charArray2 = "êåàçàý".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 137);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
