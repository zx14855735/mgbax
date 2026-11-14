package com.kwad.sdk.core.imageloader.core.assist;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum ImageScaleType {
    NONE,
    NONE_SAFE,
    IN_SAMPLE_POWER_OF_2,
    IN_SAMPLE_INT,
    EXACTLY,
    EXACTLY_STRETCHED;

    static {
        RNPzdrk();
    }

    private static /* synthetic */ void RNPzdrk() {
        char[] charArray = "\u009e\u0092\u0090Ó\u009a\u009c\u0090\u0098Ó\u009f\u0092\u0084Ó\u008e\u0095\u0098\u0091\u0091Ó·\u0093\u0094¿\u008f\u0094\u0099\u009a\u0098".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 253);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009e\u0091\u0094\u0093\u0094\u0089".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 253);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
