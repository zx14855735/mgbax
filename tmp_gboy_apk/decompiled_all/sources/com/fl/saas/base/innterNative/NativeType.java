package com.fl.saas.base.innterNative;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum NativeType {
    Feed,
    Draw,
    Banner,
    Interstitial,
    PreMovie,
    None;

    static {
        YbgJDKm();
    }

    private static /* synthetic */ void YbgJDKm() {
        char[] charArray = "\u0092\u009e\u009cß\u0096\u0090\u009c\u0094ß\u0093\u009e\u0088ß\u0082\u0099\u0094\u009d\u009dß»\u009f\u0098³\u0083\u0098\u0095\u0096\u0094".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 241);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0092\u009d\u0098\u009f\u0098\u0085".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 241);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
