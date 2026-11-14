package com.kwad.framework.c;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static final Boolean oy = Boolean.FALSE;

    static {
        jXxZgGG();
    }

    private static /* synthetic */ void jXxZgGG() {
        char[] charArray = "\u0090\u009c\u009eÝ\u0094\u0092\u009e\u0096Ý\u0091\u009c\u008aÝ\u0080\u009b\u0096\u009f\u009fÝ¹\u009d\u009a±\u0081\u009a\u0097\u0094\u0096".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 243);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0090\u009f\u009a\u009d\u009a\u0087".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 243);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
