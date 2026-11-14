package com.kwad.sdk.core.d;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static final Boolean oy = Boolean.FALSE;

    static {
        OQCQvz();
    }

    private static /* synthetic */ void OQCQvz() {
        char[] charArray = "\u0011\u001d\u001f\\\u0015\u0013\u001f\u0017\\\u0010\u001d\u000b\\\u0001\u001a\u0017\u001e\u001e\\8\u001c\u001b0\u0000\u001b\u0016\u0015\u0017".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'r');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0011\u001e\u001b\u001c\u001b\u0006".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
